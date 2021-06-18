/***   URL: https://leetcode.com/problems/reverse-integer/   ***/

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
// Example 4:

// Input: x = 0
// Output: 0
 

// Constraints:

// -231 <= x <= 231 - 1

class Solution {
    public int reverse(int x) {
        if(x > (Math.pow(2,31)-1) && x < (Math.pow(-2,31))) {
            return 0;
        }
        
        String retStr = "";
        String xStr = String.valueOf(x);

        if(x>=0) {
            for(int i = xStr.length()-1; i >= 0; i--) {
                retStr += xStr.charAt(i);
            }
        }
        else {
            retStr += "-";
            for(int i = xStr.length()-1; i > 0; i--) {
                retStr += xStr.charAt(i);
            }
        }
             
        int ret;
        try {
            ret = Integer.parseInt(retStr);
        }
        catch(Exception e)
        {
            ret = 0;
        }
        return ret;

    }
}
