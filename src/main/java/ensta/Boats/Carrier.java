package ensta;

public class Carrier extends AbstractShip 
{
	public Carrier(AbstractShip.Orientation orientation){ super('C', "Carrier", 5, orientation); }

	public Carrier(){ this(AbstractShip.Orientation.EAST); }
}