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
 * This interface models the functionalities of a ChessBoard which is responsible for:
 * <ul>
 *      <li>Memorize which tiles are free and which are occupied by a {@link Chessman}</li>
 *      <li>Checks the boundaries of the chessboard</li>
 * </ul>
 * 
 * @author DamianoG
 *
 */
public interface ChessBoard {

    /**
     * Position the chessmen configuration provided over the chessboard.
     * 
     * @return <b>false</b> in case at least two chessmen provided occupy the same position, <b>true</b> otherwise
     */
    public boolean initChessboard(Configuration configuration);
    
    /**
     * Check if the tile is already occupied or not by a chessman
     * 
     * @param x the <b>x</b>-coordinate of the tile
     * @param y the <b>y</b>-coordinate of the tile
     * @return <b>true</b> if it is occupied, <b>false</b> if it is free <b>null</b> if the coordinates are outside the chessboard
     */
    public Boolean isOccupied(int x, int y);
    
    /**
     * Checks if the input {@link Chessman} instance is placed outside the Chessboard 
     * 
     * @param chessman
     * @return <b>true</b> if the chessman is oustide this Chessboard <b>false</b> otherwise
     */
    public boolean isOutsideBounds(Chessman chessman);
    
    /**
     * Checks if the input tile is placed outside the Chessboard 
     * 
     * @param chessman
     * @return <b>true</b> if the tile is part of this Chessboard <b>false</b> otherwise
     */
    public boolean isOutsideBounds(int x, int y);
    
    /**
     * @return the width of this chessboard
     */
    public int getWidth();
    
    /**
     * @return the height of this chessboard
     */
    public int getHeight();
}
