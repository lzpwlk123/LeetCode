//执行用时 :2 ms, 在所有 java 提交中击败了5.32%的用户
//内存消耗 :37.1 MB, 在所有 java 提交中击败了42.65%的用户
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.empty()) return null;
        else {
            ListNode ans = new ListNode(stack.pop().val);
            temp = ans;
            while (!stack.empty()){
                temp.next = new ListNode(stack.pop().val);
                temp = temp.next;
            }
            temp.next = null;
            return ans;
        }
    }
}
