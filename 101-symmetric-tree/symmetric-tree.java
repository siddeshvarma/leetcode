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
    public boolean isSymmetric(TreeNode root) {
        // List<Integer>temp=new ArrayList<>();
        // inorder(root,temp);
        // for(int i=0;i<temp.size();i++){
        //     System.out.println(temp.get(i));
        // }
        // int j=temp.size()-1;
        // int i=0;
        // while(i<j){
        //     if(temp.get(i)==(temp.get(j))){
        //         i++;
        //         j--;
        //     }
        //     else return false;
        // }
        // return true;


        if(root==null)return true;
        return check(root.left,root.right);
    }
    public boolean check(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null || root1.val!=root2.val)return false;
        return check(root1.left,root2.right) && check(root1.right,root2.left);
    }
    // public void inorder(TreeNode root,List<Integer>temp){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left,temp);
    //     temp.add(root.val);
    //     inorder(root.right,temp);
    // }
}