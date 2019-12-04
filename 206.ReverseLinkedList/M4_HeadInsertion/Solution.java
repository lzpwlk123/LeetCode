//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :36.6 MB, 在所有 java 提交中击败了55.12%的用户

//头插法建立新链表，刚好和原链表反向

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode new_head = new ListNode(-1);
        new_head.next = null;
        ListNode temp = head;
        ListNode next;
        while (temp != null){
            next = temp.next;
            temp.next = new_head.next;
            new_head.next = temp;
            temp = next;
        }
        return new_head.next;
    }
}