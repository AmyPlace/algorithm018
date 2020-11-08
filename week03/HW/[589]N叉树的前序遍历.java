//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // 思路 1[🚀]: 遞歸，時間複雜度 O(N) 空間複雜度 O(N)
    // 思路 2: 迭代，先用 stack 存入逆序當層節點，為什麼要逆序，因為 stack 的特性是 FILO，LIFO
    //        逆序可以保證每次拿出來的是我們目前遍歷到的節點
    //         時間複雜度 O(N) 空間複雜度 O(N)

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> preorderList = new ArrayList<>();

        preorder(preorderList, root);
        return preorderList;
    }

    private void preorder(List<Integer> preorderList, Node root) {
        if (root!= null) {
            preorderList.add(root.val);
            for (Node child : root.children) {
                preorder(preorderList, child);
            }
        }
    }

//    public List<Integer> preorder(Node root) {
//        ArrayList<Integer> preorderList = new ArrayList<>();
//
//        if (root == null) {
//            return preorderList;
//        }
//
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            preorderList.add(node.val);
//            Collections.reverse(node.children);
//            for (Node item : node.children) {
//                stack.push(item);
//            }
//        }
//        return preorderList;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
