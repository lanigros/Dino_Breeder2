package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    ArrayList<Player> playerList;
    private String winner;
    private boolean newGame = true;
    private int totalAmountOfRounds;
    private int amountOfPlayers;
    private final Store store = new Store();


    public Game(boolean newGame) {
        this.newGame = newGame;
        playerList = new ArrayList<>();

    }

    /**
     * @return Decide how many rounds.
     */

    public int Rounds() {
        final int minRounds = 5;
        final int maxRounds = 30;

        totalAmountOfRounds = DialogueHelp.answerChecker("How many rounds?", minRounds, maxRounds);
        return totalAmountOfRounds;
    }

    public void banner() {
        System.out.println("+--------------------------+");
        System.out.println("|       DINO BREEDER       |");
        System.out.println("|                          |");
        System.out.println("+--------------------------+");
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    /**
     * @return Decide how many players will be playing.
     */

    public int Players() {
        final int minPlayers = 1;
        final int maxPlayers = 4;

        amountOfPlayers = DialogueHelp.answerChecker("How many players?", minPlayers, maxPlayers);
        return amountOfPlayers;
    }

    /**
     * After a given amount of players in the range of 1-4, You as a player get to choose the name of them.
     */

    public void NamePlayers() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Name player: " + (i + 1));
            String playerNames = input.nextLine();
            playerList.add((new Player(playerNames)));
        }
    }

    /**
     * A method that calls 3 other methods.
     */

    public void roundsAndPlayers() {
        banner();
        Rounds();
        Players();
        NamePlayers();
    }

    /**
     * Here's where the magic happens.
     */

    public void newGame() {
        while (newGame) {
            roundsAndPlayers();
            int rounds = 1;
            while (rounds <= totalAmountOfRounds) {

                int currentplayer = 0;
                while (currentplayer <= playerList.size() - 1) {

                    System.out.println("\nRound " + rounds + " Player: " + playerList.get(currentplayer).getName() + " is up!");

                    store.storeMenu(playerList.get(currentplayer));
                    decreaseDinoHealthMechanic(playerList.get(currentplayer));
                    checkingPlayerStats(playerList.get(currentplayer));
                    currentplayer++;

                }
                rounds++;
                endRound(rounds);
            }
            newGame = false;
        }
    }

    public void decreaseDinoHealthMechanic(Player player) {
        for (int i = 0; i < player.ownedPets.size(); i++) {
            Animal dino = player.ownedPets.get(i);
            int amountLost = decreaseDinoHealthRandom();
            dino.decreaseHealth(amountLost);
            if (!dino.isAlive()) {
                dino.die();
                player.ownedPets.remove(dino);
            }
        }
    }

    public int decreaseDinoHealthRandom() {
        int random = ThreadLocalRandom.current().nextInt(10, 30);
        return random;
    }

    public void checkingPlayerStats(Player player) {
        if (!player.stillGotGame()) {
            System.out.println(player.getName() +
                    " was removed from the game due to insufficient funds and Animals.");
            playerList.remove(player);
        }
    }

    public void endRound(int i) {
        if (i > totalAmountOfRounds) {
            DialogueHelp.clear();
            System.out.println("\nTHE END OF ALL ROUNDS!... calculating...");
            pressEnterToContinue();
            sellPlayersPets();
            Player player = winner();
            System.out.println("WINNER! : " + player.getName() + " with the total amount of money: " +
                    player.getMoney());

        }
    }

    public void sellPlayersPets() {
        for (Player player : playerList) {
            player.sellPets();
        }
    }

    public Player winner() {
        playerList.sort(Comparator.comparingInt(Player::getMoney).reversed());
        return playerList.get(0);
    }


}




