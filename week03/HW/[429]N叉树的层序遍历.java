//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 117 👎 0


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
    // 思路1[🚀]: 遞歸
    //       時間複雜度：Ｏ(N)
    //       空間複雜度：正常情況是Ｏ(log N)，最壞情況Ｏ(N)，空間複雜度為棧的深度
    // 思路2：DFS 迭代，Stack
    //       時間複雜度：Ｏ(N)
    //       空間複雜度：正常情況是Ｏ(log N)，最壞情況Ｏ(N)，空間複雜度為棧的深度
    // 思路3：BFS 迭代，Queue
    //       時間複雜度：Ｏ(N)
    //       空間複雜度：Ｏ(N)，最壞情況Ｏ(N/number of children)=>O(N)，最後一層的葉子節點都是滿的情況

//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (root != null) {
//            levelOrder(list, root, 0);
//        }
//
//        return list;
//    }
//
//    private void levelOrder(List<List<Integer>> list, Node node, int level) {
//        if (list.size() <= level) {
//            list.add(new ArrayList<>());
//        }
//        list.get(level).add(node.val);
//        for(Node child : node.children) {
//            levelOrder(list, child, level+1);
//        }
//    }

//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        if (root == null)
//            return list;
//
//        Stack<Pair<Node, Integer>> stack = new Stack<>();
//        stack.push(new Pair(root, 0));
//
//        while (!stack.isEmpty()) {
//            Pair<Node, Integer> pair = stack.pop();
//
//            if (pair != null) {
//                Node node = pair.getKey();
//                int level = pair.getValue();
//
//                Collections.reverse(node.children);
//                for (Node child : node.children) {
//                    stack.push(new Pair(child, level+1));
//                }
//                stack.push(pair);                                //中
//                stack.push(null);                                //加入空節點作為標記
//            } else {
//                //遇到 null 節點，表示目前 node 為標記節點，拿出下一個節點加入輸出列表中
//                Pair<Node, Integer> cur = stack.pop();
//                Node curNode = cur.getKey();
//                int curLevel = cur.getValue();
//                if(list.size() <= curLevel) {
//                    list.add(new ArrayList());
//                }
//                list.get(curLevel).add(curNode.val);
//            }
//        }
//
//        return list;
//    }


    // Solution 3:
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result = new ArrayList();
//        if (root == null) return result;
//
//        Queue<Node> queue = new LinkedList();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            List<Integer> list = new ArrayList();
//            while (size > 0) {
//                Node node = queue.poll();
//
//                for (Node child : node.children) {
//                    queue.offer(child);
//                }
//                list.add(node.val);
//                size--;
//            }
//            result.add(list);
//        }
//
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
