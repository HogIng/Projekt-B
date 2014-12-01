public class Fish9 extends Fish {
	public Fish9() {
		name = "Fish9";
		imgStr = "Fish9.png";
		menuImgStr = "Fish9M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 950;
		positionY = (int) (Math.random() * 425) + 50;
	}

	public void move() {
		if ((positionX <= 750) && (positionX > 600) && (positionY < 600)) {
			positionY += 1;
		}
		if ((positionX <= 500) && (positionX > 200) && positionY > 50) {
			positionY -= 2;
		}
		if (positionX == -102) {
			positionX = 950;
			positionY = (int) (Math.random() * 425) + 50;
		}
		if (positionX == -130) {
			setStartLocation();
		}
		positionX -= 5;
		this.setBounds(positionX, positionY, 141, 80);
	}
}
