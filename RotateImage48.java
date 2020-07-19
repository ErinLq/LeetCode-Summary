public class RotateImage48 {
    public static void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length || matrix.length == 1) return;

        int temp = 0;
        int n = matrix.length;

        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = i; j < n - 1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] b = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] m = new int[][]{{1,2,3,1},{4,5,6,2},{7,8,9,4},{5,7,3,7}};
        rotate(m);
        rotate(b);
        for(int[] n : b){
            for(int a : n){
                System.out.print(a);
            }
            System.out.print("\n");
        }
    }
}
