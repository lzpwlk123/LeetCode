//        执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
//        内存消耗 :37.7 MB, 在所有 java 提交中击败了85.50%的用户

//思路：
//A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
//B:    b1 → b2 → b3

//设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
//当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
//同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
//这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
//
//如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环。



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
