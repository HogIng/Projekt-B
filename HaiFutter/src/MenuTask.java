import java.util.ArrayList;
import java.util.EventObject;

public class MenuTask implements Runnable {

	GamePane gamePane;
	boolean running;
	Game game;
	ArrayList<GameListener> listeners;
	int i;

	public MenuTask(GamePane gp, Game game) {

		gamePane = gp;
		this.game = game;
		listeners = new ArrayList<>();

	}

	@Override
	public void run() {
		running = true;
		i = 940;
		gamePane.showLevelNum(game.getLevelNumber() - 1);
		gamePane.showMealSize(game.getLevel().getMealSize());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		gamePane.hideLevelNum();

		while (running) {

			i--;
			if (i == -470) {
				stop();
			} else {

				if (i == 270) {
					gamePane.showMeal(game.getLevel().getMealSize(), game
							.getLevel().getMeal());
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gamePane.hideMeal();
				}

				

				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gamePane.moveShark(i);

			}
		}

	}

	public void stop() {
		i = 940;
		running = false;
		gamePane.hideMeal();
		gamePane.moveShark(940);
		fireGameEvent();
	}

	public void addGameListener(GameListener l) {
		listeners.add(l);
	}

	public void removeGameListener(GameListener l) {
		listeners.remove(l);
	}

	private void fireGameEvent() {
		EventObject pe = new EventObject(this);
		if (listeners.size() > 0) {
			for (int i = 0; i < listeners.size(); i++) {
				((GameListener) listeners.get(i)).statusReceived1(pe);
			}
		}
	}

}
