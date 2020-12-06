//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 
//
// 示例 1： 
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2 
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 379 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Think 1[🚀]: dfs，遍歷數組，每次遇到1就把 group+1，跟島嶼數兩不同的是這個具有傳遞性，
    //          並把與目前1相連的1都設為0，找到未訪問過的位置，則將該 column 帶入 dfs ，最後count就是結果
    //      T.C: O(n^2)，最差情況 陣列皆為 0，整個陣列都要遍歷一次
    //      S.C: O(n)
    // Think 2:並查集，因為自己跟自己一定是朋友，所以對角線都是1，A與Ｂ是朋友，則Ｂ與Ａ一定是朋友，
    //         所以陣列一定是對稱的，所以遍歷一半即可，一開始建立Ｎ個獨立的 group(每個人自己一個 group)，
    //         每次遍歷到1就把他們兩個group 合成一個，最後的 group 數量就是結果
    //      T.C: O(n^3)，遍歷O(n^2)， union(有路徑壓縮) 最差為 O(n)
    //      S.C: O(n)

    // Solution 1:
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[M.length];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i, visited, n, M);
            }
        }

        return count;
    }

    private void dfs(int row, boolean[] visited, int n, int[][] M) {
        for (int j = 0; j < n; j++) {
            // drill down
            if (M[row][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(j, visited, n, M);
            }
        }
    }

    // Solution 2:
//    public int findCircleNum(int[][] M) {
//        int n = M.length;
//        UnionFind union = new UnionFind(n);
//
//        for(int i=0; i<n; i++) {
//            for(int j=1; j<n; j++) {
//                if (M[i][j] == 1 && i != j) {
//                    union.union(i, j);
//                }
//            }
//        }
//
//        return union.getUnionCount();
//    }

    class UnionFind {
        private int count = 0;
        private int[] parenet;

        public UnionFind(int n) {
            parenet = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parenet[i] = i;
            }
        }

        public int find(int p) {
            if (p == parenet[p]) return p;

            while (p != parenet[p]) {
                parenet[p] = parenet[parenet[p]];
                p = parenet[p];
            }

            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            parenet[rootP] = rootQ;
            count--;
        }

        public int getUnionCount() {
            return count;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
