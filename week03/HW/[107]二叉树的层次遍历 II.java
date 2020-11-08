//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //思路 1[🚀]: 遞歸，每一層依據 level 值取得對應的 list，再把當前節點的值放入 list 中，最後在 reverse 結果列表，讓他由下而上排列
    //       時間複雜度： O(N) 因為遍歷所有節點
    //       空間複雜度： 正常為 O(log N)，但當樹退化成鏈表時為 O(N)
    //思路 2: 迭代/深度優先遍歷 (stack)
    //       時間複雜度：O(N)，因為會遍歷所有節點
    //       空間複雜度：O(N)，一般情況下，為 log(N) 棧的深度，但是當二叉樹為一條鏈時，棧深度會達到 O(N)
    //思路 3[🚀]: 迭代/廣度優先遍歷 (queue)，把每一層的節點先放入一個 list，再將這個 list 插入 result 列表的第 0 個位置
    //       時間複雜度：O(N)，因為會遍歷所有節點
    //       空間複雜度：O(N)，最後一層的節點數約等於N/2 => O(N/2) = O(N)

//    // Solution 1:
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        // level, max_level, param
//        levelOrderBottom(result, root, 0);
//        Collections.reverse(result);
//
//        return result;
//    }
//
//    private void levelOrderBottom(List<List<Integer>> list, TreeNode root, int level) {
//        // terminator
//        if (root == null) {
//            return;
//        }
//
//        // process
//        if (list.size() <= level) {
//            list.add(new ArrayList());
//        }
//        list.get(level).add(root.val);
//
//        // drill down
//        levelOrderBottom(list, root.left, level+1);
//        levelOrderBottom(list, root.right, level+1);
//
//        // restore current status
//    }

    // Solution 2:
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (root != null) {
//            Stack<Pair<TreeNode, Integer>> stack = new Stack();
//            stack.push(new Pair(root, 0));
//
//            while (!stack.isEmpty()) {
//                Pair<TreeNode, Integer> pair = stack.pop();
//
//                if (pair != null) {
//                    TreeNode node = pair.getKey();
//                    if (node.right != null) stack.push(new Pair(node.right, pair.getValue() + 1));
//                    if (node.left != null) stack.push(new Pair(node.left, pair.getValue() + 1));
//
//                    stack.push(pair);
//                    stack.push(null);
//                } else {
//                    Pair<TreeNode, Integer> cur = stack.pop();
//                    TreeNode node = cur.getKey();
//                    int level = cur.getValue();
//
//                    if (result.size() <= level) {
//                        result.add(new ArrayList());
//                    }
//                    result.get(level).add(node.val);
//                }
//            }
//
//            Collections.reverse(result);
//        }
//
//        return result;
//    }

    // Solution 3:
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
                size--;
            }
            result.add(0, list);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
