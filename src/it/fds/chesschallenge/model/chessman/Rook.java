package it.fds.chesschallenge.model.chessman;


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
    }
    
    /**
     * @param i
     * @param j
     * @param k
     */
    public Rook(int id, int j, int k) {
        super(id, j, k);
        
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(boolean[][] positionMatrix) {
        return checkXY(true, positionMatrix);
    }
}
