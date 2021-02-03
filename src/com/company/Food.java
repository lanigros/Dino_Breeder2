package com.company;

abstract class Food {

     int cost;
     int kg;

    public Food (int kg){
    this.kg=kg;
    }
    public int getTotalCost(){
        int sum = cost * kg;
        return sum;

    }

}

class Meat extends Food{

    public Meat(int kg) {
        super(kg);
        this.cost=100;
    }
}
class Veggies extends Food {

    public Veggies(int kg) {
        super(kg);
        this.cost=50;
    }
}
class Fish extends Food {

    public Fish(int kg) {
        super(kg);
        this.cost=25;
    }
}





