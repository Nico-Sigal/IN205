package ensta;

public class AbstractShip {
		
	public char label;
	public String name;
	public int size;
	public enum Orientation {NORTH,EAST,SOUTH,WEST};
	public Orientation orientation;
	public int strikeCount;

	public String getName() {return this.name; }
	
	public int getLength() {return this.size; }
	
	public Orientation getOrientation() { return this.orientation; }
	
	public void setOrientation(Orientation orientation) {this.orientation = orientation; }
	
	public void addStrike(){ strikeCount ++; }

	public boolean isDestroyed(){
		boolean destroyed = strikeCount == size ? true : false ;
		return destroyed;
	}
	
	public AbstractShip(char label, String name, int size, Orientation orientation){
		this.label = label;
		this.name = name;
		this.size = size;
		this.orientation = orientation;
		this.strikeCount = 0;
	}
}