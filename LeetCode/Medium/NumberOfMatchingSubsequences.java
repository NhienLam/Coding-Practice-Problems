/***   URL: https://leetcode.com/problems/number-of-matching-subsequences/   ***/

/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2

Constraints:
1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
*/

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0;

        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)){
                map.put(c, new LinkedList<>());
            }
        }
        
        
        for(String str : words) {
            if(map.containsKey(str.charAt(0))) {
                map.get(str.charAt(0)).offer(str);
            }
        }
        
        for(char c: s.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for(int i =0; i < size; i++) {
                String str = queue.remove();
                if(str.length() == 1) {
                    count++;
                    continue;
                }
                else if(map.containsKey(str.charAt(1))) {
                    map.get(str.charAt(1)).add(str.substring(1));
                }
            }
        }
        
        return count;
    }
}
