/***   URL: https://leetcode.com/problems/subarray-sum-equals-k/   ***/

/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        //map<sum, # of times seen this sum>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // sum =0 and seen it once
        
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            
            // if 1st time seen this sum, put(sum, 1) into map
            // if not 1st time, put(sum, #of times seen + 1)
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return count;
    }
}
