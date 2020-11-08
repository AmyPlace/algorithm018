//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 821 👎 0


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
    // 思路 1[🚀]: 透過中序遍歷數值為由小到大排序的特性，驗證是否為有效二叉樹
    //      T.C:O(N) 必須遍歷每個節點，才能確認是有效二叉樹
    //      S.P:O(N) 一般來說是 O(log N)，最差情況退化成鏈表是 O(N)

    // 思路 2[🚀]: 遞歸，透過二叉搜索樹的定義
    //      T.C:O(N) 必須遍歷每個節點，才能確認是有效二叉樹
    //      S.P:O(N) 一般來說是 O(log N)，最差情況退化成鏈表是 O(N)

    // 思路 3: 迭代，透過中序遍歷數值為由小到大排序的特性，驗證是否為有效二叉樹

    // Solution 1:
    int preValue = -1;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if(!isValidBST(root.left)) {
                return false;
            }

            if (preValue != -1 && root.val <= preValue) {
                return false;
            }
            preValue = root.val;

            return isValidBST(root.right);
        }
        return true;
    }

//    // Solution 2
//    public boolean isValidBST(TreeNode root) {
//        return isBST(root, null, null);
//    }
//
//    private boolean isBST(TreeNode root, Integer lower, Integer upper) {
//        // terminator
//        if (root == null) {
//            return true;
//        }
//        // process
//        if (lower != null && root.val <= lower) return false;
//        if (upper != null && root.val >= upper) return false;
//
//        // drill down
//        return isBST(root.right, root.val, upper) &&
//                isBST(root.left, lower, root.val);
//    }

//    // Solution 3:
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//
//        Stack<TreeNode> stack = new Stack();
//        stack.push(root);
//        Integer preValue = null;
//
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (node != null) {
//                if (node.right != null) stack.push(node.right);
//
//                stack.push(node);
//                stack.push(null);
//
//                if (node.left != null) stack.push(node.left);
//            } else {
//                TreeNode cur = stack.pop();
//                if (preValue != null && preValue >= cur.val) {
//                    return false;
//                }
//                preValue = cur.val;
//            }
//        }
//
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
