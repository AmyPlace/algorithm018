//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1394 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 規律：左括號個數 <= n, 右括號個數 <= 左括號個數
    // 思路 1[🚀]: 遞歸, 每進一層加一個左括號或右括號，直到左與右括號樹等於 n
    //   T.C: O(4^n/n^0.5)，n 為題目，有效括號對數
    //   S.P: O(2n) => O(n), 遞歸森度為 2n
    // 思路 2: 動態規劃，dp 方程是定義 dp[n] 為 n 組有效括號所有組合

    // Solution 1:
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // level, max,
        generate(result, 0, 0, n, "");

        return result;
    }

    private void generate(List<String> reuslt, int leftNum, int rightNum, int maxNum, String str) {
        // terminator
        if (leftNum == maxNum && rightNum == maxNum) {
            reuslt.add(str);
        }

        // process
        String str1 = str + "(";
        String str2 = str + ")";

        // drill down
        if (leftNum < maxNum)
            generate(reuslt, leftNum + 1, rightNum, maxNum, str1);
        if (leftNum > rightNum)
            generate(reuslt, leftNum, rightNum + 1, maxNum, str2);

        // restore
    }

//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//
//        // level, max,
//        generate(result, 0, 0, n, "");
//
//        return result;
//    }
//
//    private void generate(List<String> result, int leftNum, int rightNum, int n, String currentString) {
//        // terminator
//        if (leftNum > n) return;
//        else if (leftNum == n && leftNum == rightNum) {
//            result.add(currentString);
//            return;
//        }
//
//        // process
//        if (leftNum >= rightNum) {
//            // drill down
//            generate(result, leftNum + 1, rightNum, n, currentString + "(");
//            generate(result, leftNum, rightNum + 1, n, currentString + ")");
//        }
//    }

      // DP 1:
//    public List<String> generateParenthesis(int n) {
//        /**
//         * 動態規劃轉移方程
//         * dp[n]="("+dp[m]+")"+dp[k] 其中 m+k = n-1
//         *
//         * dp[0] = ""
//         * dp[1] = "()"
//         * dp[1] = "(())", "()()"
//         * dp[2] = "((()))", "(()())", "()(())", "(())()", "()()()"
//         */
//
//        List<String> list = new ArrayList<>();
//        // terminator
//        if (n == 0) {
//            list.add("");
//            return list;
//        }
//        // process
//        for (int i = 0; i < n; i++) {
//            int k = n - i - 1;
//            // drill down
//            List<String> first = generateParenthesis(i);
//            List<String> second = generateParenthesis(k);
//            // 排列組合，括號放裡面跟放外面的排列組合
//            for (String left : first) {
//                for (String right : second) {
//                    list.add("(" + left + ")" + right);
//                }
//            }
//        }
//        return list;
//    }


//    //DP 2
//    public List<String> generateParenthesis(int n) {
//        /**
//         * 動態規劃轉移方程
//         * dp[k] = dp[k-1] 在最後一個 “(” 後面插入 “()”
//         * dp[0] = "()"
//         */
//        List<String> result  = new LinkedList<String>();
//        List<String>[] dp = new List[n];
//        List<String> dp0 = new ArrayList<String>(1);
//        dp0.add("()");
//        dp[0] = dp0;
//        for(int i = 1 ; i < n ; i++){
//            List<String> tmp = dp[i-1];
//            List newList = new ArrayList<String>();
//            for(String str:tmp){
//                int index = str.lastIndexOf("(");
//                for(int j = index ; j<str.length() ; j++){
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(str.substring(0,j+1));
//                    sb.append("()");
//                    sb.append(str.substring(j+1,str.length()));
//                    newList.add(sb.toString());
//                }
//            }
//            dp[i-1] = null;
//            dp[i] = newList;
//        }
//        return dp[n-1];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
