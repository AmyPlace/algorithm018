//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 506 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路 1：排序＋哈希表
    //      時間複雜度：Ｏ(NK log K)，N 是 strs 長度，K 是 strs 中字串最大長度，外圈 for 遍歷為 O(N)，對每個字串做排序 Ｏ(K log K)
    //      空間複雜度：Ｏ(NK)，因為把所有的字串都複製了一遍
    // 思路 2：計數＋哈希表，把計數的結果轉換成字串當作哈希表的 key 值， key 值相同即為同一組字母異位詞
    //      時間複雜度：Ｏ(NK)，N 是 strs 長度，K 是 strs 中字串最大長度，外圈 for 遍歷為 O(N)，對每個字串做計數 Ｏ(K)
    //      空間複雜度：Ｏ(NK)，因為把所有的字串都複製了一遍
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for(String str: strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String sortedStr = String.valueOf(chars);
//
//            if (!map.containsKey(sortedStr)) {
//                map.put(sortedStr, new ArrayList<>());
//            }
//            map.get(sortedStr).add(str);
//        }
//
//        return new ArrayList(map.values());
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
