package com.company;

abstract class Animal {

    public String name;
    public String gender;
    public int health;
    public int price;


    public Animal(String name, String gender, int health, int price) {
        this.name = name;
        this.gender = gender;
        this.health = health;
        this.price = price;

    }

}

class tRex extends Animal {
    public tRex(String name, String gender, int health, int price) {
        super(name, gender, health, price);
        this.price = 100;
        this.health=100;
    }
}

class velociraptor extends Animal {
    public velociraptor(String name, String gender, int health, int price) {
        super(name, gender, health, price);
        this.price = 50;
        this.health=100;
    }
}

class triceratops extends Animal {
    public triceratops(String name, String gender, int health, int price) {
        super(name, gender, health, price);
        this.price = 100;
        this.health=100;

    }
}

class stegosaurus extends Animal {
    public stegosaurus(String name, String gender, int health, int price) {
        super(name, gender, health, price);
        this.price = 200;
        this.health=100;

    }
}

class spinosaurus extends Animal {
    public spinosaurus(String name, String gender, int health, int price) {
        super(name, gender, health, price);
        this.price = 250;
        this.health=100;

    }
}



