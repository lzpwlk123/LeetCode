//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :34.5 MB, 在所有 java 提交中击败了82.19%的用户


class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Solution {
     static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode first;
        ListNode second;
        while(temp.next != null && temp.next.next != null){
            first = temp.next;
            second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return dummy.next;
    }

}
