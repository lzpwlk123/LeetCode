//我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
//      list1[0]+merge(list1[1:],list2)  list1[0]<list2[0]
//    {
//      list2[0]+merge(list1,list2[1:])  otherwise
//​
//也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
