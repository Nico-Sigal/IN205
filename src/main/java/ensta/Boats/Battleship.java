package ensta;

public class Battleship extends AbstractShip 
{
	public Battleship(AbstractShip.Orientation orientation){ super("Battleship", 'B', 4, orientation); }

	public Battleship(){ this(AbstractShip.Orientation.EAST); }
}