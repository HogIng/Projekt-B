public class Fish7 extends Fish {

	public Fish7() {
		name = "Fish7";
		imgStr = "Fish7.png";
		menuImgStr = "Fish7M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -130;
		positionY = (int) (Math.random() * 580) + 50;
	}

	public void move() {
		if (positionX > 1070) {
			setStartLocation();
		}
		if ((positionX > 100) && (positionX < 300)) {
			positionY -= 1;
			positionX += 3;
		}
		if ((positionX > 400) && (positionX < 500) && (positionY > 30)) {
			positionY -= 2;
		}
		positionX += 2;
		this.setBounds(positionX, positionY, 132, 70);
	}
}
