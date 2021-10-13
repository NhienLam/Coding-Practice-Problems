/***   URL: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/submissions/   ***/

/*
There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.

You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.

It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.

Return the original array nums. If there are multiple solutions, return any of them.

Example 1:

Input: adjacentPairs = [[2,1],[3,4],[3,2]]
Output: [1,2,3,4]
Explanation: This array has all its adjacent pairs in adjacentPairs.
Notice that adjacentPairs[i] may not be in left-to-right order.
Example 2:

Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
Output: [-2,4,1,-3]
Explanation: There can be negative numbers.
Another solution is [-3,1,4,-2], which would also be accepted.
Example 3:

Input: adjacentPairs = [[100000,-100000]]
Output: [100000,-100000]
 
Constraints:

nums.length == n
adjacentPairs.length == n - 1
adjacentPairs[i].length == 2
2 <= n <= 105
-105 <= nums[i], ui, vi <= 105
There exists some nums that has adjacentPairs as its pairs.
*/

// reference: Bodhisattva
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        List<Integer> ansList = new ArrayList<>();
        Set<Integer> seenSet = new HashSet<>();
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // build graph of number -> adjacent numbers
        for(int r = 0; r < adjacentPairs.length; r++) {
            addToGraph(graph, adjacentPairs[r][0], adjacentPairs[r][1]);
            addToGraph(graph, adjacentPairs[r][1], adjacentPairs[r][0]);
        }
        
        int start = 0;
        // start =  1st number with only one adjacent number
        for(int key : graph.keySet()){
            // only one adjacent number
            if(graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        
        
        dfs(start, graph, ansList, seenSet);
        
        int[] retArray = new int[ansList.size()];
        
        for(int i = 0; i < ansList.size(); i++) {
            retArray[i] = ansList.get(i);
        }
        
        return retArray;        
    }
    
    public void addToGraph(Map<Integer, List<Integer>> graph, int num, int adjNum) {
        // if graph num already has adjacent pair
        if(graph.containsKey(num)){
            // add adjNum to the current adjacent list of num
            graph.get(num).add(adjNum);
        }
        else {
            // create new list and add adjNum to it 
            List<Integer> temp = new ArrayList<>();
            temp.add(adjNum);
            // put the temp list with the num in graph
            graph.put(num, temp);
        }
    }
    
    public void dfs(int start, Map<Integer, List<Integer>> graph, List<Integer> ansList,  Set<Integer> seenSet)
    {
        // visit start
        ansList.add(start);
        seenSet.add(start);
        
        List<Integer> neighbors = graph.get(start);
        //loop over adjacents
        for(Integer curr : neighbors){
            if(!seenSet.contains(curr)){
                 dfs(curr, graph, ansList, seenSet);
            }
        } 
    }
}
