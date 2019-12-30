/*
与M2类似的双指针思想，但合理运用了nums1的初始时的非有效区域，减少了空间消耗

时间复杂度 : O(n + m)。
空间复杂度 : O(1)。
 */

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, count = m + n - 1;
        while(i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[count--] = nums1[i--];
            }else {
                nums1[count--] = nums2[j--];
            }
        }
        while (i >= 0){
            nums1[count--] = nums1[i--];
        }
        while (j >= 0){
            nums1[count--] = nums2[j--];
        }
    }
}