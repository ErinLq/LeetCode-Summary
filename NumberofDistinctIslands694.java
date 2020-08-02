import java.util.HashSet;

public class NumberofDistinctIslands694 {

    public static int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        int[][] dir = new int[][]{{1,0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder s = new StringBuilder();
                    getIsland(grid, dir, i, j, i , j, s);
                    set.add(s.toString());
                }
            }
        }
        return set.size();
    }

    public static void getIsland(int[][] grid, int[][] dir, int i, int j, int offx, int offy, StringBuilder s) {
        s.append(i - offx).append(",").append(j - offy);
        grid[i][j] = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                getIsland(grid, dir, x, y, offx, offy, s);
            }
        }
    }

}
