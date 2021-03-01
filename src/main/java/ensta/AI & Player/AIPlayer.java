package ensta;
import java.io.Serializable;
import java.util.List;

public class AIPlayer extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai instead.
    /**
    SendHit adapté à une IA (appelle la fonction de BattleshipsAI)
    */
    public Hit sendHit(int[] coords){
        Hit hit = ai.sendHit(coords);
        return hit;
	}

    /**
    Initialisation automatique des navires de l'IA
    */
    public void putShips() {
        ai.putShips(ships);
	}
}
    