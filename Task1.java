
import java.util.Random;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner obj = new Scanner(System.in);
        final Integer attempts = 3;
        String answer = "y";
        while (answer.equalsIgnoreCase("y")) {
            System.out.println("Enter the max:");
            Integer max = obj.nextInt();
            Integer random = r.nextInt(max) + 1;
            int i = 1;
            while (i <= attempts) {
                System.out.println("Entrez un nombre entre 1 et " + max + ":");
                Integer guessed = obj.nextInt();
                if (guessed < random) {
                    System.out.println("Too low");
                    if (i == attempts) {
                        System.out.println("Failed");
                        break;
                    }
                } else if (guessed > random) {
                    System.out.println("Too high");
                    if (i == attempts) {
                        System.out.println("Failed");
                        break;
                    }
                } else if (guessed.equals(random)) {
                    System.out.println("Correct");
                    break;
                }
                i++;
            }
            obj.nextLine();
            System.out.println("You want to play again? (y/n)");
            answer = obj.nextLine();
        }
        System.out.println("Hope that you enjoyed the play, see you next time.");
    }
}
