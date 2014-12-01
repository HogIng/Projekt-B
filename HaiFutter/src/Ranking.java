import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Ranking {

	private Map<String, Integer> map;

	public Ranking() {
		 map = new HashMap<String, Integer>();
		loadMap();
	}
	
	public Map<String, Integer> getMap(){
		return map;
	}
	
	public List<String> toKeyList(){
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				Integer i1 = map.get(s1);
				Integer i2 = map.get(s2);
				return i1.compareTo(i2);
			}
		});
		return list;
	}

	public void loadMap() {
		InputStream fis = null;

		try {
			fis = new FileInputStream("Ranking.ser");

			ObjectInputStream o = new ObjectInputStream(fis);
			map = (HashMap<String, Integer>) o.readObject();
			o.close();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
		
	}

	public void saveMap() {
		OutputStream fos = null;

		try {
			fos = new FileOutputStream("Ranking.ser");
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(map);
			o.close();
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}

	public void newScore(int points,String name) {
		map.put(name, points);
	}

}
