package com.company;

import java.util.Scanner;

public class Store {

    String name;

    public void storeMenu() {
        System.out.println("-".repeat(50));
        System.out.println("DINO STORE.");
        System.out.println("-".repeat(50));
        System.out.println("\nWhat would you like to do?");
        System.out.println("\n".repeat(2));
        System.out.println("1) Buy animals" + " 2) Sell animals" +
                "\n3) Buy food" + "4) Feed animals" + "\n5) Breed animals");
        Scanner input = new Scanner(System.in);
        int menuChoice = input.nextInt();
        switch (menuChoice) {
            case 1:
                getListAllDinos();
                buyAnimalsMenuChoice();
                break;
            case 2:
                System.out.println();

            case 3:
                getListAllFood();
                buyFoodMenuChoice();


        }
    }


    public void buyAnimalsMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name for your pet:");
        String petName = input.nextLine();
        System.out.println("And a gender (F/M)");
        String petGender = input.nextLine();
        System.out.println("And which Dino will you buy? (1-5)");
        int dinoToBuy = input.nextInt();
        switch (dinoToBuy) {
            case 1:
                Animal newTrex = new tRex(petName, petGender, 100, 100);
                player.ownedPets.add(newTrex);
                player.setMoney(player.getMoney() - 100);
                break;
            case 2:
                Animal newVelo = new velociraptor(petName, petGender, 100, 50);
                player.ownedPets.add(newVelo);
                player.setMoney(player.getMoney() - 50);
                break;
            case 3:
                Animal newTrice = new triceratops(petName, petGender, 100, 100);
                player.ownedPets.add(newTrice);
                player.setMoney(player.getMoney() - 100);
                break;
            case 4:
                Animal newStego = new stegosaurus(petName, petGender, 100, 200);
                player.ownedPets.add(newStego);
                player.setMoney(player.getMoney() - 200);
                break;
            case 5:
                Animal newSpino = new spinosaurus(petName, petGender, 100, 250);
                player.ownedPets.add(newSpino);
                player.setMoney(player.getMoney() - 250);
                break;

        }
    }

    public void buyFoodMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many kg would you like to buy?");
        int kgToBuy = input.nextInt();
        System.out.println("And which kind of food would you like to buy?");

        int foodToBuy = input.nextInt();

        switch (foodToBuy) {
            case 1:
                Food newMeat = new Meat(100, kgToBuy);
                player.ownedFood.add(newMeat);
                player.setMoney(player.getMoney() - 100);
                break;
            case 2:
                Food newVeggies = new Veggies(50, kgToBuy);
                player.ownedFood.add(newVeggies);
                player.setMoney(player.getMoney() - 50);
                break;
            case 3:
                Food newFish = new Fish(25 ,kgToBuy);
                player.ownedFood.add(newFish);
                player.setMoney(player.getMoney() - 25);
                break;
        }
    }

    public void sellAnimalsMenuChoice(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("Which animal would you like to sell?");
        for (int i = 0 ; i < player.ownedPets.size() ; i++){
            System.out.println(i+1 + ". " + player.ownedPets.get(i));
        }


    }

    public static void getListAllDinos() {
        System.out.println("1. Tyrannosaurus rex - 100$" +
                "\n2. Velociraptor - 50$" +
                "\n3. Triceratops - 100$" +
                "\n4. Stegosaurus - 200$" +
                "\n5. Spinosaurus - 250$");
    }

    public static void getListAllFood() {
        System.out.println("1. Meat - 100$/kg" +
                "\n2. Vegetables - 50$/kg" +
                "\n3. Fish - 25$/kg");
    }

}
