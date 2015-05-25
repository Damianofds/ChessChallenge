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
package it.fds.chesschallenge.main;

import it.fds.chesschallenge.engine.ChessEngine;

/**
 * @author DamianoG
 *
 */
public class ChessChallengeSolutions {

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
