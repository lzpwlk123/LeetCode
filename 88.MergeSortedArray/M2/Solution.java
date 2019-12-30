/*
一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
另取一个temp数组存放nums1的有效成员，然后双指针分别遍历temp和nums2，合适的放入nums1。

时间复杂度 : O(n + m)。
空间复杂度 : O(m)。
 */

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_temp = Arrays.copyOf(nums1,m);
        int i = 0, j = 0, count = 0;
        while(i < m && j < n){
            if (nums1_temp[i] <= nums2[j]){
                nums1[count++] = nums1_temp[i++];
            }else {
                nums1[count++] = nums2[j++];
            }
        }
        while (i < m){
            nums1[count++] = nums1_temp[i++];
        }
        while (j < n){
            nums1[count++] = nums2[j++];
        }
    }
}