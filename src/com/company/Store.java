package com.company;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Store {
    String name;


    public void storeMenu(Player player) {


        System.out.println("-".repeat(50));
        System.out.println("\t".repeat(5) + "DINO STORE.");
        System.out.println("-".repeat(50));
        System.out.println("Player: " + player.getName() + "\t".repeat(6) + "Money :" + player.getMoney());
        playerInfo(player);

        System.out.println("\n");
        System.out.println("1) Buy animals" + "\n2) Sell animals" +
                "\n3) Buy food" + "\n4) Feed animals" + "\n5) Breed animals");
        System.out.println("\n");
        int menuChoice = DialogueHelp.answerChecker("What would you like to do?", 1, 5);
        switch (menuChoice) {
            case 1:
                buyAnimalsMenuChoice(player);
                break;
            case 2:
                sellAnimalsMenuChoice(player);
                break;
            case 3:
                buyFoodMenuChoice(player);
                break;
            case 4:
                feedAnimalMenuChoice(player);
                break;
            case 5:
                breedAnimalMenuChoice(player);
                break;
            default:
                System.out.println("You have to choose between 1-5.");
                break;

        }

    }

    /**
     * @param player buyAnimalMenuChoice give you the option to buy animals and subtract the cost
     *               from the players wallet. It also give you the option to set a name and gender
     *               for your pet.
     */

    public void buyAnimalsMenuChoice(Player player) {
        var isRunning = true;
        while (isRunning) {
            getListAllDinos();
            int dinoToBuy = DialogueHelp.answerChecker("\nWhich Dino will you buy? (1-5)" + "\nExit = 6", 1, 6);
            switch (dinoToBuy) {
                case 1:
                    String petName = decidePetName();
                    String petGender = decideGenderPet();
                    Animal newTrex = new Trex(petName, petGender);
                    if (enoughMoney(player, newTrex)) {
                        player.ownedPets.add(newTrex);
                        player.setMoney(player.getMoney() - newTrex.getPrice());
                    }
                    break;
                case 2:
                    petName = decidePetName();
                    petGender = decideGenderPet();
                    Animal newVelo = new Velociraptor(petName, petGender);
                    if (enoughMoney(player, newVelo)) {
                        player.ownedPets.add(newVelo);
                        player.setMoney(player.getMoney() - newVelo.getPrice());
                    }

                    break;
                case 3:
                    petName = decidePetName();
                    petGender = decideGenderPet();
                    Animal newTrice = new Triceratops(petName, petGender);
                    if (enoughMoney(player, newTrice)) {
                        player.ownedPets.add(newTrice);
                        player.setMoney(player.getMoney() - newTrice.getPrice());
                    }
                    break;
                case 4:
                    petName = decidePetName();
                    petGender = decideGenderPet();
                    Animal newStego = new Stegosaurus(petName, petGender);
                    if (enoughMoney(player, newStego)) {
                        player.ownedPets.add(newStego);
                        player.setMoney(player.getMoney() - newStego.getPrice());
                    }
                    break;
                case 5:
                    petName = decidePetName();
                    petGender = decideGenderPet();
                    Animal newSpino = new Spinosaurus(petName, petGender);
                    if (enoughMoney(player, newSpino)) {
                        player.ownedPets.add(newSpino);
                        player.setMoney(player.getMoney() - newSpino.getPrice()
                        );
                    }
                    break;
                case 6:
                    isRunning = false;
                    break;

            }
        }
    }

    /**
     *
     * @return As the name suggests, decideGenderPet make the player give the terminal a value of "F" or "M".
     */
    public String decideGenderPet() {
        Scanner input = new Scanner(System.in);
        String genderAnswer = "";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nAnd a gender (F/M)");
            genderAnswer = input.nextLine();
            if (genderAnswer.equalsIgnoreCase("F")) {
                isRunning = false;
            } else if (genderAnswer.equalsIgnoreCase("M")) {
                isRunning = false;
            }
        }
        return genderAnswer;
    }

    /**
     *
     * @return Let's the player choose a name for their pet. In this case i chose to allow the input to be numbers
     * as well as regular letters or strings.
     */
    public String decidePetName() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter a name for your pet:");
        return input.nextLine();
    }

    /**
     * @param player BuyFoodMenuChoice is going to have in mind what kind of food you want and how much of it
     *               After you've chosen your wares it will add a new object, add to your arraylist of owned foods
     *               and also draw money from your wallet.
     */
    public void buyFoodMenuChoice(Player player) {
        var isRunning = true;
        while (isRunning) {
            getListAllFood();
            int foodToBuy = DialogueHelp.answerChecker("\nWhich kind of food would you like to buy?" + "\n4 = Exit.", 1, 4);
            switch (foodToBuy) {
                case 1:
                    int kgToBuy = amountOfKgs();
                    Food newMeat = new Meat(kgToBuy);
                    if (enoughMoneyFood(player, newMeat)) {
                        player.ownedFood.add(newMeat);
                        player.setMoney(player.getMoney() - newMeat.getTotalCost());
                    }

                    break;
                case 2:
                    kgToBuy = amountOfKgs();
                    Food newVeggies = new Veggies(kgToBuy);
                    if (enoughMoneyFood(player, newVeggies)) {
                        player.ownedFood.add(newVeggies);
                        player.setMoney(player.getMoney() - newVeggies.getTotalCost());
                    }

                    break;
                case 3:
                    kgToBuy = amountOfKgs();
                    Food newFish = new Fish(kgToBuy);
                    if (enoughMoneyFood(player, newFish)) {
                        player.ownedFood.add(newFish);
                        player.setMoney(player.getMoney() - newFish.getTotalCost());
                    }

                    break;
                case 4:
                    isRunning = false;
            }
        }

    }

    /**
     *
     * @return amountOfKgs works with the butFoodMenuChoice. Saves the amount of kilos you want to
     * buy from a specific kind of food.
     */

    public int amountOfKgs() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many kg would you like to buy?");
        int kgToBuy = input.nextInt();
        return kgToBuy;
    }

    /**
     * @param player getListAllFood gives the player the list of all owned Foods
     */

    public void getListPlayerFood(Player player) {
        for (int i = 0; i < player.ownedFood.size(); i++) {
            int kgs = player.ownedFood.get(i).kg;
            String foodName = player.ownedFood.get(i).name;
            System.out.println("\n" + (i + 1) + ". " + foodName + " (amount : " + kgs + " kgs)");
        }

    }


    /**
     * @param player sellAnimalMenuChoice is showing your full list of owned animals and give you the option
     *               to choose freely amongst them. It will remove the chosen pet from your petlist and then add
     *               the money it originally cost times the health to your wallet.
     */
    public void sellAnimalsMenuChoice(Player player) {

        System.out.println();
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println((i + 1) + ". " + player.ownedPets.get(i).name);
        }
        int i = DialogueHelp.answerChecker("\nWhich animal would you like to sell?", 1, player.ownedPets.size()) - 1;

        player.setMoney(player.getMoney() + player.petWorth(i));
        System.out.println("Sold for: " + player.petWorth(i));
        Game.pressEnterToContinue();
        player.ownedPets.remove(i);


    }

    /**
     * @param player feedAnimalMenuChoice is showing you your list of foods and pets.
     *               you then have to choose the right food and the right pet.
     *               Depending on the animals diet it could either be denied or accepted and replenish health.
     */

    public void feedAnimalMenuChoice(Player player) {
        DialogueHelp.clear();
        getListPlayerPets(player);
        int animalIndex = DialogueHelp.answerChecker("Which animal would you like to feed?", 1, player.ownedPets.size()) - 1;
        Animal getAnimalIndex = player.ownedPets.get(animalIndex);

        getListPlayerFood(player);
        int foodIndex = DialogueHelp.answerChecker("What kind of food?", 1, player.ownedFood.size()) - 1;
        Food getFoodIndex = player.ownedFood.get(foodIndex);

        int amountOfKgsFed = DialogueHelp.answerChecker("How many kgs?", 1, player.ownedFood.get(foodIndex).kg);

        dietChecker(getFoodIndex, getAnimalIndex, amountOfKgsFed);

        Game.pressEnterToContinue();
        getFoodIndex.removeKg(amountOfKgsFed);
        if (getFoodIndex.getKg() <= 0) {
            System.out.println(getAnimalIndex.name + " was removed.");
            player.ownedFood.remove(foodIndex);
        }


    }

    /**
     * @param player breedAnimalMenuChoice lets the player to choose from 2 of their pets to try to make them breed.
     *               There is a 50/50 chance that it will succeed and when it does, it lets the player give the
     *               a new name, the gender is randomly assigned to the baby.
     */
    public void breedAnimalMenuChoice(Player player) {
        getListPlayerPets(player);
        int dino1 = DialogueHelp.answerChecker("Choose your first pet.", 1, player.ownedPets.size()) - 1;
        int dino2 = DialogueHelp.answerChecker("Choose your second pet.", 1, player.ownedPets.size()) - 1;

        breederCheck(player.ownedPets.get(dino1), player.ownedPets.get(dino2));
        if (breederCheck(player.ownedPets.get(dino1), player.ownedPets.get(dino2))) {
            breederSuccess(player.ownedPets.get(dino1), player);
            System.out.println("\nSuccess!");
            Game.pressEnterToContinue();
        } else {
            System.out.println("The breeding failed.");
            Game.pressEnterToContinue();
        }

    }

    /**
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

    /**
     *
     * @param dino1
     * @param player When breeding is a success, BreederSuccess starts and lets you choose the name.
     *               It creates a new object from the Animal class and depending on the parent,
     *               the babypet will be of the same subclass as the parent.
     */

    public void breederSuccess(Animal dino1, Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name for your baby pet:");
        String babyPetName = input.nextLine();

        if (dino1 instanceof Trex) {
            Animal babyTrex = new Trex(babyPetName, genderGenerator());
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
        if (dino1 instanceof Stegosaurus) {
            Animal babyStegosaurus = new Stegosaurus(babyPetName, genderGenerator());
            babyStegosaurus.setGender(genderGenerator());
            player.ownedPets.add(babyStegosaurus);
        }
        if (dino1 instanceof Spinosaurus) {
            Animal babySpinosaurus = new Spinosaurus(babyPetName, genderGenerator());
            babySpinosaurus.setGender(genderGenerator());
            player.ownedPets.add(babySpinosaurus);
        }

    }

    /**
     * @return A method that generates the gender, 50% male, 50% female.
     */

    public String genderGenerator() {
        Random random = new Random();
        int genderProcent = random.nextInt(100);
        if (genderProcent >= 50) {
            return ("F");
        }
        return ("M");
    }

    /**
     * @param player
     * @param dino
     * @return enoughMoney will check if you have enough money to buy an specific animal.
     */

    private boolean enoughMoney(Player player, Animal dino) {
        if (player.getMoney() >= dino.getPrice()) {
            System.out.println("\nYou just bought a " + getDinoClassName(dino)
                    + " with the name " + dino.name + " for " + dino.getPrice());
            Game.pressEnterToContinue();
            return true;
        }
        System.out.println("Not enough money!");
        Game.pressEnterToContinue();
        return false;
    }

    /**
     * @param player
     * @param food
     * @return enoughMoneyFood checks if player has enough money to buy the chosen amount of food.
     */

    private boolean enoughMoneyFood(Player player, Food food) {
        if (player.getMoney() >= food.getTotalCost()) {
            return true;
        }
        System.out.println("Not enough money!");
        return false;

    }

    /**
     * getListAllDinos gives the player the list of all available pets(Dinos)
     */

    public void getListAllDinos() {
        System.out.println(
                "\n1. Tyrannosaurus rex - Diet: Meat - 100$" +
                        "\n2. Velociraptor - Diet: Meat - 50$" +
                        "\n3. Triceratops - Diet: Veggies -100$" +
                        "\n4. Stegosaurus - Diet: Veggies - 200$" +
                        "\n5. Spinosaurus - Diet: Fish - 250$");
    }

    /**
     * getListAllFood gives the player the list of all available Food
     */

    public void getListAllFood() {
        System.out.println("\n1. Meat - 100$/kg" +
                "\n2. Vegetables - 50$/kg" +
                "\n3. Fish - 25$/kg");
    }

    /**
     * No matter what animal you buy, this method returns the classname of the dino.
     * For example: I want to buy a Trex, this method returns the Classname of Trex.
     *
     * @param dino
     * @return
     */

    public String getDinoClassName(Animal dino) {
        return dino.getClass().getSimpleName();
    }

    /**
     * @param player getListPlayerPets gives the player the list of all owned pets(Dinos)
     */

    public void playerInfo(Player player) {
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + player.ownedPets.get(i).name + " | " +
                            "Type: " + player.ownedPets.get(i).getClass().getSimpleName() + " | " +
                            "Gender: " + player.ownedPets.get(i).gender + " | " +
                            "Health: " + player.ownedPets.get(i).getHealth() + "/100" + " | " +
                            "Diet: " + player.ownedPets.get(i).diet);


        }
        getListPlayerFood(player);
    }

    /**
     *
     * @param dino
     * @param amountOfKgsFed
     * @return ReplenishHealth decides the amount of health the food will generate by multiplying
     *         10 and the amount of kgs fed to the pet. e.g if the animal receives 10kgs of meat, it will
     *         generate a total return of 100 health points.
     */

    public int replenishHealth(Animal dino, int amountOfKgsFed) {
        int totalHealthRegain = 10 * amountOfKgsFed;
        System.out.println("Om nom nom!" + "\n*Replenished " + totalHealthRegain + " health!*");
        dino.setHealth(dino.getHealth() + (totalHealthRegain));

        return dino.getHealth();
    }

    /**
     *
     * @param player Loops through player pets.
     */

    public void getListPlayerPets(Player player) {
        for (int i = 0; i < player.ownedPets.size(); i++) {
            System.out.println(i + 1 + ". " + player.ownedPets.get(i).name);
        }

    }


    /**
     * @param food
     * @param dino Checks if the chosen food is compatible with the chosen pets diet. If the food
     *             does not align with the pets diet, it will return a message. If the food works
     *             it will replenish the pets health by 25 points.
     */

    public void dietChecker(Food food, Animal dino, int amountOfKgsFed) {
        if (!(food.name.equals(dino.diet))) {
            System.out.println("I don't eat that!");
            return;
        } else {
            replenishHealth(dino, amountOfKgsFed);
        }

    }

}

