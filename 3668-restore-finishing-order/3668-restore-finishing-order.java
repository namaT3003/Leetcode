class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
                HashSet<Integer> set = new HashSet<>();

        for (int friend : friends) {
            set.add(friend);
        }

        int[] ans = new int[friends.length];
        int index = 0;

        for (int num : order) {
            if (set.contains(num)) {
                ans[index++] = num;
            }
        }

        return ans;
    }
}