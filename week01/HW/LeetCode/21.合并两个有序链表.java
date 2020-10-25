import java.util.List;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //  解法 1: 迭代，沒有哨兵            時間複雜度 O(m+n) 空間複雜度O(1)
    //  解法 2: 迭代，有哨兵，簡化邊界條件  時間複雜度 O(m+n) 空間複雜度O(1)
    //  解法 3: 遞歸                    時間複雜度 O(m+n) 空間複雜度O(m+n)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1; 
        else {
            // dummy node
            ListNode head = new ListNode();
            ListNode current = head;

            while((l1 != null) || (l2 != null)) {
                if (l1 == null) {
                    current.next = l2;
                    break;
                } else if (l2 == null) {
                    current.next = l1;
                    break;
                } else {
                    if (l1.val >= l2.val) {
                        current.next = l2;
                        l2 = l2.next;
                    } else {
                        current.next = l1;
                        l1 = l1.next;
                    }
                }
                current = current.next;
            }

            return head.next;
        }
    }


    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) {
    //         return l2;
    //     }
    //     else if (l2 == null) {
    //         return l1;
    //     }
    //     else if (l1.val < l2.val) {
    //         l1.next = mergeTwoLists(l1.next, l2);
    //         return l1;
    //     }
    //     else {
    //         l2.next = mergeTwoLists(l1, l2.next);
    //         return l2;
    //     }
    // }
}
// @lc code=end

