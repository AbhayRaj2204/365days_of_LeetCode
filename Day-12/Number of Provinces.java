class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] graph, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        // dfs on neighbors
        int[] matrix = graph[node];
        for (int i = 0; i < matrix.length; i++) {
            if (i == node) continue;
            if (matrix[i] == 1) {
                // is neighbor
                dfs(graph, i, visited);
            }
        }    
    }
}
    