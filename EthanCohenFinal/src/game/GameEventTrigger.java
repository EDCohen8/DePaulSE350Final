package game;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameEventTrigger implements GameEvent {

	Image youWinImage, youLoseImage;
	ImageView youWinImageView, youLoseImageView;
	@Override
	public void gameOver(ObservableList<Node> sceneGraph) {
		// TODO Auto-generated method stub
		youLoseImage = new Image("YouLose.png", 700, 700, false, false);
		youLoseImageView = new ImageView(youLoseImage);
		youLoseImageView.setX(0);
		youLoseImageView.setY(0);
		sceneGraph.clear();
		sceneGraph.add(youLoseImageView);
	}
	
	public ImageView youLoseImageView() {
		youLoseImage = new Image("YouLose.png", 700, 700, false, false);
		youLoseImageView = new ImageView(youLoseImage);
		youLoseImageView.setX(0);
		youLoseImageView.setY(0);
		return youLoseImageView;
	}

	@Override
	public void youWin(ObservableList<Node> sceneGraph) {
		// TODO Auto-generated method stub
		youWinImage = new Image("YouWin.png", 700, 700, false, false);
		youWinImageView = new ImageView(youWinImage);
		youWinImageView.setX(0);
		youWinImageView.setY(0);
		sceneGraph.clear();
		sceneGraph.add(youWinImageView);
		
	}

}
