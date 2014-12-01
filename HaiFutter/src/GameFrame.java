import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private MenuPane menuPane;
	private GamePane gamePane;

	public GameFrame() {
		menuPane = new MenuPane();
		add(menuPane);
		gamePane = new GamePane();
		gamePane.setVisible(false);
		add(gamePane);
		setSize(943, 710);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public GamePane getGamePane() {
		return gamePane;
	}

	public MenuPane getMenuPane() {
		return menuPane;
	}

	public void showMenu() {
		gamePane.setVisible(false);
		menuPane.setVisible(true);

	}

	public void showPlayGround() {
		menuPane.setVisible(false);
		gamePane.setVisible(true);

	}
	
	public void newGamePane(){
		remove(gamePane);
		gamePane = new GamePane();
		add(gamePane);
	}
	
	public void newMenuPane(){
		remove (menuPane);
		menuPane = new MenuPane();
		add(menuPane);
	}

}
