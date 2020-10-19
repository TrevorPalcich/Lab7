package edu.cscc;
import java.util.Random;

// Trevor Palcich, 10/17/20, Lab 7 - Rock Paper Spock

/**
 * Rock Paper Scissors Lizard Spock Class
 * @author Trevor Palcich
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /**
     * Determines if string entered by player matches the choices
     * @param pick String entered by player
     * @return either false if nothing matches, or true if player pick matches the choices
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * Generates a random integer that corresponds to a game choice (string)
      * @return Computer's choice
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * Determines if the computer wins by comparing the computer's choice and the player's choice
      * @param c_pick Computer's game choice
     * @param h_pick Player's game choice
     * @return True or false based on the two choices (Scissors cuts Paper, Paper covers Rock, Rock crushes Lizard,
     * Lizard poisons Spock, Spock smashes Scissors, Scissors decapitates Lizard, Lizard eats Paper,
     * Paper disproves Spock, Spock vaporizes Rock, Rock crushes Scissors)
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}