class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void helper(int[] nums, int target,int idx,List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }   
        if(target < 0){
            return;
        }
        if(idx < 0){
            return;
        }
        if(nums[idx] <= target){
            temp.add(nums[idx]);
            helper(nums, target - nums[idx], idx, temp);
            temp.remove(temp.size() - 1);
        }
        helper(nums, target, idx - 1,temp);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        helper(nums,target,nums.length - 1,temp);
        return ans;
    }
}
