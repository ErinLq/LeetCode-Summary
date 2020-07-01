public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        return existWord(board, word, flag, 0, 0, 0);
    }
    public static boolean existWord(char[][] board, String word, boolean[][] flag, int index, int startx, int starty){
        if(index == word.length()) return true;
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};

        char ch = word.charAt(index);
        if(index != 0){
            for(int i = 0; i < 4; i++){
                int x = startx + dirx[i];
                int y = starty + diry[i];
                //check if x,y satisfy the requirement
                if(x >= 0 && y >= 0 && x < board.length && y < board[0].length){
                    if(!flag[x][y] && board[x][y] == ch){
                        flag[x][y] = true;
                        if(existWord(board, word, flag, index + 1, x, y)){
                            return true;
                        }
                        else{
                            flag[x][y] = false;
                        }
                    }
                    else continue;
                }
            }
            return false;
        }
        // if index == 0 or did not find the word, continue search for the first ch
        ch = word.charAt(0);

        int i,j;

        for(i = startx; i < board.length; i++){
            for(j = starty; j < board[0].length; j++){
                if(board[i][j] == ch){
                    flag[i][j] = true;
                    if(existWord(board, word, flag, 1, i, j)) return true;
                    else{
                        flag[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

}
