public class Fish6 extends Fish {

	public Fish6() {
		name = "Fish6";
		imgStr = "Fish6.png";
		menuImgStr = "Fish6M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -115;
		positionY = (int) (Math.random() * 500) + 100;
	}

	public void move() {
		if (positionX > 500) {
			positionX += 4;
		}
		if ((positionX > 1050) || (positionY < -150)) {
			setStartLocation();
		}
		positionX += 4;
		positionY -= 2;
		this.setBounds(positionX, positionY, 110, 71);
	}
}
