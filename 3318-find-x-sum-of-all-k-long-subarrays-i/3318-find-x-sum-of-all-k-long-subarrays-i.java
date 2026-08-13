class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<Integer> list = new ArrayList<>(freq.keySet());

            list.sort((a, b) -> {
                if (!freq.get(a).equals(freq.get(b))) {
                    return freq.get(b) - freq.get(a);
                }
                return b - a;
            });

            int sum = 0;

            for (int j = 0; j < Math.min(x, list.size()); j++) {
                int num = list.get(j);
                sum += num * freq.get(num);
            }

            ans[i] = sum;
        }

        return ans;
    }
}