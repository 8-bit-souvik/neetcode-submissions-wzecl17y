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
    public void reorderList(ListNode head) {
        ListNode forward = new ListNode();
        ListNode forwardtrvs = forward;
        ListNode fwd = head;
        ListNode reverse = null;
        int len = 0;
        while(fwd != null){
            len++;
            forwardtrvs.next = new ListNode(fwd.val);
            forwardtrvs = forwardtrvs.next;
            ListNode tmp = fwd.next;
            fwd.next = reverse;
            reverse = fwd;
            fwd = tmp;
        }
        forward = forward.next;

        // ListNode ans = new ListNode();
        ListNode anstrvs = head;

        forward = forward.next;
        for(int i=0; i<len/2; i++){
            if(i != 0){
                anstrvs.next = new ListNode(forward.val);
                anstrvs = anstrvs.next;
                forward = forward.next;
            }

            anstrvs.next = new ListNode(reverse.val);
            anstrvs = anstrvs.next;
            reverse = reverse.next;
        }

        if(len > 1 && len%2 != 0){
            anstrvs.next = new ListNode(forward.val);
        }

        // return ans.next;
        // head = ans.next;


        // while(head != null){
        //     System.out.print(head.val+" - ");
        //     head = head.next;
        // }
        // System.out.println("");
    }
}
