/***   URL: https://leetcode.com/problems/longest-common-prefix/   ***/

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        
        if(strs.length<1)
        {
            return res;
        }
        int index = 0;
        boolean notMatch = false;
       
        for(char c: strs[0].toCharArray()){
            for(int i = 1; i < strs.length; i++){
                if(strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)){
                    notMatch = true;
                    break;
                }
            }
            if(notMatch){
                break;
            }
            index++;
        }
        for(int i = 0; i < index; i++) {
            res += strs[0].charAt(i);
        }
        
        return res;
    }
}
