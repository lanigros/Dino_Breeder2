package com.company;

import java.util.Scanner;

public class Store {

    String name;

    public void storeMenu(Player player) {
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
                sellAnimalsMenuChoice();

            case 3:
                getListAllFood();
                buyFoodMenuChoice();

            case 4:


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

                Animal newTrex = new tRex(petName, petGender);
                if (enoughMoney(player, newTrex)) {
                    player.ownedPets.add(newTrex);
                    player.setMoney(player.getMoney() - newTrex.getPrice());
                }
                break;
            case 2:
                Animal newVelo = new velociraptor(petName, petGender);
                if (enoughMoney(player, newVelo)) {
                    player.ownedPets.add(newVelo);
                    player.setMoney(player.getMoney() - newVelo.getPrice());
                }

                break;
            case 3:
                Animal newTrice = new triceratops(petName, petGender);
                if (enoughMoney(player, newTrice)) {
                    player.ownedPets.add(newTrice);
                    player.setMoney(player.getMoney() - newTrice.getPrice());
                }
                break;
            case 4:
                Animal newStego = new stegosaurus(petName, petGender);
                if (enoughMoney(player, newStego)) {
                    player.ownedPets.add(newStego);
                    player.setMoney(player.getMoney() - newStego.getPrice());
                }
                break;
            case 5:
                Animal newSpino = new spinosaurus(petName, petGender);
                if (enoughMoney(player, newSpino)) {
                    player.ownedPets.add(newSpino);
                    player.setMoney(player.getMoney() - newSpino.getPrice()
                    );
                }
                break;

        }
    }

    /**
     * @param player BuyFoodMenuChoice is going to have in mind what kind of food you want and how much of it
     *               After you've chosen your wares it will add a new object, add to your arraylist of owned foods
     *               and also draw money from your wallet.
     */
    public void buyFoodMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many kg would you like to buy?");
        int kgToBuy = input.nextInt();
        System.out.println("And which kind of food would you like to buy?");
        int foodToBuy = input.nextInt();

        switch (foodToBuy) {
            case 1:
                Food newMeat = new Meat(kgToBuy);
                if (enoughMoneyFood(player, newMeat)) {
                    player.ownedFood.add(newMeat);
                    player.setMoney(player.getMoney() - newMeat.getTotalCost());
                }

                break;
            case 2:
                Food newVeggies = new Veggies(kgToBuy);
                if (enoughMoneyFood(player, newVeggies)) {
                    player.ownedFood.add(newVeggies);
                    player.setMoney(player.getMoney() - newVeggies.getTotalCost());
                }

                break;
            case 3:
                Food newFish = new Fish(kgToBuy);
                if (enoughMoneyFood(player, newFish)) {
                    player.ownedFood.add(newFish);
                    player.setMoney(player.getMoney() - newFish.getTotalCost());
                }

                break;
        }
    }


    /**
     * @param player sellAnimalMenuChoice is showing you your full list of owned animals and give you the option
     *               to choose freely amongst them. It will remove the chosen pet from your petlist and then add
     *               the money it originally cost times the health to your wallet.
     */
    public void sellAnimalsMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which animal would you like to sell?");
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedPets.get(i));
        }
        int i = input.nextInt() + 1;

        player.setMoney(player.getMoney() + player.petWorth(i));
        player.ownedPets.remove(i);
    }
    //Fixa en metod som tar in värdet av djuret som är aktuellt
    // Av indexet som väljs av användaren så ska man få fram vilket djur (Done)
    // och även då få fram vilket värde den har gånger hälsovärdet.


    public void feedAnimalMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which animal would you like to feed?");
        getListPlayerPets(player);
        int animalToFeed = input.nextInt() +1;
    }


    public static void getListAllDinos() {
        System.out.println("1. Tyrannosaurus rex - 100$" +
                "\n2. Velociraptor - 50$" +
                "\n3. Triceratops - 100$" +
                "\n4. Stegosaurus - 200$" +
                "\n5. Spinosaurus - 250$");
    }

    public void getListAllFood() {
        System.out.println("1. Meat - 100$/kg" +
                "\n2. Vegetables - 50$/kg" +
                "\n3. Fish - 25$/kg");
    }

    public void getListPlayerPets(Player player){
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedPets.get(i));
        }

    }
    public void getListPlayerFood(Player player){
        for (int i = 0; i < player.ownedFood.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedFood.get(i));
        }
    }

}
