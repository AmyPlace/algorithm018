//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例： 
//
// 
//输入：
//matrix = [["1","0","1","0","0"],
//          ["1","0","1","1","1"],
//          ["1","1","1","1","1"],
//          ["1","0","0","1","0"]]
//
//输出：4 
// Related Topics 动态规划 
// 👍 625 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // ["1","0","1","0","0"],
    // ["1","0","1","1","1"],
    // ["1","1","1","1","1"],
    // ["1","0","0","1","0"]]
    // dp 方程
    // if ((matrix[i][j] == "1")) {
    //      dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
    // }
    // Think 1: dp, 紀錄當前位置連續的最長正方形邊長
    //      TC: O(MN)
    //      SC: O(MN)

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
