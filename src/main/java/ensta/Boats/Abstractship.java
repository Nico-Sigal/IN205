package ensta;

enum Orientation {
	NORTH,
	WEST,
	SOUTH,
	EAST
}

public class AbstractShip {
		
	private char label;
	private String name;
	private int size;
	private Orientation orientation;
	public int strikeCount;

	public char getLabel() {return this.label; }

	public String getName() {return this.name; }
	
	public int getSize() {return this.size; }
	
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