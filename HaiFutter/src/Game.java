import java.util.Timer;

public class Game {

	private int levelNumber;
	private Level level;
	private int lives;
	private int totalPoints;

	public Game() {
		lives = 3;
		totalPoints = 0;
		levelNumber = 1;
		newLevel();

	}
	

	public void newLevel() {
		level = new Level(levelNumber,totalPoints);
	}

	public Level getLevel() {
		return level;
	}
	
	public int getLives(){
		return lives;
	}
	
	public void raiseLevel(){
		if(levelNumber<7){
		levelNumber++;}
		totalPoints = level.getPoints();
	}
	
	public void looseLife(){
		lives--;
	}
	
	public int getLevelNumber(){
		return levelNumber;
	}
	
	public int getTotalPoints(){
		return totalPoints;
	}

}
