//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 777 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路: 雙指針，一個指針紀錄 0的位置，另一個記錄非0位置，只要遇到非0位置，就跟指針0位置交換
    // 時間複雜度 O(n) 空間複雜度 O(1)
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;

        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if (i != zeroIndex) {
                    swap(nums, i, zeroIndex);
                }
                zeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
