class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(freq.containsKey(ch)){
                l = Math.max(l,freq.get(ch) + 1);
            }
            freq.put(ch,r);
            ans = Math.max(ans,r - l + 1);
            r++;
        }
        return ans;
    }
}
