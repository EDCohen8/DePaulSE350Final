import java.util.Observable;
import java.util.Random;

public class NormalPirateShipMovement implements PirateMovementInterface{

	Random rand = new Random();
	int x, y;
	Grid map = Grid.getInstance();
	GamePiece[][] gameMap = map.getMap();

	@Override
	public void updateStrat(Observable o, Object arg, PirateShip pir) {
		// TODO Auto-generated method stub
		PlayerShip ship = (PlayerShip) o;
		int willMove = rand.nextInt(3);
		x = (int)pir.getLocation().getX();
		y = (int)pir.getLocation().getY();
		if(willMove > 1) {
			if((int)ship.getLocation().getX() < x) {
				if (x > 0) {
					if(gameMap[y][x-1] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x , y);
						gameMap[y][--x] = pir;
					}
				}
			}
			else if((int)ship.getLocation().getX() > x) {
				if (x < gameMap.length) {
					if(gameMap[y][x+1] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x , y);
						gameMap[y][++x] = pir;
					}
				}
			}
			if((int)ship.getLocation().getY() < y) {
				if (y > 0) {
					if(gameMap[y-1][x] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x, y);
						gameMap[--y][x] = pir;
					}
				}
			}
			else if((int)ship.getLocation().getY() > y) {
				if(y < gameMap[0].length) {
					if(gameMap[y+1][x] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x,y);
						gameMap[++y][x] = pir;
					}
				}
			}
		}
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

}
