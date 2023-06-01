import com.GauPass.MainFrame;
import com.GauPass.PasswordGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         

        // Scanner scanner = new Scanner(System.in);
        // PasswordGenerator passwordGenerator = new PasswordGenerator();

        // System.out.print("\033[H\033[2J");
        // System.out.flush();

        // System.out.println("Do you wish to use a keyword/phrase in your password?\n");
        // System.out.println("y/n\n");
        // String choice = scanner.nextLine();
        // if (choice.equals("y"))
        // {
        //     System.out.println("Input a word");
        //     String word = scanner.nextLine();
        //     String password = passwordGenerator.generate(10,word);
        //     System.out.println(password);
        // }
        // else {
            MainFrame myFrame = new MainFrame();
            myFrame.initialize();
        // }
        // scanner.close();
    }
}