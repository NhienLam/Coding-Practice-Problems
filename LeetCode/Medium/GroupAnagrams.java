/***   URL: https://leetcode.com/problems/group-anagrams/   ***/

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 
Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // BRUTE FORCE
        /*   if(strs.length == 0 || strs == null) {
            return new ArrayList<>();
        }
        
        List<List<String>> ret = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();
            for(int j =i+1; j< strs.length; j++) {
                if((!strs[j].equals("-1") && !strs[i].equals("-1")))
                { 
                    if(isAnagram(strs[i], strs[j])) {
                        temp.add(strs[j]);
                        strs[j] = "-1";
                    }
                }
            }
            if(!strs[i].equals("-1")){
                temp.add(strs[i]);
            }
            if(!temp.isEmpty()){
                ret.add(temp);
            }
            strs[i] = "-1";
        }
            
        return ret;
        */
        
        // MORE EFFICIENT WAY
        if(strs.length == 0 || strs == null) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String keyStr = String.valueOf(arr);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    /* BRUTE FORCE
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
    }*/
}
