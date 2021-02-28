package ensta;

public class Submarine extends AbstractShip 
{
	public Submarine(AbstractShip.Orientation orientation){ super('S', "Submarine", 3, orientation); }

	public Submarine(){ this(AbstractShip.Orientation.EAST); }
}