package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MagicalArenaTest {

    private Player playerA;
    private Player playerB;
    private MagicalArena magicalArena;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testPlayGame_PlayerAWins() {
        // Mock the dice rolls to control the game flow
        playerA = new Player("A",50, 10, 15);
        playerB = new Player("B",100, 10,5);

        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefendDice = mock(Dice.class);

         when(mockAttackDice.roll()).thenReturn(6);  // Player A attack roll
         when(mockDefendDice.roll()).thenReturn(1);  // Player B defend roll

        // Create MagicalArena with mock Dice instances
        magicalArena = new MagicalArena(playerA, playerB, mockAttackDice, mockDefendDice);

        // Player A will win in one turn
        magicalArena.playGame();

        assertFalse(playerB.isAlive());
        assertTrue(playerA.isAlive());
    }

    @Test
    public void testPlayGame_PlayerBWins() {
        // Mock the dice rolls to control the game flow
        playerA = new Player("A",50, 10, 5);
        playerB = new Player("B",100, 10,5);

        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefendDice = mock(Dice.class);

        when(mockAttackDice.roll()).thenReturn(6);  // Player B attack roll
        when(mockDefendDice.roll()).thenReturn(1);  // Player A defend roll

        // Create MagicalArena with mock Dice instances
        magicalArena = new MagicalArena(playerA, playerB, mockAttackDice, mockDefendDice);

        // Player B will win in one turn
        magicalArena.playGame();

        assertTrue(playerB.isAlive());
        assertFalse(playerA.isAlive());
    }

}
