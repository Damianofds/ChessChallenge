package it.fds.chesschallenge.model.chessman;

import it.fds.chesschallenge.model.chessboard.ChessBoard;


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
    }

    /**
     * @param i
     * @param j
     * @param k
     */
    public Knight(int id, int j, int k) {
        super(id, j, k);        
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#move(boolean[][])
     */
    @Override
    public boolean isThreatening(ChessBoard board) {
        return checkAlongCircle(board);
    }

    /**
     * Checks if at least another one chessman is placed over one of the allowed knight moves
     * 
     * @param positionMatrix the representation of the chessmen positions over the chessboard as a boolean matrix
     * @return true if at least one chessman is found on the checked tiles, false otherwise
     */
    public boolean checkAlongCircle(ChessBoard board){
        
        int positionsToCheck[][] = {
                {x-2,y+1},{x-1,y+2}, //upper left side
                {x+2,y+1},{x+1,y+2}, //upper right side
                {x-2,y-1},{x-1,y-2}, //lower left side
                {x+2,y-1},{x+1,y-2} //lower right side
            };
        for(int i=0; i<8; i++){
            if(checkForTreaths(positionsToCheck[i][0], positionsToCheck[i][1], board)){
                return true;
            }
        }
        return false;
        
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessman.Chessman#checkForTreaths(boolean[][])
     */
    private boolean checkForTreaths(int x, int y, ChessBoard board) {
        if(!board.isOutsideBounds(x, y) && board.isOccupied(x, y)){
            return true;
        }
        return false;
    }
}