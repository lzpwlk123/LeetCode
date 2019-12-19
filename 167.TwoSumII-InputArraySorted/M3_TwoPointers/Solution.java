//执行用时 :1 ms, 在所有 java 提交中击败了99.16%的用户
//内存消耗 :38 MB, 在所有 java 提交中击败了49.77%的用户


//完美利用数组已经排序的性质
//使用两个指针，初始分别位于第一个元素和最后一个元素位置，比较这两个元素之和与目标值的大小。
//  如果和等于目标值，我们发现了这个唯一解。
//  如果比目标值小，我们将较小元素指针增加一。
//  如果比目标值大，我们将较大指针减小一。
//  又因为不能重复利用同一个数，所以当指针相遇而还没return时，就说明不存在

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 1;
        int tail = numbers.length;
        while (head != tail){
            if (numbers[head - 1] + numbers[tail - 1] == target) return new int[] {head, tail};
            if (numbers[head - 1] + numbers[tail - 1] > target)  tail --;
            else head ++;
        }
        return null;
    }
}