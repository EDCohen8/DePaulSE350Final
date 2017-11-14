import java.awt.Point;

public interface GamePiece {
	public void move(int xPos, int yPos);
	public String getValue();
	public GamePiece getObject();
	public Point getLocation();
}
