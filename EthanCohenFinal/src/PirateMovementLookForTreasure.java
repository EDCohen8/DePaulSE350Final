import java.util.Observable;

public class PirateMovementLookForTreasure implements PirateMovementInterface {

	int x, y;
	Grid map = Grid.getInstance();
	GamePiece[][] gameMap = map.getMap();
	boolean left = true, down = true, moved;
	@Override
	public void updateStrat(Observable o, Object arg, PirateShip pir) {
		// TODO Auto-generated method stub
		PlayerShip ship = (PlayerShip) o;
		x = (int)pir.getLocation().getX();
		y = (int)pir.getLocation().getY();
		moved = false;
		if(left){
			if(x > 0){
				x--;
				while(x != 0 && (gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip) && y <= 48) {
					x--;
				}
				if(gameMap[y][x] instanceof PlayerShip || gameMap[y][x] instanceof TreasurePiece){
					System.out.println("Game Over");
					pir.changeGameOverBoolean();
					moved = true;
				}
				if(gameMap[y][x] instanceof OceanPiece){
					gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
					gameMap[y][x] = pir;
					moved = true;
				}
			}
			if(x == 0 && !moved){
				left = false;
				if(down){
					if(++y < gameMap[0].length){
						while(gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip){
							x= x+1;
						}
						if(gameMap[y][x] instanceof PlayerShip  || gameMap[y][x] instanceof TreasurePiece){
							System.out.println("Game Over");
							pir.changeGameOverBoolean();
							moved = true;
						}
						else if(gameMap[y][x] instanceof OceanPiece){
							gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
							gameMap[y][x] = pir;
							moved = true;
						}
					}
					if(y == gameMap[0].length - 1){
						down = false;
					}
				}
				else if(!down){
					if(--y > 0){
						while(gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip && x > 0){
							x= x-1;
						}
						if(gameMap[y][x] instanceof PlayerShip){
							System.out.println("Game Over");
							pir.changeGameOverBoolean();
							moved = true;
						}
						if(gameMap[y][x] instanceof IslandPiece){
							gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
							gameMap[y][x] = pir;
							moved = true;
						}
					}
					if(y == 0) {
						down = true;
					}
				}
			}
		}
		if(!left && !moved){
			if(++x < gameMap.length-1) {
				while(x != gameMap.length-1 && (gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip) && x < gameMap.length -1 && y < 49) {
					x++;
				}
				if(gameMap[y][x] instanceof PlayerShip || gameMap[y][x] instanceof TreasurePiece){
					System.out.println("Game Over");
					pir.changeGameOverBoolean();
					moved = true;
				}
				if(gameMap[y][x] instanceof OceanPiece){
					gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
					gameMap[y][x] = pir;
					moved = true;
				}
			}

		}
		if(x == gameMap.length -1 && !moved){
			left = true;
			if(down){
				if(++y < gameMap[0].length - 1 ){
					while((gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip) && x < gameMap.length-1){
						x= x-1;
					}
					if(gameMap[y][x] instanceof PlayerShip  || gameMap[y][x] instanceof TreasurePiece){
						System.out.println("Game Over");
						pir.changeGameOverBoolean();
						moved = true;
					}
					if(gameMap[y][x] instanceof OceanPiece){
						gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
						gameMap[y][x] = pir;
						moved = true;
					}
				}
				if(y == gameMap[0].length - 1){
					down = false;
				}
			}
			else if(!down){
				if(--y > 0){
					while(gameMap[y][x] instanceof IslandPiece || gameMap[y][x] instanceof PirateShip){
						x= x-1;
					}
					if(gameMap[y][x] instanceof PlayerShip){
						System.out.println("Game Over");
						pir.changeGameOverBoolean();
						moved = true;
					}
					if(gameMap[y][x] instanceof IslandPiece){
						gameMap[(int)pir.getLocation().getY()][(int)pir.getLocation().getX()] = new OceanPiece((int)pir.getLocation().getX(), (int)pir.getLocation().getY());
						gameMap[y][x] = pir;
						moved = true;
					}
				}
				if(y == 0){
					down = true;
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
