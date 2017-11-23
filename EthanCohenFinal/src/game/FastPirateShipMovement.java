package game;
import java.util.Observable;
import java.util.Random;

public class FastPirateShipMovement implements PirateMovementInterface {

	Random rand = new Random();
	int x, y;
	Grid map = Grid.getInstance();
	GamePiece[][] gameMap = map.getMap();

	@Override
	public void updateStrat(Observable o, Object arg, PirateShip pir) {
		// TODO Auto-generated method stub
		PlayerShip ship = (PlayerShip) o;
		int willMove = rand.nextInt(4);
		x = (int)pir.getLocation().getX();
		y = (int)pir.getLocation().getY();
		if(willMove >= 2){
			if((int)ship.getLocation().getX() < x) {
				if (x-2 > 0) {
					if(gameMap[y][x-2] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x , y);
						x = x-2;
						gameMap[y][x] = pir;
					}
					else if(gameMap[y][x-2] instanceof PlayerShip) {
						gameMap[y][x] = new OceanPiece(x , y);
						x = x-2;
						pir.changeGameOverBoolean();
						gameMap[y][x] = pir;
					}
				}
			}
			else if((int)ship.getLocation().getX() > x) {
				if (x+2 < gameMap.length) {
					if(gameMap[y][x+2] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x , y);
						x = x + 2;
						gameMap[y][x] = pir;
					}
					else if(gameMap[y][x+2] instanceof PlayerShip) {
						gameMap[y][x] = new OceanPiece(x , y);
						x = x + 2;
						pir.changeGameOverBoolean();
						gameMap[y][x] = pir;
					}
				}
			}
			if((int)ship.getLocation().getY() < y) {
				if (y-2 > 0) {
					if(gameMap[y-2][x] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x, y);
						y = y - 2;
						gameMap[y][x] = pir;
					}
					else if(gameMap[y-2][x] instanceof PlayerShip) {
						gameMap[y][x] = new OceanPiece(x, y);
						y = y - 2;
						pir.changeGameOverBoolean();
						gameMap[y][x] = pir;
					}
				}
			}
			else if((int)ship.getLocation().getY() > y) {
				if(y+2 < gameMap[0].length) {
					if(gameMap[y+2][x] instanceof OceanPiece) {
						gameMap[y][x] = new OceanPiece(x,y);
						y = y + 2;
						gameMap[y][x] = pir;
					}
					else if(gameMap[y+2][x] instanceof PlayerShip) {
						gameMap[y][x] = new OceanPiece(x,y);
						y = y + 2;
						pir.changeGameOverBoolean();
						gameMap[y][x] = pir;
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
