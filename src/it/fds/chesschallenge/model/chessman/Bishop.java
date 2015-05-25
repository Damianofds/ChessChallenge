package it.fds.chesschallenge.model.chessman;

import it.fds.chesschallenge.model.chessboard.ChessBoard;


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
    public boolean isThreatening(ChessBoard board) {
        return checkDiagonal(true, board);
    }

}
