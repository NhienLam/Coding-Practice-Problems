/***   URL: https://leetcode.com/problems/surrounded-regions/   ***/

/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Example 2:
Input: board = [["X"]]
Output: [["X"]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/

class Solution {
    public void solve(char[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) { 
                // 1 or last row || 1st or last col
                if(r == 0 || r == board.length-1 || c == 0 || c == board[0].length-1) {  
                    if(board[r][c] == 'O') {
                        dfs(board, r, c);
                    }
                }  
            }
        }     
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) { 
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if(board[r][c] == '1'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length)
        {
            return;
        }
        if(board[r][c] == 'O') {
            board[r][c] = '1';
            dfs(board, r-1, c);
            dfs(board, r+1, c);
            dfs(board, r, c-1);
            dfs(board, r, c+1);
        }      
    }
}
