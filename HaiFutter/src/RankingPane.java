import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class RankingPane extends JLayeredPane {

	private Ranking ranking;

	public RankingPane() {

		JLabel bgImg = new JLabel();
		bgImg.setIcon(new ImageIcon("top10_bg1.png"));
		bgImg.setBounds(0, 0, 480, 400);
		add(bgImg, new Integer(0));
		ranking = new Ranking();

		setOpaque(false);
		setPreferredSize(new Dimension(480, 400));
		
		printMap();

	}


	
	public void printMap() {
		ranking.loadMap();
		int x;
		int a = 0;
		JLabel header = new JLabel("Bestenliste");
		header.setFont(new Font("AR CENA", Font.BOLD, 36));
		header.setForeground(new Color(183, 24, 59));
		header.setBounds(160, 50, 240, 30);
		add(header, new Integer(1));
		
		List<String> list = ranking.toKeyList();

		JPanel rlist = new JPanel();
		rlist.setLayout(new BoxLayout(rlist, BoxLayout.Y_AXIS));
		rlist.setOpaque(false);
		JPanel countlist = new JPanel();
		countlist.setLayout(new BoxLayout(countlist, BoxLayout.Y_AXIS));
		countlist.setOpaque(false);

		x = list.size() - 1;
		JLabel label;
		JLabel label1;
		while (x >= 0 && a < 10) {
			String key = list.get(x);
			Integer p = ranking.getMap().get(key);
			String z = p.toString();
			if (a == 9) {
				label = new JLabel((a + 1) + ".  " + key);
			} else {
				label = new JLabel(" " + (a + 1) + ".   " + key);
			}

			if (p < 10) {
				label1 = new JLabel(z + "      Punkte");
			} else if (p > 9 && p < 100) {
				label1 = new JLabel(z + "    Punkte");
			} else {
				label1 = new JLabel(z + "  Punkte");
			}

			label.setForeground(new Color(15, 79, 55));
			label.setFont(new Font("AR CENA", Font.PLAIN, 18));
			label1.setForeground(new Color(15, 79, 55));
			label1.setFont(new Font("AR CENA", Font.PLAIN,18));
			rlist.add(label);
			countlist.add(label1);
			x--;
			a++;
		}

		while (a < 10) {

			if ((a + 1) == 10) {
				label = new JLabel((a + 1) + ".");

			} else {
				label = new JLabel((a + 1) + ".");
			}
			label.setForeground(new Color(15, 79, 55));
			label.setFont(new Font("Verdana", Font.BOLD, 18));
			rlist.setAlignmentX(header.CENTER_ALIGNMENT);
			rlist.add(label);
			a++;
		}
		rlist.setBounds(120, 105, 200, 300);
		add(rlist, new Integer(1));
		countlist.setBounds(280, 105, 200, 300);
		add(countlist, new Integer(1));

	}

}

