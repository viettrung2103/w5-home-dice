import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DiceTest {

    public Dice dice;

    @BeforeEach
    void setup() {
        dice = new Dice();

    }

    @Test
    void isDouble() {
        dice.roll();
        int die1 = dice.getDie1();
        int die2 = dice.getDie2();
        assertEquals(die1 == die2, dice.isDouble(), "Two dice should be the same");

    }

    @Test
    @DisplayName("Get value of die 1")
    void getDie1() {
        dice.roll();
        int die1 = dice.getDie1();
        assertTrue(die1 != 0, "Value of die 1 should be different than 0 after rolling");
        assertTrue(1 <= die1 && die1 <= 6, "value of die 1 should be between 1 and 6");
    }

    @Test
    @DisplayName("Get value of die 2")
    void getDie2() {
        dice.roll();
        int die2 = dice.getDie2();
        assertTrue(die2 != 0, "Value of die 2 should be different than 0 after rolling");
        assertTrue(1 <= die2 && die2 <= 6, "value of die 2 should be between 1 and 6");
    }

    @Test
    @DisplayName("Get roll counts")
    void getRollCounts() {
        dice.roll();
        int rollCount = dice.getRollCounts();
        assertTrue(rollCount != 0, "roll count should be more than 0 after rolling");
    }

    @Test
    void roll() {
        dice.roll();
        int die1 = dice.getDie1();
        int die2 = dice.getDie2();
        assertTrue(die1 != 0, "Value of die 1 should be different than 0 after rolling");
        assertTrue(die2 != 0, "Value of die 1 should be different than 0 after rolling");
        assertTrue(dice.isDouble(), "value of die1 should be equal to value of die 2");
        assertTrue(dice.getRollCounts() != 0, "value of roll counts should be more than 0 after rolling");

    }

}