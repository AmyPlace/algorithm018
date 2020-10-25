/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
  
    /**  空間複雜度 O(1)
    思路 1: 遍歷 k 次，每次向右移1格，時間複雜度 O(kn) 最佳是 O(1) 最差是 O(n^2)
    思路 2: 反轉陣列，時間複雜度 O(n) 
    反轉整個數組，ex: k = 3
    原始数组                  : 1 2 3 4 5 6 7
    反转所有数字后             : 7 6 5 4 3 2 1
    反转前 k 个数字后          : 5 6 7 4 3 2 1
    反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     */

    /** 空間複雜度 O(n)
     思路 3: 開一個新的陣列，時間複雜度 O(N)
     原始数组                            : 1 2 3 4 5 6 7
     target                             : 0 0 0 0 0 0 0     
     先複製最後k個數值到target數組的開頭    ： 5 6 7 0 0 0 0
     再將剩下的數值依序搬進target 中        : 5 6 7 1 2 3 4

     */
    
    // // 思路 1 暴力法
    // public void rotate(int[] nums, int k) {
    //     for(int i=0; i<k; i++) {
    //         for(int j=0; j<nums.length-1; j++) {
    //             swap(nums, j, nums.length-1);
    //         }
    //     }
    // }

    // 思路 2 反轉陣列
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k > len) {
            k = k % len;
        }

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len - 1);
    }

    private void swap (int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6, 7};
        new Solution().rotate(nums, 3);

        for(int j=0; j<nums.length; j++) {
            System.out.print(nums[j]+" ");
        }

    }
}
// @lc code=end

