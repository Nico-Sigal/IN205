package ensta;

public class Board implements IBoard
{

	private int size;
	private String name;
	private ShipState[][] ship;
	private Boolean[][] hits;
	

	public Board(String name, int size){
		this.size = size;
		this.name = name;
		this.ship = new ShipState[size][size];
		this.hits = new Boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ship[i][j] = new ShipState();
				hits[i][j] = null;
			}
		}
	}
	
	public Board(String name) {
		this(name, 10);
	}
	
	public String getName() {return this.name; }
	
	public void setName(String name) {this.name = name; }
	
	public ShipState[][] getShip() {return ship; }
	
	public Boolean getHit(int x, int y)
	{
		try{
		return this.hits[y][x];
		}
		catch (Exception e)
		{
			System.out.println("Problème d'indice de type : " + e.toString() );
			System.out.println("Réponse à l'appel getHit("+x+","+y+") impossible, false renvoyé par défaut\n");
			return false;
		}
	}
	
	public int getSize() { return this.size; }

	public void sautLigne(int n){
		System.out.print(new String(new char[n]).replace("\0", "\n"));
	}

	public void printSpaces(int n){
		System.out.print(new String(new char[n]).replace("\0", " "));
	}

	public void centrerNom(){
		sautLigne(1);
		printSpaces(2 * getSize() + 6 - this.name.length()/2 + 2);	// centrer le nom
		System.out.println(this.name);
		sautLigne(1);
	}
	
	public void affichageInit(){
		centrerNom();
		printSpaces(getSize() + 2);
		System.out.print("SHIPS");
		printSpaces(2 * getSize());
		System.out.print("HITS");
		sautLigne(2);		
		affichagePointillés();
	}
	
	public void affichageLettre(){
		char ch = 'A';
		for (int i = 0 ; i < getSize() ; i ++){
			System.out.print(ch);
			ch += 1;
			printSpaces(1);
		}
	}
	
	public void affichageLettresGlobal(){
		printSpaces(4);
		affichageLettre();
		printSpaces(5);
		affichageLettre();
		sautLigne(1);
	}
	
	public void affichagePointillés(){
		for (int k = 0 ; k < 4 * getSize() + 13 ; k ++){
			System.out.print("-");
		}
		sautLigne(1);
	}
	
	public void affichageNumérosDébutLignes(int i){
		if (i < 9) {
			printSpaces(1);
		}
		System.out.print(i+1);
		printSpaces(1);
		System.out.print("|");
	}
	
	public void affichageShips(int i, int j){
		if (this.ship[i][j] == null){
			System.out.print(".");
			printSpaces(1);
		}
   		else { 
			System.out.print(this.ship[i][j].toString());
			printSpaces(1);
		}
	}
	
	public void affichageCentral(){
		System.out.print(" || ");
		printSpaces(1);
	}
	
	public void affichageHits(int i, int j){
		if (this.hits[i][j] == null){
			System.out.print(".");
			printSpaces(1);
		}
		else if(this.hits[i][j] == true){
			System.out.print(ColorUtil.colorize("X", ColorUtil.Color.RED));
			printSpaces(1);
		}
		else {
			System.out.print ("X ");	    
		}
	}
	
	public void affichageNumérosFinLignes(int i){
		System.out.print("|");
		if (i < 9) {
			printSpaces(1);
		}
		System.out.print(i+1);
		printSpaces(1);
		sautLigne(1);
	}
	
	public void affichageGrilles(){
			for (int i = 0 ; i < getSize() ; i++){
				affichageNumérosDébutLignes(i);
				for (int j = 0; j < getSize() ; j++) { affichageShips(i,j); }
				affichageCentral();
				for (int j = 0; j < getSize() ; j++) { affichageHits(i,j);}
				affichageNumérosFinLignes(i);
			}
	}

	public void print() {
		affichageInit();
		affichageLettresGlobal();
		affichagePointillés();
		affichageGrilles();
		affichagePointillés();
	sautLigne(2);
	}

	public ShipState[][] saveShips()
	{
		ShipState[][] saveShips = new ShipState[this.size][this.size];
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j< this.size; j++){
				if (this.ship[i][j].isStruck()==null){
					saveShips[i][j]=new ShipState();
				}
				else {
					saveShips[i][j]=this.ship[i][j];
				}
			}
		}
		return saveShips;
	}
	
	public void putShip(AbstractShip ship, int x, int y)
	{
		ShipState[][] saveShips = saveShips();
		AbstractShip.Orientation o = ship.getOrientation();
		ship.initialized = true;
		int no = 0 , ea = 0 , so = 0, we = 0;
		if (o == AbstractShip.Orientation.NORTH){ no = 1;}
		if (o == AbstractShip.Orientation.EAST){ ea = 1;}
		if (o == AbstractShip.Orientation.SOUTH){ so = 1;}
		if (o == AbstractShip.Orientation.WEST){ we = 1;}
		try
		{
			if (no+so == 1){
				if (y - 1 + (so-no) * ship.size > this.size || y + (so-no) * ship.size < 0){
					throw new Exception("Coordonées selon y trop grandes ou petites");
				}
				for (int i = 0; i < ship.size; i++){
					if (this.ship[y - 1 + (so-no) * i][x - 1 ].isStruck() != null){
						throw new Illegal­Argument­Exception ("Bateau déjà présent à cet endroit: " + ship.name.toString() + "non placé.");
					}
					this.ship[y - 1 + (so-no) * i][x - 1 ] = new ShipState(ship);
				}
			}
			if (ea+we == 1){
				if (x - 1 + (ea-we) * ship.size > this.size || x - 1 + (ea-we) * ship.size < -1){
					throw new Exception("Coordonnées selon y trop grandes ou petites : " + ship.name.toString() + " non placé.");
				}
				for (int j = 0; j < ship.size; j++){
					if (this.ship[y - 1][x - 1 + (ea-we) * j].isStruck() != null){
						throw new Illegal­Argument­Exception ("Bateau déjà présent à cet endroit : " + ship.name.toString() + " non placé.");
					}
					this.ship[y - 1][x - 1 + (ea-we) * j] = new ShipState(ship);
				}
			}
		}

		catch (Illegal­Argument­Exception e){
			ship.initialized = false;
			this.ship = saveShips;
			sautLigne(1);
			System.out.println("Problème de type : " + e.toString());
		}
		catch (Exception e){
			ship.initialized = false;
			this.ship = saveShips;
			sautLigne(1);
			System.out.println("Problème d'indice de type : " + e.toString());
		}
	}

	public boolean hasShip(int x, int y) 
	{
		try {
			if (this.ship[y-1][x-1].isStruck() == null || this.ship[y-1][x-1].getShip().isSunk()){ return false; }
			else { return true;}
		}
		catch (Exception e) {
			System.out.println("Problème d'indice de type : " + e.toString() );
			System.out.println("Réponse à l'appel hasShip("+x+","+y+") impossible, false renvoyé par défaut\n");
			return false;
		}
	}

	public void setHit(boolean hit, int x, int y)
	{
		try{
		this.hits[y][x] = hit;
		}
		catch (Exception e)
		{
			System.out.println("Problème d'indice de type : " + e.toString() );
			System.out.println("Frappe annulée\n");
		}
	}
		
	public Hit sendHit(int x, int y){
		Hit res;
		if (ship[y-1][x-1].isStruck() == null || ship[y-1][x-1].isStruck() == true) {
			//Si le navire est déjà touché on renvoie MISS
			return Hit.MISS;
		}
		else {
			ship[y-1][x-1].addStrike();
			if (ship[y-1][x-1].getShip().isSunk()){
				res = Hit.fromInt(ship[y-1][x-1].getShip().size);
				System.out.println(res.toString()+" ==> coulé\n");
				return res;
			}
			else{ return Hit.STRIKE; }
		}
	}
};