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
    // 思路 1: 遞歸, 每進一層加一個左括號或右括號，直到左與右括號樹等於 n

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
}
//leetcode submit region end(Prohibit modification and deletion)
