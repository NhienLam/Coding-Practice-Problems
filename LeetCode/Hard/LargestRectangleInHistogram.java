/***   URL: https://leetcode.com/problems/largest-rectangle-in-histogram/   ***/
/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++) {
            if(stack.empty()){
                left[i] = 0;
                stack.push(i);
            }
            else{
                while(!stack.empty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                   
                if(stack.empty()) {
                    left[i] = 0;
                } 
                else{
                    left[i] = stack.peek()+1;
                }
                stack.push(i);
            }
        }
        // clear stack
        stack.clear();
        for(int i = heights.length-1; i >= 0; i--) {
            if(stack.empty()){
                right[i] = heights.length-1;
                stack.push(i);
            }
            else {
                while(!stack.empty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                   
                if(stack.empty()) {
                    right[i] = heights.length-1;
                } 
                else{
                    right[i] = stack.peek()-1;
                }
                stack.push(i);
            }          
        }
                
        for(int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i]-left[i]+1) * heights[i]);
        }
        return max;
    }
}
