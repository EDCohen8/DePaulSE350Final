package game;
import java.util.Observable;
//OBSERVABLE PATTERN
public interface PirateMovementInterface {

	public void updateStrat(Observable o, Object arg, PirateShip pir);
	public int getY();
	public int getX();
}

