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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>qu=new LinkedList<>();
        List<List<Integer>>ans=new LinkedList<>();
        if(root==null)return ans;
        qu.offer(root);
        boolean check=true;
        while(!qu.isEmpty()){
            int level=qu.size();
            List<Integer>sub=new LinkedList<Integer>();
            for(int i=0;i<level;i++){
                if(qu.peek().left!=null){
                    qu.offer(qu.peek().left);
                }
                if(qu.peek().right!=null){
                    qu.offer(qu.peek().right);
                }
                sub.add(qu.poll().val);
            }
            if(!check){
           Collections.reverse(sub);
           }
           check=!check;
           ans.add(sub);
        }
        
        return ans;
        }
        
        
    }