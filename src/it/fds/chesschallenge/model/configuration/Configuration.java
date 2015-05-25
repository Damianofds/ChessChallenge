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
package it.fds.chesschallenge.model.configuration;

import it.fds.chesschallenge.model.chessboard.ChessBoard;
import it.fds.chesschallenge.model.chessman.Chessman;

import java.util.Collection;

/**
 * A Configuration is a set of chessmen.
 * A Chessman configuration is considered valid against a {@link ChessBoard} when none of the configuration elements threat any other configuration element.
 *  
 * @author DamianoG
 *
 */
public interface Configuration extends Collection<Chessman>, Cloneable{

    /**
     * @return an Integer value which uniquely identifies a valid configuration
     */
    public int getConfigurationUniqueID();
    
    /**
     * @return the number of distinct elements which compose this configuration
     */
    public int getNumberOfElements();
    
    /**
     * @return the number of distinct elements which compose this configuration
     */
    public Object clone();
}
