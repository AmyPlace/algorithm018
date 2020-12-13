//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 263 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // think 1: 清除最後一位 (n & (n-1)) 後為 0 ，表示為2的冪次
    //       T.C:O(1)
    //       S.C:O(1)
    // think 2: 取得最右邊的1 = (n & (-n))，如果等同於 n，表示為2的冪次
    //       T.C:O(1)
    //       S.C:O(1)
//    public boolean isPowerOfTwo(int n) {
//        long x = (long) n;
//        return (n != 0) && ((x & (x-1)) == 0);
//    }

    public boolean isPowerOfTwo(int n) {
        long x = (long) n;
        return (n != 0) && ((x & (-x)) == x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
