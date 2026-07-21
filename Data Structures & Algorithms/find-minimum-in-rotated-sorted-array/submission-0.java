class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1, ans = 1001;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[i] <= nums[mid]){
                ans = Math.min(ans,nums[i]);
                i = mid + 1;
            }else{
                ans = Math.min(ans,nums[mid]);
                j = mid - 1;
            }
        }
        return ans;
    }
}
