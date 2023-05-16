import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // MainFrame myFrame = new MainFrame();
        // myFrame.initialize();

        Scanner scanner = new Scanner(System.in);
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Input a word");
        String word = scanner.nextLine();
        String password = passwordGenerator.generate(10,word);

        System.out.println(password);
        scanner.close();
    }
}