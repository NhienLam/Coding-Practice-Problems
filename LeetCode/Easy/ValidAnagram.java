/***   URL: https://leetcode.com/problems/valid-anagram/   ***/

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // if lengths not the same, return false
        if(s.length() != t.length()) {
            return false;
        }
        
        // int arrays sized 26 as buckets for each letter in alphabet
        int[] alphabet = new int[26];
        
        // increment bucket value for each s char
        // decrement bucket value for each t char
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) 
            {
                return false;
            }
        }
        return true;
    }
}
