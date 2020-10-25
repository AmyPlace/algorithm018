## 數據結構學習筆記

- 數組 Array

  - 特性

    - 連續的儲存空間，儲存相同類型的資料

    - 可以依據下標計算內存地址隨機訪問資料

    - 大小是固定的

  - 時間複雜度

    - ⭕ 依據下標的查找操作 O(1)

    - ⭕ Prepend、append O(1)
      注意正常情況下 prepend 為 O(n) 但可以進行特殊優化成 O(1)，  
      例如在數組開頭預留空間，prepend 就是把頭下標前一個位置即可

    - ❌ 插入、刪除 O(n)
      (需要搬移數據)

  - 技巧

    - 反轉陣列

    - 雙指針

- 鏈表 Linked list

  - 特性

    - 非連續的儲存空間，串連起來使用

    - ⭕ 支援動態擴容

    - ❌ 容易造成內存碎片

  - 時間複雜度

    - ⭕ 插入、刪除 O(1)

    - ⭕ prepend、append O(1)

    - ❌ 搜尋 O(N)

  - 種類

    - 單向鏈表

      - 最後一個 Node 的 next 指向 null

      - 找到前一個 node, O(n)

    - 雙向鏈表

      - 比單向鏈表佔用更多內存(因為多儲存前一個 node 的 地址)  
        用空間換時間的概念

      - 支援雙向遍歷

      - 找到前一個 node, O(1)

      - 如資料為有序，查找也會比單向鏈表快

      - Java 中的 LinkedHashMap 就是雙向鏈表的實作

    - 循環鏈表

      - 最後一個 Node 的 next 指向 head pointer

      - 適合約瑟夫問題  
        (https://zh.wikipedia.org/wiki/%E7%BA%A6%E7%91%9F%E5%A4%AB%E6%96%AF%E9%97%AE%E9%A2%98)

    - 雙向循環鏈表

  - 常用技巧

    - Dummy Node 哨兵頭節點

      - 作法

        - 建立一個 dummy node 作為頭節點，不包含數據

      - 作用

        - 簡化邊界條件

          - 建立頭節點

          - 刪除的節點是頭節點

        - 針對單向鏈表沒有前向指標的問題，保證鏈表的 head 不會在刪除操作中遺失

    - Fast/slow pointer 快慢指針

      - 應用

        - 尋找鏈表中間節點

          - 設定一個慢指針一次走一步  
                一個快指針一次走兩步  
            當快指針走到鏈表尾時，慢指針剛好在鏈表一半的位置

        - 判斷是否為循環鏈表

          - 當快指針追上慢指針時(fastPtr == slowPtr)，則為循環鏈表

  - 邊界條件

    - 鏈表為空

    - 鏈表只包含1個節點

    - 鏈表只包含2個節點

    - 鏈表處理頭節點或是尾節點時的操作

    - 一般正常業務邏輯

- 跳表 skip list

  - 特性

    - 只能用於元素有序的情況

    - 被用來取代平衡樹和二分查找，例如 Redis、LevelDB

    - 維護成本高，每次新增或是刪除都要更新索引

  - 複雜度

    - 時間

      - ⭕ 插入、刪除、搜索 O(log n)

    - 空間

      - O(N)

  - 概念

    - 升維，空間換時間

  - 補充資料

    - https://zhuanlan.zhihu.com/p/54869087

    - 跳表([https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html](https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html))

    - https://www.zhihu.com/question/20202931

- 棧 Stack

  - 特性

    - 先進後出 FILO，後進先出LIFO

    - 栈是一种“操作受限”的线性表，只允许在一端插入和删除数据。

    - 當數據具有”最近相關性”時，適合用棧來解題

  - 複雜度

    - 時間

      - ⭕ 插入與刪除 O(1)

      - ❌ 搜尋是 O(N)

    - 空間

      - worst O(N)

  - 種類

    - 順序棧

      - 用 array 實作的棧

        - 容量固定

    - 鏈式棧

      - 用鏈表實作的棧

        - 大小可以動態擴容

  - 常見技巧

    - 一個棧 Stack

      - 假设表达式中只包含三种括号，圆括号 ()、方括号[]和花括号{}，并且三種括號可任意嵌套。如何检查字串是否合法呢？

      - 左括號入棧，右括號出棧

    - 兩個棧 Stack

      - 編譯器數學運算
      - 瀏覽器
      - 用 stack 實作 queue

  - 補充資料

    - Stack: (http://developer.classpath.org/doc/java/util/Stack-source.html)

- 隊列 Queue

  - 種類

    - 隊列 Queue

      - 特性

        - 先進先出 FIFO

      - 時間複雜度

        - ⭕ 插入與刪除 O(1)

        - ❌ 搜尋是 O(N)

      - 補充資料

        - Queue: ([http://fuseyism.com/classpath/doc/java/util/Queue-source.html](http://fuseyism.com/classpath/doc/java/util/Queue-source.html))

    - 雙向隊列 deque

      - 特性

        - 可以從頭(head)跟尾(tail)新增(push)或是刪除(pop)資料

        - 簡單理解:兩端可以進出的 Queue

      - 時間複雜度

        - ⭕ 插入與刪除都是 O(1)

        - ⭕ 搜尋是 O(N)

    -   優先權隊列 Priority Queue

        - 特性

          - 依據元素優先權取出元素

          - 底層實作較為多元複雜  
            Ex: Heap、BST、Treap

        - 時間複雜度

          - ⭕ 插入 O(1)

          - ⭕ 取出/刪除是 O(log N)
            按照元素優先其取出

        - 補充資料

          - Java 的 PriorityQueue   
            (https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)

  - 循環隊列

    - 避免數據搬移操作

  - 適合用於  sliding window 題目



## 作業

| Simple | 用 add first 或 add last 这套新的 API 改写 Deque 的代码      | [⭕](./HW/用 add first 或 add last 这套新的 API 改写 Deque 的代码.md) |
| ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
|        | 分析 Queue 和 Priority Queue 的源码                          | 代補                                                         |
|        | [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)（Facebook、字节跳动、微软在半年内面试中考过） | [⭕](./HW/LeetCode/26.删除排序数组中的重复项.java)            |
|        | [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)（亚马逊、字节跳动在半年内面试常考） | [⭕](./HW/LeetCode/21.合并两个有序链表.java)                  |
|        | [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)（Facebook 在半年内面试常考） | [⭕](./HW/LeetCode/[88]合并两个有序数组.java)                 |
|        | [两数之和](https://leetcode-cn.com/problems/two-sum/)（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考） | [⭕](./HW/LeetCode/[1]两数之和.java)                          |
|        | [移动零](https://leetcode-cn.com/problems/move-zeroes/)（Facebook、亚马逊、苹果在半年内面试中考过） | [⭕](./HW/LeetCode/[283]移动零.java)                          |
|        | [加一](https://leetcode-cn.com/problems/plus-one/)（谷歌、字节跳动、Facebook 在半年内面试中考过） | [⭕](./HW/LeetCode/[66]加一.java)                             |
| Medium | [设计循环双端队列](https://leetcode.com/problems/design-circular-deque)（Facebook 在 1 年内面试中考过） | 代補                                                         |
| Hard   | [接雨水](https://leetcode.com/problems/trapping-rain-water/)（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考） | 代補                                                         |