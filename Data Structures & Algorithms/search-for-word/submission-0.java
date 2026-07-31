class Solution {
    int[] dx = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    private boolean dfsHelper(int i, int j, char[][] board, boolean[][] visited,int idx,String word){
        if(idx == word.length()){
            return true;
        }
        visited[i][j] = true;
        boolean checkdr = false;
        for(int dr = 0; dr < 4; dr++){
            int newX = dx[dr] + i;
            int newY = dc[dr] + j;
            
            if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length || board[newX][newY] != word.charAt(idx) || visited[newX][newY] == true){
                continue;
            }
            checkdr = (checkdr || dfsHelper(newX,newY,board,visited,idx + 1,word));
        }
        visited[i][j] = false;
        return checkdr;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && board[i][j] == word.charAt(0)){
                    if(dfsHelper(i,j,board,visited,1,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
