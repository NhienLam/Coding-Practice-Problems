/***   URL: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/   ***/

/*
You are given an integer array nums. In one move, you can choose one element of nums and change it by any value.

Return the minimum difference between the largest and smallest value of nums after performing at most three moves.

Example 1:
Input: nums = [5,3,2,4]
Output: 0
Explanation: Change the array [5,3,2,4] to [2,2,2,2].
The difference between the maximum and minimum is 2-2 = 0.

Example 2:
Input: nums = [1,5,0,10,14]
Output: 1
Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1]. 
The difference between the maximum and minimum is 1-0 = 1.

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

class Solution {
    public int minDifference(int[] nums) {
        // kill 3 smallest
        // kill 2 smallest and 1 biggest
        // kill 1 smallest and 2 biggest
        // kill 3 biggest
        // return the minimum of the 4 ways above
        
        if(nums.length < 5) {
            return 0;
        }
        
        int[] ways = new int[4];
        Arrays.sort(nums);
        
        // kill 3 smallest
        ways[0] = nums[nums.length-1] - nums[3];
        
        // kill 2 smallest and 1 biggest
        ways[1]  = nums[nums.length-2] - nums[2];
        
        // kill 1 smallest and 2 biggest
        ways[2]  = nums[nums.length-3] - nums[1];
        
        // kill 3 biggest
        ways[3]  = nums[nums.length-4] - nums[0];
        
        int minDiff = ways[0];
        for(int i = 1; i < ways.length; i++) {
           minDiff = Math.min(ways[i], minDiff);
        }
        return minDiff;
    }
}
