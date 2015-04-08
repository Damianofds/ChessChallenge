package it.fds.chesschallenge.model;


/**
 * @author DamianoG
 *
 */
public class Knight extends Chessman {

    /**
     * @param id
     */
    public Knight(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkAlongCircle(positionMatrix);
    }


    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.Chessman#checkForTreaths(boolean[][])
     */
    @Override
    protected boolean checkForTreaths(int x, int y, boolean positionMatrix[][]) {
        int n = positionMatrix.length;
        int m = positionMatrix[0].length;
        if(!isOutsideChessboard(x, y, n, m) && positionMatrix[x][y]){
            return true;
        }
        return false;
    }
}