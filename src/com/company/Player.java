package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    int money = 1000;


    public ArrayList<Animal> ownedPets = new ArrayList<>(); // ownedPets.size()
    public ArrayList<Food> ownedFood = new ArrayList<>(); // Börja med 0


    public Player(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void removeFood(int index){
        System.out.println(ownedFood.get(index) + " was removed.");
        ownedFood.remove(index);
    }

    public int petWorth (int i){
        ownedPets.get(i).getTotalWorth();

    } // Behöver fixas, ska returna värdet av djuret

    public ArrayList<Animal> getOwnedPets() {
        return ownedPets;
    }

    public void setOwnedPets(ArrayList<Animal> ownedPets) {
        this.ownedPets = ownedPets;
    }
}