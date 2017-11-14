import java.util.Observable;
public interface PirateMovementInterface {

	public void updateStrat(Observable o, Object arg, PirateShip pir);
	public int getY();
	public int getX();
}

