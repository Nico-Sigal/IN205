package ensta;
import java.util.*;

public class TestGame
{
	private static void sleep(int ms) 
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main( String[] args )
    {
    	IBoard testBoard = new Board("TEST",15);
    	testBoard.print();
    	int counter = 5;
    	Hit testHit;
        Random rnd = new Random();

    	AbstractShip ships[] = new AbstractShip[] {new Destroyer(), 
    											new Submarine(), 
    											new Submarine(),
    											new Battleship(),
    											new Carrier() };
    	BattleShipsAI ai = new BattleShipsAI(testBoard, testBoard);
    	ai.putShips(ships);
		    	
    	while (counter != 0)
    	{

    		int[] coords = new int[2];
    		testHit =ai.sendHit(coords);
    		System.out.println(testHit.toString());
    		testBoard.print();

    		if (testHit.getValue() > 0)
    			counter--;

    		sleep(100);
    	}
    }
}