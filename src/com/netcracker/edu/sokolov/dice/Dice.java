package com.netcracker.edu.sokolov.dice;

import java.util.LinkedList;
import java.util.Random;

/**
 * Class for Dice game
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class Dice {
    private final LinkedList<Player> players;
    private final int numberOfDices;

    public Dice(String[] namesOfPlayers, int numberOfDices) {
        LinkedList<Player> players = new LinkedList<>();
        for (String namesOfPlayer : namesOfPlayers) {
            players.add(new Player(namesOfPlayer));
        }
        this.players = players;
        this.numberOfDices = numberOfDices;
    }

    /**
     * Class for player in dice game
     *
     * @author kirillsokolov
     * @version 1.1
     */
    public class Player {
        private final String name;
        private int numberOfVictories = 0;
        private int points = 0;

        public Player(String name) {
            this.name = name;
        }

        public int getPoints() {
            return points;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfVictories() {
            return numberOfVictories;
        }

        /**
         * Method for rolling K dices (where K is number of dices)
         */
        private int rollDices() {
            points = 0;
            Random random = new Random();
            for (int i = 0; i < numberOfDices; i++) {
                points += random.nextInt(5) + 1;
            }
            return points;
        }

        public void numberOfVictoriesIncrement() {
            numberOfVictories++;
        }

    }

    /**
     * Method for starting new game.
     */
    public void play() {
        Player winner = null;
        int step = 1;
        do {
            boolean draw = false;
            System.out.println("Step " + step);
            step++;
            int maxNumberOfPoints = 0;
            Player stepWinner = players.getFirst();
            for (Player player : players) {
                int points = player.rollDices();
                System.out.println(player.getName() + ", points: " + points);
                if (points >= maxNumberOfPoints) {
                    maxNumberOfPoints = points;
                    stepWinner = player;
                }
            }
            // if there are two or more stepWinners we say that it is a draw and don't give anyone points
            for (Player player : players) {
                if (player.getPoints() == maxNumberOfPoints && player != stepWinner) {
                    draw = true;
                    break;
                }
            }
            if (draw) {
                System.out.println();
                System.out.println("Draw");
                System.out.println("–––––––––––––––––––––––––––––––––");
            } else {
                stepWinner.numberOfVictoriesIncrement();
                System.out.println();
                System.out.println(stepWinner.getName() + " won this step");
                System.out.println("–––––––––––––––––––––––––––––––––");
                if (stepWinner.getNumberOfVictories() >= 7) {
                    winner = stepWinner;
                    break;
                }
                //replace winner of the step to the beginning of players list
                players.remove(stepWinner);
                players.addFirst(stepWinner);
            }
        } while (winner == null);

        System.out.println("–––––––––––––––––––––––––––––––––");
        System.out.println(winner.getName() + " won the game !");
    }
}
