package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    ArrayList<Player> playerList;

    public boolean newGame = true;
    public int amountOfRounds;
    public int amountOfPlayers;

    public Game(boolean newGame) {
        this.newGame = newGame;
        playerList = new ArrayList<>();
    }


    public void banner() {
        System.out.println("+--------------------------+");
        System.out.println("|       DINO BREEDER       |");
        System.out.println("|                          |");
        System.out.println("+--------------------------+");
    }

    public void roundsAndPlayers() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter how many rounds you want to play.");
        int rounds = input.nextInt();
        if (rounds < 5 || rounds > 30) {
            System.out.println("Wrong amount of rounds! 5-30!");
            return;
        } else {
            amountOfRounds = rounds;
        }

        System.out.println("\nEnter how many players will be playing.");
        int players = input.nextInt();
        if (players < 1 || players > 4) {
            System.out.println("Wrong amount of players! 1-4");
            return;

        } else {

            for (int i = 0; i < amountOfPlayers; i++) {
                System.out.println("Name player " + (i + 1));
                String playerNames = input.nextLine();

                playerList.add((new Player(playerNames)));

            }
        }

    }
}
