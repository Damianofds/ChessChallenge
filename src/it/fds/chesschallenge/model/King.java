package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 *
 */
public class King extends Chessman{

    /**
     * @param id
     */
    public King(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkXY(false, positionMatrix) || checkDiagonal(false, positionMatrix);
    }
}
