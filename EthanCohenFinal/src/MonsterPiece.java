import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MonsterPiece implements Runnable {

	Grid grid;
	boolean running = true;
	int radius;
	int scalingFactor;
	ArrayList<MonsterSpriteInterface> monsterSprites = new ArrayList<MonsterSpriteInterface>();
	GamePiece[][] map;
	int xMove, yMove;
	Random random;
	ObservableList<Node> gameEventScene;

	public MonsterPiece(int scalingFactorScale) {
		random = new Random();
		scalingFactor = scalingFactorScale;
		for(int i = 0; i < 15; i++) {
			monsterSprites.add(new NormalMonsterSprite(scalingFactor));
		}
		this.radius = 10;
		grid = Grid.getInstance();
		map = grid.getMap();
	}

	public ArrayList<MonsterSpriteInterface> getMonsterSprite() {
		return monsterSprites;
	}

	public void addToPane(ObservableList<Node> sceneGraph) {
		for(MonsterSpriteInterface monsterSprite: monsterSprites){
			Circle circle = monsterSprite.getCircle();
			System.out.println("Adding circle to pane: " + circle.getCenterX() + " " + circle.getCenterY() + " " + radius);
			sceneGraph.add(circle);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(300);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList<MonsterSpriteInterface> tempArrayList = new ArrayList<MonsterSpriteInterface>();
			ArrayList<MonsterSpriteInterface> removeFromList = new ArrayList<MonsterSpriteInterface>();
			for(MonsterSpriteInterface monsterSprite: monsterSprites) {
				if(monsterSprite instanceof NormalMonsterSprite) {
					map[monsterSprite.getY()][monsterSprite.getX()] = new OceanPiece(monsterSprite.getX(), monsterSprite.getY());
					xMove = monsterSprite.getX() + random.nextInt(3) - 1;
					yMove = monsterSprite.getY() + random.nextInt(3) - 1;
					if(xMove >= 0 && yMove >= 0 && xMove <= map.length-1 && yMove <= map[0].length-1)
						if(map[yMove][xMove] instanceof OceanPiece) {
							map[monsterSprite.getY()][monsterSprite.getX()] = new OceanPiece(monsterSprite.getX(), monsterSprite.getY());
							map[yMove][xMove] = (NormalMonsterSprite) monsterSprite;
							monsterSprite.setX(xMove);
							monsterSprite.setY(yMove);
							tempArrayList.add(monsterSprite);
						}
						else if(map[yMove][xMove] instanceof NormalMonsterSprite) {
							System.out.println("Making a SuperMonster");
							for(MonsterSpriteInterface monsterSpriteTemp: monsterSprites){
								if(monsterSpriteTemp.getY() == yMove && monsterSpriteTemp.getX() == xMove){
									removeFromList.add(monsterSpriteTemp);
								}
							}
							removeFromList.add(monsterSprite);
							MonsterSpriteInterface newSprite = (MonsterSpriteInterface) new SuperMonsterSprite(xMove, yMove);
							tempArrayList.add(newSprite);
							map[monsterSprite.getY()][monsterSprite.getX()] = new OceanPiece(monsterSprite.getX(), monsterSprite.getY());
							map[yMove][xMove] = (GamePiece) newSprite;
						}
						else if(map[yMove][xMove] instanceof PlayerShip) {
							PlayerShip playerShip =  (PlayerShip) map[yMove][xMove];
							playerShip.changeGameOverBoolean();
							map[yMove][xMove] = playerShip;
							monsterSprite.setX(xMove);
							monsterSprite.setY(yMove);
							System.out.println("YOU DIED TO A MONSTER");
						}
						else{
							map[monsterSprite.getY()][monsterSprite.getX()] = (GamePiece) monsterSprite;
							tempArrayList.add(monsterSprite);
						}
				}
				else if (monsterSprite instanceof SuperMonsterSprite) {
					System.out.println("SUPER MONSTER BABY");
				}
			}
			for(MonsterSpriteInterface removeS: removeFromList){
				removeS.destroy();
				if(tempArrayList.contains(removeS)){
					tempArrayList.remove(removeS);
				}
			}
			monsterSprites = tempArrayList;
		}

	}
}
