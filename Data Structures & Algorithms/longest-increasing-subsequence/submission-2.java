class Solution {
    private int lowerBound(int[] nums,int startIdx,int endIdx,int ele){
        int l = startIdx;
        int r = endIdx;
        int ans = 0;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < ele){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int size = 0;
        for(int num : nums){
            int idx = lowerBound(tail,0,size,num);
            tail[idx] = num;
            if(idx == size){
                size++;
            } 
        }
        return size;
    }
}
