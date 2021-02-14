package com.company;

abstract class Food {
    String name;
     int cost;
     int kg;
     int energy;

    public Food (int kg){
    this.kg=kg;
    }
    public int getTotalCost(){
        int sum = cost * kg;
        return sum;

    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public void removeKg(int kgs){
        setKg((getKg() - kgs));
    }
}

class Meat extends Food{

    public Meat(int kg) {
        super(kg);
        this.name="Meat";
        this.cost=100;
        this.energy=10;
    }
}
class Veggies extends Food {

    public Veggies(int kg) {
        super(kg);
        this.name="Veggies";
        this.cost=50;
        this.energy=10;
    }
}
class Fish extends Food {

    public Fish(int kg) {
        super(kg);
        this.name="Fish";
        this.cost=25;
        this.energy=10;
    }

}







