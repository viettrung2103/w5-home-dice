import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class DiceTest {

    public Dice dice;
    // create a output Stream to store to print
    private final ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
    // save the origin print out source, so I can restore the print out source later
    // now, the printout source is save to outContent
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setup() {
        dice = new Dice();
        System.setOut(new PrintStream(outputStringStream));

    }


    @Test
    void isDouble() {
        dice.roll();
        int die1 = dice.getDie1();
        int die2 = dice.getDie2();
        assertEquals(die1 == die2, dice.isDouble(), "Two dice should be the same");

    }

    @Test
    @DisplayName("Get value of die 1 now")
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

    @Test
    void DisplayRollMessage() {
        dice.roll();
        String expectPartOfPrintMessage = "After";
        assertTrue(outputStringStream.toString().contains(expectPartOfPrintMessage), "the final message should contain \"After\" keyword");
    }

    @AfterEach
    void restorePrintStream() {
        System.setOut(originalOut);
    }

}