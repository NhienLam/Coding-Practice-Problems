/***   URL: https://leetcode.com/problems/merge-intervals/   ***/

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        // check if start1 or end1 is in between 2nd interval OR
        // start2 or end2 is in between 1st interval
        // -> keep lowest start and highest end
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        
        for(int[] i : intervals) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else{
                int[] cur = stack.peek();
                
                // overlap
                if((cur[0] >= i[0] && cur[0] <= i[1]) || 
                  (cur[1] >= i[0] && cur[1] <= i[1]) || 
                  (i[0] >= cur[0] && i[0] <= cur[1]) || 
                  (i[1] >= cur[0] && i[1] <= cur[1])) {
                    stack.pop();
                    int[] mer = new int[]{Math.min(cur[0], i[0]), Math.max(cur[1], i[1])};
                    stack.push(mer);
                }
                else{
                    stack.push(i);
                }
            }
        }
        
        int[][] res = new int[stack.size()][2];
        
        for(int i = res.length-1; i >=0; i--){
            res[i] = stack.pop(); 
        }
        return res;
    }
}
