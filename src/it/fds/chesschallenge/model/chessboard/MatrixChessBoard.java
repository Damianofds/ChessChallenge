/*
 *  Copyright (C) 2007-2012 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 *  GPLv3 + Classpath exception
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.fds.chesschallenge.model.chessboard;

import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.configuration.Configuration;

/**
 * 
 * @author DamianoG
 *
 */
public class MatrixChessBoard implements ChessBoard{

    private boolean positionMatrix[][];
    private int n;
    private int m;
    
    public MatrixChessBoard(int width, int height){
        positionMatrix = new boolean[width][height];
        n = width;
        m = height;
    }
    
    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#initChessboard(it.fds.chesschallenge.model.configuration.Configuration)
     */
    @Override
    public boolean initChessboard(Configuration configuration) {
        for (Chessman cp : configuration) {
            if (isOutsideBounds(cp.getX(), cp.getY()) || positionMatrix[cp.getX()][cp.getY()]) {
                return false;
            }
            positionMatrix[cp.getX()][cp.getY()] = true;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#isOccupied(int, int)
     */
    @Override
    public Boolean isOccupied(int x, int y) {
        if(isOutsideBounds(x, y)){
            return false;
        }
        return positionMatrix[x][y];
    }
    
    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#isOutsideBounds(it.fds.chesschallenge.model.chessman.Chessman)
     */
    @Override
    public boolean isOutsideBounds(Chessman chessman) {
        return isOutsideBounds(chessman.getX(), chessman.getY());
    }
    
    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#isOutsideBounds(int, int)
     */
    @Override
    public boolean isOutsideBounds(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m){
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#getWidth()
     */
    @Override
    public int getWidth() {
        return n;
    }

    /* (non-Javadoc)
     * @see it.fds.chesschallenge.model.chessboard.ChessBoard#getHeight()
     */
    @Override
    public int getHeight() {
        return m;
    }
}
