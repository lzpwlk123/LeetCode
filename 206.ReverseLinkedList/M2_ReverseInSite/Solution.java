//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :37.1 MB, 在所有 java 提交中击败了39.80%的用户
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}