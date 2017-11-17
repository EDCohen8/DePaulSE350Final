import javafx.scene.shape.Circle;

public interface MonsterSpriteInterface {
	public MonsterSpriteInterface getComponent();
	public Circle getCircle();
	public void setX(int xPos);
	public void setY(int yPos);
	public void setSize(int newSize);
	public int getSize();
	public int getX();
	public int getY();
	public void setPositionX(int x);
	public void setPositionY(int y);
	public void incrementSize();
	public int getIndexNum();
	public int getClassNum();
	public void changeClassNum();
	public void destroy();
}
