//1.Java 不支持默认参数，否则可以只写一个add方法。这里使用了重载来间接实现
//2.add方法中，学会使用“%” 和 “/”，以避免if语句
//3.temps是必要的，不要写成了sum.next = new ，这样永远只有两个节点
//4.当一个加数列表到尽头时，人为把它设为0，能简化许多（即 将长度较短的链表在末尾补零，使得两个链表长度一样。这样就把许多种情况简化为一种情况）

//执行用时 :3 ms, 在所有 java 提交中击败了60.73%的用户
//内存消耗 :44.7 MB, 在所有 java 提交中击败了84.85%的用户


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] sumOfDigits = add(l1, l2);
        ListNode sum = new ListNode(sumOfDigits[0]);
        ListNode templ = l1.next;
        ListNode temp2 = l2.next;
        ListNode temps = sum;  //3
        while (templ != null || temp2 != null){
            int carryFlag = sumOfDigits[1];
            sumOfDigits = add(templ,temp2, carryFlag);
            temps.next = new ListNode(sumOfDigits[0]);
            if (templ != null) templ = templ.next;
            if (temp2 != null) temp2 = temp2.next;
            temps = temps.next;
        }
        if (sumOfDigits[1] == 1){
                temps.next = new ListNode(sumOfDigits[1]);
        }
        return sum;
    }

    int[] add(ListNode l1, ListNode l2){
        int[] a = new int[2];
        a[0] = (l1.val + l2.val) % 10; //2
        a[1] = (l1.val + l2.val) / 10;
        return a;
    }

    int[] add(ListNode l1, ListNode l2, int carryFlag){
        int[] a = new int[2];
        if (l1 == null) l1 = new ListNode(0); // 4
        if (l2 == null) l2 = new ListNode(0);
        a[0] = (l1.val + l2.val + carryFlag) % 10;
        a[1] = (l1.val + l2.val + carryFlag) / 10;
        return a;
    }

}
