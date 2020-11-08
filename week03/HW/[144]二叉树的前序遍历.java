//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 441 👎 0


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

    // 思路 1[🚀]: 遞歸
    //        時間複雜度 O(N)：因為會遍歷所有節點
    //        空間複雜度 O(N)：一般情況下，為 log(N) 棧的深度，但是當二叉樹為一條鏈時，棧深度會達到 O(N)
    // 思路 2: 迭代，先用 stack 存入逆序當層節點，為什麼要逆序，因為 stack 的特性是 FILO，LIFO
    //        逆序可以保證每次拿出來的是我們目前遍歷到的節點
    //         時間複雜度 O(N)：因為會遍歷所有節點
    //         空間複雜度 O(N)：一般情況下，為 log(N) 棧的深度，但是當二叉樹為一條鏈時，棧深度會達到 O(N)
    // 思路 3: 迭代，前中後序統一迭代法
    //         時間複雜度 O(N)：因為會遍歷所有節點
    //         空間複雜度 O(N)：一般情況下，為 log(N) 棧的深度，但是當二叉樹為一條鏈時，棧深度會達到 O(N)

    // Solution 1:
    private void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list, root);

        return list;
    }


    // Solution 2:
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        if (root == null) return list;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            list.add(node.val);
//
//            if (node.right != null) stack.push(node.right);
//            if (node.left != null) stack.push(node.left);
//        }
//
//        return list;
//    }

//    // Solution 3: 迭代統一寫法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if (root == null)
//            return list;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (node != null) {
//                // 將 右左中 加入棧中
//                if (node.right != null)  stack.push(node.right); //右
//                if (node.left != null)  stack.push(node.left);   //左
//
//                stack.push(node);                                //中
//                stack.push(null);                                //加入空節點作為標記
//            } else {
//                //遇到 null 節點，表示目前 node 為標記節點，拿出下一個節點加入輸出列表中
//                TreeNode cur = stack.pop();
//                list.add(cur.val);
//            }
//        }
//
//        return list;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
