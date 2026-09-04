class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = points[i][0];
        }

        java.util.Arrays.sort(x);

        int ans = 0;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, x[i] - x[i - 1]);
        }

        return ans;
    }
}