package com.example;

public class App {
    public static void main(String[] args) throws Exception {
        Player playerA = new Player("A",50, 5, 10);
        Player playerB = new Player("B",100, 10, 15);

        MagicalArena magicalArena = new MagicalArena(playerA, playerB, 6);
        magicalArena.playGame();
    }
}
