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
    public int countNodes(TreeNode root) {
        //TC-o(N);
        // if(root==null){
        //     return 0;
        // }
        // int left=countNodes(root.left);
        // int right=countNodes(root.right);
        // return 1+left+right;
        //

        //TC-< O(N)-->
        if(root==null){
            return 0;
        }
        int left=countHeightL(root);
        int right=countHeightR(root);

        if(left==right)return (2<<(left))-1;

        else return countNodes(root.left)+countNodes(root.right)+1;
    }

    int countHeightL(TreeNode root){
        int cnt=0;
        while(root.left!=null){
            cnt++;
            root=root.left;
        }
        return cnt;
    }
     int countHeightR(TreeNode root){
        int cnt=0;
        while(root.right!=null){
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}