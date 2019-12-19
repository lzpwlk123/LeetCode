

//为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。
//保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希Map
//将数组的值作为key，索引作为value构建hashMap
//在不发生冲突的理想情况下，哈希表可以以O（1）的时间复杂度寻找某个值（key）,如果能找到这个值，那么value就是索引了

//1.对于以数组值为key，存在一个问题：比如 {2,2,3,4,5}
// 最终HashMap中key 2 对应的 value为1而不是0，但这会影响最后的结果吗？ 不会，因为在 * 处，是num[i]
// 如果 target 为 6，那么结果是[0, 3]
//如果target 为 4， 那么结果是[0, 1]


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // *
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 更简单的方法，一次哈希
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // *
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

