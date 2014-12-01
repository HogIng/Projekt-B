import java.util.ArrayList;

import javax.swing.Timer;

public class Level {

	private ArrayList<Fish> meal;
	private Timer timer;
	private int levelNumber;
	private int mealSize;
	private int fishCount;
	int points;

	public Level(int levelNumber, int points) {
		meal = new ArrayList<>();
		this.levelNumber = levelNumber;
		this.points = points;
		setMealSize();
		setFishCount();
		meal = newMeal();
	}

	public ArrayList<Fish> newMeal() {
		meal.clear();
		FishList list = new FishList();
			for (int i = 0; i < mealSize; i++) {
			int x = (int) (Math.random() * (fishCount - i));
			Fish ani = list.get(x);
			meal.add(ani);
			list.remove(ani);
		}
		return meal;
	}

	private void setFishCount() {
		fishCount = mealSize + 4;
		while (fishCount > 12) {
			fishCount--;
		}
	}

	private void setMealSize() {
		mealSize = levelNumber + 2;
		while (mealSize > 10) {
			mealSize--;
		}
	}

	public ArrayList<Fish> getMeal() {
		return meal;
	}
	
	public int getFishCount(){
		return fishCount;
	}
	
	public void deleteFish(){
		meal.remove(0);
		points +=15;
	}
	
	public int getPoints(){
		return points ;
	}
	
	public int getMealSize(){
		return meal.size();
	}
	
}
