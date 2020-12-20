//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 139 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // think 1: 遍歷，判斷大寫 ascii 並加上與小寫的差值
    //      T.C: O(N)
    //      S.C: O(N)
    public String toLowerCase(String str) {
        char[] array = str.toCharArray();
        for (int i = 0 ; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 90)
                array[i] = (char)(array[i] + 32);
        }

        return new String(array);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
