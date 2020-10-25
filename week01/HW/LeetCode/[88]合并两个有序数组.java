//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 670 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 思路 1: 先把 nums2 陣列複製到 nums1 的尾端，在調用 java sort api -> Arrays.sort(nums1)
    //       Time Complexity: O((m+n)log(m+n))
    //       Space Complexity: O(1)
    // 思路 2: 配置 m 的空間複製 nums1 的數值，雙指針由前往後，兩個指針分別指向 nums1 和 nums2 的開頭位置
    //        開始遍歷，值較小者則把數值覆值到當前遍歷的 index 位置中
    //       Time Complexity: O(m+n)
    //       Space Complexity: O(m)
    // 思路 3: 雙指針由後往前，兩個指針分別指向 nums1 的 index = m-1 和 nums2 的 index = n-1 的位置
    //        由後遍歷， 值較大者則把數值覆值到當前遍歷的 index 位置中
    //       Time Complexity: O(m+n)
    //       Space Complexity: O(1)
    // Solution 3
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;
        
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

//    // Solution 1:
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
//    }
//
//    // Solution 2:
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int [] nums1_copy = new int[m];
//        System.arraycopy(nums1, 0, nums1_copy, 0, m);
//
//        int p1 = 0;
//        int p2 = 0;
//
//        // Set pointer for nums1
//        int p = 0;
//
//        // Compare elements from nums1_copy and nums2
//        // and add the smallest one into nums1.
//        while ((p1 < m) && (p2 < n))
//            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
//
//        // if there are still elements to add
//        if (p1 < m)
//            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
//        if (p2 < n)
//            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
