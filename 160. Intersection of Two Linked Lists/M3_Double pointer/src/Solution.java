
//执行结果：通过
//        执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
//        内存消耗 :37.7 MB, 在所有 java 提交中击败了85.50%的用户

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB ==null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

}
