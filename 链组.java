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
    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        ListNode temp = null;
        
        while(right != null){            //反转表组
            temp = right.next;           //有时候写while会晕，是因为没想明白“开始”的规则
            right.next = left;           //每次开始进行操作前，都是left在做，right在右的，所以结束操作的时候也要保证新的操作开始前是这个位置。
            left = right;                //这样一想就明白多了。
            right = temp;
            
        }
        
        return left;
        
        
        
    }
}
