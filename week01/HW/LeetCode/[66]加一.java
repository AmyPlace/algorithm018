//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 565 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    // 思路1: 用 stack 來做，先把資料全部推到棧中，然後把最後一個位數拿出來+1並判斷是否進位。
    //       Time Complexity: O(n)
    //       Space Complexity: O(n)
    // 思路2: 把狀況分為2個部分情況，最大位數是否進位，
    //        如需要進位，則數組需要擴容，且新增的位數值一定為1
    //        如果不需要進位，則透過原數組進行運算
    //        由右往左遍歷，如果最後一位遇到 9 則持續進位，直到遇到小於9 的數值
    //        Time Complexity: O(n)
    //        Space Complexity: O(1)

//    // Solution 1:
//    public int[] plusOne(int[] digits) {
//        Stack stack = new Stack();
//
//        int length = digits.length;
//        for(int digit: digits) {
//            stack.push(digit);
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        boolean needToPlue = true;
//        while(!stack.empty()) {
//            int value = (int)stack.pop();
//            if (needToPlue) {
//                value++;
//                needToPlue = (value == 10);
//            }
//
//            if (needToPlue) {
//                list.add(0, 0);
//                if (stack.empty()) {
//                    list.add(0, 1);
//                }
//            } else {
//                list.add(0, value);
//            }
//        }
//
//        return buildIntArray(list);
//
//    }

//    private int[] buildIntArray(List<Integer> integers) {
//        int[] ints = new int[integers.size()];
//        int i = 0;
//        for (Integer n : integers) {
//            ints[i++] = n;
//        }
//        return ints;
//    }


    // Solution 2:
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
