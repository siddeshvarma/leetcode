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
// class Solution {
//     int sum=0;
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root==null)return false;
//         sum=f(root,targetSum);
//         System.out.println(sum);
//         if(sum==targetSum)return true;
//         return false;
//     }
//     int f(TreeNode root,int targetSum){
//         if(root==null){
//             if(sum==targetSum)return sum;
//             //return sum;
//             return 0;
//         }
//         sum=sum+root.val;
//         f(root.left,targetSum);
//         if(sum==targetSum)return sum;
//         sum=sum-root.val;
//         f(root.right,targetSum);
//         sum=sum+root.val;
//         if(sum==targetSum)return sum;
//         return sum;
//     }
// }
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        // leaf node
        if (root.left == null && root.right == null)
            return targetSum == root.val;

        targetSum = targetSum - root.val;

        return hasPathSum(root.left, targetSum) ||
               hasPathSum(root.right, targetSum);
    }
}