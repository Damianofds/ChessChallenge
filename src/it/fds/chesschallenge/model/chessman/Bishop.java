package it.fds.chesschallenge.model.chessman;


/**
 * @author DamianoG
 *
 */
public class Bishop extends Chessman {

    public Bishop(int id) {
        super(id);
    }

    public Bishop(int id, int j, int k) {
        super(id, j, k);
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkDiagonal(true, positionMatrix);
    }

}
