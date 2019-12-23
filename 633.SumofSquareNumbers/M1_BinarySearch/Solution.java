//执行用时 :8 ms, 在所有 java 提交中击败了12.73%的用户
//内存消耗 :33 MB, 在所有 java 提交中击败了82.19%的用户

//执行用时 :62 ms, 在所有 java 提交中击败了5.01%的用户
// 内存消耗 :33.1 MB, 在所有 java 提交中击败了81.88%的用户

/*
    1. 最直观的想法。借助了Math.sqrt方法来
    2. 二分查找
 */


public class Solution {
    //1
    public boolean judgeSquareSum(int c) {
        for (long a = 0; c - a * a >= 0; a++){
            double diff = c - a * a;
            long b = (long) Math.sqrt(diff);
            if (b * b == diff) return true;
        }
        return false;
    }

    //2
    boolean binarySearch(long head, long tail, long target){
        if (head > tail) return false;
        long mid = (head + tail) / 2;
        if (mid * mid == target) return true;
        if (mid * mid > target) return binarySearch(head,mid -1, target);
        else return binarySearch(mid + 1, tail, target);

    }
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; c - a * a >= 0; a++){
            long diff = c - a * a;
            boolean ans = binarySearch(0, diff, diff);
            if (ans) return ans;
        }
        return false;
    }
}
