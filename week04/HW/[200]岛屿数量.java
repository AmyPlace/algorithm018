//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 852 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // Think 1: dfs 深度優先遍歷，遍歷數組，每次遇到 '1' 先將島嶼數量加1，接著遞歸把相鄰的 '1' 都設定為 '0'，即可將相鄰的島嶼都夷平，下次遇到 '1' 表示是新的島嶼
    //     T.C: O(MN)
    //     S.C: O(MN)，最壞 case 是整個島皆為'1'為 1 x MN or NM x 1 的形狀，則 遞歸深度為ＭＮ
    // Think 2: bfs 廣度優先遍歷，遍歷數組，每次遇到 '1' 先將島嶼數量加1，接著遞歸把相鄰的 '1' 都設定為 '0'，即可將相鄰的島嶼都夷平，下次遇到 '1' 表示是新的島嶼
    //     T.C: O(MN)
    //     S.C: O (min(M, N),


    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j< grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    bfsMarking(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
        // terminator
        if (i < 0 || j < 0|| i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // process
        grid[i][j] = '0';
        // drill down
        dfsMarking(grid, i+1, j);
        dfsMarking(grid, i, j+1);
        dfsMarking(grid, i-1, j);
        dfsMarking(grid, i, j-1);
    }

    private void bfsMarking(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();

        int index2D = x * m + y;
        queue.add(index2D);
        while (!queue.isEmpty()) {
            index2D = queue.poll();

            int row = index2D / m;
            int col = index2D % m;
            if (row > 0 && grid[row - 1][col] == '1') {//up
                grid[row - 1][col] = '0';
                queue.add((row - 1) * m + col);
            }
            if (row < n - 1 && grid[row + 1][col] == '1') {//down
                grid[row + 1][col] = '0';
                queue.add((row + 1) * m + col);
            }
            if (col > 0 && grid[row][col - 1] == '1') { //left
                grid[row][col - 1] = '0';
                queue.add(row * m + col - 1);
            }
            if (col < m - 1 && grid[row][col + 1] == '1') {//right
                grid[row][col + 1] = '0';
                queue.add(row * m + col + 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
