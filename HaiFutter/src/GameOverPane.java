import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameOverPane extends JLayeredPane {

	private Ranking ranking;
	private int totalPoints;
	private ArrayList<GameListener> listeners;
	private JTextField nameField;

	public GameOverPane(int totalPoints) {
		this.totalPoints = totalPoints;
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("top10_bg2.png"));
		bg.setBounds(220, 170, 550, 460);
		add(bg, new Integer(0));
		setOpaque(false);
		setPreferredSize(new Dimension(943, 650));
		JLabel header = new JLabel();
		header.setIcon(new ImageIcon("GameOver.png"));
		header.setBounds(0, 0, 943, 144);
		add(header, new Integer(1));
		ranking = new Ranking();
		listeners = new ArrayList<>();
		showPoints();
	}


	public void showPoints() {
		JLabel il = new JLabel("" + totalPoints + " Punkte");
		il.setForeground(new Color(15, 79, 55));
		il.setFont(new Font("AR CENA", Font.BOLD, 38));
		il.setBounds(395, 240, 400, 40);
		add(il, new Integer(1));
		ButtonHandler bh = new ButtonHandler();
		List<String> list = ranking.toKeyList();
		if (ranking.getMap().get(list.get(9)) > totalPoints) {
			JLabel nrl = new JLabel();
			nrl.addMouseListener(bh);
			nrl.setName("tryAgain");
			nrl.setIcon(new ImageIcon("NeueRunde.png"));
			nrl.setBounds(350, 450, 226, 65);
			add(nrl, new Integer(1));
			JLabel pl = new JLabel("Du hast es leider nicht in die Top 10");
			pl.setForeground(new Color(15, 79, 55));
			pl.setFont(new Font("AR CENA", Font.PLAIN, 24));
			pl.setBounds(315, 300, 400, 40);
			add(pl, new Integer(1));
			JLabel sl = new JLabel("geschafft!");
			sl.setForeground(new Color(15, 79, 55));
			sl.setFont(new Font("AR CENA", Font.PLAIN, 24));
			sl.setBounds(420, 330, 400, 40);
			add(sl, new Integer(1));
			JLabel al = new JLabel("Versuch es noch einmal!");
			al.setForeground(new Color(15, 79, 55));
			al.setFont(new Font("AR CENA", Font.PLAIN, 24));
			al.setBounds(360, 380, 400, 40);
			add(al, new Integer(1));
		} else {
			JLabel saveLabel = new JLabel();
			saveLabel.setName("save");
			saveLabel.addMouseListener(bh);
			saveLabel.setIcon(new ImageIcon("Save.png"));
			saveLabel.setBounds(355, 460, 226, 65);
			add(saveLabel, new Integer(1));
			nameField = new JTextField();
			nameField.setColumns(20);
			nameField.setBounds(355, 400, 227, 30);
			add(nameField, new Integer(1));
			JLabel pl = new JLabel("Du hast es in die Top 10 geschafft!");
			pl.setForeground(new Color(15, 79, 55));
			pl.setFont(new Font("AR CENA", Font.PLAIN, 24));
			pl.setBounds(325, 300, 400, 40);
			add(pl, new Integer(1));
			JLabel al = new JLabel("Zum Speichern, gib deinen Namen ein!");
			al.setForeground(new Color(15, 79, 55));
			al.setFont(new Font("AR CENA", Font.PLAIN, 24));
			al.setBounds(310, 330, 400, 40);
			add(al, new Integer(1));
		}
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

	public String getUserName() {
		String text = nameField.getText();
		return text;
	}

	class ButtonHandler implements MouseListener {

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

			if (name.equals("tryAgain")) {
				fireGameEvent(comp);
			}

			if (name.equals("save")) {
				fireGameEvent(comp);

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
