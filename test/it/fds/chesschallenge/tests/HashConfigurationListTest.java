package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.Bishop;
import it.fds.chesschallenge.model.Chessman;
import it.fds.chesschallenge.model.King;
import it.fds.chesschallenge.model.Knight;
import it.fds.chesschallenge.model.Queen;
import it.fds.chesschallenge.model.Rook;
import it.fds.chesschallenge.utils.HashConfigurationList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DamianoG
 * 
 */
public class HashConfigurationListTest extends Assert {

    @Test
    public void HashConfigurationListTest1() {
        Chessman cp1 = new Rook(1);
        cp1.setPos(5, 5);
        Chessman cp2 = new Queen(2);
        cp2.setPos(4, 4);
        Chessman cp3 = new Rook(3);
        cp3.setPos(45, 87);
        Chessman cp4 = new Rook(4);
        cp4.setPos(2, 22);
        Chessman cp5 = new Bishop(5);
        cp5.setPos(98, 2);
        Chessman cp6 = new King(6);
        cp6.setPos(5, 5);
        Chessman cp7 = new King(7);
        cp7.setPos(7, 1);
        Chessman cp8 = new Knight(8);
        cp8.setPos(7, 7);

        HashConfigurationList<Chessman> list = new HashConfigurationList<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp4);
        list.add(cp5);
        list.add(cp6);
        list.add(cp7);
        // list.add(cp8);
        int hash1 = list.hashCode();

        list = new HashConfigurationList<>();
        list.add(cp1);
        list.add(cp4);
        // list.add(cp8);
        list.add(cp5);
        list.add(cp7);
        list.add(cp2);
        list.add(cp3);
        list.add(cp6);
        list.hashCode();
        int hash2 = list.hashCode();

        list = new HashConfigurationList<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp4);
        list.add(cp4);
        list.add(cp4);
        list.add(cp7);
        list.add(cp8);
        list.hashCode();
        int hash3 = list.hashCode();

        list = new HashConfigurationList<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        list.add(cp7);
        list.hashCode();
        int hash4 = list.hashCode();

        assertTrue(hash1 == hash2);
        assertTrue(hash1 != hash4);
        assertTrue(hash2 != hash3);
        assertTrue(hash2 != hash4);
        assertTrue(hash3 != hash4);

    }

    @Test
    public void HashConfigurationListTest2() {
        Chessman cp1 = new King(1);
        cp1.setPos(0, 0);
        Chessman cp2 = new King(2);
        cp2.setPos(2, 0);
        Chessman cp3 = new Rook(3);
        cp2.setPos(1, 2);

        HashConfigurationList<Chessman> list = new HashConfigurationList<>();
        list.add(cp1);
        list.add(cp2);
        list.add(cp3);
        int hash1 = list.hashCode();

        list = new HashConfigurationList<>();
        list.add(cp2);
        list.add(cp1);
        list.add(cp3);
        int hash2 = list.hashCode();

        assertTrue(hash1 == hash2);

    }

    @Test
    public void HashConfigurationListTest3() {
        Chessman cp1 = new Knight(1);
        cp1.setPos(0, 0);
        Chessman cp2 = new Knight(2);
        cp2.setPos(0, 2);
        Chessman cp3 = new Knight(3);
        cp3.setPos(2, 0);
        Chessman cp4 = new Knight(4);
        cp4.setPos(2, 2);
        HashConfigurationList<Chessman> l = new HashConfigurationList<>();
        l.add(cp1);
        l.add(cp2);
        l.add(cp3);
        l.add(cp4);
        System.out.println(l.hashCode());

        Chessman cp11 = new Knight(11);
        cp11.setPos(0, 0);
        Chessman cp12 = new Knight(12);
        cp12.setPos(3, 0);
        Chessman cp13 = new Knight(13);
        cp13.setPos(3, 3);
        Chessman cp14 = new Knight(14);
        cp14.setPos(0, 1);
        HashConfigurationList<Chessman> l1 = new HashConfigurationList<>();
        l1.add(cp11);
        l1.add(cp12);
        l1.add(cp13);
        l1.add(cp14);
        System.out.println(l1.hashCode());

        assertFalse(l.hashCode() == l1.hashCode());

    }

}
