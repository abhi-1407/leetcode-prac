class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0,maxLen = 0,maxFreq = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        while(r < s.length()){
            freqMap.put(s.charAt(r),freqMap.getOrDefault(s.charAt(r),0) + 1);
            maxFreq = Math.max(maxFreq,freqMap.get(s.charAt(r)));
            while((r - l + 1) - maxFreq > k){
                freqMap.put(s.charAt(l),freqMap.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
