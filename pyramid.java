
import java.util.Scanner;

class pyramid {

    public static void main(String[] args) {
        try (Scanner xyz = new Scanner(System.in)) {
            System.out.print("Enter number of lines: ");
            int num = xyz.nextInt();

            for (int i = 1; i <= num; i++) {
                // Print spaces
                for (int j = i; j < num; j++) {
                    System.out.print(" ");
                }

                // Print stars
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }

                // Move to the next line
                System.out.println();
            }

            xyz.close();
        }
    }
}
