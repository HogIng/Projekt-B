public class Fish10 extends Fish {
	public Fish10() {
		name = "Fish10";
		imgStr = "Fish10.png";
		menuImgStr = "Fish10M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -120;
		positionY = (int) (Math.random() * 500) + 100;
	}

	public void move() {
		if (positionX > 1030) {
			setStartLocation();
		}
		if ((positionX > 100) && (positionX < 150) && (positionY > 30)) {
			positionY -= 2;
			positionX += 5;
		}
		if ((positionX >= 1500) && (positionX < 200) && (positionY < 600)) {
			positionY += 3;
			positionX += 2;
		}
		if ((positionX >= 200) && (positionX < 300) && (positionY > 30)) {
			positionY -= 2;
			positionX += 2;
		}
		if ((positionX >= 400) && (positionX < 500) && (positionY > 30)) {
			positionY -= 4;
			positionX += 6;
		}
		positionX += 4;
		this.setBounds(positionX, positionY, 108, 32);
	}
}
