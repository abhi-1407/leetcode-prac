class Solution {
    List<List<Integer>> ans;
    private void dfs(int start, int[] candidates, int target, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if( i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i],temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        ans = new ArrayList<>();
        dfs(0,candidates,target,new ArrayList<>());
        return ans;

    }
}
