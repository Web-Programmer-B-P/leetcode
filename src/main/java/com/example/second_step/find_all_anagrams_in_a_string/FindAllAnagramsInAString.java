package com.example.second_step.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqWindow = new int[26];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqWindow[c - 'a']++;
            while (right - left + 1 > p.length()) {
                freqWindow[s.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(freqWindow, freqP)) {
                result.add(left);
            }
        }
        return result;
    }
}
