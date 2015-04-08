package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.Knight;

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
        Integer positionsToCheckTrue[][] = new Integer[9][2];
        Integer positionsToCheckFalse[][] = new Integer[3][2];

        Integer[] res1 = { 0, 1 };
        Integer[] res2 = { 0, 3 };
        Integer[] res3 = { 1, 0 };
        Integer[] res4 = { 1, 4 };
        Integer[] res5 = { 2, 2 };// Move this in the other array!!!
        Integer[] res6 = { 3, 0 };
        Integer[] res7 = { 3, 4 };
        Integer[] res8 = { 4, 1 };
        Integer[] res9 = { 4, 3 };

        positionsToCheckTrue[0] = res1;
        positionsToCheckTrue[1] = res2;
        positionsToCheckTrue[2] = res3;
        positionsToCheckTrue[3] = res4;
        positionsToCheckTrue[4] = res5;
        positionsToCheckTrue[5] = res6;
        positionsToCheckTrue[6] = res7;
        positionsToCheckTrue[7] = res8;
        positionsToCheckTrue[8] = res9;

        Integer[] res10 = { 0, 2 };
        Integer[] res11 = { 3, 1 };
        Integer[] res12 = { 4, 4 };

        positionsToCheckFalse[0] = res10;
        positionsToCheckFalse[1] = res11;
        positionsToCheckFalse[2] = res12;

        int matrixSize = 5;
        Chessman cp = new Knight(1);
        cp.setPos(2, 2);
        assertTrue(!cp.isOutsideChessboard(cp.getX(), cp.getY(), 5, 5));

        assertTrue(!cp.isOutsideChessboard(0, 0, 5, 5));
        assertTrue(cp.isOutsideChessboard(-1, 0, 5, 5));
        assertTrue(cp.isOutsideChessboard(-1, -1, 5, 5));
        assertTrue(cp.isOutsideChessboard(4, 5, 5, 5));
        assertTrue(cp.isOutsideChessboard(5, 4, 5, 5));
        assertTrue(!cp.isOutsideChessboard(4, 4, 5, 5));

        assertEquals(8, testIsThreatening(positionsToCheckTrue, cp, matrixSize));
        assertEquals(0, testIsThreatening(positionsToCheckFalse, cp, matrixSize));

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
