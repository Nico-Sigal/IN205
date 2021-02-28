package ensta;

public class Destroyer extends AbstractShip 
{
	public Destroyer(AbstractShip.Orientation orientation){ super('D', "Destroyer", 2, orientation); }

	public Destroyer(){ this(AbstractShip.Orientation.EAST); }
}