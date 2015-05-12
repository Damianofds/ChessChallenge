package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 *
 */
public class Bishop extends Chessman {

    /**
     * @param id
     */
    public Bishop(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkDiagonal(true, positionMatrix);
    }

}
