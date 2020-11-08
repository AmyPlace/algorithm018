//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 982 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 思路1 : 遞歸，與括號生成相同作法，假如 nums=[1,2,3]，表示總共有3個格子，每個格子都可以填 [1,2,3]3種數字，只是數字要求不重複
    //         terminator: 當陣列長度為 nums 的長度時，表示處理結束
    //         每一層都加入一個數字，每一層都呼叫 3 次 permuteRecr 分別放入 nums 陣列中的所有數字
    //         減枝：判斷如果 list 內有已經包含這次要放入的數字則跳過不做事
    //      T.C: O(N×N!)，其中 N 為 nums 的長度，
    //      一共會呼叫 N! 次的 permuteRecr => O(N!)
    //      每次最後複製資料到列表中在加入 result  => O(N)
    //      時間複雜度為 O(N x N!)
    //      S.C: O(N)，棧的深度為 nums 的長度
    // 思路 2: 回朔遞歸，每一層向下呼叫遞歸時都選擇一個數字加入 path 中，每次呼叫遞歸後，都要恢復原始 path 的狀態，這樣才能確保每個狀態都被遍歷
    //      參數 used 陣列：一個紀錄數字是否已經使用過
    //          path：紀錄目前選擇的 path
    //          nums: 題目陣列
    //          result: 結果陣列
    //      T.C: O(N×N!)
    //      S.C: O(N)

    // Solution 1
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList();
//        permuteRecr(result, nums, new ArrayList());
//        return result;
//    }
//
//    private void permuteRecr(List<List<Integer>> result, int[] nums, List<Integer> current) {
//        // terminator
//        if (current.size() == nums.length) {
//            result.add(current);
//            return;
//        }
//        // process && drill down
//        for(int num: nums) {
//            if (!current.contains(num)) {
//                List<Integer> list = new ArrayList(current);
//                list.add(num);
//                permuteRecr(result, nums, list);
//            }
//        }
//
//        // restore
//    }

    // Solution 2
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, path, used, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] visited,
                     List<List<Integer>> res) {
        // terminator
        // path.size() = depth
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // process
                path.add(nums[i]);
                visited[i] = true;

                // drill down
                // pick one num and go to next layer
                dfs(nums, path, visited, res);
                // 注意：下面這兩行代碼發生 「回溯」，回溯發生在從 深層結點 回到 淺層結點 的過程，代碼在形式上和遞歸之前是對稱的
                // restore
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
