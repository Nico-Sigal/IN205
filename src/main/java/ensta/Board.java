package ensta;
import java.util.Arrays;

public class Board {
	private int size;
	private String name;
	private Character[][] ship;
	private Boolean[][] hits;
	

	public Board(String name, int size){
		this.size = size;
		this.name = name;
		this.ship = new Character[size][size];
		this.hits = new Boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ship[i][j] = '.';
				hits[i][j] = false;
			}
		}
	}
	
	public Board(String name) {
		this(name, 10);
	}
	
	public String getName() {return this.name; }
	
	public void setName(String name) {this.name = name; }
	
	public Character[][] getShip() {return ship; }
	
	public Boolean[][] getHits() {	return hits; }
	
	public int getSize() { return this.size; }

	public void sautLigne(int n){
		for (int i = 0 ; i < n ; i++){
			System.out.println(" ");
		}
	}

	public void printSpaces(int n){
		for (int i = 0 ; i < n ; i++){
			System.out.print(" ");
		}
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
		System.out.print(this.ship[i][j]);
		printSpaces(1);
	}
	
	public void affichage_central(){
		printSpaces(1);
		System.out.print(" || ");
		printSpaces(1);
	}
	
	public void affichageHits(int i, int j){
		if (this.hits[i][j]) {
			System.out.print("x");
			printSpaces(1);
		}
		else {
			System.out.print(".");
			printSpaces(1);
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
				affichage_central();
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
}