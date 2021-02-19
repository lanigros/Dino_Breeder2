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
                    if(playerList.get(currentplayer).stillGotGame()){  //ny

                        System.out.println("\nRound " + rounds + " Player: " + playerList.get(currentplayer).getName() + " is up!");

                        store.storeMenu(playerList.get(currentplayer));
                        decreaseDinoHealthMechanic(playerList.get(currentplayer));
                        currentplayer++;
                    } else {    //ny
                        checkingPlayerStats(playerList.get(currentplayer)); // flyttad hit istället
                    }
                }
                rounds++;
                endRound(rounds);
            }
            newGame = false;
        }
    }

    /**
     *
     * @param player After each round the method decreases the health of
     *               each pet owned by the current player.
     */

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

    /**
     *
     * @return Method that returns a randomized number between 10-30.
     */

    public int decreaseDinoHealthRandom() {
        int random = ThreadLocalRandom.current().nextInt(10, 30);
        return random;
    }

    /**
     *
     * @param player CheckingPlayerStats checks if the currentplayer has
     *               owned animals and sufficient funds ( money ), and if
     *               they don't. The method deleted the players.
     */

    public void checkingPlayerStats(Player player) {
        if (!player.stillGotGame()) {
            System.out.println(player.getName() +
                    " was removed from the game due to insufficient funds and Animals.");
            playerList.remove(player);
        }
    }

    /**
     *
     * @param i When the variable i has reached the total given amount of
     *          rounds, it will clear the termimal and sell off the player
     *          pets and declare the winner.
     */
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

    /**
     * SellPlayerPets goes into loop that goes through all the players
     * and sell their pets.
     */
    public void sellPlayersPets() {
        for (Player player : playerList) {
            player.sellPets();
        }
    }

    /**
     *
     * @return Winner goes finally through the playerlist and compares the amount of money each player
     * has, instead of writing the code ( playerList.sort((p1,p2)->(p1.getMoney() - p2.getMoney()); ) the
     * IDE recommended me to use the code below instead, which does basically the same thing.
     */
    public Player winner() {
        playerList.sort(Comparator.comparingInt(Player::getMoney).reversed());
        return playerList.get(0);
    }


}




