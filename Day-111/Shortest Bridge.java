class Solution {
    public int shortestBridge(int[][] grid) {
         int rows = grid.length;
        int cols = grid[0].length;
        
        // Step 1: Find the first island and mark its cells as 2
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }
        
        // Step 2: Expand the first island using BFS and find the shortest path to the second island
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int distance = 0;
        
        // Add the cells of the first island to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        // Perform BFS to find the shortest path to the second island
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                
                for (int[] dir : directions) {
                    int newRow = currRow + dir[0];
                    int newCol = currCol + dir[1];
                    
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 1) {
                            return distance;
                        }
                        
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            
            distance++;
        }
        
        return -1; // In case there is no path between the islands
    }

    private void dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) {
            return;
        }
        
        grid[row][col] = 2;
        
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
    }
}