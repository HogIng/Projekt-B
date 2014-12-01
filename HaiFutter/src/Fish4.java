
public class Fish4 extends Fish{

	public Fish4() {
		name = "Fish4";
		imgStr="Fish4.png";
		menuImgStr="Fish4M.png";
		setIcon();
	}

	public void setStartLocation() {
		positionX = 1040;
		positionY = (int) (Math.random() * 520) + 100;
	}

	public void move() {
		if((positionX<580)&&(positionX>400)){
			positionX -=3;
			positionY +=2;
		}
		if ((positionX < 300)&&(positionX>200)) {
			positionX -= 2;
		}
		if ((positionX < -100)||(positionY>710)) {
			setStartLocation();
		}
		positionX -= 3;
		this.setBounds(positionX, positionY, 105, 63);
	}
}
