//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 684 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //思路 1[🚀]: 遞歸，每一層依據 level 值取得對應的 list，再把當前節點的值放入 list 中
    //       時間複雜度： O(N) 因為遍歷所有節點
    //       空間複雜度： 正常為 O(log N)，但當樹退化成鏈表時為 O(N)
    //思路 2[🚀]: 迭代/廣度優先遍歷 (queue)，把每一層的節點先放入一個 list，再將這個 list 加到 result 列表後端
    //       時間複雜度：O(N)，因為會遍歷所有節點
    //       空間複雜度：O(N)，最後一層的節點數約等於N/2 => O(N/2) = O(N)

    // Solution 1:
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList();
//
//        //max, level, param
//        levelOrder(result, root, 0);
//
//        return result;
//    }
//
//    public void levelOrder(List<List<Integer>> list, TreeNode root, int level) {
//        // terminator
//        if (root == null) return;
//
//        // process
//        if (list.size() <= level) {
//            list.add(new ArrayList());
//        }
//
//        list.get(level).add(root.val);
//        //drill down
//        if (root.left != null) levelOrder(list, root.left, level+1);
//        if (root.right != null) levelOrder(list, root.right, level+1);
//
//        // restore
//    }

    // Solution 2:
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            ArrayList levelList = new ArrayList();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                levelList.add(node.val);
            }
            result.add(levelList);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
