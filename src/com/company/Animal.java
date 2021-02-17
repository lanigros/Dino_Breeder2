package com.company;

abstract class Animal {

    public String name;
    public String gender;
    public int health = 100;
    public int price;
    public String diet;
    public boolean alive = true;

    @Override
    public String toString() {
        return name + " has " + health;
    }

    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;

    }

    public String getGender() {
        return gender;
    }

    public int getHealth() {
        return health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int decreaseHealth(int healthDecrease) {
        health = health - healthDecrease;
        if (health <= 0) {
            alive = false;
        }
        System.out.println(name + " lost: " + healthDecrease + " health");
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

    public boolean isDead() {
        return alive = false;
    } // namn

    abstract void die();

    public void die(String sound) {
        System.out.println(sound + " i'm dead!");
    }

}

class Trex extends Animal {
    public Trex(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Meat";

    }

    public void die() {
        super.die("Roar!");
    }

}

class Velociraptor extends Animal {
    public Velociraptor(String name, String gender) {
        super(name, gender);
        this.price = 50;
        this.diet = "Meat";
    }

    public void die() {
        super.die("Screech!");
    }
}

class Triceratops extends Animal {
    public Triceratops(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Veggies";

    }

    public void die() {
        super.die("Squeek!");
    }
}

class Stegosaurus extends Animal {
    public Stegosaurus(String name, String gender) {
        super(name, gender);
        this.price = 200;
        this.diet = "Veggies";

    }

    public void die() {
        super.die("Wraaah!");
    }
}

class Spinosaurus extends Animal {
    public Spinosaurus(String name, String gender) {
        super(name, gender);
        this.price = 250;
        this.diet = "Fish";

    }

    public void die() {
        super.die("Blub!");
    }

}






