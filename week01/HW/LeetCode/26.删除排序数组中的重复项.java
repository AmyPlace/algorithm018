/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    // 思路：因為有排序過，所以只要檢查相鄰的資料是否不同即可
    // 作法：雙指針，用一個參數紀錄目前未重複資料的 index，每次遇到不重複的資料就一直覆寫對應未重複的 index 資料  
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int count = 1;
        for (int i=1 ; i<nums.length; i++) {            
            if (nums[i-1] != nums[i]) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int count = new Solution().removeDuplicates(nums);

        System.out.println("count:"+count);
    }
}
// @lc code=end

