import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int generateRandom(int min, int max) {

        int diff = max - min;
        Random randomDice = new Random();
        int numberOfSides = randomDice.nextInt(diff + 1);
        numberOfSides += min;

        return numberOfSides;

    }

    public static void diceRollerApp(int die1, int die2) {

        if ((die1 == 1) & (die2 == 1)) {
            System.out.println("You rolled SNAKE EYES!!");
        }
        else if  ((die1 == 6) & (die2 == 6)) {
            System.out.println("You rolled BOXCARS!!");
        }
        else if (((die1 == 2) & (die2 == 3)) ||
                 ((die1 == 3) & (die2 == 2)))  {
            System.out.println("You rolled CRAPS!!");
        }

        return ;

    }

    public static void main(String[] args) {

        int inputNumber = 0;
        int rollTimes = 1;
        String answer = "Y";
        boolean checkNumber = false;

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the Grand Circus Casino!");
        System.out.println();


        while (answer.equalsIgnoreCase("Y")) {

            // Validate that the User has not entered 0
            while (checkNumber == false) {

                // Get Max Value for Range from user
                System.out.println("How many sides should each die have? ");
                // scnr.nextInt();
                inputNumber = scnr.nextInt();
                System.out.println(inputNumber);
                if (inputNumber > 0) {
                    checkNumber = true;
                } else {
                    System.out.println("There cannot be 0 sides on die");
                    checkNumber = false;
                }
            }

            System.out.println("There are " + inputNumber + " sides on each die");

            int die1 = generateRandom(1, inputNumber);
            int die2 = generateRandom(1, inputNumber);

            System.out.println("Roll " + rollTimes + ":");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println();
            diceRollerApp(die1, die2);
            System.out.println();

            System.out.println("Do you want to roll again? Enter Y or N");
            scnr.nextLine();
            answer = scnr.nextLine();
            if ((answer.equals("Y")) || (answer.equals("y"))) {
                 rollTimes = rollTimes + 1;
            }
            checkNumber = false;
        }
    }
}
