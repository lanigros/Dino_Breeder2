package com.company;
import java.util.Scanner;

public class DialogueHelp {

    static private Scanner scanner = new Scanner(System.in);


    static public void clear() {

        // "clear" the console by printing 60 new lines

        System.out.println("\n".repeat(60));

    }


    static public String prompt(String question) {

        // clear() ? maybe we want a clear before each prompt

        System.out.println(question);

        return scanner.nextLine();

    }


    static public int promptInt(String question, int min, int max) {

        var num = min - 1;

        try {

            num = Integer.parseInt(prompt(question));

        } catch (Exception ignore) {
        }

        // if illegal choice show the prompt again (recursion)

        // otherwise return the choice

        return num < min || num > max ?

                promptInt(question, min, max) : num;

    }


    static public int menu(String menuName, String... options) {

        // print the menu

        clear();

        System.out.println("-".repeat(50));

        System.out.println("MY GAME NAME: " + menuName);

        System.out.println("-".repeat(50));

        var counter = 1;

        for (var option : options) {

            System.out.println(counter + ". " + option);

            counter++;

        }

        System.out.println("-".repeat(50));

        // wait for the user to make a choice

        var choice = 0;

        try {

            choice = Integer.parseInt(scanner.nextLine());

        } catch (Exception ignore) {
        }

        // if illegal choice show the menu again (recursion)

        // otherwise return the choice

        return choice < 1 || choice > options.length ?

                menu(menuName, options) : choice;

    }


}
