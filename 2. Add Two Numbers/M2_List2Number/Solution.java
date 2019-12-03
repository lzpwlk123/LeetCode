//把链表转换成数字，相加之后，再转换为链表
//考虑到溢出的问题，变量类型需要谨慎选择。需要使用java.math.BigInteger 或者 java.math.BigDecimal
//BigInteger内部用一个int[]数组来模拟一个非常大的整数
//1.由于链表表示数字是从低位到高位，所以链表转String后，String转链表前，都要逆序

//执行用时 :17 ms, 在所有 java 提交中击败了5.66%的用户
//内存消耗 :40.6 MB, 在所有 java 提交中击败了95.96%的用户


import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = listNode2String(l1);
        String s2 = listNode2String(l2);

        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        BigInteger sum = n1.add(n2);

        char[] c = reverse(sum.toString()).toCharArray();  // 1
        ListNode ans = new ListNode(Integer.parseInt(String.valueOf(c[0])));
        ListNode temp = ans;
        for (int i = 1; i < c.length; i++) {
            ListNode cl = new ListNode(Integer.parseInt(String.valueOf(c[i])));
            temp.next = cl;
            temp = cl;
        }
        return ans;
    }

    String listNode2String(ListNode l){
        String s = "";
        while (l != null){
            s += l.val;
            l = l.next;
        }
        s = reverse(s);  // 1
        return  s;
    }

    String reverse(String s){
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--){
            r += s.charAt(i);
        }
        return r;
    }
}
