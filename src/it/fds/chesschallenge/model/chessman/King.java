package it.fds.chesschallenge.model.chessman;


/**
 * @author DamianoG
 *
 */
public class King extends Chessman{

    public King(int id) {
        super(id);
    }

    public King(int id, int j, int k) {
        super(id,j, k);
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkXY(false, positionMatrix) || checkDiagonal(false, positionMatrix);
    }
}
