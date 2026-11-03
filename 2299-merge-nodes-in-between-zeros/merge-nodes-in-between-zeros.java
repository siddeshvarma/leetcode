/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode head1=new ListNode();
        ListNode temp1=head1;
        ListNode temp=head.next ;
        int sum=0;
        while(temp!=null){
            if(temp.val==0){
                temp1.next=new ListNode(sum);
                temp1=temp1.next;
                sum=0;
            }
            else{
                sum=sum+temp.val;
            }
            temp=temp.next;
        }
        return head1.next;
    }
}