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

}