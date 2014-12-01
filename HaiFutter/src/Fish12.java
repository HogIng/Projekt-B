public class Fish12 extends Fish {
	public Fish12() {
		name = "Fish12";
		imgStr = "Fish12.png";
		menuImgStr = "Fish12M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -100;
		positionY = (int) (Math.random() * 480) + 50;
	}

	public void move() {
		if (positionX > 1040) {
			setStartLocation();
		}
		if ((positionX > 350) && (positionX < 650)) {
			positionY -= 1;
		}
		if ((positionX >= 100) && (positionX < 300)) {
			positionX += 2;
		}
		positionX += 3;
		this.setBounds(positionX, positionY, 97, 71);
	}
}
