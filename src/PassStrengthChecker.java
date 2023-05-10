import java.util.ArrayList;

public class PassStrengthChecker {

    PassStrengthChecker() {
    };

    ArrayList<String> CheckStrength(String password) {
        ArrayList<String> PasswordWeaknesses = new ArrayList<String>();
        PasswordWeaknesses.add("Password contains these weaknesses: \n");

        if (!containsLetters(password))
            PasswordWeaknesses.add("* No letters used!\n");
        if (!containsNumbers(password))
            PasswordWeaknesses.add("* No numbers used!\n");
        if (!containsSpecialChars(password)) /* !,@,#,$,%... */
            PasswordWeaknesses.add("* No special characters used!\n");
        return PasswordWeaknesses;
    }

    public static boolean containsLetters(String password) {
        return password.matches(".*[a-zA-Z].*");
    }

    public static boolean containsNumbers(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean containsSpecialChars(String password) {
        return password.matches(".*\\W.*");
    }
}