/***   URL: https://leetcode.com/problems/palindrome-number/   ***/

/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
 

Constraints:

-231 <= x <= 231 - 1
*/

class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length()-1;
        
        // return false if less than 1 digit
        if(str.length() < 1) {
            return false;
        } 
        // return true if 1 digit number 
        else if(str.length() == 1) {
            return true;
        }
        // if even number of digits
        else if(str.length() % 2 == 0) {
            while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
            }   
        }
        // if odd number of digits
        else {
            while(i != j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
            }   
        }
        return true;
        
    }
}
