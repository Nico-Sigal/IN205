package ensta;

public class AbstractShip {
		
	public char label;
	public String name;
	public int size;
	public enum Orientation {NORTH,EAST,SOUTH,WEST};
	public Orientation orientation;
	public int strikeCount;
	public boolean initialized; // Pour savoir si le navire a été posé avec succes sur un board

	public AbstractShip(char label, String name, int size, Orientation orientation){
		this.name = name;
		this.label = label;
		this. size = size;
		this.orientation = orientation;
		this.strikeCount = 0;
	}
	
	public String getName() {return this.name; }
	
	public int getLength() {return this.size; }
	
	public Orientation getOrientation() { return this.orientation; }
	
	public void setOrientation(Orientation orientation) {this.orientation = orientation; }
	
	public void addStrike(){ strikeCount ++; }
	
	public boolean getInitialized() { return this.initialized; }

	public boolean isSunk(){
		boolean sunk = strikeCount == size ? true : false ;
		return sunk;
	}
}