class Solution {
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    private void dfsHelper(char[][] grid, boolean[][] visited, int startX, int startY){
        visited[startX][startY] = true;
        for(int i = 0; i < 4; i++){
            int newX = dr[i] + startX; 
            int newY = dc[i] + startY;
            if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || visited[newX][newY] == true ||grid[newX][newY] == '0'){
                continue;
            }
            dfsHelper(grid,visited,newX,newY);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    dfsHelper(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
