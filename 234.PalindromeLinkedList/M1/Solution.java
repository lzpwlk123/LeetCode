//执行用时 :2 ms, 在所有 java 提交中击败了54.41%的用户
//内存消耗 :41.1 MB, 在所有 java 提交中击败了97.57%的用户


//遍历链表。
// 前半段时，边遍历，边用头插法建一个新链表
// 后半段时，新旧链表逐个结点对比
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length +=1;
            head = head.next;
        }
        return length;
    }
    public boolean isPalindrome(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode temp2;
        for (int i = 0; i < length/2; i++){
            temp2 = new ListNode(temp.val);
            temp2.next = dummy.next;
            dummy.next = temp2;
            temp = temp.next;
        }
        if (length % 2 != 0) temp = temp.next;
        temp2 = dummy.next;
        while (temp != null){
            if (temp.val != temp2.val ) return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }
}
