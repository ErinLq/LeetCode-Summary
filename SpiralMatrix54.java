import java.util.*;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        boolean[][] reached = new boolean[matrix.length][matrix[0].length];

        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};

        int n = 0;
        int x = 0, y = 0;

        //turning
        while ((x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) && !reached[x][y]) {
            //keep moving forward
            while ((x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) && !reached[x][y]){
                res.add(matrix[x][y]);
                reached[x][y] = true;
                x = x + dirx[n];
                y = y + diry[n];
            }
            x -= dirx[n];
            y -= diry[n];
            n = (n + 1) % 4;
            x = x + dirx[n];
            y = y + diry[n];
        }

        return res;
    }

}
