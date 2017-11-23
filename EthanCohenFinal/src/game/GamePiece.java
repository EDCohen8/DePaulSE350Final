package game;
import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface GamePiece {
	public void move(int xPos, int yPos);
	public String getValue();
	public GamePiece getObject();
	public Point getLocation();
}
