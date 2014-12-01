public class Fish2 extends Fish {

	public Fish2() {
		name = "Fish2";
		imgStr = "Fish2.png";
		menuImgStr = "Fish2M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 950;
		positionY = (int) (Math.random() * 200) + 300;
	}

	public void move() {
		if (positionX <= -75) {
			setStartLocation();
		}
		if (((positionX <= 600) && (positionX > 510))
				|| ((positionX <= 300) && (positionY > 360))) {
			positionY -= 4;
		}
		if (((positionX <= 700) && (positionX > 650))
				|| ((positionX <= 450) && (positionY > 500))) {
			positionY += 2;
			positionX += 1;
		}
		positionX -= 3;
		this.setBounds(positionX, positionY, 90, 62);
	}
}
