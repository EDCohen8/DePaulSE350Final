import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements GamePiece, Observer {
	int x, y;
	Random rand = new Random();
	Grid grid;
	GamePiece[][] map;
	PirateMovementInterface movementStrat;
	
	public PirateShip() {
		grid = Grid.getInstance();
		map = grid.getMap();
		x = rand.nextInt(map.length);
		y = rand.nextInt(map[0].length);
		while(!(map[y][x] instanceof OceanPiece)){
			x = rand.nextInt(map.length);
			y = rand.nextInt(map[0].length);
		}
		grid.addPirateShip(x, y, this);
		movementStrat = new PirateMovementLookForTreasure();
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
	
	//Changes movement strategy of the specific pirate
	public void changeFollowStrategy(PirateMovementInterface strat){
		movementStrat = strat;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return new Point(x,y);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		movementStrat.updateStrat(arg0, arg1, this);
		x = movementStrat.getX();
		y = movementStrat.getY();
	}

}
