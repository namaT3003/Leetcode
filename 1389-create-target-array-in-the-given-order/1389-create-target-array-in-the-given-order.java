class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ans = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            for (int j = size; j > index[i]; j--) {
                ans[j] = ans[j - 1];
            }

            ans[index[i]] = nums[i];
            size++;
        }

        return ans;
    }
}