package ensta;

public class ShipState
{
	private AbstractShip ship;
	private Boolean struck;
	
	public ShipState() { struck = null; }

	public ShipState(AbstractShip ship){
		this.ship = ship;
		this.struck = false;
	}

	public void addStrike(){
		if (struck != null && struck != true){
			this.struck = true;
			ship.addStrike();
		}
	}
	
	public void launchStrike(){
		this.struck = true;
	}

	public Boolean isStruck(){ return struck; }

	public String toString(){
		if (struck == null){ return "."; }
		else if (struck == true){ return ColorUtil.colorize(Character.toString(ship.label), ColorUtil.Color.RED);}
		else{ return Character.toString(ship.label); }
	}

	public AbstractShip getShip(){ return ship; }
}