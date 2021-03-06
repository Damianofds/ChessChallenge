package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.engine.ChessEngine;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author DamianoG
 * 
 */
public class ChessChallengeTest extends BaseChessChallengeTest{

    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>3 x 3 chessboard<\li>
     *    <li>2 Kings<\li>
     *    <li>1 Rook<\li>
     * </ul>
     */
    @Test
    public void test_3x3_3P() {
        int numRow = 3;
        int numCol = 3;
        // int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(numRow, numCol, 2, 0, 0, 1, 0);
        long start = System.currentTimeMillis();
        int numberOfSolutions = ce.search();
        assertEquals(4, numberOfSolutions);
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }
    
    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>4 x 4 chessboard<\li>
     *    <li>2 Rooks<\li>
     *    <li>4 Knights<\li>
     * </ul>
     */
    @Test
    public void test_4x4_6P() {
         int numRow = 4;
         int numCol = 4;
        // int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
         ChessEngine ce = new ChessEngine(numRow, numCol, 0, 0, 0, 2, 4);
         long start = System.currentTimeMillis();
         int numberOfSolutions = ce.search();
         assertEquals(8, numberOfSolutions);
         long end = System.currentTimeMillis();
         System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }

    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>7 x 7 chessboard<\li>
     *    <li>2 Kings<\li>
     *    <li>2 Queens<\li>
     *    <li>2 Bishops<\li>
     *    <li>1 Knight<\li>
     * </ul>
     */
    @Ignore // It takes too much time
    @Test
    public void test_7x7_7P() {
        int numRow = 7;
        int numCol = 7;
        // int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(numRow, numCol, 2, 2, 2, 0, 1);
        long start = System.currentTimeMillis();
        int numberOfSolutions = ce.search();
        assertEquals(3062636, numberOfSolutions);
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }

    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>7 x 7 chessboard<\li>
     *    <li>7 Queens<\li>
     * </ul>
     */
    @Test
    public void test_7Queens() {
        // int numRows, int numColumns, int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(7, 7, 0, 7, 0, 0, 0);
        long start = System.currentTimeMillis();
        int numberOfSolutions = ce.search();
        assertEquals(40, numberOfSolutions);
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }

    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>8 x 8 chessboard<\li>
     *    <li>8Queens<\li>
     * </ul>
     */
    @Ignore // It takes too much time
    @Test    
    public void test_8Queens() {
        // int numRows, int numColumns, int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(8, 8, 0, 8, 0, 0, 0);
        long start = System.currentTimeMillis();
        int numberOfSolutions = ce.search();
        assertEquals(92, numberOfSolutions);
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }

    /**
     * Test the challenge engine against the configuration below
     * <ul>
     *    <li>9 x 9 chessboard<\li>
     *    <li>9 Queens<\li>
     * </ul>
     */
    @Ignore // It takes too much time
    @Test
    public void test_9Queens() {
        // int numRows, int numColumns, int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(9, 9, 0, 9, 0, 0, 0);
        long start = System.currentTimeMillis();
        int numberOfSolutions = ce.search();
        assertEquals(352, numberOfSolutions);
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
    }
}
