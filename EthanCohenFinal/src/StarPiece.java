import java.awt.Point;
import java.util.Random;

import javafx.application.Platform;

public class StarPiece implements GamePiece, PowerUpInterface {
	int x, y;
	Random rand = new Random();
	Grid grid;
	GamePiece[][] map;
	
	PowerUpInterface powerUp;
	public StarPiece(PowerUpInterface powerUp){
		this.powerUp=powerUp;
		
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
		return "*";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void power() {
		// TODO Auto-generated method stub
		
	}
	

}
