package io.github.superslowjelly.extracredit51;

import java.util.Scanner;

public class Main {

    public static Hand.Choice getChoice() {
        try {
            // Player enters their choice of hand.
            System.out.print("\nPlease enter your choice (Rock, Paper, Scissors, Player, or Frank): ");
            return Hand.Choice.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        } catch (IllegalArgumentException e) { // User entered invalid hand choice.
            System.out.println("Incorrect input, please try again!");
            getChoice();
        }
        return null; // Will never happen.
    }

    public static boolean wantsToReplay() {
        // Handle replays.
        System.out.print("Want to play again? (Y/N): ");
        String choice = new Scanner(System.in).nextLine();
        if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))
            return choice.equalsIgnoreCase("Y");
        return false;
    }

    public static void playGame(Hand.Choice playerChoice) {
        Game game = new Game(playerChoice);
        game.compareChoices();
        System.out.println("Playing game...\n\tYou picked: " + playerChoice +
                "\n\tComputer Picked: " + game.getComputerChoice() +
                "\n\tYou " + game.getResult().toString().toLowerCase() + "!");
    }

    public static void main(String[] args) {
        boolean continuePlaying = true;
        while (continuePlaying) {
            playGame(getChoice());
            if (!wantsToReplay()) {
                continuePlaying = false;
                System.out.print(new Game(Hand.Choice.PLAYER)); // Instantiate a dummy game to get the stats.
            }
        }
    }

}
