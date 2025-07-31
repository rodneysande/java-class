// A program to show a car login system
package login.system;
import java.io.Console;
import java.util.Scanner;

public class LoginSystem {
    
    public static void main(String[] args) {
        // TODO code application logic here
        final String CORRECT_USERNAME = "admin";
        final String CORRECT_PASSWORD = "1234";
        
         Scanner scanner = new Scanner(System.in);
        Console console = System.console(); // Used to read password as '*'
        boolean isAuthenticated = false;

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            String password;
            if (console != null) {
                char[] passwordChars = console.readPassword("Enter password: ");
                password = new String(passwordChars);
                // Echo stars for clarity
                System.out.print("Password entered: ");
                for (int i = 0; i < password.length(); i++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                // Fallback if console is not available 
                System.out.print("Enter password (characters will be visible): ");
                password = scanner.nextLine();
            }

            if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                System.out.println("Login successful. Welcome, " + username + "!");
                isAuthenticated = true;
                break;
            } else {
                System.out.println("Incorrect username or password. Attempt " + attempt + " of 3.");
            }
        }

        if (!isAuthenticated) {
            System.out.println("Maximum login attempts exceeded. Access denied.");
        }

        scanner.close();
    }
    
}
