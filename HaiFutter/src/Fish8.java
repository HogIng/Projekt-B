public class Fish8 extends Fish {

	public Fish8() {
		name = "Fish8";
		imgStr = "Fish8.png";
		menuImgStr = "Fish8M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 1060;
		positionY = (int) (Math.random() * 500) + 50;
	}

	public void move() {
		if ((positionX <= -110) || (positionY <= -80) || (positionY >= 714)) {
			setStartLocation();
		}
		if (((positionX <= 800) && (positionX > 750))
				|| ((positionX <= 300) && (positionY > 250))) {
			positionY -= 2;
			positionX -= 1;
		}
		if ((positionX <= 750) && (positionX > 700)) {
			positionX -= 4;
		}
		if (((positionX <= 700) && (positionX > 650))
				|| ((positionX <= 500) && (positionY > 420))) {
			positionY += 2;
			positionX += 1;
		}
		positionX -= 3;
		this.setBounds(positionX, positionY, 109, 75);
	}
}
