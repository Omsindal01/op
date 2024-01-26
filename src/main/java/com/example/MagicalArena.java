package com.example;

class MagicalArena {
    private Player playerA;
    private Player playerB;
    private Dice attackDice;
    private Dice defendDice;

    public MagicalArena(Player playerA, Player playerB, int sides) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.attackDice = new Dice(sides);
        this.defendDice = new Dice(sides);
    }

    public MagicalArena(Player playerA, Player playerB, Dice attackDice, Dice defendDice) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.attackDice = attackDice;
        this.defendDice = defendDice;
    }

    public void playGame() {
        Player attacker = (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
            Player defender = (attacker == playerA) ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            // Determine the player with lower health to attack first
            playTurn(attacker, defender);
    
            // Check if the game has ended after the current turn
            if (!defender.isAlive()) {
                displayWinner();
                break;
            }
    
            // Swap roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    private void playTurn(Player attacker, Player defender) {
        int attackRoll = attackDice.roll();
        int defendRoll = defendDice.roll();

        int damage = Math.max(0, attackRoll * attacker.getAttack() - defendRoll * defender.getStrength());
        defender.takeDamage(damage);

        System.out.println(attacker.getName() + " attacks with roll " + attackRoll +
                " and deals damage " + damage + ". " + defender.getName() +
                " defends with roll " + defendRoll + ". " +
                defender.getName() + "'s health: " + defender.getHealth());
    }

    private void displayWinner() {
        if (playerA.getHealth() == 0 && playerB.getHealth() == 0) {
            System.out.println("It's a draw!");
        } else if (playerA.getHealth() == 0) {
            System.out.println("Player " + playerB.getName() + " wins!");
        } else {
            System.out.println("Player " + playerA.getName() + " wins!");
        }
    }
}

