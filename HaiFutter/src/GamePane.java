import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GamePane extends JLayeredPane {

	private FishList fishList;
	private GameOverPane gOPane;
	private JLabel mealBubbleLabel;
	private JPanel topPanel;
	private JProgressBar tpProBar;
	private JPanel tpLifeContainer;
	private JPanel tpPointContainer;
	private JLabel sharkLabel;
	private JLabel levelLabel;
	private JLabel menuButtonLabel;
	private JLabel mealSizeLabel;
	private JLabel tpPointLabel;
	private String[] levelImgList;
	private ArrayList<GameListener> listeners;
	private JLabel bubble1Label;
	private JLabel bubble2Label;
	private JLabel bubble3Label;
	private JLabel bubble4Label;
	private JLabel sizeFishLabel;

	public GamePane() {

		listeners = new ArrayList<>();
		setSize(943, 710);
		createPlayGround();
		
		

	}

	
	public GameOverPane getGameOverPane(){
		return gOPane;
	}

	public void createPlayGround() {
		levelLabel = new JLabel();
		levelImgList = new String[8];
		levelImgList[0] = "Level1.png";
		levelImgList[1] = "Level2.png";
		levelImgList[2] = "Level3.png";
		levelImgList[3] = "Level4.png";
		levelImgList[4] = "Level5.png";
		levelImgList[5] = "Level6.png";
		levelImgList[6] = "Level7.png";
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 930, 70);
		topPanel.setOpaque(false);
		topPanel.setLayout(new BorderLayout());
		Border bord = new LineBorder(new Color(17, 79, 55), 2);
		UIManager.put("ProgressBarUI",
				"javax.swing.plaf.metal.MetalProgressBarUI");
		tpProBar = new JProgressBar(1, 350);
		tpProBar.setBorder(bord);
		Color co = new Color(131, 204, 5);
		tpProBar.setForeground(co);
		tpProBar.setOpaque(false);
		tpProBar.setValue(350);
		tpProBar.setPreferredSize(new Dimension(110, 35));
		tpLifeContainer = new JPanel();
		tpLifeContainer.setOpaque(false);
		tpLifeContainer.setPreferredSize(new Dimension(250, 60));
		topPanel.add(tpLifeContainer, BorderLayout.CENTER);
		tpPointContainer = new JPanel();
		tpPointContainer.setOpaque(false);
		tpPointContainer.setPreferredSize(new Dimension(132, 60));
		JPanel tpTimeContainer = new JPanel();
		tpTimeContainer.setOpaque(false);
		tpTimeContainer.setPreferredSize(new Dimension(110, 60));
		tpTimeContainer.add(tpProBar);
		topPanel.add(tpTimeContainer, BorderLayout.EAST);
		tpPointLabel = new JLabel();
		tpPointLabel.setText("0");
		tpPointLabel.setForeground(new Color(15, 79, 55));
		tpPointLabel.setFont(new Font("AR CENA", Font.BOLD, 32));
		tpPointContainer.add(tpPointLabel);
		topPanel.add(tpPointContainer, BorderLayout.WEST);
		add(topPanel, new Integer(2));
		
		mealBubbleLabel = new JLabel();
		mealBubbleLabel.setVisible(false);
		mealBubbleLabel.setIcon(new ImageIcon("Menu_BG.png"));
		mealBubbleLabel.setBounds(20, 75, 899, 391);
		add(mealBubbleLabel, new Integer(3));

		sharkLabel = new JLabel();
		sharkLabel.setName("shark");
		sharkLabel.setIcon(new ImageIcon("Shark2.png"));
		sharkLabel.setBounds(944, 466, 470, 266);
		add(sharkLabel, new Integer(3));

		JLabel bgLabel = new JLabel();
		ImageIcon bgIcon = new ImageIcon("Game_BG.png");
		bgIcon.setImage(bgIcon.getImage().getScaledInstance(943, 710,
				Image.SCALE_DEFAULT));
		bgLabel.setIcon(bgIcon);
		bgLabel.setBounds(0, 0, 943, 710);
		add(bgLabel, new Integer(0));

		JLabel a1 = new JLabel();
		ImageIcon icon1 = new ImageIcon("Alga1.png");
		a1.setIcon(icon1);
		a1.setBounds(195, 555, 190, 160);
		add(a1, new Integer(5));

		JLabel a2 = new JLabel();
		ImageIcon icon2 = new ImageIcon("Alga1.png");
		a2.setIcon(icon2);
		a2.setBounds(725, 545, 190, 160);
		add(a2, new Integer(5));

		JLabel a3 = new JLabel();
		ImageIcon icon3 = new ImageIcon("Alga2.png");
		a3.setIcon(icon3);
		a3.setBounds(-12, 350, 350, 450);
		add(a3, new Integer(5));

		bubble1Label = new JLabel();
		ImageIcon bubble1Icon = new ImageIcon("Bubble.png");
		bubble1Label.setIcon(bubble1Icon);
		bubble1Label.setBounds(-20, 590, 171, 171);
		add(bubble1Label, new Integer(6));

		bubble2Label = new JLabel();
		bubble2Label.setName("menu");
		ImageIcon bubble2Icon = new ImageIcon("Bubble.png");
		bubble2Label.setIcon(bubble2Icon);
		bubble2Label.setBounds(786, 590, 171, 171);
		add(bubble2Label, new Integer(6));

		bubble3Label = new JLabel();
		ImageIcon bubble3Icon = new ImageIcon("Bubble.png");
		bubble3Label.setIcon(bubble3Icon);
		bubble3Label.setBounds(786, -85, 171, 171);
		add(bubble3Label, new Integer(6));

		bubble4Label = new JLabel();
		ImageIcon bubble4Icon = new ImageIcon("Bubble.png");
		bubble4Label.setIcon(bubble4Icon);
		bubble4Label.setBounds(-20, -85, 171, 171);
		add(bubble4Label, new Integer(6));

		mealSizeLabel = new JLabel();
		mealSizeLabel.setText("0");
		mealSizeLabel.setForeground(Color.WHITE);
		mealSizeLabel.setFont(new Font("AR CENA", Font.BOLD, 22));
		mealSizeLabel.setBounds(60, 590, 100, 100);
		add(mealSizeLabel, new Integer(7));

		sizeFishLabel = new JLabel();
		ImageIcon ficon = new ImageIcon("FishMealSize.png");
		sizeFishLabel.setIcon(ficon);
		sizeFishLabel.setBounds(20, 554, 171, 171);
		add(sizeFishLabel, new Integer(7));

		menuButtonLabel = new JLabel();
		menuButtonLabel.setName("Menu");
		ImageIcon micon = new ImageIcon("Menutext.png");
		menuButtonLabel.setIcon(micon);
		menuButtonLabel.setBounds(826, 606, 140, 80);
		add(menuButtonLabel, new Integer(7));
		fishList = new FishList();
		for (int i = 0; i < fishList.size(); i++) {
			fishList.get(i).setVisible(false);
			add(fishList.get(i),new Integer(1));
		}

		addMouseHandler();
	}

	public void addMouseHandler() {
		MouseHandler mh = new MouseHandler();
		for (int i = 0; i < fishList.size(); i++) {
			fishList.get(i).addMouseListener(mh);
		}
		bubble2Label.addMouseListener(mh);
		sharkLabel.addMouseListener(mh);
	}

	public void showFish(int fishCount) {
		for (int i = 0; i < fishCount; i++) {
			fishList.get(i).setVisible(true);
		}
	}

	public void hideFish() {
		for (int i = 0; i < fishList.size(); i++) {
			fishList.get(i).setVisible(false);
		}
	}

	public void eatFish(String compName) {
		for (int i = 0; i < fishList.size(); i++) {
			if (fishList.get(i).getName().equals(compName)) {
				fishList.get(i).setVisible(false);
			}
		}
	}

	public void moveShark(int sharkPositionX) {
		sharkLabel.setBounds(sharkPositionX, 460, 470, 266);
	}

	public void showMeal(int mealSize, ArrayList<Fish> list) {
		mealBubbleLabel.setVisible(true);
		int x = 75;
		for (int i = 0; i < mealSize; i++) {
			JLabel xLabel = new JLabel();
			ImageIcon xIcon = new ImageIcon(list.get(i).getMenuImgStr());
			xLabel.setIcon(xIcon);
			xLabel.setBounds(x, 185, 200, 85);
			add(xLabel, new Integer(4));
			x += 95;
		}
	}

	public void hideMeal() {
		Component[] comps = getComponentsInLayer(4);
		int l = comps.length;
		for (int i = 0; i < l; i++) {
			Component c = comps[i];
			c.setVisible(false);
			remove(comps[i]);
		}
		mealBubbleLabel.setVisible(false);
		mealBubbleLabel.repaint();
	}

	public void showLevelNum(int levelIndex) {
		levelLabel.setIcon(new ImageIcon(levelImgList[levelIndex]));
		levelLabel.setBounds(0, 240, 943, 144);
		levelLabel.setVisible(true);
		add(levelLabel, new Integer(4));
	}

	public void hideLevelNum() {
		levelLabel.setVisible(false);
		remove(levelLabel);
	}

	public void updatePoints(int points) {
		String p = Integer.toString(points);
		tpPointLabel.setText(p);
	}

	public void updateLives(int lives) {
		tpLifeContainer.removeAll();
		for (int x = 0; x < lives; x++) {
			JLabel lifeLabel = new JLabel();
			ImageIcon lifeIcon = new ImageIcon("SharkLife.png");
			lifeLabel.setIcon(lifeIcon);
			tpLifeContainer.add(lifeLabel);
		}
		int nolives = 3 - lives;
		for (int x = 0; x < nolives; x++) {
			JLabel noLifeLabel = new JLabel();
			ImageIcon noLifeIcon = new ImageIcon("SharkDeath.png");
			noLifeLabel.setIcon(noLifeIcon);
			tpLifeContainer.add(noLifeLabel);
		}
		tpLifeContainer.repaint();
	}

	public void updateProBar(Color color, int time) {
		tpProBar.setForeground(color);
		tpProBar.setValue(time);
		tpProBar.repaint();
	}
	
	public void showMealSize(int mealSize) {
		String p = Integer.toString(mealSize);
		mealSizeLabel.setText(p);
		mealSizeLabel.repaint();
	}
	
	public void showGameOver(int points,GameController.StartMenuHandler sMHandler){
		hideFish();
		topPanel.setVisible(false);
		bubble1Label.setVisible(false);
		bubble3Label.setVisible(false);
		bubble4Label.setVisible(false);
		mealSizeLabel.setVisible(false);
		sizeFishLabel.setVisible(false);
		gOPane = new GameOverPane(points);
		gOPane.addGameListener(sMHandler);
		gOPane.setBounds(0, 30, 943, 700);
		add(gOPane, new Integer(3));
	}

	public void addGameListener(GameListener l) {
		listeners.add(l);

	}

	public void removeGameListener(GameListener l) {
		listeners.remove(l);
	}

	private void fireGameEvent(Component comp) {
		EventObject pe = new EventObject(this);
		if (listeners.size() > 0) {
			for (int i = 0; i < listeners.size(); i++) {
				((GameListener) listeners.get(i)).statusReceived(pe, comp);
			}
		}
	}

	public class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Component comp = e.getComponent();
			fireGameEvent(comp);

		}

	}

}
