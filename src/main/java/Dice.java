public class Dice {
    private int die1;
    private int die2;
    private int rollCounts;


    public Dice() {
        die1 = 0;
        die2 = 0;
        rollCounts = 0;

    }

    public void roll() {
        int count = 0;
        System.out.println("Rolling the dice...");
        do {

            die1 = generateRandomNumber();
            die2 = generateRandomNumber();
            System.out.println("Die 1: " + getDie1());
            System.out.println("Die 2: " + getDie2());
            rollCounts++;
        }
        while (!isDouble());
        System.out.println("You rolled a double");
        System.out.println("After " + rollCounts + (rollCounts > 1 ? " tries" : " try") + " both reach the same value");

    }

    public boolean isDouble() {
        return die1 == die2;
    }

    public int getDie1() {
//        die1 = generateRandomNumber();
        return die1;
    }

    public int getDie2() {
//        die2 = generateRandomNumber();
        return die2;
    }

    public int getRollCounts() {
        return rollCounts;
    }

    private int generateRandomNumber() {
        int value = (int) (Math.random() * 6) + 1;
        System.out.println(value);
        return value;
    }


}
