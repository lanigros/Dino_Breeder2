package com.company;

abstract class Food {

     int cost;
     int kg;

    public Food (int cost, int kg){


    }

}

class Meat extends Food{

    public Meat(int cost, int kg) {
        super(cost, kg);
        this.cost=100;
        this.kg=kg;

    }
}
class Veggies extends Food {

    public Veggies(int cost, int kg) {
        super(cost, kg);
        this.cost=50;
        this.kg=kg;
    }
}
class Fish extends Food {

    public Fish(int cost, int kg) {
        super(cost, kg);
        this.cost=25;
        this.kg=kg;
    }
}


