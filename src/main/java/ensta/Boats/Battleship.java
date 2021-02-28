package ensta;

public class Battleship extends AbstractShip 
{
	public Battleship(AbstractShip.Orientation orientation){ super('B', "Battleship", 4, orientation); }

	public Battleship(){ this(AbstractShip.Orientation.EAST); }
}