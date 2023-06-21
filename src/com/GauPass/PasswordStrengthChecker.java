package com.GauPass;

import java.util.ArrayList;

import com.GauPass.constants.UI_locale;

public class PasswordStrengthChecker {

    private int score = 1;
    private boolean hasLetters = false;
    private boolean hasCharacters = false;
    private boolean hasNumbers = false;

    PasswordStrengthChecker() {
    };

    ArrayList<String> checkStrength(String password) {
        ArrayList<String> PasswordWeaknesses = new ArrayList<String>();
        if (!containsLetters(password)) {
            PasswordWeaknesses.add(UI_locale.ERROR_NO_LETTERS);
        } else {
            hasLetters = true;
        }

        if (!containsNumbers(password)) {
            PasswordWeaknesses.add(UI_locale.ERROR_NO_NUMBERS);
        } else {
            hasNumbers = true;
        }

        if (!containsSpecialChars(password)) {
            /* !,@,#,$,%... */
            PasswordWeaknesses.add(UI_locale.ERROR_NO_CHARS);
        } else {
            hasCharacters = true;
        }

        // Length check
        int length = password.length();
        if (length < 12)
            PasswordWeaknesses.add(UI_locale.ERROR_NOT_ENOUGH_LENGTH);
        if (length >= 12) {
            score += 20;
        } else if (length >= 6) {
            score += 10;
        } else {
            score += 5;
        }

        if (hasLetters && hasNumbers) {
            score += 20;
        }
        if (hasNumbers) {
            score += 20;
        }

        if (hasCharacters) {
            score += 20;
        }

        // Bonus points for additional complexity
        if (hasLetters && hasNumbers && length >= 12 && hasCharacters) {
            score += 20;
        }

        // Cap the score to a maximum of 100
        score = Math.min(score, 100);

        return PasswordWeaknesses;
    }

    public int getPasswordScore() {
        return score;
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