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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)     // O(n+m) time, O(1) space
    {
        int carry = 0;
        ListNode ans = l1, l1tail = l1;                         // Store answer in l1
        while(l1!=null && l2!=null)
        {
            l1tail = l1;
            int t = l1.val;
            l1.val = (carry + l1.val + l2.val)%10;
            carry = (carry + t + l2.val)/10;
            l1 = l1.next;
            l2=l2.next;
        }
        if(l2!=null)                                           // If l1 is smaller list, use nodes of l2.
        {
            l1tail.next = l2;
            l1 = l2;
        }
        while(l1!=null)
        {
            l1tail = l1;
            int t = l1.val;
            l1.val = (carry + l1.val)%10;
            carry = (carry + t)/10;
            l1 = l1.next;
        }
        if(carry!=0)                                         // Lastly, if carry is non-zero add it to the end
        {
            l1tail.next = new ListNode(carry);
        }
        return ans;
    }
}