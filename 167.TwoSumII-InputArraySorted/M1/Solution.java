//执行用时 :70 ms, 在所有 java 提交中击败了17.85%的用户
//内存消耗 :36.3 MB, 在所有 java 提交中击败了95.63%的用户

//暴力解法，对“有序”这一条件应用地不是很充分（只体现在 1处）
//该解法，即使没有“有序”，依然可以使用。缺点是时间复杂度高 为 O（n^2）


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int curr = 1;
        int pre = 2;
        while (curr <= numbers.length){
            while (pre <= numbers.length){
                if (numbers[curr - 1] + numbers[pre - 1] == target){
//                    int[] ans = new int[2];
////                    ans[0] = curr;
////                    ans[1] = pre;
////                    return ans;
                    return new int[] {curr, pre};
                }
                if (numbers[curr - 1] + numbers[pre - 1] > target) break;  // 1
                pre ++;
            }
            curr += 1;
            pre = curr + 1;
            if (numbers[curr - 1] + numbers[pre - 1] > target) break;     // 1
        }
        return null;
    }
}