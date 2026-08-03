class Solution {
    int[] dr = {0,1,-1,0};
    int[] dc = {1,0,0,-1};
    private void dfsHelper(int[][] heights,boolean[][] visited, int currX, int currY){
        visited[currX][currY] = true;
        for(int i = 0; i < 4; i++){
            int newX = currX + dr[i];
            int newY = currY + dc[i];
            if(newX < 0 || newY < 0 || newX >= visited.length || newY >= visited[0].length || visited[newX][newY] == true || heights[newX][newY] < heights[currX][currY]){
                continue;
            }
            dfsHelper(heights,visited,newX,newY);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        if(m == 0 && n == 0){
            return ans;
        }

        boolean[][] pacafic = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfsHelper(heights,pacafic,i,0);
            dfsHelper(heights,atlantic,i,n - 1);
        }
        for(int i = 0; i < n; i++){
            dfsHelper(heights,pacafic,0,i);
            dfsHelper(heights,atlantic,m - 1,i);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacafic[i][j] == true && atlantic[i][j] == true){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
