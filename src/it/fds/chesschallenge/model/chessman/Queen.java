package it.fds.chesschallenge.model.chessman;


/**
 * @author DamianoG
 *
 */
public class Queen extends Chessman {

    public Queen(int id) {
        super(id);
    }

    public Queen(int id, int j, int k) {
        super(id, j, k);
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkXY(true, positionMatrix) || checkDiagonal(true, positionMatrix);
    }
}
