package game;
import javafx.collections.ObservableList;
import javafx.scene.Node;
//interface that toggles gameover or youwin pictures
public interface GameEvent {
	public void gameOver(ObservableList<Node> sceneGraph);
	public void youWin(ObservableList<Node> sceneGraph);
}
