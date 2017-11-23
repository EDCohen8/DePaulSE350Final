import java.awt.Point;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SuperMonsterSprite implements MonsterSpriteInterface, GamePiece{
	
	int x, y;
	Grid grid;
	GamePiece[][] map;
	Random rand = new Random();
	
	Circle circle;
	int scalingFactor = 14;
	int radius = 10;
	int size, classnum;
	
	public SuperMonsterSprite(int x, int y) {
		grid = Grid.getInstance();
		map = grid.getMap();
		circle = new Circle();
		circle.setFill(Color.RED);
		circle.setStroke(Color.RED);
		this.x = x;
		this.y = y;
		size = 2;
		setPositionX(this.x);
		setPositionY(this.y);
		circle.setRadius(radius * size);
	}

	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "M";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x, y);
	}

	@Override
	public MonsterSpriteInterface getComponent() {
		// TODO Auto-generated method stub
		return (MonsterSpriteInterface) circle;
	}

	@Override
	public Circle getCircle() {
		// TODO Auto-generated method stub
		return circle;
	}

	@Override
	public void setX(int xPos) {
		// TODO Auto-generated method stub
		x = xPos;
		
	}

	@Override
	public void setY(int yPos) {
		// TODO Auto-generated method stub
		y = yPos;
	}

	@Override
	public void setSize(int newSize) {
		// TODO Auto-generated method stub
		size = newSize;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setPositionX(int x) {
		// TODO Auto-generated method stub
		circle.setCenterX(x*scalingFactor + (scalingFactor/2));
	}

	@Override
	public void setPositionY(int y) {
		// TODO Auto-generated method stub
		circle.setCenterY(y*scalingFactor + (scalingFactor/2));
	}

	@Override
	public void incrementSize() {
		// TODO Auto-generated method stub
		size++;
	}

	@Override
	public int getIndexNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getClassNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeClassNum() {
		// TODO Auto-generated method stub
		
	}

	public void addToPane(ObservableList<Node> sceneGraph) {
		System.out.println("Adding circle to pane: " + circle.getCenterX() + " " + circle.getCenterY() + " " + radius);
		sceneGraph.add(circle);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
