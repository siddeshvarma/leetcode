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
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int temp=root.val;
        return check(root,temp);
    }
    public boolean check(TreeNode root,int temp){
        if(root==null )return true;
        if(root.val!=temp)return false;
        return check(root.left,temp) && check(root.right,temp);

    }
}