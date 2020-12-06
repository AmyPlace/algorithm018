//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 294 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // Think 1: 暴力法，word 遍歷 --> board search
    //       T.C:O(N*m*n+4k) N是有幾個字串，k 是字串長度，m跟n是 board 的length
    // Think 2: 字典樹 Trie，把 words 所有字串建立字典樹，遍歷 board 進行四連通 dfs 判斷字串是字典樹中
    //      T.C:O(M*N*(4*3^(L-1))) L是最長的單詞長度
    //      S.C:O(K)，K是字典中字母的總數
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(result, trie, board, i, j, m, n);
            }
        }

        return result;
    }

    private void dfs(List<String> result, Trie trie, char[][] board, int i, int j, int maxI, int maxJ) {
        // terminator
        if (board[i][j] == '#') return;

        // process
        Trie node = trie.next[board[i][j] - 'a'];
        if (node == null) return;

        if (node.finalWord != null) {
            result.add(node.finalWord);
            node.finalWord = null; //去重，已經加入的就不要再重複加入結果列表
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#'; // 避免往回走 ["a", "a"]
//        int [] x = {-1, 1, 0, 0};
//        int [] y = {0, 0, -1, 1};
//        for (int k=0; k<4; k++) {
//            // drill down
//            dfs(result, node, board, i+x[k], j+y[k], maxI, maxJ);
//        }
        if (i - 1 >= 0)
            dfs(result, node, board, i - 1, j, maxI, maxJ);
        if (i + 1 < maxI)
            dfs(result, node, board, i + 1, j, maxI, maxJ);
        if (j + 1 < maxJ)
            dfs(result, node, board, i, j + 1, maxI, maxJ);
        if (j - 1 >= 0)
            dfs(result, node, board, i, j - 1, maxI, maxJ);

        // restore
        board[i][j] = temp;
    }

    class Trie {
        String finalWord;
        Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            finalWord = null;
            next = new Trie[26];
        }

        // insert ＴC: O(K)，K 字串長度
        // insert SC: O(26*K)，K 字串長度

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;

            Trie current = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int n = chars[i] - 'a';
                if (current.next[n] == null) current.next[n] = new Trie();
                current = current.next[n];
            }

            current.finalWord = word;
        }

        // insert ＴC: O(K)，K 字串長度
        // insert SC: O(1)

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return (node != null) && node.finalWord != null;
        }

        // insert ＴC: O(K)，K 字串長度
        // insert SC: O(1)

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return (node != null);
        }

        // insert ＴC: O(K)，K 字串長度
        // insert SC: O(1)
        public Trie searchPrefix(String word) {
            if (word == null || word.length() == 0) return null;

            Trie node = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                node = node.next[chars[i] - 'a'];
                if (node == null) return null;
            }

            return node;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
