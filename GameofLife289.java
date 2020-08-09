public class GameofLife289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int[][] help = new int[board.length][board[0].length];
        int[] dirx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] diry = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 1) {
                    for (int d = 0; d < 8; d++) {
                        int x = i + dirx[d];
                        int y = j + diry[d];
                        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                            help[x][y] ++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (help[i][j] < 2 || help[i][j] > 3) {
                        board[i][j] = 0;
                    }
                }
                else {
                    if (help[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
