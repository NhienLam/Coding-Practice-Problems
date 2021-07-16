/***   URL: https://leetcode.com/problems/valid-parentheses/   ***/

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 
Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            
            if(s.charAt(i) == ')') {
                if(stack.empty()) {
                    return false;
                } else {
                    if(stack.pop() != '(') {
                        return false;
                    }
                }
            }
            if(s.charAt(i) == '}') {
                if(stack.empty()) {
                    return false;
                } else {
                    if(stack.pop() != '{') {
                        return false;
                    }
                }
            }
            if(s.charAt(i) == ']') {
                if(stack.empty()) {
                    return false;
                } else { 
                    if(stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        
        if(stack.empty()){
            return true;
        }
        else {
            return false;
        }
    }
}
