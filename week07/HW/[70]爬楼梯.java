//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1315 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路 1: 遞歸，爬樓梯，只有兩種走法， f(3) = f(2) + f(2)
    //       走到第3階的可能走法[1] f(2) ＋ 走一階上來或是[2] f(1)＋跨兩階
    //       走到第N階的可能走法[1] f(N-1) ＋ 走一階上來或是[2] f(N-2)＋跨兩階
    //       時間複雜度：O(2^N)
    //       空間複雜度：O(N)

    // 思路 2: 迭代
    //       時間複雜度：O(N)
    //       空間複雜度：O(1)

    // Solution 2:
//    public int climbStairs(int n) {
//        if (n < 3) {
//            return n;
//        }
//        int prev = 1;
//        int prev2 = 2;
//        int result = 0;
//        for (int i=3; i<=n; i++) {
//            result = prev + prev2;
//            prev = prev2;
//            prev2 = result;
//        }
//
//        return result;
//    }

    // Solution 1:
//    public int climbStairs(int n) {
//        // terminator
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        // process
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(3, n, 1, 2);
    }

    private int climbStairs(int level, int max, int prev, int prev1) {
        // terminator
        if (level >= max) return prev + prev1;

        // process
        return climbStairs(level + 1, max, prev1, prev + prev1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
