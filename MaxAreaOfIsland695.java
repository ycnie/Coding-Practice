class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] tempMax = new int[1];
        boolean[][] visited = new boolean[grid.length][ grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, 0, tempMax, visited);
            }
        }
        return tempMax[0];
    }
    
    private int dfs(int[][] grid, int row, int col, int curArea, 
                     int[] tempMax, boolean[][] visited) {
        if (row < 0 || row > grid.length - 1 
            || col < 0 || col > grid[0].length - 1 
            || grid[row][col] == 0 || visited[row][col] == true) {
            return curArea;
        }
        visited[row][col] = true;
        tempMax[0] = Math.max(tempMax[0], curArea + 1);
        int bot = dfs(grid, row + 1, col, curArea + 1, tempMax, visited);
        int top = dfs(grid, row - 1, col, bot, tempMax, visited);
        int right = dfs(grid, row, col + 1, top, tempMax, visited);
        int left = dfs(grid, row, col - 1, right, tempMax, visited);
        return left;
    }
}