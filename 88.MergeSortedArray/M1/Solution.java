/*
最暴力的方法
遍历nums2，每个元素和nums1中的每个元素比较，找到位置后就覆盖该位置，并将nums1从这个位置以后的数全部向后移一位
 */


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {   // 注意，m是nums1的初始有效长度，实际长度是m + n
        if(m == 0){            // 要把nums1为空的情况单独列出来，下面的代码处理不了这种情况
            for(int i = 0; i < n; i++) nums1[i] = nums2[i];
        }else{
            for(int k = 0; k < n; k++){
                for(int i = 0; i < m + k; i++){   // nums1的有效长度不断变化，从m 递增到 m + n
                    if(nums1[i] > nums2[k]){
                        int temp1 = nums1[i];
                        nums1[i] = nums2[k];
                        for(int j = i + 1; j < m + n; j++){
                            int temp2 = nums1[j];
                            nums1[j] = temp1;
                            temp1 = temp2;
                        }
                        break;
                    }
                    if(i == m + k -1){        // 如果i == m + k -1时（即到了nums1数组的有效长度），还没有break，那么直接把nums2的这个元素置在nums1的有效长度
                        nums1[m + k] = nums2[k];
                    }
                }
            }
        }
    }
}