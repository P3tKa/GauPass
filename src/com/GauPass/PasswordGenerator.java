package com.GauPass;

import java.util.*;

import com.GauPass.components.SettingsTab.SettingsCheckbox;
import com.GauPass.constants.UI_locale;

public class PasswordGenerator {
    private String password;
    private int length;
    private String keyword;

    private boolean includeNumber;
    private boolean includeSpecChars;
    private boolean includeCapLetters;

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()";

    Random rand = new Random();

    public PasswordGenerator(String keyword, int length) {
        this.length = length;
        this.keyword = keyword;

        getCheckBoxValues();
        this.password = generate();
    }

    public String generate() {
        if (keyword.length() == 0 || keyword.equals(UI_locale.KEYWORDS_DEFAULT_TEXT)) {
            return password = generateWithoutKeyword();
        } else {
            return password = generateWithKeyword();
        }
    }

    public String generateWithKeyword() {
        if (keyword.length() > length) {
            System.out.println("Keyword length is longer than the total password length");
            return null;
        } else if (keyword.length() == length) {
            return keyword;
        }

        int lengthWithoutKeyword = length - keyword.length();
        String passwordWithoutKeyword = randomizeString(generateCheckboxStrings(lengthWithoutKeyword));

        int insertAt = rand.nextInt(lengthWithoutKeyword + 1);

        password = passwordWithoutKeyword.substring(0, insertAt) + keyword + passwordWithoutKeyword.substring(insertAt);

        return password;
    }

    public String generateWithoutKeyword() {
        return generateCheckboxStrings(length);
    }

    public String generateCheckboxStrings(int length) {
        StringBuilder passwordBuilder = new StringBuilder();
        
        if(includeNumber) {
            int perc = rand.nextInt(41 - 20) + 20; // Get random percent between 20 and 40
            String numberString = generateRandomString(NUMBER_CHARS, length * perc / 100);
            passwordBuilder.append(numberString);
        }

        if(includeSpecChars) {
            int perc = rand.nextInt(41 - 20) + 20;
            String specialCharString = generateRandomString(SPECIAL_CHARS, length * perc / 100);
            passwordBuilder.append(specialCharString);
        }

        if(includeCapLetters) {
            int perc = rand.nextInt(41 - 20) + 20;
            String capLetterString = generateRandomString(UPPERCASE_CHARS, length * perc / 100);
            passwordBuilder.append(capLetterString);
        }

        int remainingLength = length - passwordBuilder.length();

        if (remainingLength > 0) {
            String lowercaseString = generateRandomString(LOWERCASE_CHARS, remainingLength);
            passwordBuilder.append(lowercaseString);
        }

        // trim it if password is longer than required length due to integer division aprox
        if (passwordBuilder.length() > length) {
            passwordBuilder.setLength(length);
        }

        return passwordBuilder.toString();
    }
    
    public void getCheckBoxValues() {
        includeNumber = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_NUMBERS).isChecked();
        includeSpecChars = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_SPEC_CHAR).isChecked();
        includeCapLetters = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_CAP_LETTERS).isChecked();
    }

    private String generateRandomString(String charSet, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(charSet.charAt(rand.nextInt(charSet.length())));
        }

        return sb.toString();
    }

    private String randomizeString(String input) {
        List<String> characters = Arrays.asList(input.split(""));
        Collections.shuffle(characters);
        String password = String.join("", characters);

        return password;
    }
        
    public String getPassword() {
        return password;
    }
}


    
    // public String generateGen(int passwordLength) { //Generic password generation
    //         SecureRandom random = new SecureRandom();
    //         String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!?@";
    
    //         for (int i = 0; i < passwordLength; i++) {
    //             int randomIndex = random.nextInt(validChars.length());
    //             password += validChars.charAt(randomIndex);
    //         }
    //         return password;
    // }

    
    // private boolean checkIfValid (String word, String newPass) //Function that will be expanded
    // {
    //     int k = 0;
    //         for (int i = 0; i < word.length(); ++i) {
    //             char c = word.charAt(i);
    //             char ch = newPass.charAt(i);
    
    //             if (c == ch) {
    //                 k++;
    //             }
    //         }
    //         if ((word.length()>=7) && (k>=word.length()/2) || word == newPass) { //
    //             return false; 
    //         }
    //         else return true;
           
    // }

    
    // private static Map<Character, List<Character>> createSymbolMap() {
        
    //     Map<Character, List<Character>> symbolMap = new HashMap<>();

    //     symbolMap.put('a', List.of('4', '@', '^', 'a', 'A'));
    //     symbolMap.put('b', List.of('8', '6', '3', 'b', 'B'));
    //     symbolMap.put('c', List.of('(', '<', '[', 'c', 'C'));
    //     symbolMap.put('d', List.of('b', 'D', 'd', 'p', 'q','0'));
    //     symbolMap.put('e', List.of('3', 'e', 'E','_'));
    //     symbolMap.put('f', List.of('f', 'F'));
    //     symbolMap.put('g', List.of('9', '6', 'g', 'G', 'q'));
    //     symbolMap.put('h', List.of('#', 'h', 'H'));
    //     symbolMap.put('i', List.of('1', '|', '!', 'i', '/', 'I'));
    //     symbolMap.put('j', List.of('j', 'J'));
    //     symbolMap.put('k', List.of('k', 'K'));
    //     symbolMap.put('l', List.of('1', '|', 'l', 'L', 'i', '/', '!'));
    //     symbolMap.put('m', List.of('m', 'M'));
    //     symbolMap.put('n', List.of('n', 'N'));
    //     symbolMap.put('o', List.of('0', '*', '#', 'o', 'O'));
    //     symbolMap.put('p', List.of('d', 'P', 'p', 'q'));
    //     symbolMap.put('q', List.of('9', '6', 'g', 'G', 'q'));
    //     symbolMap.put('r', List.of('r', 'R'));
    //     symbolMap.put('s', List.of('$', '5', 's', 'S'));
    //     symbolMap.put('t', List.of('7', '+', 't', '7', 'T', '/'));
    //     symbolMap.put('u', List.of('u', 'U'));
    //     symbolMap.put('v', List.of('v', 'V','<','>'));
    //     symbolMap.put('w', List.of('w', 'W'));
    //     symbolMap.put('x', List.of('x', 'X'));
    //     symbolMap.put('y', List.of('y', 'Y'));
    //     symbolMap.put('z', List.of('2', '5', 'z', 'Z'));
        


    //     return symbolMap;
    // }
// }
