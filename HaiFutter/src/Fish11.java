public class Fish11 extends Fish {
	public Fish11() {
		name = "Fish11";
		imgStr = "Fish11.png";
		menuImgStr = "Fish11M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = -90;
		positionY = (int) (Math.random() * 500) + 100;
	}

	public void move() {
		if ((positionX > 100) && (positionX < 250)) {
			positionX += 1;
			positionY += 2;
		}
		if ((positionX >= 252) && (positionX < 300)) {
			positionY += 3;
		}
		if ((positionX > 400) && (positionX < 560)) {
			positionX += 4;
			positionY -= 2;
		}
		if ((positionX > 1020) || (positionY < -90) || (positionY > 730)) {
			setStartLocation();
		}
		positionX += 2;
		this.setBounds(positionX, positionY, 86, 80);
	}
}
