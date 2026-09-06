class Solution {
    public int colorTheGrid(int m, int n) {
        int mod = 1_000_000_007;
        int states = 1;

        for (int i = 0; i < m; i++) {
            states *= 3;
        }

        int[][] colors = new int[states][m];
        int valid = 0;

        for (int mask = 0; mask < states; mask++) {
            int x = mask;
            boolean ok = true;

            for (int i = 0; i < m; i++) {
                colors[mask][i] = x % 3;
                x /= 3;

                if (i > 0 && colors[mask][i] == colors[mask][i - 1]) {
                    ok = false;
                }
            }

            if (ok) valid++;
        }

        int[] validStates = new int[valid];
        int idx = 0;

        for (int mask = 0; mask < states; mask++) {
            boolean ok = true;

            for (int i = 1; i < m; i++) {
                if (colors[mask][i] == colors[mask][i - 1]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                validStates[idx++] = mask;
            }
        }

        long[] dp = new long[valid];

        for (int i = 0; i < valid; i++) {
            dp[i] = 1;
        }

        for (int col = 1; col < n; col++) {
            long[] next = new long[valid];

            for (int i = 0; i < valid; i++) {
                for (int j = 0; j < valid; j++) {
                    boolean ok = true;

                    for (int r = 0; r < m; r++) {
                        if (colors[validStates[i]][r] == colors[validStates[j]][r]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) {
                        next[i] = (next[i] + dp[j]) % mod;
                    }
                }
            }

            dp = next;
        }

        long ans = 0;

        for (long value : dp) {
            ans = (ans + value) % mod;
        }

        return (int) ans;
    }
}