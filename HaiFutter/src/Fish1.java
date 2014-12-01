public class Fish1 extends Fish {

	public Fish1() {
		name = "Fish1";
		imgStr = "Fish1.png";
		menuImgStr = "Fish1M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 1041;
		positionY = (int) (Math.random() * 425) + 50;
	}

	public void move() {
		if (positionX < -90) {
			setStartLocation();
		}
		positionX -= 4;
		this.setBounds(positionX, positionY, 97, 58);
	}

}
