package ensta;
import java.io.Serializable;
import java.util.*;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getLength());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            char o = res.orientation.charAt(0);

            if (o == 'n') { s.setOrientation(AbstractShip.Orientation.NORTH); }
            else if (o == 'e') { s.setOrientation(AbstractShip.Orientation.EAST); }
            else if (o == 's') { s.setOrientation(AbstractShip.Orientation.SOUTH); }
            else if (o == 'w') { s.setOrientation(AbstractShip.Orientation.WEST); }
            // TODO put ship at given position
			board.putShip(s, res.x, res.y);
			
            // TODO when ship placement successful
            if (s.getInitialized()){ ++i; }
            done = i == 5;

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.print("où frapper? ");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard
            done = true;
            try {
                hit = this.opponentBoard.sendHit(hitInput.x + 1, hitInput.y + 1);
                coords[0] = hitInput.x;
                coords[1] = hitInput.y;

            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                done = false;
                System.out.println("Frappe envoyée hors des limites, essaie encore !");
            }
            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?

            // ==> On stocke les valeurs dans coord


        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
