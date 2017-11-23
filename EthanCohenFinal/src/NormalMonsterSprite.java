import java.awt.Point;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NormalMonsterSprite implements MonsterSpriteInterface, GamePiece {
	int x, y;
	Grid grid;
	GamePiece[][] map;
	Random rand = new Random();
	
	Circle circle;
	int scalingFactor = 14;
	int radius = 10;
	int size, classnum;
	
	public NormalMonsterSprite(int scalingFactorScale) {
		grid = Grid.getInstance();
		map = grid.getMap();
		circle = new Circle();
		circle.setFill(Color.BLACK);
		scalingFactor = scalingFactorScale;
		x = rand.nextInt(map.length - 1);
		y = rand.nextInt(map[0].length - 1);
		while(!(map[y][x] instanceof OceanPiece)) {
			if(map[y][x] instanceof NormalMonsterSprite){
				NormalMonsterSprite nmSprite = (NormalMonsterSprite)map[y][x];
				nmSprite.destroy();
				map[y][x] = new SuperMonsterSprite(x,y, circle);
				System.out.println("YAY");
			}
			x = rand.nextInt(map.length - 1);
			y = rand.nextInt(map[0].length - 1);
		}
		setPositionX(x);
		setPositionY(y);
		map[y][x] = this;
		size = 1;
		circle.setRadius(radius);
	}

	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "m";
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
		setPositionX(x);
	}

	@Override
	public void setY(int yPos) {
		// TODO Auto-generated method stub
		y = yPos;
		setPositionY(y);
	}

	@Override
	public void setSize(int newSize) {
		// TODO Auto-generated method stub
		size = 1;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
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

	public void destroy() {
		map[y][x] = new OceanPiece(x, y);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.TRANSPARENT);
	}
	
	@Override
	public void incrementSize() {
		// TODO Auto-generated method stub
		System.out.println("Size of normal monster cannot increase");
	}

	@Override
	public int getIndexNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getClassNum() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void changeClassNum() {
		// TODO Auto-generated method stub
		
	}

}
