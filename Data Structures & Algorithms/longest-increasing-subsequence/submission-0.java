class Solution {
    private int[][] memo;
    private int helper(int idx,int[] nums, int prevIdx){
        if(idx == nums.length){
            return 0;
        }
        if(memo[idx][prevIdx + 1] != -1){
            return memo[idx][prevIdx + 1];
        }
        int notPick = helper(idx + 1,nums,prevIdx);
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            int pick = 1 + helper(idx + 1,nums,idx);
            return memo[idx][prevIdx + 1] = Math.max(pick,notPick);
        }
        return memo[idx][prevIdx + 1] = notPick;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(0,nums,-1);
    }
}
