package com.GauPass.components.KeywordsTab;

import java.awt.*;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifyKeyword {

    private String keyword;

    public ModifyKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String modifyKeyword() {
        return generate(keyword);
    }

    public String generate(String word) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        Map<Character, List<Character>> symbolMap = createSymbolMap();
        int letterCount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)){
            letterCount++;
            char lowerC = Character.toLowerCase(c);
            List<Character> symbols = symbolMap.get(lowerC);

            if (symbols != null && symbols.size() > 0) {
                int index = random.nextInt(symbols.size());
                password.append(symbols.get(index));
            } 
        }
        else {
                password.append(c);
            }
        }

        if (letterCount < word.length()/4 || !checkIfValid(word, password.toString())) {
            return generate(word); // Retry if all letters are replaced or generated password is invalid
        }

        return password.toString();
    }

    private boolean checkIfValid(String word, String newPass) {
        int k = 0;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            char ch = newPass.charAt(i);

            if (c == ch) {
                k++;
            }
        }
        return word.length() >= 7 && k >= word.length() / 2 && !word.equals(newPass);
    }

    private static Map<Character, List<Character>> createSymbolMap() {
        Map<Character, List<Character>> symbolMap = new HashMap<>();

        symbolMap.put('a', List.of('4', '@', '^', 'a', 'A'));
        symbolMap.put('b', List.of('8', '6', '3', 'b', 'B'));
        symbolMap.put('c', List.of('(', '<', '[', 'c', 'C'));
        symbolMap.put('d', List.of('b', 'D', 'd', 'p', 'q', '0'));
        symbolMap.put('e', List.of('3', 'e', 'E', '_'));
        symbolMap.put('f', List.of('f', 'F'));
        symbolMap.put('g', List.of('9', '6', 'g', 'G', 'q'));
        symbolMap.put('h', List.of('#', 'h', 'H'));
        symbolMap.put('i', List.of('1', '|', '!', 'i', '/', 'I'));
        symbolMap.put('j', List.of('j', 'J'));
        symbolMap.put('k', List.of('k', 'K'));
        symbolMap.put('l', List.of('1', '|', 'l', 'L', 'i', '/', '!'));
        symbolMap.put('m', List.of('m', 'M'));
        symbolMap.put('n', List.of('n', 'N'));
        symbolMap.put('o', List.of('0', '*', '#', 'o', 'O'));
        symbolMap.put('p', List.of('d', 'P', 'p', 'q'));
        symbolMap.put('q', List.of('9', '6', 'g', 'G', 'q'));
        symbolMap.put('r', List.of('r', 'R'));
        symbolMap.put('s', List.of('$', '5', 's', 'S'));
        symbolMap.put('t', List.of('7', '+', 't', '7', 'T', '/'));
        symbolMap.put('u', List.of('u', 'U'));
        symbolMap.put('v', List.of('v', 'V', '<', '>'));
        symbolMap.put('w', List.of('w', 'W'));
        symbolMap.put('x', List.of('x', 'X'));
        symbolMap.put('y', List.of('y', 'Y'));
        symbolMap.put('z', List.of('2', '5', 'z', 'Z'));

        return symbolMap;
    }
}

    