//执行用时 :8 ms, 在所有 java 提交中击败了56.67%的用户
//内存消耗 :44.8 MB, 在所有 java 提交中击败了86.67%的用户
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp;
        int add1;
        int add2;
        while (!stack1.empty() || !stack2.empty() || carry ==1){
            add1 = stack1.empty() ? 0 : stack1.pop();
            add2 = stack2.empty() ? 0 : stack2.pop();
            sum = (add1 + add2 + carry) % 10;
            carry = (add1 + add2 + carry) / 10;
            temp = new ListNode(sum);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}
