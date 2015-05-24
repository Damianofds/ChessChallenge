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
package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.chessman.Knight;
import it.fds.chesschallenge.utils.ChessboardUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DamianoG
 *
 */
public class ChessboardTest extends Assert{

    
    /**
     * Tests the isOutsideChessboard method over a wide range of square or rectangular chessboards
     */
    @Test
    public void testOutsideChessboard() {
        
        Chessman cp = new Knight(1);
        
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Integer[][] posArray = ChessboardUtils.buildPositionsArray(i, j);
                // Check if the number of positions computed is correct
                assertEquals(i*j, posArray.length);
                
                // Check if all the positions computed are inside the chessboard 
                for(int c=0; c<posArray.length; c++){
                    cp.setPos(posArray[c]);
                    assertFalse(cp.isOutsideChessboard(i, j));
                }
                
                // check positions outside of the chessboard but close to its margins
                cp.setPos(-1, 0);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(0, -1);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(-1, -1);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(i, j-1);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(i-1, j);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(i, j);
                assertTrue(cp.isOutsideChessboard(i, j));
                cp.setPos(i+1, j-1);
                assertTrue(cp.isOutsideChessboard(i, j));
            }
        }
    }
}
