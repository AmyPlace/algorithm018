学习笔记

- 哈希表 Hash Table

  - 複雜度

    - 時間

      - ⭕ 插入、刪除與搜尋 O(1)

    - 空間

      - worst O(N)

  - 特性

    - 透過哈希函數，把值映射到一個位置(index)  
      較好的哈希函數，可把數據均勻分散到不同的 index

    - 如不同數據分配在同一個index，則稱哈希碰撞(Hash Collisions) 

    - 當哈希衝突太多，就會退化成鏈表，時間複雜度就會變成鏈表的時間複雜度

  - 實際實作的 class

    - HashMap、HashSet

- 紅黑樹 Red-Black Tree

  - 複雜度

    - 時間

      - ⭕ 插入、刪除與搜尋 O(log n)

    - 空間

      - worst O(N)

  - 實際實作的 class

    - TreeMap、TreeSet

- 映射 Map

  - 特性

    - Key-value 對，Key值不重複，value 可重複

    - 根據 key 值直接訪問數據結構

  - 作業

    - 分析 HashMap 的 put()跟get() 函數

- 集合 HashSet

  - 特性

    - 不重複元素的集合

    - 在 java 中底層是用 HashMap 實作，  
      把數據塞在 key 值中，value 則是一個隨意創建的 Object

- 補充資料

  - 笙南(https://blog.csdn.net/weixin_38118016/category_8797369.html)



- 二元搜尋樹 Binary search tree(BST)

  - 特性

    - 空樹也是 BST

    - 左子樹『所有節點』的值均小於他的根節點的值

    - 右子樹『所有節點』的值均大於他的根節點的值

    - 中序遍歷即為升序排列

    - 左右子樹也分別為二元搜尋樹

  - 遍歷

    - 前序(Pre-order) : 根 - 左 - 右

    - 中序(In-order) : 左 - 根 - 右

    - 後序(Post-order) : 左 - 右 - 根

  - 複雜度

    - 時間

      - ⭕ 插入、刪除與搜尋 O(log N)

    - 空間

      - Worst O(N)

  - 常用技巧

    - 前中後遞歸模板

    - 遍歷二叉樹

      - 棧 stack，FILO

        - 深度優先

      - 隊列 queue，FIFO

        - 廣度優先

- 樹 Tree

  - 特性

    - Tree是特殊化的 Graph

    - 沒有環
- 圖 Graph
  - 特性
    - 有點(Vertex)與邊(Edge)
    - 點 Vertex 
      - 度(表示這個點連了多少個邊)
        - 入度
        - 出度
        - 點與點是否相連
    - 邊 Edge
      - 有方向或是無方向性
      - 權重
  - 表示方法
    - 相鄰矩列 Adjacency matrix
    - 相鄰鏈表 Adjacency list
  - 種類
    - 無向(方向)無權(權重)圖
    - 有向無權圖
    - 無向有權圖
    - 有向有權圖
  - 常用技巧
    - 遞歸
      - 深度優先 DFS
      - 廣度優先 BFS
  - 補充資料
    - 拓撲排序(Topological Sorting) https://zhuanlan.zhihu.com/p/34871092
    - 最短路徑 https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158
    - 最小生成樹 https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051
  - LeetCode
    - LC 200 島嶼數量 https://leetcode-cn.com/problems/number-of-islands/



## 作業

| Simple | 写一个关于 HashMap 的小总结。说明：对于不熟悉 Java 语言的同学，此项作业可选做。 | [⭕](./HW/HashMap 小總結.md)                     |
| ------ | ------------------------------------------------------------ | ----------------------------------------------- |
|        | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)（亚马逊、Facebook、谷歌在半年内面试中考过） | [⭕](./HW/LeetCode/[242]有效的字母异位词.java)   |
|        | [N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)（亚马逊在半年内面试中考过） | [⭕](./HW/LeetCode/[95]不同的二叉搜索树 II.java) |
|        | [两数之和](https://leetcode-cn.com/problems/two-sum/)（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考） | [⭕](./HW/LeetCode/[1]两数之和.java)             |
| Medium | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)（亚马逊在半年内面试中常考） | [⭕](./HW/LeetCode/[49]字母异位词分组.java)      |
|        | [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)（亚马逊、字节跳动、微软在半年内面试中考过） | [⭕](./HW/LeetCode/[94]二叉树的中序遍历.java)    |
|        | [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)（字节跳动、谷歌、腾讯在半年内面试中考过 | [⭕](./HW/LeetCode/[144]二叉树的前序遍历.java)   |
|        | [N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)（亚马逊在半年内面试中考过） | 代補                                            |
|        | [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)（字节跳动在半年内面试中考过） | 代補                                            |
|        | [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)（亚马逊在半年内面试中常考 | 代補                                            |