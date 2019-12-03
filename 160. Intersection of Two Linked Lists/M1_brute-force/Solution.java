
//执行结果：通过
//        执行用时 :652 ms, 在所有 java 提交中击败了5.04%的用户
//        内存消耗 :47.7 MB, 在所有 java 提交中击败了11.37%的用户

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
        for(ListNode tempA = headA; tempA != null; tempA = tempA.next){
            for (ListNode tempB = headB; tempB != null; tempB = tempB.next){
                if (tempA == tempB){
                    return tempA;
                }
            }
        }
        return null;
    }
}
