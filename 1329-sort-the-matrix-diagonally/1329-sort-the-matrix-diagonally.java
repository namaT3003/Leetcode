class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            sortDiagonal(mat, i, 0);
        }

        for (int j = 1; j < n; j++) {
            sortDiagonal(mat, 0, j);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        ArrayList<Integer> list = new ArrayList<>();

        int r = row;
        int c = col;

        while (r < mat.length && c < mat[0].length) {
            list.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(list);

        r = row;
        c = col;
        int index = 0;

        while (r < mat.length && c < mat[0].length) {
            mat[r][c] = list.get(index++);
            r++;
            c++;
        }
    }
}