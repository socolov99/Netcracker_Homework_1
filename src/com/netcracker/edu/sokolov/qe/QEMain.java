package com.netcracker.edu.sokolov.qe;

/**
 * Test class for testing QuadraticEquation class.
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class QEMain {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(1, 4, 4);
        quadraticEquation1.solve();

        QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 6, 5);
        quadraticEquation2.solve();

        QuadraticEquation quadraticEquation3 = new QuadraticEquation(1, 1, 4);
        quadraticEquation3.solve();
    }
}
