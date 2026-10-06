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
 */class Solution {
    public boolean isBalanced(TreeNode root) {
        int x = f(root);

        if (x == 100000)
            return false;

        return true;
    }

    int f(TreeNode root) {
        if (root == null)
            return 0;

        int l = f(root.left);

        if (l == 100000)
            return 100000;

        int r = f(root.right);

        if (r == 100000)
            return 100000;

        int diff = Math.abs(l - r);

        if (diff > 1)
            return 100000;

        return 1 + Math.max(l, r);
    }
}