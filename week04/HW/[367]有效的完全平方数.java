//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 177 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路 1: 二分查找，符合單調
    //      T.C: O(log N)
    //      S.P: O(1)
    public boolean isPerfectSquare(int num) {
        if (num == 0) return true;

        int left = 1;
        int right = num;

        while (left <= right) {
            int mid = (left + right) / 2;
            int quotient = num/mid;     // quotient：商數
            int remainder = num % mid;  // remainder:餘數

            if (remainder == 0 && mid == quotient) {
                return true;
            } else if (quotient < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
