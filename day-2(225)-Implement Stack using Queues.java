import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Calculate years left to 100
        int yearsLeft = 100 - age;

        // Print result
        System.out.println("Hello, " + name + "! You will turn 100 in " + yearsLeft + " years.");

        scanner.close();
    }
}
