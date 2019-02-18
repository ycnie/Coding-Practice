class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && visited[row][col] == false) {
                    count++;
                    findAllNeighbors(grid, visited, row, col);
                }
            }
        }
        return count;
    }
    
    private void findAllNeighbors(char[][] grid, boolean[][] visited, int row, int col) {
        if (row == grid.length || col == grid[0].length || row < 0 || col < 0 
            || grid[row][col] == '0' || visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        findAllNeighbors(grid, visited, row + 1, col);
        findAllNeighbors(grid, visited, row, col + 1);
        findAllNeighbors(grid, visited, row - 1, col);
        findAllNeighbors(grid, visited, row, col - 1);
    }
}