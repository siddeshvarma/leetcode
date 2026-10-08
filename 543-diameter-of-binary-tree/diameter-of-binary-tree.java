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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return ans;
    }
    int f(TreeNode root){
    if(root==null)return 0;
        int lh=f(root.left);
        int rh=f(root.right);
        ans=Math.max(ans,(rh+lh));
        return 1+Math.max(lh,rh);
    }
}