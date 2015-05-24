package it.fds.chesschallenge.engine;

import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.configuration.Configuration;
import it.fds.chesschallenge.model.configuration.HashedConfiguration;
import it.fds.chesschallenge.utils.ChessboardUtils;

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
        this.chessArray = ChessboardUtils.buildChessArray(numOfKings, numOfQueens, numOfBishops, numOfRooks, numOfKnights);
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
        HashedConfiguration<Chessman> emptyConfig = new HashedConfiguration<>();
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
                boolean positionMatrix[][] = ChessboardUtils.configurePositionMatrix(clonedConfig,
                        boardWidth, boardHeight);
                boolean isThisConfigValid = true;
                if (positionMatrix != null) {
                    for (Chessman ccp : clonedConfig) {
                        if (ccp.isThreatening(positionMatrix)) {
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
        }
        if (chessIndex == 0) {
            return;
        }
        // finalValidConfigsList;
        for (Configuration config : validConfigs) {
            searchForNonThreateningConfigurations(config, chessIndex - 1);
        }
    }

    public static void main(String [] args) {
        
        int numRow = 7;
        int numCol = 7;
        // int numOfKings, int numOfQueens, int numOfBishops, int numOfRooks, int numOfKnights
        ChessEngine ce = new ChessEngine(numRow, numCol, 2, 2, 2, 0, 1);
        long start = System.currentTimeMillis();
        int numOfSolutions = ce.search();
        long end = System.currentTimeMillis();
        System.out.println("Processing Time: " + ((double)(end-start))/1000 + " seconds");
        System.out.println("Number of solutions: '" + numOfSolutions + "'");
    }
}
