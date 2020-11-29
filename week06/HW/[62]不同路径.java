//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 760 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //  think 1: 動態規劃， dp[i][j] = dp[i-1][j] + dp[i][j-1]
    //           子問題，(i, j)位置的總走法 ＝ 上一格的走法＋左邊一格的走法
    //  TC:O(MxN)
    //  SC:O(MxN)

    //  think 2[🚀]: 動態規劃， dp[i][j] = dp[i-1][j] + dp[i][j-1]
    //           子問題，(i, j)位置的總走法 ＝ 上一格的走法＋左邊一格的走法
    //           優化記憶體空間，只需要紀錄單排的陣列，每次透過前一排去算下一排的值
    //  TC:O(MxN)
    //  SC:O(N)

//    // Solution 1:
//    public int uniquePaths(int m, int n) {
//        if (m<1 || n<1) return 1;
//
//        int[][] arr = new int[m][n];
//
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if (i==0) { arr[i][j] = 1; }
//                else {
//                    if (j-1>=0 && i-1>=0) {
//                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
//                    } else if (j-1 < 0) {
//                        arr[i][j] = arr[i - 1][j];
//                    } else if(i-1 < 0){
//                        arr[i][j] = arr[i][j - 1];
//                    }
//                }
//
//            }
//        }
//
//        return arr[m-1][n-1];
//    }

    // Solution 2:
    public int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        return arr[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 子問題(分治): sub[i, j] = sub[i-1, j] + sub[i, j-1]
// 狀態： f(i, j)
// 方程：sub[i, j] = sub[i-1, j] + sub[i, j-1]