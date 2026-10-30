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
    public void flatten(TreeNode root) {
        List<TreeNode>arr=new ArrayList<>();
        makingNull(root,arr);
        for(int i=0;i<arr.size()-1;i++){
            arr.get(i).left=null;
            arr.get(i).right=arr.get(i+1);
        }
        if(arr.size() > 0) {
            arr.get(arr.size()-1).left = null;
            arr.get(arr.size()-1).right = null;
        }
    }
    public void makingNull(TreeNode root,List<TreeNode>arr){
        if(root==null){
            return;
        }
        arr.add(root);
        makingNull(root.left,arr);
        makingNull(root.right,arr);
    }
}