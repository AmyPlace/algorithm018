//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 106 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 思路 1：二叉樹層序迭代，每一層找最大值存入 result 列表中
    //     T.C: O(N)
    //     S.P: O(N)
    // 思路 2[🚀]：二叉樹前序遞歸，每一層找到最大值就取代 result 列表中的值
    //     T.C: O(N)
    //     S.P: O(log N)
    // 思路 3：二叉樹前序迭代，每一層找到最大值就取代 result 列表中的值
    //     T.C: O(N)
    //     S.P: O(N)
    // Solution 1:
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            int max = Integer.MIN_VALUE;
//            while(size-- > 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) { queue.offer(node.left); }
//                if (node.right != null) { queue.offer(node.right); }
//
//                if (max < node.val) max = node.val;
//            }
//            result.add(max);
//        }
//
//        return result;
//    }

    // Solution 2:
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recur(result, root,0);

        return result;
    }
    // max, level, param
    private void recur(List<Integer> result, TreeNode root, int level) {
        // terminator
        if (root == null) {
            return;
        }

        // process
        if (result.size() <= level) { result.add(root.val); }

        // drill down
        if (result.get(level) < root.val) {
            result.set(level, root.val);
        }

        //restore
        recur(result, root.left, level+1);
        recur(result, root.right, level+1);
    }

    // Solution 3:
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new Pair(root, 0));
//
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//
//            if (pair != null) {
//                TreeNode node = pair.getKey();
//                int level = pair.getValue();
//
//                if (node.left != null) { stack.push(new Pair(node.left, level+1)); }
//                if (node.right != null) { stack.push(new Pair(node.right, level+1)); }
//
//                if (result.size() <= level) {
//                    result.add(node.val);
//                } else if (result.get(level) < node.val) {
//                    result.set(level, node.val);
//                }
//            }
//        }
//
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
