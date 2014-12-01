public class Fish3 extends Fish {
	
	public Fish3() {
		name = "Fish3";
		imgStr = "Fish3.png";
		menuImgStr = "Fish3M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 950;
		positionY = (int) (Math.random() * 425) + 50;
	}

	public void move() {
		int a = 0;
		if ((positionX <= 950) && (positionX > 750) && (positionY > 80)) {
			a = 1;
		}
		if ((positionX <= 750) && (positionX > 600) && (positionY < 600)) {
			a = 2;
		}
		if ((positionX <= 500) && (positionX > -102) && positionY > 80) {
			a = 1;
		}
		if (positionX == -102) {
			setStartLocation();
		}
		if (a == 1) {
			positionY -= 1;
		}
		if (a == 2) {
			positionY += 1;
		}
		positionX -= 2;
		this.setBounds(positionX, positionY, 113, 62);
	}
}
