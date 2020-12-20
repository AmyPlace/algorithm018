//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 263 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Think 1: 重後面遍歷並計算擔子字母數量
    //      T.C : O(N)
    //      S.C : O(1)
    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = array.length-1; i>=0; i--) {
            if (array[i] != ' ') {
                count++;
            } else {
                if (count != 0) {
                    break;
                }
            }

        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
