//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 650 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Think1: 動態規劃，因為只能相鄰的相加，宣告最後一層大小的陣列，每次紀錄每一層兩兩相鄰數值取小的與自己相加
    //         依據經驗從下而上開始計算
    //         dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
    //      ＴＣ： O(MxN)
    //      ＳＣ： O(MxN)
    // Think2: 優化動態規劃，因為只能相鄰的相加，宣告最後一層大小的陣列，每次紀錄每一層兩兩相鄰數值取小的與自己相加
    //         依據經驗從下而上開始計算
    //         dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
    //      ＴＣ： O(MxN)
    //      ＳＣ： O(N)
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 0) return 0;
//
//        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
//
//        for (int i=triangle.size()-1; i>=0; i--) {
//            for (int j=0; j<triangle.get(i).size(); j++) {
//                if (i == triangle.size()-1) {
//                    dp[i][j] = triangle.get(i).get(j);
//                } else {
//                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    //Solution 2
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 0) return 0;
//
//        int[] dp = new int[triangle.get(triangle.size()-1).size()];
//
//        for (int i=triangle.size()-1; i>=0; i--) {
//            for (int j=0; j<triangle.get(i).size(); j++) {
//                if (i == triangle.size()-1) {
//                    dp[j] = triangle.get(i).get(j);
//                } else {
//                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
//                }
//            }
//        }
//
//        return dp[0];
//    }

    //Solution 3
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        int[] dp = new int[triangle.get(triangle.size()-1).size()+1];

        for (int i=triangle.size()-1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }

        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
