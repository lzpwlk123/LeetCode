
//执行结果：通过
//        执行用时 :10 ms, 在所有 java 提交中击败了17.99%的用户
//        内存消耗 :38.2 MB, 在所有 java 提交中击败了84.73%的用户

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode tempA = headA; tempA != null; tempA = tempA.next) {
            set.add(tempA);
        }
        for (ListNode tempB = headB; tempB != null; tempB = tempB.next) {
            if (set.contains(tempB)) {
                return tempB;
            }
        }
        return null;
    }
}
