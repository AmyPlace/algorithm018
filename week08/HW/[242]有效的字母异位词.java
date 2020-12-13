//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 解法 1: 排序，分別排序 s 跟 t ，判斷兩個字符串是否相等
    //        時間複雜度 O(n log n) 空間複雜度O(1)
    // 解法 2: 哈希表，把 char 當作 key (陣列 index)，value 紀錄出現的數量，
    //        遍歷 s 每次對應char 出現就 ++
    //        遍歷 t 每次對應char 出現就 --，最後在遍歷一次判斷值是否皆為0
    //        時間複雜度 O(n) 空間複雜度O(1)

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i)-'a']++;
//            table[t.charAt(i)-'a']--;
//        }
//        for (int count : table) {
//            if (count != 0)
//                return false;
//        }
//
//        return true;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
