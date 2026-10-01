class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int top = 0; top < m; top++) {
            int[] sum = new int[n];

            for (int bottom = top; bottom < m; bottom++) {
                for (int col = 0; col < n; col++) {
                    sum[col] += matrix[bottom][col];
                }

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int prefix = 0;

                for (int x : sum) {
                    prefix += x;
                    ans += map.getOrDefault(prefix - target, 0);
                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
                }
            }
        }

        return ans;
    }
}