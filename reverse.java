
import java.util.Scanner;

class reverse {

    public static void main(String[] args) {
        Scanner xyz = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = xyz.nextLine();
        String rev = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            rev = rev + name.charAt(i);
        }
        System.out.println("Reversed:" + rev);
        xyz.close();
        if (rev.equals(name)) {
            System.out.println("Given string is a palindrome\t" + rev);
        } else {
            System.out.println("Given string is not a palindrome\t" + rev);

        }
    }
}
