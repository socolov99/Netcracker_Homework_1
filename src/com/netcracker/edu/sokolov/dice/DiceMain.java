package com.netcracker.edu.sokolov.dice;

/**
 * Test class for testing Dice class.
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class DiceMain {
    public static void main(String[] args) {
        String[] namesOfPlayers = {"Kirill", "Maxim", "Anton"};
        Dice dice = new Dice(namesOfPlayers, 3);
        dice.play();
    }
}
