class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] freq = new int[nums.length + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= nums.length; i++) {
            while (ans.size() < freq[i]) {
                ans.add(new ArrayList<>());
            }

            for (int j = 0; j < freq[i]; j++) {
                ans.get(j).add(i);
            }
        }

        return ans;
    }
}