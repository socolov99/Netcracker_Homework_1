package com.netcracker.edu.sokolov.qe;

import static java.lang.Math.sqrt;

/**
 * Class of quadratic equation.
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class QuadraticEquation {
    //first equation's coefficient
    private final double a;
    //second equation's coefficient
    private final double b;
    //third equation's coefficient
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Class of quadratic equation's discriminant:
     * finds the discriminant of the quadratic equation.
     *
     * @author kirillsokolov
     * @version 1.1
     */
    private class Discriminant {
        private final double discriminant;

        public Discriminant() {
            discriminant = b * b - 4 * a * c;
        }

        public double getDiscriminant() {
            return discriminant;
        }
    }


    /**
     * Method for solving quadratic equation: finding roots/root if they exist
     */
    public void solve() {
        double discriminant = new Discriminant().getDiscriminant();
        if (discriminant < 0) {
            System.out.println("The equation has no roots in the set of real numbers");
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The equation has one root: " + root);
        } else {
            double root1 = (-b + sqrt(discriminant)) / (2 * a);
            double root2 = (-b - sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two root: " + root1 + " and " + root2);
        }
    }
}
