package com.example.first_step.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagramMap(s, t));
        System.out.println(isAnagramInt26(s, t));
    }

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * <p>
     * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
     */
    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char leftCh : s.toCharArray()) {
            // Берем букву из первой строки, делаем ее ключом значение если null ставим 1 иначе делаем + 1
            map.merge(leftCh, 1, Integer::sum);
        }

        for (char rightCh : t.toCharArray()) {
            if (!map.containsKey(rightCh)) {
                return false;
            }
            //Уменьшаем инкремент т.к у нас нашлась буква по такому ключу
            map.put(rightCh, map.get(rightCh) - 1);
            if (map.get(rightCh) == 0) {
                map.remove(rightCh);
            }
        }
        return map.isEmpty();
    }


    public static boolean isAnagramInt26(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int index = 0; index < s.length(); index++) {
            // Берем букву из первой строки, превращаем в индекс и прибавляем 1
            count[s.charAt(index) - 'a']++;

            // Берем букву из второй строки, превращаем в индекс и вычитаем 1
            count[t.charAt(index) - 'a']--;
        }

        // Проверяем: если после всех операций в массиве остались не нули — не анаграмма
        for (int index : count) {
            if (index != 0) {
                return false;
            }
        }
        return true;
    }
}
