class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] pos = new int[26];

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;

        for (int i = 0; i < t.length(); i++) {
            ans += Math.abs(pos[t.charAt(i) - 'a'] - i);
        }

        return ans;
    }
}