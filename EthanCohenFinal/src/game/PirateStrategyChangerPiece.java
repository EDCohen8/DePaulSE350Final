package game;
import java.awt.Point;
import java.util.Random;

public class PirateStrategyChangerPiece implements GamePiece, PowerUpInterface {


	int x, y;
	Random rand = new Random();
	Grid grid;
	GamePiece[][] map;

	PowerUpInterface powerUp;
	public PirateStrategyChangerPiece(PowerUpInterface powerUp){
		this.powerUp=powerUp;

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

	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		//does nothing
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "?";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "?";
	}

	@Override
	public void power() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++){
				if(map[j][i] instanceof PirateShip){
					PirateShip ps = (PirateShip) map[j][i];
					ps.changeFollowStrategy();			
				}
			}
		}

	}
}