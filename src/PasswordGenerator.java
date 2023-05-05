import java.security.SecureRandom;

public class PasswordGenerator {
    private String password;

    PasswordGenerator() {
        password = "";
    }

    public String generate(int passwordLength) {
        SecureRandom random = new SecureRandom();
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!?@";

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password += validChars.charAt(randomIndex);
        }
        return password;
    }
}
