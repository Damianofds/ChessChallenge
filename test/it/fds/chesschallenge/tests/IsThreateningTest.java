package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.Knight;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
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
        
        List<Integer[]> positions = new ArrayList<>();
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), matrixSize, matrixSize));
        assertEquals(2, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        
        cp.setPos(1, 1);
        assertEquals(4, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        cp.setPos(3, 3);
        assertEquals(4, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        cp.setPos(2, 2);
        assertEquals(8, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        cp.setPos(4, 4);
        assertEquals(2, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        cp.setPos(0, 3);
        assertEquals(3, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = new ArrayList<>();
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        assertEquals(8, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
        
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = new ArrayList<>();
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        assertEquals(0, testIsThreatening((positions.toArray(new Integer[matrixSize*matrixSize][2])), cp, matrixSize));
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
