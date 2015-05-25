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

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * @author DamianoG
 *
 */
public class BaseChessChallengeTest extends Assert{
    
    /**
     * Given the dimensions of a N x M Chessboard this method build an array of all the valid positions over it.
     * 
     * @param matrixN the N size of a N x M matrix
     * @param matrixM the M size of a N x M matrix
     * 
     * @return the computed position array
     */
    protected Integer[][] buildPositionsArray(int matrixN, int matrixM){
        List<Integer[]> positions = new ArrayList<>();
        for(int i=0; i<matrixN; i++){
            for(int j=0; j<matrixM; j++){
                Integer [] pos = { i , j };
                positions.add(pos);
            }
        }
        return positions.toArray(new Integer[matrixN*matrixM][2]);
    }
}
