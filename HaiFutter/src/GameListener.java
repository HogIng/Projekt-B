import java.awt.Component;
import java.util.EventObject;

public interface GameListener {

	public void statusReceived(EventObject event, Component comp );
	
	public void statusReceived1(EventObject event);

	
}
