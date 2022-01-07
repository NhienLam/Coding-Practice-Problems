/***   URL: https://leetcode.com/problems/binary-tree-inorder-traversal/   ***/

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 
Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**** RECURSIVE SOLUTION ****/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        helper(root, list);
        
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if(root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
        
    }
}

/**** ITERATING using Stack SOLUTION ****/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // L -> RO -> R
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode cur = root;
        
        while(cur!=null || !stack.empty())
        {
            while(cur!=null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        
        return list;
    }
}
