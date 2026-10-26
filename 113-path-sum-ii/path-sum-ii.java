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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        sum(root,targetSum,ans,temp);
        return ans;
    }
    public void sum(TreeNode root,int targetSum,List<List<Integer>>ans,List<Integer>temp){
        if(root==null){
            return ;
        }
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                return;
            }
        }
        targetSum-=root.val;
        sum(root.left,targetSum,ans,temp);
        sum(root.right,targetSum,ans,temp);
        temp.remove(temp.size()-1);
    }

}