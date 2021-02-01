package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game(true);
        Game otherGame = new Game ( true);


        newGame.roundsAndPlayers();

        newGame.banner();
        newGame.roundsAndPlayers();

    }
}
