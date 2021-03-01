package ensta;
import java.util.*;

public class TestBoard {
	public static void main(String[] args) {
		
		//Test exo 1

		/*Board testBoard = new Board("Nico", 15);
		testBoard.print();*/
			
		//Test exo 2

		/*Board testBoard = new Board("Nico", 15);
		Submarine testSubmarine = new Submarine(AbstractShip.Orientation.EAST);
        System.out.println(testSubmarine.orientation);
        testSubmarine.setOrientation(AbstractShip.Orientation.WEST);
        System.out.println(testSubmarine.orientation);*/
		
		// Test exo 3
		
		/*Board testBoard = new Board("Nico", 15);
        // On essaie de placer un sous-marin en dehors de la grille ==> Erreur.
        testBoard.putShip(testSubmarine, 15, 15);
        System.out.println(testBoard.hasShip(0,15));*/
				
		/* Destroyer testDestroyer = new Destroyer(AbstractShip.Orientation.NORTH);
		Carrier	testCarrier = new Carrier(AbstractShip.Orientation.WEST);
		/*testBoard.putShip(testDestroyer, 1, 15);
		testDestroyer.setOrientation(AbstractShip.Orientation.EAST);
        testBoard.putShip(testDestroyer, 1, 1);
		/*testDestroyer.setOrientation(AbstractShip.Orientation.SOUTH);
        testBoard.putShip(testDestroyer, 15, 1);
		testDestroyer.setOrientation(AbstractShip.Orientation.WEST	);
        testBoard.putShip(testDestroyer, 15, 15);
		testDestroyer.setOrientation(AbstractShip.Orientation.EAST);
		testBoard.putShip(testDestroyer, 13, 15);
        testBoard.putShip(testCarrier, 10, 8);
		testBoard.putShip(testCarrier, 2, 10);
		testBoard.print();*/
		
		// Test exo 4
		
        /*Board testEnnemyBoard = new Board("Test", 15);
		List<AbstractShip> ships = new ArrayList();
        Player testPlayer = new Player(testBoard,testEnnemyBoard, ships);*/
		
		// Test exo 5
		
		/*Board testBoard = new Board("Nico", 15);
		Destroyer testDestroyer = new Destroyer(AbstractShip.Orientation.NORTH);
        testBoard.putShip(testDestroyer, 5, 14);
		testBoard.setHit(true, 3,3);
		testBoard.setHit(false, 5,5);
        testBoard.print();*/
        // Tout marche comme souhaité.
		
		// Test exo 6
		
        Hit testHit;
        Board testBoard = new Board("Nico", 35);
        Destroyer testDestroyer = new Destroyer(AbstractShip.Orientation.EAST);
        testBoard.putShip(testDestroyer, 10, 5);
        testBoard.print();
		testHit = testBoard.sendHit(10,5);
		System.out.println(testHit.toString());
        testBoard.print();
        testHit = testBoard.sendHit(9,5);
		System.out.println(testHit.toString()); // doit renvoyer "Manqué"
		testBoard.print();
		testHit = testBoard.sendHit(11,5); // doit retourner la valeur TYPE_DU_NAVIRE
       	System.out.println(testHit.toString());
		testBoard.print();

        System.out.println("Navire coulé  ? ==> " + testDestroyer.isSunk());
        System.out.println("Dernière valeur renvoyée ? ==> " + testHit.toString());
        //Cela fonctionne bien		
	}
}