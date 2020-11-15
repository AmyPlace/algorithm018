//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 791 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 思路 1: 哈希表，紀錄每個數字出現的次數
    //    T.C: O(n)，每一個數字都要紀錄過
    //    S.P: O(n)，HashMap 最多會有 N/2 => O(N/2) = O(N)
    // 思路 2: 排序，因為題目說一定會有一個數字數量大於 n/2，所以 index = n/2 一定為最多數量的那個數值
    //    T.C: O(n log n)，排序演算法的時間複雜度
    //    S.P: O(log n)，依據不同的排序演算法值會有不同
    // Think 3[🚀]: 摩尔投票法，把當前的數字當為候選人，並設定數量為1，遍歷後面的元素，如果是相同的數字，則數量加1，反之數量減1
    //          當數量變成 0 時就換更換候選人為當前的數字，遍歷一遍最後的候選人就是眾數
    //    T.C: O(n)
    //    S.P: O(1)
     // Think 4: 分治，將資料一直分成兩區，直到最後剩下1個，直到兩區剩下一個數值各自回傳該數字，如果左右兩邊數字相同直接回傳該數字，
    //                不同就從目前的 range 中計算各自的數量回傳較多數量的數字
    //    T.C: O(n log n)，每一層會各自遍歷自己區間內的所有元素，所以 O(N)，總共有 log n 層 => O(n log n)
    //    S.P: O(log n)，總共有 log n 層

    // Solution 1:
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int max = 0;
//        int currentKey = 0;
//        for (int i=0; i<nums.length; i++) {
//            int cnt = 1;
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], cnt);
//            } else {
//                cnt = map.get(nums[i]);
//                map.put(nums[i], ++cnt);
//            }
//
//            if (cnt > max) {
//                max = cnt;
//                currentKey = nums[i];
//            }
//        }
//
//        return currentKey;
//    }


    // Solution 2:
//    public int majorityElement(int[] nums) {
//        int size = nums.length;
//        Arrays.sort(nums);
//        return nums[size/2];
//    }

    // Solution 3:
//    public int majorityElement(int[] nums) {
//        int candidate = nums[0], count = 1;
//        for (int i = 1; i < nums.length; ++i) {
//            if (count == 0) {
//                candidate = nums[i];
//                count = 1;
//            } else if (nums[i] == candidate) {
//                count++;
//            } else{
//                count--;
//            }
//        }
//        return candidate;
//    }


    // Solution 4:
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
