//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 395 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // 思路 1:遞歸 DFS，每個非葉子節點的左子樹與右子樹高度做比較取得最小高度 + 1 ＝ 最小深度
    //      T.C: O(N) 每個節點都要遍歷
    //      S.C: O(N) 樹的高度，一般為 O(log N)最差情況為 O(N)
    // 思路 2[🚀]:迭代 BFS，使用層序遍歷，當找到第一個葉子節點即取得最小深度
    //      T.C: O(N) 最差情況是每個節點都要遍歷
    //      S.C: O(N) 取決於 queue 儲存當層節點的個數，
    //                最差情況應該是最後一層且葉子節點是滿的狀況節點數量是 O(N/2) => O(N)
    // 思路 3:遞歸，使用層序遍歷，當找到第一個葉子節點即取得最小深度
    //      T.C: O(N) 每個節點都要遍歷
    //      S.C: O(N) 樹的高度，一般為 O(log N)最差情況為 O(N)

//    另外这道题的关键是搞清楚递归结束条件
//
//    叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
//    当 root 节点左右孩子都为空时，返回 1
//    当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
//    当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
//
//    作者：reals
//    链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    // Solution 1:
//    public int minDepth(TreeNode root) {
//        // terminator
//        if (root == null) return 0;
//        //葉子節點的終止條件
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        // process & drill down
//        int depth = Integer.MAX_VALUE;
//        if (root.left != null)
//            depth = Math.min(minDepth(root.left), depth);
//        if (root.right != null)
//            depth = Math.min(minDepth(root.right), depth);
//
//        return depth + 1;
//    }

    // Solution 2:
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                // find first leaf node
                if (node.left == null && node.right == null) {
                    return ++depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            depth++;
        }

        return depth;
    }

    // Solution 3:
//    int minLevel = Integer.MAX_VALUE;
//    public int minDepth(TreeNode root) {
//        TreeNode dummy = new TreeNode(0);
//        dummy.left = root;
//
//        minDepth(dummy, 0);
//
//        return minLevel;
//    }
//    private void minDepth(TreeNode root, int level) {
//        // terminator
//        if (root == null || (root.left == null && root.right == null)) {
//            minLevel = Math.min(minLevel, level);
//            return;
//        }
//
//        if (level < minLevel) {
//            // process & drill down
//            if (root.left != null)
//                minDepth(root.left, level + 1);
//            if (root.right != null)
//                minDepth(root.right, level + 1);
//        }
//        //
//        // restore
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
