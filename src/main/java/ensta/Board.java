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
	
	public String getName() {return name; }
	
	public void setName(String name) {this.name = name; }
	
	public Character[][] getMyGrid() {return ship; }
	
	public Boolean[][] getEnemyGrid() {	return hits; }
	
	public int getSize() { return this.size; }

	public void saut_ligne(int n){
		for (int i = 0 ; i < n ; i++){
			System.out.println(" ");
		}
	}

	public void printspaces(int n){
		for (int i = 0 ; i < n ; i++){
			System.out.print(" ");
		}
	}

	public void centrer_nom(){
		saut_ligne(1);
		printspaces(2 * getSize() + 6 - this.name.length()/2 + 2);	// centrer le nom
		System.out.println(this.name);
		saut_ligne(1);
	}
	
	public void affichage_init(){
		centrer_nom();
		printspaces(getSize() + 3);
		System.out.print("SHIPS");
		printspaces(2 * getSize());
		System.out.print("HITS");
		saut_ligne(2);		
		affichage_pointillés();
	}
	
	public void affichage_lettre(){
		char ch = 'A';
		for (int i = 0 ; i < getSize() ; i ++){
			System.out.print(ch);
			ch += 1;
			printspaces(1);
		}
	}
	
	public void affichage_lettres_global(){
		printspaces(5);
		affichage_lettre();
		printspaces(6);
		affichage_lettre();
		saut_ligne(1);
	}
	
	public void affichage_pointillés(){
		for (int k = 0 ; k < 4 * getSize() + 14 ; k ++){
			System.out.print("-");
		}
		saut_ligne(1);
	}
	
	public void affichage_numéros_début_lignes(int i){
		if (i < 9) {
			printspaces(1);
		}
		System.out.print(i+1);
		printspaces(1);
		System.out.print("|");
		printspaces(1);
	}
	
	public void affichage_ships(int i, int j){
		System.out.print(this.ship[i][j]);
		printspaces(1);
	}
	
	public void affichage_central(){
		printspaces(1);
		System.out.print(" || ");
		printspaces(1);
	}
	
	public void affichage_hits(int i, int j){
		if (this.hits[i][j]) {
			System.out.print("x");
			printspaces(1);
		}
		else {
			System.out.print(".");
			printspaces(1);
		}
	}
	
	public void affichage_numéros_fin_lignes(int i){
		System.out.print("|");
		if (i < 9) {
			printspaces(1);
		}
		System.out.print(i+1);
		printspaces(1);
		saut_ligne(1);
	}
	
	public void affichage_grilles(){
			for (int i = 0 ; i < getSize() ; i++){
				affichage_numéros_début_lignes(i);
				for (int j = 0; j < getSize() ; j++) { affichage_ships(i,j); }
				affichage_central();
				for (int j = 0; j < getSize() ; j++) { affichage_hits(i,j);}
				affichage_numéros_fin_lignes(i);
			}
	}

	public void print() {
		affichage_init();
		affichage_lettres_global();
		affichage_pointillés();
		affichage_grilles();
		affichage_pointillés();
	saut_ligne(2);
	}
}