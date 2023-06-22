package com.GauPass;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.GauPass.components.SettingsTab.CheckboxData;
import com.GauPass.constants.UI_locale;
import com.GauPass.components.SettingsTab.SettingsCheckbox;
import java.util.*;



import java.util.*;

import com.GauPass.components.SettingsTab.SettingsCheckbox;
import com.GauPass.constants.UI_locale;

public class PasswordGenerator {
    private int length;
    private String keyword;
    private String password;
    private boolean includeNumber;
    private boolean includeSpecChars;
    private boolean includeCapLetters;

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()";

    public PasswordGenerator(String keyword, int length) {
        this.length = length;
        this.keyword = keyword;

        getCheckBoxValues();
        this.password = generate();
    }

    public String generate() {
        StringBuilder passwordBuilder = new StringBuilder();
        Random rand = new Random();

        if (includeNumber) {
            int perc = rand.nextInt(41 - 20) + 20; // Get random percent between 20 and 40
            String numberString = generateRandomString(NUMBER_CHARS, length * perc / 100);
            passwordBuilder.append(numberString);
        }

        if (includeSpecChars) {
            int perc = rand.nextInt(41 - 20) + 20; // Get random percent between 20 and 40
            String specialCharString = generateRandomString(SPECIAL_CHARS, length * perc / 100);
            passwordBuilder.append(specialCharString);
        }

        if (includeCapLetters) {
            int perc = rand.nextInt(41 - 20) + 20; // Get random percent between 20 and 40
            String capLetterString = generateRandomString(UPPERCASE_CHARS, length * perc / 100);
            passwordBuilder.append(capLetterString);
        }

        int remainingLength = length - passwordBuilder.length();

        if (remainingLength > 0) {
            String lowercaseString = generateRandomString(LOWERCASE_CHARS, remainingLength);
            passwordBuilder.append(lowercaseString);
        }

        // If the password is longer than the required length due to integer division approximation, trim it
        if (passwordBuilder.length() > length) {
            passwordBuilder.setLength(length);
        }

        // Randomize the characters in the string builder
        password = randomizeString(passwordBuilder.toString());

        return password;
    }

    private void getCheckBoxValues() {
        includeNumber = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_NUMBERS).isChecked();
        includeSpecChars = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_SPEC_CHAR).isChecked();
        includeCapLetters = SettingsCheckbox.getCheckboxById(UI_locale.CHECKBOX_INCLUDE_CAP_LETTERS).isChecked();
    }

    private String generateRandomString(String charSet, int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(charSet.charAt(rand.nextInt(charSet.length())));
        }
        return sb.toString();
    }

    private String randomizeString(String input) {
        List<String> characters = Arrays.asList(input.split(""));
        Collections.shuffle(characters);
        return String.join("", characters);
    }

    public String getPassword() {
        return password;
    }

 public void checkIfKeywordsUsed (String keyword, int value){
    //     // *TODO
    //     //fix
    //         if (keyword.length() == 0 || keyword.equals(UI_locale.KEYWORDS_DEFAULT_TEXT)) {
    //             password = generateRandom(value);
    //         } else {
    //             password = generate(value, keyword);
    //         }
    //     }
        
    // public String getPassword (){
    //     return password;
    // }
    // public void setUseNumbers(boolean useNumbers) {
    //     this.useNumbers = useNumbers;
    // }

    // public void setUseSpecialChars(boolean useSpecialChars) {
    //     this.useSpecialChars = useSpecialChars;
    // }

    // public String generate (int passwordLength, String word) {
    //     SecureRandom random = new SecureRandom();
    //         StringBuilder password = new StringBuilder();
    //         Map<Character, List<Character>> symbolMap = createSymbolMap();
    
    //         for (char c : word.toCharArray()) {
    //             char lowerC = Character.toLowerCase(c);
    //             List<Character> symbols = symbolMap.get(lowerC);
    //             if (symbols != null && symbols.size() > 0) {
    //                 int index = random.nextInt(symbols.size());
    //                 password.append(symbols.get(index));
    //             } else {
    //                 password.append(c);
    //             }
    //         }

    //         if (checkIfValid(word, password.toString()) == true) return password.toString(); //Validity check
    //         else return generate(passwordLength, word);
        
            
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
    // //The list has to be updated according to the checkboxes used. 
    
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
    
    //========================================================================================================


