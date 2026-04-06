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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1=1;
        int num1=0;
        while(l1 != null){
            num1 = num1+n1*l1.val;
            n1 = n1*10;
            l1=l1.next;
        }

        int n2=1;
        int num2=0;
        while(l2 != null){
            num2 = num2+n2*l2.val;
            n2 = n2*10;
            l2=l2.next;
        }

        int sum = num1+num2;
        // System.out.println(sum);
        ListNode sumlist = new ListNode();
        ListNode sumlistItr = sumlist;

        if(sum == 0){
            sumlistItr.next = new ListNode(0);
            sumlistItr = sumlistItr.next;
        } else{
            while(sum >= 1){
                sumlistItr.next = new ListNode(sum%10);
                sumlistItr = sumlistItr.next;
                sum = sum/10;
            }
        }


        return sumlist.next;

        // System.out.println(sum);
        // return l1;
    }
}
