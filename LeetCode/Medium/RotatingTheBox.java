/***   URL: https://leetcode.com/problems/rotating-the-box/   ***/

/*
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:



Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:

Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:

Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]
 
Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'.
*/

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char[][] retBox = new char[col][row];
        
        // move all the stones to the right until no more empty space to move
        for(int i = 0; i < row; i++) {
            for(int j = col - 1; j >= 0; j--) {
                // if stone
                if(box[i][j] == '#'){
                    int empty = j + 1; // empty space
                    
                    // keeps traversing to the right until we see the obstacle or the end
                    // to find the last cell that is NOT empty (obstacle/stone/end of box)
                    // aka find the cell the stone will end up falling to
                    while(empty < col && box[i][empty] == '.') {
                       empty++;
                    }
                    if(empty < col && box[i][empty] == '.') {
                        // swap the stone with the last empty cell
                        box[i][empty] = '#'; // set the 'last' empty cell to stone aka stone falls down
                        box[i][j] = '.'; // set the cell where the stone initially was to empty
                    }
                    else if(empty-1 < col && box[i][empty-1] == '.') {
                        box[i][empty-1] = '#'; // set the 'last' empty cell to stone aka stone falls down
                        box[i][j] = '.'; // set the cell where the stone initially was to empty
                    }
                    
                }
            }
        }
        
        // turn the box to vertical
        // aka standup the box
        int newColIndex = row - 1;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                retBox[j][newColIndex] = box[i][j];
            }
            newColIndex--;
        }
        
        return retBox;
    }
}
