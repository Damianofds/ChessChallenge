package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 *
 */
public class Rook extends Chessman {

    /**
     * @param id
     */
    public Rook(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkAlongPlus(true, positionMatrix);
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#checkForTreaths(int, int, boolean[][])
     */
    @Override
    protected boolean checkForTreaths(int x, int y, boolean[][] positionMatrix) {
        throw new RuntimeException("This method hasn't been implemented yet...");
    }


}
