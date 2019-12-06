//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
// 内存消耗 :34.5 MB, 在所有 java 提交中击败了88.24%的用户

//本题看似简单，容易写出注释部分的代码。但忽视了列表中只含有一个结点，或需要删除列表的头部。
//通过引入哑结点，可以简化这些极端情况。

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode temp = head;
//        int length = 0;
//        while (temp != null){
//            length ++;
//            temp = temp.next;
//        }
//        length -= n;
//        temp = head;
//        while (length > 1){
//            length --;
//            temp = temp.next;
//        }
//        temp.next = temp.next.next;
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        int length = 0;
        while (temp != null){
            length ++;
            temp = temp.next;
        }
        length -= n;
        temp = dummy;
        while (length > 0){
            length --;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
