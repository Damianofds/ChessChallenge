package it.fds.chesschallenge.utils;

import it.fds.chesschallenge.model.chessman.Bishop;
import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.chessman.King;
import it.fds.chesschallenge.model.chessman.Knight;
import it.fds.chesschallenge.model.chessman.Queen;
import it.fds.chesschallenge.model.chessman.Rook;
import it.fds.chesschallenge.model.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DamianoG
 * 
 */
public class ChessboardUtils {

    public static Chessman[] buildChessArray(int numOfKings, int numOfQueens, int numOfBishops,
            int numOfRooks, int numOfKnights) {
        Chessman[] chessArray = new Chessman[numOfKings + numOfQueens + numOfBishops + numOfRooks
                + numOfKnights];
        int threshold = numOfKings;
        int i = 0;
        for (; i < threshold; i++) {
            chessArray[i] = new King(i);
        }
        threshold += numOfQueens;
        for (; i < threshold; i++) {
            chessArray[i] = new Queen(i + threshold);
        }
        threshold += numOfBishops;
        for (; i < threshold; i++) {
            chessArray[i] = new Bishop(i + threshold);
        }
        threshold += numOfRooks;
        for (; i < threshold; i++) {
            chessArray[i] = new Rook(i + threshold);
        }
        threshold += numOfKnights;
        for (; i < threshold; i++) {
            chessArray[i] = new Knight(i + threshold);
        }
        return chessArray;
    }

    public static boolean[][] configurePositionMatrix(Configuration configuration, int boardWidth,
            int boardHeight) {
        boolean positionMatrix[][] = new boolean[boardWidth][boardHeight];
        for (Chessman cp : configuration) {
            if (positionMatrix[cp.getX()][cp.getY()]) {
                return null;
            }
            positionMatrix[cp.getX()][cp.getY()] = true;
        }
        return positionMatrix;
    }

    /**
     * Given the dimensions of a N x M Chessboard this method build an array of all the valid positions over it.
     * 
     * @param matrixN the N size of a N x M matrix
     * @param matrixM the M size of a N x M matrix
     * 
     * @return the computed position array
     */
    public static Integer[][] buildPositionsArray(int matrixN, int matrixM){
        List<Integer[]> positions = new ArrayList<>();
        for(int i=0; i<matrixN; i++){
            for(int j=0; j<matrixM; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        return positions.toArray(new Integer[matrixN*matrixM][2]);
    }
}
