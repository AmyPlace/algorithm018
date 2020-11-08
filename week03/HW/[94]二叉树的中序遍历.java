//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 761 👎 0


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
    // 因為一定會遍歷所有節點，所以時間複雜度為 O(N)
    // 思路 1: 遞歸，時間複雜度 O(N) 空間複雜度 O(N)
    // 思路 2: 迭代，先用 stack 存入逆序當層節點，為什麼要逆序，因為 stack 的特性是 FILO，LIFO
    //        逆序可以保證每次拿出來的是我們目前遍歷到的節點
    //         時間複雜度 O(N) 空間複雜度 O(N)

    // Solution 1:
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        inorderTraversal(list, root);
//
//        return list;
//    }
//
//    private void inorderTraversal(ArrayList<Integer> list, TreeNode root) {
//        if (root != null) {
//            inorderTraversal(list, root.left);
//            list.add(root.val);
//            inorderTraversal(list, root.right);
//        }
//    }

      // Solution 2:
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if (root == null)
//            return list;
//
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pop();
//                list.add(cur.val);
//                cur = cur.right;
//            }
//        }
//
//        return list;
//    }
//

    // Solution 3: 迭代統一寫法
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                // 將 右中左 加入棧中
                if (node.right != null)  stack.push(node.right); // 右

                stack.push(node);                                //中
                stack.push(null);                                //加入空節點作為標記

                if (node.left != null)  stack.push(node.left);   //左
            } else {
                //遇到 null 節點，表示目前 node 為標記節點，拿出下一個節點加入輸出列表中
                TreeNode cur = stack.pop();
                list.add(cur.val);
            }
        }

        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
