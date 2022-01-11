/***   URL: https://leetcode.com/problems/max-area-of-island/   ***/

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        
        HashSet<String> visited = new HashSet<>();
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                max = Math.max(max, explore(grid, r, c, visited));
            }
        }
        
        return max;
    }
    
    public int explore(int[][] grid, int r, int c, HashSet<String> visited){
        // r or c not in bound
        if(!(r>=0 && r<grid.length)){
            return 0;
        }
        if(!(c>=0 && c<grid[0].length)){
            return 0;
        }
        
        // not land
        if(grid[r][c] == 0){
            return 0;
        }
        
        String index = String.valueOf(r) + "," + String.valueOf(c);
        if(visited.contains(index)){
            return 0;
        }
        
        visited.add(index);
        
        int size = 1;
        size += explore(grid, r+1, c, visited);
        size += explore(grid, r, c+1, visited);
        size += explore(grid, r-1, c, visited);
        size += explore(grid, r, c-1, visited);
        
        return size;
    }
}
