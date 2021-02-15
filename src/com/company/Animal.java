package com.company;

abstract class Animal {

    public String name;
    public String gender;
    public int health = 100;
    public int price;
    public String diet;
    public boolean alive=true;

    public Animal(String name, String gender) { //Yeah
        this.name = name;
        this.gender = gender;

    }

    public String getGender() {
        return gender;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return this.price;
    }

    public int getTotalWorth() {
        return health * price;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean dead() {
        return alive = false;
    }


}

class tRex extends Animal {
    public tRex(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Meat";

    }
    public void die(){
        System.out.println("Roar! I'm dead!");
        super.dead();
    }

}

class Velociraptor extends Animal {
    public Velociraptor(String name, String gender) {
        super(name, gender);
        this.price = 50;
        this.diet = "Meat";
    }
    public void die(){
        System.out.println("Roar! I'm dead!");
        super.dead();
    }
}

class Triceratops extends Animal {
    public Triceratops(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Veggies";

    }
    public void die(){
        System.out.println("Roar! I'm dead!");
        super.dead();
    }
}

class stegosaurus extends Animal {
    public stegosaurus(String name, String gender) {
        super(name, gender);
        this.price = 200;
        this.diet = "Veggies";

    }
    public void die(){
        System.out.println("Roar! I'm dead!");
        super.dead();
    }
}

class spinosaurus extends Animal {
    public spinosaurus(String name, String gender) {
        super(name, gender);
        this.price = 250;
        this.diet = "Fish";

    }
    public void die(){
        System.out.println("Roar! I'm dead!");
        super.dead();
    }

}






