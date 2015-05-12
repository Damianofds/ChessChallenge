package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 *
 */
public class Queen extends Chessman {

    /**
     * @param id
     */
    public Queen(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkXY(true, positionMatrix) || checkDiagonal(true, positionMatrix);
    }
}
