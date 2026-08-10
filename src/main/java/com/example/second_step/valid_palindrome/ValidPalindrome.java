package com.example.second_step.valid_palindrome;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
