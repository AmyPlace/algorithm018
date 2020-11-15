//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 539 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路 1: 二分查找，每次取左右平均值平方後與 題目傳入的 x 比較大小，比 x 大表示目標在左邊=>移動 right，
    //                                                        比 x 小表示目標在右邊=>移動 left
    //    T.C: O(log n) 二分的次數，
    //    S.C: O(1) 只有用幾個常數變量
    // 思路 2: 牛頓法，切線逼近法，原理：https://blog.csdn.net/ccnt_2012/article/details/81837154
    //    T.C: O(log n)，此方法是二次收斂的，相較於二分查找更快。
    //    S.C: O(1) 只有用幾個常數變量
    // 思路 3: 袖珍計算器法，x^(1/2) = (e^ln x)^(1/2) = e^(0.5 * ln x)
    //    T.C: O(1)
    //    S.C: O(1)

    // Solution 1
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while(left <= right) {
            long mid = left + ((right-left) >> 1);
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)(left - 1);
    }

//    // Solution 2
//    public int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//
//        double C = x, x0 = x;
//        while (true) {
//            double xi = 0.5 * (x0 + C / x0);
//            if (Math.abs(x0 - xi) < 1e-7) {
//                break;
//            }
//            x0 = xi;
//        }
//        return (int) x0;
//    }
//
//
//    // Solution 3
//    public int mySqrt(int x) {
//        int l = 0, r = x, ans = -1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if ((long) mid * mid <= x) {
//                ans = mid;
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return ans;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
