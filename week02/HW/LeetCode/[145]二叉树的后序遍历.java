//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 470 👎 0


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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        postOrder(list, root);
//
//        return list;
//    }
//
//    private void postOrder(ArrayList<Integer> list, TreeNode root) {
//        if (root == null) return;
//
//        postOrder(list, root.left);
//        postOrder(list, root.right);
//        list.add(root.val);
//    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if (root == null) return list;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            list.add(node.val);
//            if(node.left != null) stack.push(node.left);
//            if(node.right != null) stack.push(node.right);
//        }
//        Collections.reverse(list);
//        return list;
//    }

    // Solution 3: 迭代統一寫法
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                // 將 中右左 加入棧中
                stack.push(node);                                //中
                stack.push(null);                                //加入空節點作為標記

                if (node.right != null)  stack.push(node.right); //右
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
