package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiceTest {

    // Mock the Random object
    @Mock
    private Random random;

    @Test
    public void testRoll() {
        // Create an instance of Dice with the mocked Random object
        Dice dice = new Dice(random,6);

        // Mock the behavior of random.nextInt() to return a specific value (e.g., 3)
        when(random.nextInt(Mockito.anyInt())).thenReturn(3);

        // Call the roll method
        int result = dice.roll();

        System.out.println("result is " + result);

        // Verify that the result is the expected value (which is 3 in this case)
        assertEquals(4, result);
    }
}
