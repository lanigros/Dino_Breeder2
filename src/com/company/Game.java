package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<Player> playerList;


    private boolean newGame = true;
    private int totalAmountOfRounds;
    private int amountOfPlayers;
    private Store store = new Store();
    private int currentPlayer = 0;

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

    public void roundsAndPlayers() {
        Scanner input = new Scanner(System.in);
        banner();
        System.out.println("\nEnter how many rounds you want to play.");
        int rounds = input.nextInt();
        input.nextLine();
        while (rounds < 5 || rounds > 30) {
            System.out.println("Wrong amount of rounds! (5-30)");
            return;
        }
        totalAmountOfRounds = rounds;


        System.out.println("\nEnter how many players will be playing.");
        int players = input.nextInt();
        input.nextLine();
        if (players < 1 || players > 4) {
            System.out.println("Wrong amount of players! 1-4");
            return;

        } else {

            amountOfPlayers = players;

            for (int i = 0; i < amountOfPlayers; i++) {
                System.out.println("Name player " + (i + 1));
                String playerNames = input.nextLine();
                playerList.add((new Player(playerNames)));

            }
        }

    }

    public void currentPlayer() {
        while (newGame = true) {
            for (int i = 0; i < totalAmountOfRounds; i++) {
                for (int j = 0; j <= playerList.size(); j++) {

                    System.out.println("\nRound " + (i + 1) + " Player: " + playerList.get(j).name + " is up!");

                    store.storeMenu(playerList.get(j));
                }
            }
        }

    }

    // Tveksam eftersom den lutar sig på currentplayer som har ett fast värde på 0.
    //Vilket känns som om den alltid kommer kalla på den som är satt som spelare 0.

    private void rotatePlayers(){
        for ( int i = 0; i > playerList.size(); i++){

        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }


}

