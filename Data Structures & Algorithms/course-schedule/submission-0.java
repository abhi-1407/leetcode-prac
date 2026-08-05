class Solution {
    private boolean isCycle(List<Integer>[] graph,int currNode, boolean[] visited,boolean[] pathVisited){
        visited[currNode] = true;
        pathVisited[currNode] = true;

        for(int adjNode : graph[currNode]){
            if(visited[adjNode] == true && pathVisited[adjNode] == true){
                return true;
            }else if(visited[adjNode] == false){
                if(isCycle(graph,adjNode,visited,pathVisited)){
                    return true;
                }
            }
        }

        pathVisited[currNode] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            graph[start].add(end);
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == false && isCycle(graph,i,visited,pathVisited)){
                return false;
            }
        }
        return true;
    }
}
