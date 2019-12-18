//        执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
//        内存消耗 :38.8 MB, 在所有 java 提交中击败了83.81%的用户



public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;

        int lenA = getListNodeLength(headA);
        int lenB = getListNodeLength(headB);
        ListNode tempBig = null;
        ListNode tempSmall = null;
        int diff = 0;

//        if (lenA >= lenB){
//            diff = lenA - lenB;
//            tempBig = headA;
//            tempSmall = headB;
//        }else {
//            diff = lenB - lenA;
//            tempBig = headB;
//            tempSmall = headA;
//        }

        diff = lenA > lenB ? lenA - lenB : lenB - lenA;
        tempBig = lenA > lenB ? headA : headB;
        tempSmall = lenA > lenB ? headB : headA;


        while (diff > 0){
            diff --;
            tempBig = tempBig.next;
        }
        while (tempBig != null){
            if (tempBig == tempSmall) return tempBig;
            tempBig = tempBig.next;
            tempSmall = tempSmall.next;
        }
        return null;
    }

    private int getListNodeLength(ListNode headA){
        int count = 0;
        while (headA != null){
            count++;
            headA = headA.next;
        }
        return count;
    }

}
