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
class DeleteDuplicatesList {
    
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null) return head;
        
        ListNode res = head;
        ListNode prev = head;
        head = head.next;
        
        while(head != null){
             if(prev.val == head.val){
                 prev.next = head.next;
             }else{
                 prev = head;
             }
            head = head.next;
        }
        return res;
    }
}