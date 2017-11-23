
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
				gameMap[y][x] = new OceanPiece(x ,y);
				ship.incrementX(1);
				StarPiece a = (StarPiece)gameMap[y][x + 1];
				a.power();
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof TreasurePiece) {
				ship.changeYouWinBoolean();
				ship.incrementX(1);
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof NormalMonsterSprite) {
				ship.changeGameOverBoolean();
				ship.incrementX(1);
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof PirateShip) {
				ship.changeGameOverBoolean();
				ship.incrementX(1);
				gameMap[y][++x] = ship;
			}
			else if(gameMap[y][x+1] instanceof PirateStrategyChangerPiece){
				PirateStrategyChangerPiece b = (PirateStrategyChangerPiece) gameMap[y][x+1];
				b.power();
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
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				StarPiece a = (StarPiece)gameMap[y][x - 1];
				a.power();
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof TreasurePiece) {
				ship.changeYouWinBoolean();
				ship.incrementX(-1);
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof NormalMonsterSprite) {
				ship.changeGameOverBoolean();
				ship.incrementX(-1);
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof PirateShip) {
				ship.changeGameOverBoolean();
				ship.incrementX(-1);
				gameMap[y][--x] = ship;
			}
			else if(gameMap[y][x-1] instanceof PirateStrategyChangerPiece){
				PirateStrategyChangerPiece b = (PirateStrategyChangerPiece) gameMap[y][x-1];
				b.power();
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
				ship.incrementY(-1);
				StarPiece a = (StarPiece)gameMap[y-1][x];
				a.power();
				gameMap[--y][x] = ship;
			}
			else if(gameMap[y-1][x] instanceof TreasurePiece) {
				ship.changeYouWinBoolean();
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
			else if(gameMap[y-1][x] instanceof NormalMonsterSprite) {
				ship.changeGameOverBoolean();
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
			else if(gameMap[y-1][x] instanceof PirateShip) {
				ship.changeGameOverBoolean();
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
			else if(gameMap[y-1][x] instanceof PirateStrategyChangerPiece){
				PirateStrategyChangerPiece b = (PirateStrategyChangerPiece) gameMap[y-1][x];
				b.power();
				ship.incrementY(-1);
				gameMap[--y][x] = ship;
			}
		}
	}

	@Override
	public void goSouth() {
		// TODO Auto-generated method stub
		if (y < gameMap[0].length - 1) {
			if(gameMap[y+1][x] instanceof OceanPiece){
				gameMap[y][x] = new OceanPiece(x , y);
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof StarPiece) {
				gameMap[y][x] = new OceanPiece(x, y);
				ship.incrementX(-1);
				StarPiece a = (StarPiece)gameMap[y+1][x];
				a.power();
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof TreasurePiece){
				ship.changeYouWinBoolean();
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof NormalMonsterSprite){
				ship.changeGameOverBoolean();
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof PirateShip){
				ship.changeGameOverBoolean();
				gameMap[++y][x] = ship;
			}
			else if(gameMap[y+1][x] instanceof PirateStrategyChangerPiece){
				PirateStrategyChangerPiece b = (PirateStrategyChangerPiece) gameMap[y+1][x];
				b.power();
				ship.incrementY(1);
				gameMap[++y][x] = ship;
			}

		}

	}
}
