import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

class TimerAction implements ActionListener {

	int time;
	GamePane gp;
	int x, y, z;
	ArrayList<GameListener> listeners;

	public TimerAction(GamePane gp) {
		this.gp = gp;
		time = 350;
		x=131;
		y=204;
		z=5;
		listeners = new ArrayList<>();

	}
	
	public void addGameListener(GameListener l) {
		listeners.add(l);

	}

	public void removeGameListener(GameListener l) {
		listeners.remove(l);
	}

	private void fireGameEvent() {
		EventObject pe = new EventObject(this);
		if (listeners.size() > 0) {
			for (int i = 0; i < listeners.size(); i++) {
				((GameListener) listeners.get(i)).statusReceived1(pe);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(time <=0){
			fireGameEvent();
		}
		else{
		if (time < 200) {
			x = 249;
			y = 127;
			z = 6;
		}
		if (time < 60) {
			x = 225;
			y = 27;
			z = 67;
		}
		
		gp.updateProBar(new Color(x, y, z), time);
		time -= 2;
		}
	}
}