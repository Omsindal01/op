package com.example;
import java.util.Random;

class Dice {
    private Random random;
    private int sides;

    public Dice(int sides) {
        this.random = new Random();
        this.sides = sides;
    }

    public Dice(Random random, int sides){
        this.random = random;
        this.sides = sides;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
