package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.Knight;

import java.util.ArrayList;
import java.util.List;

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
        
        int matrixSize = 5;
        cp.setPos(0, 0);
        
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(2, testIsThreatening(positions, cp, matrixSize));
        
        cp.setPos(1, 1);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize));
        cp.setPos(3, 3);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize));
        cp.setPos(2, 2);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize));
        cp.setPos(4, 4);
        assertEquals(2, testIsThreatening(positions, cp, matrixSize));
        cp.setPos(0, 3);
        assertEquals(3, testIsThreatening(positions, cp, matrixSize));
        
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize));
        
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(0, testIsThreatening(positions, cp, matrixSize));
    }
    
    /**
     * Given the dimensions of a N x M Chessboard this method build an array of all the valid positions over it.
     * 
     * @param matrixN the N size of a N x M matrix
     * @param matrixM the M size of a N x M matrix
     * 
     * @return the computed position array
     */
    public Integer[][] buildPositionsArray(int matrixN, int matrixM){
        List<Integer[]> positions = new ArrayList<>();
        for(int i=0; i<matrixN; i++){
            for(int j=0; j<matrixM; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        return positions.toArray(new Integer[matrixN*matrixM][2]);
    }
    
    @Test
    public void testOutsideChessboard5x5() {
        Chessman cp = new Knight(1);
        
//        int matrixSize = 5;
        cp.setPos(2, 2);
        
        assertTrue(!cp.isOutsideChessboard(0, 0, 5, 5));
        assertTrue(cp.isOutsideChessboard(-1, 0, 5, 5));
        assertTrue(cp.isOutsideChessboard(-1, -1, 5, 5));
        assertTrue(cp.isOutsideChessboard(4, 5, 5, 5));
        assertTrue(cp.isOutsideChessboard(5, 4, 5, 5));
        assertTrue(!cp.isOutsideChessboard(4, 4, 5, 5));
    }
    
    public int testIsThreatening(Integer positionsToCheck[][], Chessman cp, int positionMatrixSize) {
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
