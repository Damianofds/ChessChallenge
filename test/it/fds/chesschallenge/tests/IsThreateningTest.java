package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.Knight;
import it.fds.chesschallenge.utils.ChessboardUtils;
import org.junit.Assert;
import org.junit.Test;
/**
 * This test suite validates the implementation provided by all of the {@link Chessman} specialized classes of the {@link Chessman}{@link #IsThreateningTest()} method.
 * 
 * @author DamianoG
 * 
 */
public class IsThreateningTest extends Assert {

    public static int numRow = 7;

    public static int numCol = 7;

    @Test
    public void testKnight() {
        Chessman cp = new Knight(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = ChessboardUtils.buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(2, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(1, 1);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(4, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(3, 3);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(4, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(2, 2);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(8, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(4, 4);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(2, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(0, 3);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(3, testIsThreatening(positions, cp, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = ChessboardUtils.buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = ChessboardUtils.buildPositionsArray(matrixSize, matrixSize);
        assertEquals(0, testIsThreatening(positions, cp, matrixSize));
    }
    
    
    
    private int testIsThreatening(Integer positionsToCheck[][], Chessman cp, int positionMatrixSize) {
        if (positionsToCheck == null || positionsToCheck.length <= 0
                || positionsToCheck[0].length != 2) {
            throw new IllegalArgumentException("wrong parameters...");
        }
        int counter = 0;
        for (Integer[] b : positionsToCheck) {
            boolean positionMatrix[][] = new boolean[positionMatrixSize][positionMatrixSize];
            positionMatrix[b[0]][b[1]] = true;
            if (cp.isThreatening(positionMatrix))
                counter++;
        }
        return counter;

    }
}
