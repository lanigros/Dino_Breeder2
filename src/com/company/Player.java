package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    int money = 1000;


    public ArrayList<Animal> ownedPets = new ArrayList<>();
    public ArrayList<Food> ownedFood = new ArrayList<>();


    public Player(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void removeFood(int index) {
        System.out.println(ownedFood.get(index).name + " was removed.");
        ownedFood.remove(index);
    }

    public int petWorth(int i) {
        return ownedPets.get(i).getTotalWorth();
    }

    public String getName() {
        return name;
    }

    public void sellPets(){
        for (int a = 0; a < ownedPets.size(); a++) {
            money+= petWorth(a);
            System.out.println(ownedPets.get(a).name + " sold for " + petWorth(a));
            ownedPets.remove(ownedPets.get(a));
        }
    }

    public void removePlayer(){

    }

}