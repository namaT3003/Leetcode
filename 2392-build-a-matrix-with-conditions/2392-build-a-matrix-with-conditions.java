class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(k, rowConditions);
        List<Integer> colOrder = topoSort(k, colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }

        int[][] ans = new int[k][k];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            colPos[colOrder.get(i)] = i;
        }

        for (int i = 0; i < k; i++) {
            ans[i][colPos[rowOrder.get(i)]] = rowOrder.get(i);
        }

        return ans;
    }

    private List<Integer> topoSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];

        for (int i = 0; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[k + 1];

        for (int[] edge : conditions) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int next : graph[node]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (order.size() != k) {
            return null;
        }

        return order;

    }
}