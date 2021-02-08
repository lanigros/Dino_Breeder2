package com.company;

import java.util.Random;
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
                buyAnimalsMenuChoice(player);
                break;
            case 2:
                sellAnimalsMenuChoice(player);

            case 3:
                getListAllFood();
                buyFoodMenuChoice(player);

            case 4:
                feedAnimalMenuChoice(player);

            case 5:
                breedAnimalMenuChoice(player);

        }
    }

    /**
     * @param player buyAnimalMenuChoice give you the option to buy animals and subtract the cost
     *               from the players wallet. It also give you the option to set a name and gender
     *               for your pet.
     */


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
                Animal newVelo = new Velociraptor(petName, petGender);
                if (enoughMoney(player, newVelo)) {
                    player.ownedPets.add(newVelo);
                    player.setMoney(player.getMoney() - newVelo.getPrice());
                }

                break;
            case 3:
                Animal newTrice = new Triceratops(petName, petGender);
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
     * @param player sellAnimalMenuChoice is showing your full list of owned animals and give you the option
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

    /**
     * @param player feedAnimalMenuChoice is showing you your list of foods and pets.
     *               you then have to choose the right food and the right pet.
     *               Depending on the animals diet it could either be denied or accepted and replenish health.
     *               (!Needs to be looked over!)
     */

    public void feedAnimalMenuChoice(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which animal would you like to feed?");
        getListPlayerPets(player);
        int animalIndex = input.nextInt();
        player.ownedPets.get(animalIndex + 1);
        getListPlayerFood(player);
        int foodIndex = input.nextInt();
        player.ownedFood.get(foodIndex + 1);

        dietChecker(player.ownedFood.get(foodIndex), player.ownedPets.get(animalIndex));
        player.removeFood(foodIndex);

    }

    public void breedAnimalMenuChoice(Player player) {  //Här måste jag skriva om
        Scanner input = new Scanner(System.in);
        getListPlayerPets(player);
        System.out.println("Choose your first pet.");
        int dino1 = input.nextInt();
        System.out.println("Choose your second pet.");
        int dino2 = input.nextInt();
        breederCheck(player.ownedPets.get(dino1), player.ownedPets.get(dino2));
        if (breederCheck(player.ownedPets.get(dino1), player.ownedPets.get(dino2))) {
            breederSuccess(player.ownedPets.get(dino1), player);
        }

    }

    /**
     *
     * @param dino1
     * @param dino2
     * @return breederCheck checks if the 2 chosen pets are compatible.
     * There are 3 steps to this method.
     * 1) If the genders are different, continue.
     * 2) if the classes are the same, (Same type of dino) continue.
     * 3) Start the method "RandomChanceOfBreeding).
     * 4) If all of the above are true, return a true value, if either one fails, return a false value.
     */

    public boolean breederCheck(Animal dino1, Animal dino2) {
        if (!dino1.gender.equals(dino2.gender)) {
            if (dino1.getClass().equals(dino2.getClass())) {
                if (randomChanceOfBreeding()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @return randomChanceOfBreeding, generates a number between 0-100. If the
     * number is more or equals to 50, return a true value. Otherwise false.
     */

    public boolean randomChanceOfBreeding() {
        Random random = new Random();
        int breedChance = random.nextInt(100);
        if (breedChance >= 50) {
            return true;
        }
        return false;
    }

    public void breederSuccess(Animal dino1, Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name for your baby pet:");
        String babyPetName = input.nextLine();

        if (dino1 instanceof tRex) {
            Animal babyTrex = new tRex(babyPetName, genderGenerator());
            babyTrex.setGender(genderGenerator());
            player.ownedPets.add(babyTrex);
        }
        if (dino1 instanceof Velociraptor) {
            Animal babyVelo = new Velociraptor(babyPetName, genderGenerator());
            babyVelo.setGender(genderGenerator());
            player.ownedPets.add(babyVelo);
        }
        if (dino1 instanceof Triceratops) {
            Animal babyTriceratops = new Triceratops(babyPetName, genderGenerator());
            babyTriceratops.setGender(genderGenerator());
            player.ownedPets.add(babyTriceratops);
        }
        if (dino1 instanceof stegosaurus) {
            Animal babyStegosaurus = new stegosaurus(babyPetName, genderGenerator());
            babyStegosaurus.setGender(genderGenerator());
            player.ownedPets.add(babyStegosaurus);
        }
        if (dino1 instanceof spinosaurus) {
            Animal babySpinosaurus = new spinosaurus(babyPetName, genderGenerator());
            babySpinosaurus.setGender(genderGenerator());
            player.ownedPets.add(babySpinosaurus);
        }

    }

    /**
     *
     * @return A method that generates the gender, 50% male, 50% female.
     */

    public String genderGenerator() {
        Random random = new Random();
        int genderProcent = random.nextInt(100);
        if (genderProcent >= 50) {
            return ("M");
        }
        return ("M");
    }

    /**
     * @param player
     * @param dino
     * @return enoughMoney will check if you have enough money to buy an specific animal.
     */

    private boolean enoughMoney(Player player, Animal dino) {
        if (player.getMoney() > dino.getPrice()) {
            return true;
        }
        System.out.println("Not enough money!");
        return false;
    }

    public static void getListAllDinos() {
        System.out.println("1. Tyrannosaurus rex - 100$" +
                "\n2. Velociraptor - 50$" +
                "\n3. Triceratops - 100$" +
                "\n4. Stegosaurus - 200$" +
                "\n5. Spinosaurus - 250$");
    }

    /**
     * getListAllFood gives the player the list of all available Food
     */

    public void getListAllFood() {
        System.out.println("1. Meat - 100$/kg" +
                "\n2. Vegetables - 50$/kg" +
                "\n3. Fish - 25$/kg");
    }

    /**
     *
     * @param player getListPlayerPets gives the player the list of all owned pets(Dinos)
     */

    public void getListPlayerPets(Player player) {
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedPets.get(i));
        }

    }

    /**
     *
     * @param player getListAllFood gives the player the list of all owned Foods
     */

    public void getListPlayerFood(Player player) {
        for (int i = 0; i < player.ownedFood.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedFood.get(i));
        }
    }

    /**
     *
     * @param food
     * @param dino Checks if the chosen food is compatible with the chosen pets diet. If the food
     *             does not align with the pets diet, it will return a message. If the food works
     *             it will replenish the pets health by 25 points.
     */

    public void dietChecker(Food food, Animal dino) {
        if (!food.equals(dino.diet)) {
            System.out.println("I don't eat that!");
            return;
        }
        dino.replenishHealth();


    }


}
