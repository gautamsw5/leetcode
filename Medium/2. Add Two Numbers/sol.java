// https://leetcode.com/problems/add-two-numbers/discuss/1159518/Java-two-solution-one-with-O(m%2Bn)-space-other-with-constant-space
// Definition for singly-linked list.
public class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)     // O(n+m) time, O(n+m) space
    {
        int carry = 0;
        ListNode ans = new ListNode(), tail = ans;
        while(l1!=null && l2!=null)
        {
            tail.next = new ListNode((carry + l1.val + l2.val)%10);   // Single digit in every node
            carry = (carry + l1.val + l2.val)/10;                     // If sum of previous carry and current two digits > 9 then carry should become 1 else 0
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null)
        {
            tail.next = new ListNode((carry + l1.val)%10);
            carry = (carry + l1.val)/10;
            tail = tail.next;
            l1 = l1.next;
        }
        while(l2!=null)
        {
            tail.next = new ListNode((carry + l2.val)%10);
            carry = (carry + l2.val)/10;
            tail = tail.next;
            l2 = l2.next;
        }
        if(carry!=0)                          // Lastly, if carry is non-zero add it to the end
        {
            tail.next = new ListNode(carry);
        }
        return ans.next;
    }
}