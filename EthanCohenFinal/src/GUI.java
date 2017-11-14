import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {

	Random rand = new Random();
	Scene scene;
	Pane root;
	PlayerShip ship;
	TreasurePiece treasure;
	Grid map = Grid.getInstance();
	GamePiece[][] mapArray;
	int scale;
	ArrayList<PirateShip> pirateShipList = new ArrayList<PirateShip>();
	ArrayList<Image> pirateImageList = new ArrayList<Image>();
	ArrayList<ImageView> pirateImageViewList = new ArrayList<ImageView>();
	Image shipImage, pirateImage, treasureImage;
	ImageView shipImageView, pirateImageView, treasureImageView;
	Thread monstersThread;
	MonsterPiece monster;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new AnchorPane();
		scene = new Scene(root, 700, 700);
		primaryStage.setTitle("SE350 Final Project");
		primaryStage.setScene(scene);
		primaryStage.show();
		startSailing();
		map.populateMap();
		placeShips();
		placeTreasure();
		map.displayMap();
		mapArray = map.getMap();
		drawMap();
		loadShipImage();
		loadPirateImages();
		loadTreasureImage();
		root.getChildren().add(shipImageView);
		root.getChildren().add(treasureImageView);
		for(ImageView pirIV: pirateImageViewList) {
			root.getChildren().add(pirIV);
		}
		/*
		monster = new Monster(14);
		monster.addToPane(root.getChildren());
		monstersThread = new Thread(monster);
		monstersThread.start();
		*/

	}

	public void drawMap() {
		scale = 14;
		for(int x = 0; x < mapArray.length; x++) {
			for(int y = 0; y < mapArray[0].length; y++){
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if(mapArray[y][x] instanceof IslandPiece) {
					rect.setFill(Color.GREEN);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
				}
				root.getChildren().add(rect);
			}
		}
	}
	
	public void loadShipImage() {
		shipImage = new Image("ship.png", scale, scale, false, false);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getLocation().getX() * scale);
		shipImageView.setY(ship.getLocation().getY() * scale);
	}


	public void loadTreasureImage() {
		treasureImage = new Image("treasure.png", scale, scale, false, false);
		treasureImageView = new ImageView(treasureImage);
		treasureImageView.setX(treasure.getLocation().getX() * scale);
		treasureImageView.setY(treasure.getLocation().getY() * scale);
	}


	public void loadPirateImages() {
		pirateImage = new Image("pirateShip.png", scale, scale, false, false);
		for(PirateShip pir: pirateShipList) {
			pirateImageView = new ImageView(pirateImage);
			pirateImageView.setX(pir.getLocation().getX() * scale);
			pirateImageView.setY(pir.getLocation().getY() * scale);
			pirateImageViewList.add(pirateImageView);
		}
	}



	public void updateImageLocation() {
		shipImageView.setX(ship.getLocation().getX() * scale);
		shipImageView.setY(ship.getLocation().getY() * scale);
		int counter = 0;
		for(ImageView pirIV: pirateImageViewList) {
			pirIV.setX(pirateShipList.get(counter).getLocation().getX() * scale);
			pirIV.setY(pirateShipList.get(counter).getLocation().getY() * scale);
			counter++;
		}
		System.out.println();
		//map.displayMap();
	}

	public void placeShips() {
		ship = new PlayerShip();
		int x = rand.nextInt(13);
		while (x < 6){
			x = rand.nextInt(13);
		}
		for(int i = 0; i < x; i++){
			pirateShipList.add(new PirateShip());
		}
	}
	
	public void placeTreasure() {
		treasure = new TreasurePiece();
		
	}
	public void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent> () {

			@Override
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
				case RIGHT:
					ship.shipMovementStrat.goEast();
					for(PirateShip pir: pirateShipList) {
						pir.update(ship, mapArray);
					}
					break;
				case LEFT:
					ship.shipMovementStrat.goWest();
					for(PirateShip pir: pirateShipList) {
						pir.update(ship, mapArray);
					}
					break;
				case DOWN:
					ship.shipMovementStrat.goSouth();
					for(PirateShip pir: pirateShipList) {
						pir.update(ship, mapArray);
					}
					break;
				case UP:
					ship.shipMovementStrat.goNorth();
					for(PirateShip pir: pirateShipList) {
						pir.update(ship, mapArray);
					}
					break;
				default:
					break;
				}
				updateImageLocation();
				System.out.println(ship.getLocation().toString());
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}