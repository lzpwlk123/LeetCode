//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
// 内存消耗 :34.8 MB, 在所有 java 提交中击败了86.69%的用户

//双指针法，可以只遍历一次链表
//第一个指针先跑n，那么第一个指针到达尾部时，第二个指针指的就是需要的
//哑结点

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n > 0){
            first = first.next;
            n --;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
