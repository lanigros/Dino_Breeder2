package com.company;

abstract class Animal {

    public String name;
    public String gender;
    public int health;
    public int price;
    public String diet;


    public Animal(String name, String gender, int health, int price) {
        this.name = name;
        this.gender = gender;

    }

}

class tRex extends Animal {
    public tRex(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Meat";

    }

}

class Velociraptor extends Animal {
    public Velociraptor(String name, String gender) {
        super(name, gender);
        this.price = 50;
        this.diet = "Meat";
    }
}

class Triceratops extends Animal {
    public Triceratops(String name, String gender) {
        super(name, gender);
        this.price = 100;
        this.diet = "Veggies";

    }
}

class stegosaurus extends Animal {
    public stegosaurus(String name, String gender) {
        super(name, gender);
        this.price = 200;
        this.diet = "Veggies";

    }
}

class spinosaurus extends Animal {
    public spinosaurus(String name, String gender) {
        super(name, gender);
        this.price = 250;
        this.diet = "Fish";

    }

}






