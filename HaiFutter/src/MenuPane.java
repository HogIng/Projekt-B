import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class MenuPane extends JLayeredPane {

	private RankingPane ranking;
	private int status;
	private JLabel speechBubbleLabel;
	private JLabel shark1Label;
	private JLabel shark2Label;
	private JLabel fishLabel;
	private JLabel bubblesLabel;
	private int positionFish;
	private int positionBubbles;
	private int positionshark1;
	private int positionshark2;
	private ArrayList<GameListener> listeners;

	public MenuPane() {

		listeners = new ArrayList<>();

		MenuHandler mh = new MenuHandler();

		ranking = new RankingPane();
		ranking.setBounds(230, 170, 490, 460);
		ranking.setVisible(false);
		add(ranking, new Integer(2));

		speechBubbleLabel = new JLabel();
		ImageIcon icon9 = new ImageIcon("Infobubble.png");
		speechBubbleLabel.setIcon(icon9);
		speechBubbleLabel.setBounds(36, 180, 319, 257);
		speechBubbleLabel.setVisible(false);
		add(speechBubbleLabel, new Integer(3));

		shark2Label = new JLabel();
		positionshark2 = 302;
		ImageIcon icon8 = new ImageIcon("Shark2.png");
		shark2Label.setIcon(icon8);
		shark2Label.setBounds(positionshark2, 200, 470, 266);
		shark2Label.setVisible(false);
		add(shark2Label, new Integer(3));

		positionshark1 = 350;
		shark1Label = new JLabel();
		ImageIcon icon5 = new ImageIcon("Shark1.png");
		shark1Label.setIcon(icon5);
		shark1Label.setBounds(positionshark1, 200, 470, 266);
		add(shark1Label, new Integer(3));

		JLabel bg = new JLabel();
		ImageIcon bgIcon = new ImageIcon("Startframe_BG.png");
		bg.setIcon(bgIcon);
		bg.setBounds(0, 0, 943, 710);
		add(bg, new Integer(0));

		positionFish = 110;
		fishLabel = new JLabel();
		ImageIcon icon6 = new ImageIcon("StartFish.png");
		fishLabel.setIcon(icon6);
		fishLabel.setBounds(positionFish, 275, 140, 78);
		add(fishLabel, new Integer(3));

		positionBubbles = 195;
		bubblesLabel = new JLabel();
		ImageIcon icon7 = new ImageIcon("StartBlasen.png");
		bubblesLabel.setIcon(icon7);
		bubblesLabel.setBounds(70, positionBubbles, 50, 92);
		add(bubblesLabel, new Integer(3));

		JLabel startButtonLabel = new JLabel();
		ImageIcon icon2 = new ImageIcon("Start.png");
		startButtonLabel.setIcon(icon2);
		startButtonLabel.setBounds(335, 570, 271, 81);
		startButtonLabel.addMouseListener(mh);
		startButtonLabel.setName("Start");
		add(startButtonLabel, new Integer(3));

		JLabel infoButtonLabel = new JLabel();
		ImageIcon icon3 = new ImageIcon("Info.png");
		infoButtonLabel.setIcon(icon3);
		infoButtonLabel.setBounds(120, 580, 218, 67);
		add(infoButtonLabel, new Integer(3));
		infoButtonLabel.setName("Info");
		infoButtonLabel.addMouseListener(mh);

		JLabel rankingButtonLabel = new JLabel();
		ImageIcon icon4 = new ImageIcon("Top10.png");
		rankingButtonLabel.setIcon(icon4);
		rankingButtonLabel.setBounds(650, 580, 219, 68);
		add(rankingButtonLabel, new Integer(3));
		rankingButtonLabel.setName("Ranking");
		rankingButtonLabel.addMouseListener(mh);

		setSize(943, 710);
		setVisible(true);

		status = 0;
	}



	final Timer timerI = new Timer(80, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			if (status == 0) {
				if (positionshark1 < 302) {
					remove(fishLabel);
					remove(bubblesLabel);
					timerI.stop();
					showInfo();
				}

				positionFish -= 20;
				fishLabel.setBounds(positionFish, 275, 140, 78);
				positionBubbles -= 13;
				bubblesLabel.setBounds(80, positionBubbles, 50, 92);
				positionshark1 -= 2;
				shark1Label.setBounds(positionshark1, 200, 470, 266);
			}

			else {
				ranking.setVisible(false);

				shark1Label.setVisible(true);

				positionshark1 -= 30;
				shark1Label.setBounds(positionshark1, 200, 470, 266);
				if (positionshark1 < 312) {

					timerI.stop();
					showInfo();
				}
			}
		}
	});

	final Timer timerR = new Timer(80, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			if (status == 0) {
				if (positionshark1 < -500) {
					shark1Label.setVisible(false);

					ranking.setVisible(true);

					timerR.stop();
					showRanking();
				}
				positionFish -= 30;
				fishLabel.setBounds(positionFish, 275, 140, 78);
				positionBubbles -= 15;
				bubblesLabel.setBounds(80, positionBubbles, 50, 92);
				positionshark1 -= 20;
				shark1Label.setBounds(positionshark1, 200, 470, 266);

			}

			else {

				speechBubbleLabel.setVisible(false);

				positionshark2 -= 30;
				shark2Label.setBounds(positionshark2, 200, 470, 266);
				if (positionshark2 < -460) {
					timerR.stop();
					showRanking();
				}

			}
		}
	});

	public void showInfo() {
		shark1Label.setVisible(false);
		positionshark2 = 302;
		shark2Label.setBounds(positionshark2, 200, 470, 266);
		shark2Label.setVisible(true);
		speechBubbleLabel.setVisible(true);
		status = 1;

	}

	public void showRanking() {
		ranking.setVisible(true);
		positionshark1 = 910;
		status = 1;
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

	public class MenuHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Component comp = e.getComponent();

			String name = comp.getName();

			if (name.equals("Start")) {
				fireGameEvent();
			}

			if (name.equals("Info")) {
				timerI.start();

			}

			if (name.equals("Ranking")) {
				timerR.start();

			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
