//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 476 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    boolean isEnd = false;
    Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    // insert ＴC: O(K)，K 字串長度
    // insert SC: O(26*K)，K 字串長度
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0) return;

        Trie current = this;
        char[] chars = word.toCharArray();
        for (int i=0; i<chars.length; i++) {
            int n = chars[i]-'a';
            if (current.next[n] == null) current.next[n] = new Trie();
            current = current.next[n];
        }

        current.isEnd = true;
    }

    // insert ＴC: O(K)，K 字串長度
    // insert SC: O(1)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return (node != null) && node.isEnd;
    }

    // insert ＴC: O(K)，K 字串長度
    // insert SC: O(1)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return (node != null);
    }

    // insert ＴC: O(K)，K 字串長度
    // insert SC: O(1)
    private Trie searchPrefix(String word) {
        if(word == null || word.length() == 0) return null;

        Trie node = this;
        char[] chars = word.toCharArray();
        for (int i=0; i<chars.length; i++) {
            node = node.next[chars[i]-'a'];
            if (node == null) return null;
        }

        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
