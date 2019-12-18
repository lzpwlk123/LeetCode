//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :37.2 MB, 在所有 java 提交中击败了33.66%的用户

// 一.递归出口
// 二.递归方程，即F(n)与F(n-1)的关系

//假设列表为：1 →2 →3 →4	→5 →∅
//若现在正处在4（即4以后的都已经完成逆置）：1 →2 →3 →4 →←5
//那我们希望4.next能指向3： 3.next.next = 3

//1. 为什么 “若现在正处在4”代表“4以后的都已经完成逆置”，而不是“4以前的都已经完成逆置” 即  null←1 ←2 ←3 ←4 →5 →null
//   因为递归是栈，先进后出，从1开始进，那么1肯定是最后完成的
//2.
//   下一个必须指向 Ø，否则最后1的next就始终指向2，让链表产生循环
//3. new_head 从最深层得到后，值不会再变，一路传上去
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode new_head = reverseList(head.next); // 3.
        head.next.next = head;  //注意这里不是 new_head.next = head；
        head.next = null;   //2.
        return new_head;    //3.
    }
}