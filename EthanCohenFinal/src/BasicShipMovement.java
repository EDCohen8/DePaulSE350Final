
public class BasicShipMovement implements ShipMovementInterface {

	int x, y;
	Grid grid;
	GamePiece[][] gameMap;
	PlayerShip ship;

	public BasicShipMovement(PlayerShip ship) {
		this.ship = ship;
		grid = Grid.getInstance();
		gameMap = grid.getMap();
		for(int i = 0; i < gameMap[0].length; i++ ) {
			for(int j = 0; j < gameMap.length; j++) {
				if(gameMap[i][j] instanceof PlayerShip) {
					x = j;
					y = i;
					break;
				}
			}
		}
	}

	@Override
	public void goEast() {
		// TODO Auto-generated method stub
		if(x < gameMap.length -1) {
			if(gameMap[y][x+1] instanceof OceanPiece) {
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(1);
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof StarPiece) {
				System.out.println("YES");
				gameMap[y][x] = new OceanPiece(x ,y);
				ship.incrementX(1);
				StarPiece a = (StarPiece)gameMap[y][x + 1];
				a.power();
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof TreasurePiece) {
				ship.incrementX(1);
				gameMap[y][++x] = ship;
			}
		}
	}

	@Override
	public void goWest() {
		// TODO Auto-generated method stub
		if(x > 0) {
			if(gameMap[y][x-1] instanceof OceanPiece) {
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof StarPiece) {
				System.out.println("YES");
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				StarPiece a = (StarPiece)gameMap[y][x - 1];
				a.power();
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof TreasurePiece) {
				ship.incrementX(-1);
				gameMap[y][--x] = ship;
			}
		}
	}

	@Override
	public void goNorth() {
		// TODO Auto-generated method stub
		if(y > 0) {
			if(gameMap[y-1][x] instanceof OceanPiece) {
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
			else if(gameMap[y-1][x] instanceof StarPiece) {
				System.out.println("YES");
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				StarPiece a = (StarPiece)gameMap[y-1][x];
				a.power();
				gameMap[--y][x] = ship;
			}
			if(gameMap[y-1][x] instanceof TreasurePiece) {
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
		}
	}

	@Override
	public void goSouth() {
		// TODO Auto-generated method stub
		System.out.println(y + " " + (gameMap[0].length - 1));
		if (y < gameMap[0].length - 1) {
			if(gameMap[y+1][x] instanceof OceanPiece){
				gameMap[y][x] = new OceanPiece(x , y);
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof StarPiece) {
				System.out.println("YES");
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				StarPiece a = (StarPiece)gameMap[y+1][x];
				a.power();
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof TreasurePiece){
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}


		}

	}
}
