//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 147 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Think 1: HashTable + 計數排序
    //       T.C: O(N log N)
    //       S.C: O(N)，N 為 arr1 元素數量
    // Think 2[🚀]: 計數排序
    //       T.C: O(N)
    //       S.C: O(M)，M 為 arr1 最大元素 + 1 ，這邊題目數值不會超過 1000
    // Solution 1:
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
//        Arrays.sort(arr1);
//
//        for (int num : arr1) {
//            Integer value = map.get(num);
//            value = (value == null) ? 1 : (value + 1);
//            map.put(num, value);
//        }
//
//        int index = 0;
//        for (int num : arr2) {
//            Integer count = map.get(num);
//            while (count-- > 0) {
//                arr1[index++] = num;
//            }
//            map.remove(num);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int count = entry.getValue();
//            while (count-- > 0)
//                arr1[index++] = entry.getKey();
//        }
//        return arr1;
//    }

    // Solution 2:
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int data : arr1) {
            bucket[data]++;
        }

        int index = 0;
        for (int data : arr2) {
            while (bucket[data]-- > 0)
                arr1[index++] = data;
        }

        for (int i = 0; i < 1001; i++) {
            while (bucket[i]-- > 0)
                arr1[index++] = i;
        }
        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
