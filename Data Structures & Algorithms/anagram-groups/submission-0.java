class Solution {
    private String getKey(String str){
        int[] count = new int[26];
        for(char ch : str.toCharArray()){
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int ch : count){
            sb.append(ch);
            sb.append("#");
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mpp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str : strs){
            String key = getKey(str);
            if(!mpp.containsKey(key)){
                mpp.put(key,new ArrayList<>());
            }
            mpp.get(key).add(str);
        }
        for(String key : mpp.keySet()){
            ans.add(mpp.get(key));
        }
        return ans;
    }
}
