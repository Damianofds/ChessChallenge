package it.fds.chesschallenge.engine;

import it.fds.chesschallenge.model.chessboard.ChessBoard;
import it.fds.chesschallenge.model.chessboard.MatrixChessBoard;
import it.fds.chesschallenge.model.chessman.Bishop;
import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.chessman.King;
import it.fds.chesschallenge.model.chessman.Knight;
import it.fds.chesschallenge.model.chessman.Queen;
import it.fds.chesschallenge.model.chessman.Rook;
import it.fds.chesschallenge.model.configuration.Configuration;
import it.fds.chesschallenge.model.configuration.HashedConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DamianoG
 * 
 */
public class ChessEngine {

    /**
     * the width of the chessboard
     */
    private final int boardWidth;

    /**
     * the height of the chessboard
     */
    private final int boardHeight;

    /**
     * The array that holds the chessmen involved for the current puzzle instance
     */
    private final Chessman[] chessArray;

    private final int chessArraySize;

    /**
     * This list stores all the valid solutions found for the puzzle
     */
    public List<Configuration> finalValidConfigsList;

    /**
     * This map stores all the valid solutions found the solution i-esimo inductive step
     */
    private Map<Integer, Set<Integer>> updatedValidConfigsMap;

    public ChessEngine(int boardWidth, int boardHeight, int numOfKings, int numOfQueens,
            int numOfBishops, int numOfRooks, int numOfKnights) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.chessArray = buildChessArray(numOfKings, numOfQueens, numOfBishops, numOfRooks, numOfKnights);
        chessArraySize = chessArray.length;
        finalValidConfigsList = new ArrayList<>();
        updatedValidConfigsMap = new HashMap<>();
        for (int ii = 0; ii < chessArraySize; ii++) {
            updatedValidConfigsMap.put(ii, new HashSet<Integer>());
        }
    }

    public int search() {

        finalValidConfigsList = new ArrayList<Configuration>();
        countSolutions();
        return finalValidConfigsList.size();
        
    }

    private void countSolutions() {
        // step0: add initial configuration: an empty list
        Configuration emptyConfig = new HashedConfiguration<>();
        searchForNonThreateningConfigurations(emptyConfig, chessArray.length - 1);
    }

    /**
     * Search a puzzle solution for a subset of k [k=1,...,n] chessmen and discard equivalent solutions, 
     * then add the k+1 chessman to the solutions founds and reiterate the process 
     *  
     * @param validConfig
     * @param chessIndex
     */
    private void searchForNonThreateningConfigurations(
            Configuration validConfig, int chessIndex) {
        Chessman cp = chessArray[chessIndex];
        List<Configuration> validConfigs = new ArrayList<Configuration>();
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                cp.setPos(i, j);
                Configuration clonedConfig = (Configuration)validConfig.clone();
                clonedConfig.add((Chessman) cp.clone());
                ChessBoard board = new MatrixChessBoard(boardWidth, boardHeight);
                if (!board.initChessboard(clonedConfig)) {
                    continue;
                }
                boolean isThisConfigValid = true;
                for (Chessman ccp : clonedConfig) {
                    if (ccp.isThreatening(board)) {
                        isThisConfigValid = false;
                        break;
                    }
                }
                if (isThisConfigValid
                        && updatedValidConfigsMap.get(chessIndex).add(clonedConfig.getConfigurationUniqueID())) {

                    validConfigs.add(clonedConfig);
                    if (chessIndex == 0) {
                        finalValidConfigsList.add(clonedConfig);
                    }
                }
            }
        }
        if (chessIndex == 0) {
            return;
        }
        // finalValidConfigsList;
        for (Configuration config : validConfigs) {
            searchForNonThreateningConfigurations(config, chessIndex - 1);
        }
    }

    private Chessman[] buildChessArray(int numOfKings, int numOfQueens, int numOfBishops,
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
}
