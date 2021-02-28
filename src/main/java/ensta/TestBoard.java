package ensta;
import java.util.*;

public class TestBoard {
	public static void main(String[] args) {
		
		//Test exo 1

		Board testBoard = new Board("Nico", 15);
		//testBoard.print();
			
		//Test exo 2

		Submarine testSubmarine = new Submarine(AbstractShip.Orientation.EAST);
        //System.out.println(testSubmarine.orientation);
        testSubmarine.setOrientation(AbstractShip.Orientation.WEST);
        //System.out.println(testSubmarine.orientation);
		
		// Test exo 3
		
        // On essaie de placer un sous-marin en dehors de la grille ==> Erreur.
        /*testBoard.putShip(testSubmarine, 15, 15);
        System.out.println(testBoard.hasShip(0,15));*/
				
		Destroyer testDestroyer = new Destroyer(AbstractShip.Orientation.NORTH);
		Carrier	testCarrier = new Carrier(AbstractShip.Orientation.WEST);
		/*testBoard.putShip(testDestroyer, 1, 15);
		testDestroyer.setOrientation(AbstractShip.Orientation.EAST);
        testBoard.putShip(testDestroyer, 1, 1);
		testDestroyer.setOrientation(AbstractShip.Orientation.SOUTH);
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
	}
}