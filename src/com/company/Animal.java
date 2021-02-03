package com.company;

abstract class Animal {

    public String name;
    public String gender;
    public int health;
    public int price;


    public Animal(String name, String gender, int health, int price) {
        this.name = name;
        this.gender = gender;

    }

}

class tRex extends Animal {
    public tRex(String name, String gender) {
        super(name, gender);
        this.price = 100;

    }

}

class velociraptor extends Animal {
    public velociraptor(String name, String gender) {
        super(name, gender);
        this.price = 50;
    }
}

class triceratops extends Animal {
    public triceratops(String name, String gender) {
        super(name, gender);
        this.price = 100;

    }
}

class stegosaurus extends Animal {
    public stegosaurus(String name, String gender) {
        super(name, gender);
        this.price = 200;

    }
}

class spinosaurus extends Animal {
    public spinosaurus(String name, String gender) {
        super(name, gender);
        this.price = 250;

    }
}






