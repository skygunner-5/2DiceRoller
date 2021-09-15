import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create character variable to check if the user wants to use the program again, set to y by default
        char repeat = 'y';
        while (repeat == 'y' || repeat == 'Y') {
            //prompt user to enter number of dice and number of sides in XdY format
            System.out.println("Please enter the number of dice to be rolled and the number of sides on each die as XdY");
            System.out.println("(Where X is the number of dice, and Y is the number of sides):");
            Scanner input = new Scanner(System.in);

            //create string to hold XdY input and split that string by the 'd'
            String diceAndSides = input.next();
            String split[] = diceAndSides.split("d");
            //create integer variables to hold the individual split values
            int numDie = Integer.parseInt(split[0]);
            int numSides = Integer.parseInt(split[1]);
            //create integer to hold the total value of all the dice rolls
            int total = 0;

            //create an array of integers to hold the value of each die
            int[] dice = new int[numDie];

            //for loop that produces random value for each die depending on the number of sides
            for (int i = 0; i < numDie; i++) {
                Random rand = new Random();
                dice[i] = rand.nextInt(numSides) + 1;
            }

            //create string variable that will hold result message
            String msg = "";

            //for loop that displays the resulting number from each die roll and adds each number to the total
            for (int die : dice) {
                msg = "You rolled a " + die + " on a " + numSides + "-sided dice\n";
                System.out.println(msg);
                total += die;
            }

            //display the total value
            System.out.println("Your total is " + total + "\n");

            //prompt user to check if they want to repeat the program
            System.out.println("Would you like to roll again? (y or n)");
            Scanner again = new Scanner(System.in);
            repeat = again.next().charAt(0);
        }
    }
}
