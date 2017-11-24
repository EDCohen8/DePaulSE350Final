package game;
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
		map[y][x] = this;
	}
	
	//moves treasure closer to the ship
	@Override
	public void move(int xPos, int yPos) {
		
		grid.displayMap();
		System.out.println("MOVING TREASURE FROM " + this.getLocation().toString());
		// TODO Auto-generated method stub
		int shipX= 0, shipY = 0, newTreasureX = xPos, newTreasureY = yPos;
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[j][i] instanceof PlayerShip){
					shipX = i;
					shipY = j;
				}
			}
		}
		if(shipX < x){
			newTreasureX = x - 1;
		}
		else if(shipX > x) {
			newTreasureX = x + 1;
		}
		if(shipY < y) {
			newTreasureY = y - 1;
		}
		else if(shipY > y) {
			newTreasureY = x + 1;
		}
		map[y][x] = new OceanPiece(x, y);
		x = newTreasureX;
		y = newTreasureX;
		map[y][x] = this; 
		System.out.println("MOVING TREASURE TO " + this.getLocation().toString());
		System.out.println();
		grid.displayMap();
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
