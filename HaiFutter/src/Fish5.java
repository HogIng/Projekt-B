public class Fish5 extends Fish {

	public Fish5() {
		name = "Fish5";
		imgStr = "Fish5.png";
		menuImgStr = "Fish5M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -135;
		positionY = (int) (Math.random() * 480) + 100;
	}

	public void move() {
		if (positionX > 1070) {
			setStartLocation();
		}
		if ((positionX > 100) && (positionX < 150) && (positionY > 30)) {
			positionY -= 2;
		}
		if ((positionX > 400) && (positionX < 500) && (positionY > 30)) {
			positionY -= 3;
		}
		positionX += 2;
		this.setBounds(positionX, positionY, 128, 38);
	}
}
