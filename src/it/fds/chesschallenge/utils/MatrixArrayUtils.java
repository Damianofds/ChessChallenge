package it.fds.chesschallenge.utils;

import it.fds.chesschallenge.model.Bishop;
import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.King;
import it.fds.chesschallenge.model.Knight;
import it.fds.chesschallenge.model.Queen;
import it.fds.chesschallenge.model.Rook;

import java.util.Arrays;
import java.util.List;

/**
 * @author DamianoG
 * 
 */
public class MatrixArrayUtils {

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

    public static HashConfigurationList<Chessman> cloneChessArray(List<Chessman> chessArray) {
        HashConfigurationList<Chessman> newChessArray = new HashConfigurationList<>();
        for (Chessman cp : chessArray) {
            newChessArray.add((Chessman) cp.clone());
        }
        return newChessArray;
    }

    public static boolean[][] configurePositionMatrix(List<Chessman> configuration, int boardWidth,
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

    @Deprecated
    public static boolean[][] positionMatrixClone(boolean[][] original) {
        if (original == null) {
            return null;
        }

        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

    @Deprecated
    public static String positionMatrixToString(boolean positionMatrix[][]) {
        StringBuffer sb = new StringBuffer();
        sb.append("[N='").append(positionMatrix.length).append("' M='")
                .append(positionMatrix[0].length).append("' ");
        for (int i = 0; i < positionMatrix.length; i++) {
            for (int j = 0; j < positionMatrix[0].length; j++) {
                if (positionMatrix[i][j]) {
                    sb.append("(").append(i).append(",").append(j).append(") ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Deprecated
    public static String chessArrayToString(Chessman chessArray[], boolean positionMatrix[][]) {
        StringBuffer sb = new StringBuffer();
        sb.append("{ N='").append(positionMatrix.length).append("' M='")
                .append(positionMatrix[0].length).append("' ");
        for (Chessman cp : chessArray) {
            sb.append("[ " + cp.getClass().getSimpleName() + " (").append(cp.getX()).append(",")
                    .append(cp.getY()).append(")] ");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Deprecated
    public static Chessman[] cloneChessArray(Chessman[] chessArray) {
        Chessman[] newChessArray = new Chessman[chessArray.length];
        for (int i = 0; i < newChessArray.length; i++) {
            newChessArray[i] = (Chessman) chessArray[i].clone();
        }
        return newChessArray;
    }
}
