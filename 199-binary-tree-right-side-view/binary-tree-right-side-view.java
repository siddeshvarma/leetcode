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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int levelnum=qu.size();
            for(int i=0;i<levelnum;i++){
                if(qu.peek().left!=null){
                    qu.offer(qu.peek().left);
                }
                if(qu.peek().right!=null){
                    qu.offer(qu.peek().right);
                }
                if(i==levelnum-1){
                    ans.add(qu.peek().val);
                }
                qu.poll();
            }
        }return ans;

    }
    
}