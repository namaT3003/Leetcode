class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        if (nums[a] != nums[b]) {
            return Integer.compare(nums[a], nums[b]);
        }
            return Integer.compare(a, b);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }

        while (k-- > 0) {
            int i = pq.poll();
            nums[i] *= multiplier;
            pq.offer(i);
        }

        return nums;
    }
}