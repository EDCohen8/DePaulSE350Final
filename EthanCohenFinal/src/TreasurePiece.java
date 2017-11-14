import java.awt.Point;
import java.util.Random;

public class TreasurePiece implements GamePiece {
	int x, y;
	Random rand = new Random();
	Grid grid;
	GamePiece[][] map;
	
	public TreasurePiece() {
		grid = Grid.getInstance();
		map = grid.getMap();
		x = rand.nextInt(map.length);
		y = rand.nextInt(map[0].length);
		while(!(map[y][x] instanceof OceanPiece)){
			x = rand.nextInt(map.length);
			y = rand.nextInt(map[0].length);
		}
	}
	
	
	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "T";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}
	
	

}
