//执行用时 :3 ms, 在所有 java 提交中击败了92.82%的用户
//内存消耗 :44.8 MB, 在所有 java 提交中击败了86.67%的用户

//先用0填充，把链表对齐
//再进行递归
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length += 1;
            head = head.next;
        }
        return length;
    }

    ListNode headFillZero(ListNode head, int num){
        while (num > 0){
            num -= 1;
            ListNode temp = new ListNode(0);
            temp.next = head;
            head = temp;
        }
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int diff = getLength(l1) - getLength(l2);
        if (diff > 0) l2 = headFillZero(l2,diff);
        else l1 = headFillZero(l1, -diff);

        ListNode dummy = new ListNode(-1);

        int carry = recursion(l1, l2, dummy);
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = dummy.next;
            dummy.next = temp;
        }        return dummy.next;

    }

    int recursion(ListNode l1, ListNode l2, ListNode dummy){
        if (l1.next == null){
            dummy.next = new ListNode((l1.val + l2.val) % 10);
            return (l1.val + l2.val ) / 10;
        }
        int carry = recursion(l1.next, l2.next, dummy);
        ListNode temp = new ListNode((l1.val + l2.val + carry) % 10);
        temp.next = dummy.next;
        dummy.next = temp;
        return (l1.val + l2.val + carry) / 10;
    }
}


