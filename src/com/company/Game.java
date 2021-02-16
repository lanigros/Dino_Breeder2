package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    ArrayList<Player> playerList;
    private String winner;
    private boolean newGame = true;
    private int totalAmountOfRounds;
    private int amountOfPlayers;
    private Store store = new Store();
    private Player currentPlayer;

    public Game(boolean newGame) {
        this.newGame = newGame;
        playerList = new ArrayList<>();

    }

    public int Rounds() {
        final int minRounds = 5;
        final int maxRounds = 30;
        int answer = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("How many rounds: ");
        boolean repeat = true;
        while (repeat) {
            try {
                answer = input.nextInt();
                repeat = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, it has to be a number.");
                input.next();
                repeat = true;
            }
        }


        while (answer < minRounds || answer > maxRounds) {
            System.out.println("Wrong amount of rounds! (5-30)");
            System.out.println("\nTry again.");

            answer = input.nextInt();

        }

        totalAmountOfRounds = answer;
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

    public int Players() {
        int minPlayers = 1;
        int maxPlayers = 4;
        int answer;

        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter how many players:");
        answer = input.nextInt();
        while (answer < minPlayers || answer > maxPlayers) {
            System.out.println("Wrong amount of players! (1-4)");
            System.out.println("\nTry again.");
            answer = input.nextInt();
        }
        amountOfPlayers = answer;
        return amountOfPlayers;
    }

    public void NamePlayers() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Name player: " + (i + 1));
            String playerNames = input.nextLine();
            playerList.add((new Player(playerNames)));
        }
    }


    public void roundsAndPlayers() {
        banner();
        Rounds();
        Players();
        NamePlayers();
    }


//    public void nextPlayer(int i) {
//        Player currentPlayer = playerList.get(i);
//        System.out.println("Player: " + currentPlayer.getName() + " is up!");
//        store.storeMenu(currentPlayer);
//    }
//    public Player getCurrentPlayer(int index) {
//        currentPlayer = playerList.get(index);
//        System.out.println("Player: " + currentPlayer.getName() + " is up!");
//        return currentPlayer;
//    }
//    public void getNextPlayer() {
//
//        for (int i = 0; i < playerList.size() - 1; i++) {
//            Player currentPlayer = playerList.get(i);
//            if (playerList.indexOf(currentPlayer) == (playerList.size() - 1)) {
//                nextPlayer(0);
//            } else {
//                store.storeMenu(getCurrentPlayer(i + 1));
//            }
//        }
//    }


    public void newGame() {
        while (newGame) {
            roundsAndPlayers();
            int i = 1;
            while (i <= totalAmountOfRounds) {

                int j = 0;
                while (j <= playerList.size() - 1) {

                    System.out.println("\nRound " + i + " Player: " + playerList.get(j).getName() + " is up!");

                    store.storeMenu(playerList.get(j));
                    decreaseDinoHealthMechanic(playerList.get(j));
                    j++;

                }
                i++;
                endRound(i);
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




