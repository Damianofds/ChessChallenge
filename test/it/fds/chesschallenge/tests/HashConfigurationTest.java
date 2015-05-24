package it.fds.chesschallenge.tests;

import java.util.HashSet;
import java.util.Set;

import it.fds.chesschallenge.model.chessman.Bishop;
import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.chessman.King;
import it.fds.chesschallenge.model.chessman.Knight;
import it.fds.chesschallenge.model.chessman.Queen;
import it.fds.chesschallenge.model.chessman.Rook;
import it.fds.chesschallenge.model.configuration.Configuration;
import it.fds.chesschallenge.model.configuration.HashedConfiguration;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DamianoG
 * 
 */
public class HashConfigurationTest extends Assert {

    /**
     * Compute the hashcode for configurations made selecting n of the 8 chessman created and check for equalities and differences
     */
    @Test
    public void hashConfigurationListCollisionsTest8chessmen() {
        Chessman cp1 = new Rook(1, 5, 5);
        Chessman cp2 = new Queen(2, 4, 4);
        Chessman cp3 = new Rook(3, 45, 87);
        Chessman cp4 = new Rook(4, 2, 22);
        Chessman cp5 = new Bishop(5, 98, 2);
        Chessman cp6 = new King(6, 5, 5);
        Chessman cp7 = new King(7, 7, 1);
        Chessman cp8 = new Knight(8, 7, 7);

        Configuration list = new HashedConfiguration<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp4);
        list.add(cp5);
        list.add(cp6);
        list.add(cp7);
        int sevenElementOrder1 = list.getConfigurationUniqueID();

        list = new HashedConfiguration<>();
        list.add(cp1);
        list.add(cp4);
        list.add(cp5);
        list.add(cp7);
        list.add(cp2);
        list.add(cp3);
        list.add(cp6);
        int sevenElementOrder2 = list.getConfigurationUniqueID();

        list = new HashedConfiguration<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp4);
        list.add(cp4);
        list.add(cp4);
        list.add(cp7);
        list.add(cp8);
        list.hashCode();
        int eightElementsWithRipetitions = list.getConfigurationUniqueID();

        list = new HashedConfiguration<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp7);
        list.hashCode();
        int fourDistinctsElements = list.getConfigurationUniqueID();

        // Check if two configurations with the same elements in different order has the same hashcode
        assertTrue(sevenElementOrder1 == sevenElementOrder2);
        assertTrue(sevenElementOrder1 != fourDistinctsElements);
        assertTrue(sevenElementOrder2 != eightElementsWithRipetitions);
        assertTrue(sevenElementOrder2 != fourDistinctsElements);
        assertTrue(eightElementsWithRipetitions != fourDistinctsElements);
    }

    @Test
    public void hashConfigurationListTest2() {
        Chessman cp1 = new King(1, 0, 0);
        Chessman cp2 = new King(2, 2, 0);
        Chessman cp3 = new Rook(3, 1, 2);

        Configuration list = new HashedConfiguration<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        int threeDinstinctPiecesOrder1 = list.getConfigurationUniqueID();

        list = new HashedConfiguration<>();
        list.add(cp2);
        list.add(cp1);
        list.add(cp3);
        int threeDinstinctPiecesOrder2 = list.getConfigurationUniqueID();

        assertTrue(threeDinstinctPiecesOrder1 == threeDinstinctPiecesOrder2);
    }

    @Test
    public void hashConfigurationListCollisionsTest3() {
        Chessman cp1 = new Knight(1, 0, 0);
        Chessman cp2 = new Knight(2, 0, 2);
        Chessman cp3 = new Knight(3, 2, 0);
        Chessman cp4 = new Knight(4, 2, 2);
        Configuration l = new HashedConfiguration<>();
        l.add(cp1);
        l.add(cp2);
        l.add(cp3);
        l.add(cp4);
        System.out.println(l.getConfigurationUniqueID());

        Chessman cp11 = new Knight(11, 0, 0);
        Chessman cp12 = new Knight(12, 3, 0);
        Chessman cp13 = new Knight(13, 3, 3);
        Chessman cp14 = new Knight(14, 0, 1);
        Configuration l1 = new HashedConfiguration<>();
        l1.add(cp11);
        l1.add(cp12);
        l1.add(cp13);
        l1.add(cp14);
        System.out.println(l1.getConfigurationUniqueID());

        assertFalse(l.hashCode() == l1.hashCode());
    }

    @Test
    public void hashPositionCollisionsTest(){
        int n = 1050;
        int m = 1050;
        int counter = 0;
        Set<Integer> positionsSet = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Chessman cp = new Rook(i*j);
                cp.setPos(i, j);
                int hashCode = cp.hashPosition();
                boolean isAdded = positionsSet.add(hashCode);
                assertTrue(isAdded);
                counter++;
            }
        }
        assertEquals(counter, n*m);
    }
}
