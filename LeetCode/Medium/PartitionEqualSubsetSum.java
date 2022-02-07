/***   URL: https://leetcode.com/problems/partition-equal-subset-sum/   ***/

/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        
        // Return false if total is odd because cannot split into 2 sub arrays
        if(total % 2 != 0) {
            return false;
        }
        
        return partition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }
    
    public boolean partition(int[] nums, int index, int curSum, int total, HashMap<String, Boolean> map) {
        String cur = index + ";" + curSum;
        if(map.containsKey(cur)) {
            return map.get(cur);
        }
        if(curSum * 2 == total) {
            return true;
        }
        
        if(index >= nums.length || curSum * 2 > total) {
            return false;
        }
        boolean curState = partition(nums, index+1, curSum, total, map) || partition(nums, index+1, curSum+nums[index], total, map);
        map.put(cur, curState);
        return curState;
    }
}
