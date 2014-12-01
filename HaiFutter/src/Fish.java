import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fish extends JLabel {

	protected ImageIcon img;
	protected String name;
	protected int positionX;
	protected int positionY;
	protected Timer timer;
	protected String imgStr;
	protected String menuImgStr;
	

	public Fish() {
		
		setStartLocation();

		timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
			}
		});

		timer.start();
	}
	

	protected void setIcon() {
		img = new ImageIcon(imgStr);
		this.setIcon(img);
	}

	protected void setStartLocation() {

	}


	protected void move() {

	}
	
	

	public String getMenuImgStr() {
		return menuImgStr;

	}

	public String getName() {
		return name;
	}

}
