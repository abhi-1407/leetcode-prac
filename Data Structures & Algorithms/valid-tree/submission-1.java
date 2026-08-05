class Solution {
    private void dfs(int node, boolean[] visited, List<Integer>[] graph){
        visited[node] = true;
        for(int adjNode : graph[node]){
            if(visited[adjNode] == false){
                dfs(adjNode,visited,graph);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        int edgesCount = edges.length;
        boolean[] visited = new boolean[n];

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int end1 = edges[i][0];
            int end2 = edges[i][1];

            graph[end1].add(end2);
            graph[end2].add(end1);
        }

        if(edgesCount != n - 1){
            return false;
        }

        dfs(0,visited,graph);

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}
