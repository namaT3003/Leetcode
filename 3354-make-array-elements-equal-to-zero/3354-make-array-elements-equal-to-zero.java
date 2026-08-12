class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        
        for (int num : nums) {
            total += num;
        }

        int left = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            left += nums[i];

            if (nums[i] == 0) {
                int right = total - left;

                if (left == right) {
                    ans += 2;
                } else if (Math.abs(left - right) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}