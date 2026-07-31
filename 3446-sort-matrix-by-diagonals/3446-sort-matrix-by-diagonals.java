class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int r = i;
            int c = 0;

            while (r < n && c < n) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list, Collections.reverseOrder());

            r = i;
            c = 0;
            int index = 0;

            while (r < n && c < n) {
                grid[r][c] = list.get(index++);
                r++;
                c++;
            }
        }

        for (int j = 1; j < n; j++) {
            ArrayList<Integer> list = new ArrayList<>();

            int r = 0;
            int c = j;

            while (r < n && c < n) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list);

            r = 0;
            c = j;
            int index = 0;

            while (r < n && c < n) {
                grid[r][c] = list.get(index++);
                r++;
                c++;
            }
        }

        return grid;
    }
}