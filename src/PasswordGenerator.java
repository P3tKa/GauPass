import java.security.SecureRandom;

public class PasswordGenerator {
    private String password;
    private boolean useNumbers;
    private boolean useSpecialChars;

    PasswordGenerator() {
        password = "";
        useNumbers = true;
        useSpecialChars = true;
    }

    public void setUseNumbers(boolean useNumbers) {
        this.useNumbers = useNumbers;
    }

    public void setUseSpecialChars(boolean useSpecialChars) {
        this.useSpecialChars = useSpecialChars;
    }

    public String generate(int passwordLength) {
        SecureRandom random = new SecureRandom();
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if (useNumbers)
            validChars += "0123456789";
        if (useSpecialChars)
            validChars += "~!@#$%^&*()_-,.?";

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password += validChars.charAt(randomIndex);
        }
        return password;
    }
}
