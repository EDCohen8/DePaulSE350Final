package game;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
//OBSERVABLE DESIGN AND MOVES WITH STRATEGY DESIGN
public class PirateShip implements GamePiece, Observer {
	int x, y, randSearch;
	Random rand = new Random();
	Grid grid;
	GamePiece[][] map;
	PirateMovementInterface movementStrat;
	boolean gameOverBoolean;
	public PirateShip() {
		grid = Grid.getInstance();
		map = grid.getMap();
		x = rand.nextInt(map.length);
		y = rand.nextInt(map[0].length);
		randSearch = rand.nextInt(3);
		while(!(map[y][x] instanceof OceanPiece)){
			x = rand.nextInt(map.length);
			y = rand.nextInt(map[0].length);
		}
		grid.addPirateShip(x, y, this);
		if (randSearch == 0) {
			movementStrat = new PirateMovementLookForTreasure();
		}
		else if (randSearch == 1)
		{
			movementStrat = new FastPirateShipMovement();
		}
		else {
			movementStrat = new NormalPirateShipMovement();
		}
		gameOverBoolean = false;
	}

	@Override
	public void move(int xPos, int yPos) {
		// TODO Auto-generated method stub
		//not implemented because Pirate moves from an interface strategy
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "P";
	}

	@Override
	public GamePiece getObject() {
		// TODO Auto-generated method stub
		return this;
	}

	//Changes movement strategy of the specific pirate, can be done at runtime
	public void changeFollowStrategy(){
		randSearch = rand.nextInt(6);
		if (randSearch == 0) {
			movementStrat = new PirateMovementLookForTreasure();
		}
		else {
			movementStrat = new NormalPirateShipMovement();
		}
	}
	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}

	//update movement based on when player ship moves.
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		movementStrat.updateStrat(arg0, arg1, this);
		x = movementStrat.getX();
		y = movementStrat.getY();
	}
	//makes gameOver display
	public void changeGameOverBoolean(){
		gameOverBoolean = true;
	}
	public boolean gameOver(){
		return gameOverBoolean;
	}

}
