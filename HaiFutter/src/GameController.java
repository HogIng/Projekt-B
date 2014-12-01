import java.awt.Component;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.Timer;

public class GameController {

	private GameFrame gameFrame;
	private Game game;
	private Sound sound;
	private StartMenuHandler sMHandler;
	private MenuTask mTask;
	private Thread thread;
	private Timer timer;
	private Ranking ranking;
	private TimerAction timerAct;

	public GameController() {
		
		ranking = new Ranking();
		gameFrame = new GameFrame();
		sMHandler = new StartMenuHandler();
		gameFrame.getMenuPane().addGameListener(sMHandler);
		sound = new Sound();
		

	}

	private void startGame() {
		
		game = new Game();
		newGamePane();
		timerAct = new TimerAction(gameFrame.getGamePane());
		timerAct.addGameListener(sMHandler);
		timer = new Timer(1000,timerAct );
		timer.start();
		gameFrame.showPlayGround();
		gameFrame.getGamePane().updateLives(game.getLives());
		
		sound.playBGSound();
		
		startLevel();

	}

	private Boolean checkFish(String fishName) {
		if (fishName.equals(game.getLevel().getMeal().get(0).getName())) {
			sound.playBiteSound();
			return true;
		} else {
			return false;
		}
	}
	
	private void newGamePane(){
		gameFrame.newGamePane();
		gameFrame.getGamePane().addGameListener(sMHandler);;
	}
	
	private void newMenuPane() {
		gameFrame.newMenuPane();
		gameFrame.getMenuPane().addGameListener(sMHandler);
		
	}

	public void nextLevel() {
		gameFrame.getGamePane().updatePoints(game.getLevel().getPoints());
		game.raiseLevel();
		game.newLevel();
		startLevel();
	}

	public void startLevel() {
		if(thread!=null){
			thread.stop();
		}
		
		gameFrame.getGamePane().hideFish();
		mTask = new MenuTask(gameFrame.getGamePane(), game);
		mTask.addGameListener(sMHandler);
		thread = new Thread(mTask);
		thread.start();

	}

	private void fail() {
		sound.playFailSound();
		gameFrame.getGamePane().updatePoints(game.getTotalPoints());
		if (game.getLives() == 0) {
			gameOver();
		} else {
			// sound.playFailSound();
			game.looseLife();
			game.newLevel();
			startLevel();
			gameFrame.getGamePane().updateLives(game.getLives());
		}
	}

	private void gameOver() {
		timer.stop();
		gameFrame.getGamePane().showGameOver(game.getTotalPoints(),sMHandler);
	}

	public static void main(String[] args) {
		GameController gc = new GameController();

	}

	public class StartMenuHandler implements GameListener {

		@Override
		public void statusReceived(EventObject event, Component comp) {
			String compStr = comp.getName();
			if (compStr.equals("menu")) {
				sound.stopSound();
				newMenuPane();
				gameFrame.showMenu();
				
			}
			else if (compStr.equals("shark")) {
				mTask.stop();
			}
			else if(compStr.equals("save")){
				ranking.newScore(game.getTotalPoints(), gameFrame.getGamePane().getGameOverPane().getUserName());
				ranking.saveMap();
				newMenuPane();

				sound.stopSound();
				gameFrame.showMenu();
				gameFrame.getMenuPane().timerR.start();
			}
			else if(compStr.equals("tryAgain")){

				sound.stopSound();
				startGame();
			}
			else {
				if (checkFish(compStr)) {
					game.getLevel().deleteFish();
					gameFrame.getGamePane().showMealSize(
							game.getLevel().getMealSize());
					gameFrame.getGamePane().eatFish(compStr);
					gameFrame.getGamePane().updatePoints(
							game.getLevel().getPoints());

					if (game.getLevel().getMeal().size() == 0) {
						nextLevel();
					}
				} else {
					fail();
				}
			}
		}

		@Override
		public void statusReceived1(EventObject e) {
			if (e.getSource().equals(mTask)) {
				gameFrame.getGamePane()
						.showFish(game.getLevel().getFishCount());
			}
			if (e.getSource().equals(gameFrame.getMenuPane())) {
				startGame();
			}
			if(e.getSource().equals(timerAct)){
				gameOver();
			}
		}

	}

}
