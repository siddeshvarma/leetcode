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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>qu=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        int check=0;
        qu.offer(root);
        while(!qu.isEmpty()){
                int size=qu.size();
                List<Integer>add1=new ArrayList<>();
                for(int i=0;i<size;i++){
                    if(qu.peek().left!=null){
                        qu.offer(qu.peek().left);
                    }
                    if(qu.peek().right!=null){
                        qu.offer(qu.peek().right);
                    }
                    add1.add(qu.poll().val);
                }
                ans.add(add1);
        }
        for(int i=0;i<ans.size();i++){
            int prev=ans.get(i).get(0);
            // Check first element parity
            if (i % 2 == 0 && prev % 2 == 0) {
                return false;
            }
            if (i % 2 != 0 && prev % 2 != 0) {
                return false;
            }
            for(int j=1;j<ans.get(i).size();j++){            
                if(i%2==0){
                    if(prev<ans.get(i).get(j) && (ans.get(i).get(j))%2!=0){
                        prev=ans.get(i).get(j);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(prev>ans.get(i).get(j) && (ans.get(i).get(j))%2==0){
                        prev=ans.get(i).get(j);
                    }
                    else{
                        return false;
                    }
                }
            }
        }return true;
    }
}