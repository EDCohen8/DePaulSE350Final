import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface GameEvent {
	public void gameOver(ObservableList<Node> sceneGraph);
	public void youWin(ObservableList<Node> sceneGraph);
}
