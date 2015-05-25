package it.fds.chesschallenge.model.chessman;

import it.fds.chesschallenge.model.chessboard.ChessBoard;


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
    public boolean isThreatening(ChessBoard board) {
        return checkXY(true, board) || checkDiagonal(true, board);
    }
}
