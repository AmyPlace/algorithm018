//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 431 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if (k == 0) return result;

        List<Integer> path = new ArrayList();
        boolean[] visited = new boolean[n];
        int [] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = i+1;
        }

        recu(result, nums, path, visited, k, 0);

        return result;
    }


    private void recu(List<List<Integer>> result, int[] nums, List<Integer> path, boolean[] visited, int maxLen, int lastPrev) {
        if (path.size() == maxLen) {
            result.add(new ArrayList(path));
            return;
        }

        int size = nums.length - maxLen + 1 + path.size();
        for (int i=path.size(); i<size; i++) {
            int pathSize = path.size();
            if (!visited[i] && lastPrev < nums[i]) {
                path.add(nums[i]);
                visited[i] = true;

                recu(result, nums, path, visited, maxLen, nums[i]);

                visited[i] = false;
                path.remove(path.size()-1);

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
