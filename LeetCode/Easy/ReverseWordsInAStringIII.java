/***   URL: https://leetcode.com/problems/reverse-words-in-a-string-iii/   ***/

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"
 
Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

class Solution {
    public String reverseWords(String s) {
        String res = "";
        
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++) {
            res += reverse(arr[i]);
            if(i != arr.length-1) {
                res += " ";
            }
        }
        
        return res;
    }
    
    public String reverse(String s) {
        String rev = "";
        for(int i = s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        
        return rev;
    }
}
