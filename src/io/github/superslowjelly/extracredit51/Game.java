package io.github.superslowjelly.extracredit51;

import java.util.Random;

public class Game {

    public enum Result {
        WIN,
        LOSE,
        TIE
    }

    public Game(Hand.Choice playerChoice) {
        PLAYERCHOICE = playerChoice;
        COMPUTERCHOICE = generateComputerChoice();
    }

    private static int wins = 0, ties = 0, losses = 0;

    private final Hand.Choice PLAYERCHOICE;

    private final Hand.Choice COMPUTERCHOICE;

    private Game.Result result;

    public Hand.Choice getComputerChoice() {
        return COMPUTERCHOICE;
    }

    public Game.Result getResult() {
        return result;
    }

    private Hand.Choice generateComputerChoice() { // Pick random choice for computer.
        Hand.Choice[] choices = Hand.Choice.values();
        return choices[new Random().nextInt(choices.length)];
    }

    public void compareChoices() {
        switch (PLAYERCHOICE) {
            case ROCK:
                switch (COMPUTERCHOICE) {
                    case ROCK:
                        ties += 1;
                        result = Result.TIE;
                        break;
                    case PAPER:
                        losses += 1;
                        result = Result.LOSE;
                        break;
                    case SCISSORS:
                        wins += 1;
                        result = Result.WIN;
                        break;
                }
                break;
            case PAPER:
                switch (COMPUTERCHOICE) {
                    case ROCK:
                        wins += 1;
                        result = Result.WIN;
                        break;
                    case PAPER:
                        ties += 1;
                        result = Result.TIE;
                        break;
                    case PLAYER:
                    case FRANK:
                    case SCISSORS:
                        losses += 1;
                        result = Result.LOSE;
                        break;
                }
                break;
            case SCISSORS:
                switch (COMPUTERCHOICE) {
                    case PLAYER:
                    case FRANK:
                    case ROCK:
                        losses += 1;
                        result = Result.LOSE;
                        break;
                    case PAPER:
                        wins += 1;
                        result = Result.WIN;
                        break;
                    case SCISSORS:
                        ties += 1;
                        result = Result.TIE;
                        break;
                }
                break;
            case FRANK:
                if (COMPUTERCHOICE != Hand.Choice.FRANK) {
                    wins += 1;
                    result = Result.WIN;
                } else {
                    ties += 1;
                    result = Result.TIE;
                }
                break;
            case PLAYER:
                switch (COMPUTERCHOICE) {
                    case FRANK:
                        losses += 1;
                        result = Result.LOSE; // Frank always beats players.
                        break;
                    case PLAYER:
                        ties += 1;
                        result = Result.TIE;
                        break;
                    default:
                        wins += 1;
                        result = Result.WIN;  // It's a whole ass person, of course it's gonna win??
                        break;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "\nYour stats:\n\tWins: " + wins + "\n\tTies: " + ties + "\n\tLosses: " + losses + "\n";
    }

}
