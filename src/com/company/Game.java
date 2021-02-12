package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    ArrayList<Player> playerList;


    private boolean newGame = true;
    private int totalAmountOfRounds;
    private int amountOfPlayers;
    private Store store = new Store();
    private int currentPlayer;

    public Game(boolean newGame) {
        this.newGame = newGame;
        playerList = new ArrayList<>();

    }

    public void Rounds(int AmountOfRounds) {
        boolean rightAmount = true;
        while (!rightAmount) {

            if (AmountOfRounds < 5 || AmountOfRounds > 30) {
                System.out.println("Wrong amount of rounds! 5-30!");
            } else {
                totalAmountOfRounds = AmountOfRounds;

            }

        }
    } // Kolla igenom denna, det är en renskrivning av metoden under.

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

    public void roundsAndPlayers() {
        Scanner input = new Scanner(System.in);
        banner();
        System.out.println("\nEnter how many rounds you want to play.");
        int rounds = input.nextInt();
        input.nextLine();
        while (rounds < 5 || rounds > 30) {
            System.out.println("Wrong amount of rounds! (5-30)");
            break;
        }
        totalAmountOfRounds = rounds;


        System.out.println("\nEnter how many players will be playing.");
        int players = input.nextInt();
        input.nextLine();
        if (players < 1 || players > 4) {
            System.out.println("Wrong amount of players! 1-4");

        } else {

            amountOfPlayers = players;

            for (int i = 0; i < amountOfPlayers; i++) {
                System.out.println("Name player " + (i + 1));
                String playerNames = input.nextLine();
                playerList.add((new Player(playerNames)));

            }
        }

    }

    public void playerListLoop() {
        for (int j = 0; j < playerList.size();) {
            if (j == (playerList.size() - 1)) {
                System.out.println("\n Player: " + playerList.get(j).name + " is up!");
                store.storeMenu(playerList.get(0));
            } else {
                j++;
                System.out.println("\n Player: " + playerList.get(j).name + " is up!");
                store.storeMenu(playerList.get(j));


            }

        }
    }

    public void currentPlayer() {
        while (newGame) {
            int i = 1;
            while (i < totalAmountOfRounds) {

                int j = 0;
                while (playerList.indexOf(j) < playerList.size() - 1) {
                    System.out.println("\nRound " + i + " Player: " + playerList.get(j).name + " is up!");
                    store.storeMenu(playerList.get(j));
                    playerListLoop();
                    i++;
                    decreaseDinoHealth(playerList.get(j));

                }
            }
        }
    }

    public void decreaseDinoHealth(Player player) {
        decreaseDinoHealthMechanic(player);
    }

    public void decreaseDinoHealthMechanic(Player player) {
        for (int i = 0; i < player.ownedPets.size(); i++) {

            Animal dino = player.ownedPets.get(i);
            dino.setHealth(dino.getHealth() - decreaseDinoHealthRandom());

            System.out.println("\nDino : " + dino.name + " lost " + decreaseDinoHealthRandom() + " health.");

            if (dino.getHealth() == 0) {
                dino.dead();
                System.out.println(dino.name + " died! RIP.");
                player.ownedPets.remove(dino);
            }
        }
    }

    public int decreaseDinoHealthRandom() {
        int random = ThreadLocalRandom.current().nextInt(10, 30);
        return random;
    }

}




