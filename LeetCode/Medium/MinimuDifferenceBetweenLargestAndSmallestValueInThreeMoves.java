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
        // sort 
        // kill 3 smallest -> 4
        // kill 3 biggest -> 1
        // kill 2 smallest and 1 biggest -> 5
        // kill 2 biggest and 1 smallest -> 4
        // return the minimum of the 4 ways above

        // 0 1 5 10 14 -> 4
        if(nums.length < 5){
            return 0;
        }
        
        Arrays.sort(nums);
        /*
        // kill 3 smallest
        int dif1 = nums[nums.length-1] - nums[3];
        
        // kill 3 biggest
        int dif2 = nums[nums.length-1 - 3] - nums[0];
        
        // kill 2 smallest and 1 biggest
        int dif3 = nums[nums.length-1 -1] - nums[2];
        
        // kill 2 biggest and 1 smallest
        int dif4 = nums[nums.length-1 - 2] - nums[1];
        */
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            min = Math.min(min, nums[nums.length-1-i] - nums[3-i]);
        }
        
        return min;
    }
}
