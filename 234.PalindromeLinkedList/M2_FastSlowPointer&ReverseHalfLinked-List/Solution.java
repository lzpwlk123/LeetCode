//执行用时 :1 ms, 在所有 java 提交中击败了99.68%的用户
//内存消耗 :41 MB, 在所有 java 提交中击败了97.63%的用户


//1. 快慢指针
//   快指针每次走两步，慢指针每次走一步，那么当快指针达到链表尾时，慢指针刚好到链表中心
//2. pre 和 prepre指针
//   在快慢指针遍历时，顺着慢指针，把前半链表逆置
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        ListNode prepre = null;

        while(fast != null && fast.next != null){
            //1.
            fast = fast.next.next;
            slow = slow.next;
            //2.
            pre.next = prepre;
            prepre = pre;
            pre = slow;
        }
        if (fast != null) slow = slow.next;  //如果结点个数是奇数，slow要再走一格
                                            // （奇数时，fast指向最后一个结点；偶数时，就会指向null；这个结论也跟fast的初值有关）
        while (slow != null){
            if (slow.val != prepre.val) return false;    //前半链表逆置后，头结点是prepre
            slow = slow.next;
            prepre = prepre.next;
        }
        return true;
    }
}
