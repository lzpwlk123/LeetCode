//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :34.2 MB, 在所有 java 提交中击败了86.15%的用户

// 0. 本题是交换两个相邻结点，所以思考时，把两个结点设为一组。
// 1. 把递归想成是  先进栈，再出栈
// 2. 递归出口，当参数为xxx时，结果是已知的，可以直接返回
//    结合栈的思想，从链表开头，一直递归进栈，直至链表尾，
//    所以这里递归出口的参数就是链表尾部——当前结点为null或者下一个为null。此时，不用交换结点，直接返回 组头结点
// 3. 找出递归关系式。即f(n)与f(n-1)的关系
//

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Solution {
     static ListNode swapPairs(ListNode head) {
         if (head == null || head.next == null) return head;   // 2.
         ListNode next = swapPairs(head.next.next);    // f(n)。当递归返回时，说明后面的结点已经全部交换完毕。
                                                       // 返回的f(n)：next是下一组的 组头结点
                                                        //借助 f（n）来完成这一组的 结点交换
         ListNode second = head.next;
         head.next = next;
         second.next = head;
         return second;
     }

}
