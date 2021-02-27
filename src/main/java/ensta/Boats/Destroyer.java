package ensta;

public class Destroyer extends AbstractShip 
{
	public Destroyer(AbstractShip.Orientation orientation){ super("Destroyer", 'D', 2, orientation); }

	public Destroyer(){ this(AbstractShip.Orientation.EAST); }
}