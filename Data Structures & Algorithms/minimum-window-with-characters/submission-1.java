class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        Map<Character,Integer> pattern = new HashMap<>();
        Map<Character,Integer> currWindow = new HashMap<>();
        int satisfiedChars = 0, i = 0, j = 0,minLen = 1001, startIdx = 0, endIdx = 0;
        for(char ch : t.toCharArray()){
            pattern.put(ch,pattern.getOrDefault(ch,0) + 1);
        }
        while(j < s.length()){
            currWindow.put(s.charAt(j),currWindow.getOrDefault(s.charAt(j),0) + 1);
            if(pattern.containsKey(s.charAt(j)) && currWindow.getOrDefault(s.charAt(j),0) == pattern.getOrDefault(s.charAt(j),0)){
                satisfiedChars++;
            }
            while(i <= j && satisfiedChars >= pattern.size()){
                if(minLen > j - i + 1){
                    minLen = j - i + 1;
                    startIdx = i;
                    endIdx = j;
                }
                currWindow.put(s.charAt(i),currWindow.get(s.charAt(i)) - 1);
                if(pattern.containsKey(s.charAt(i)) && currWindow.get(s.charAt(i)) < pattern.get(s.charAt(i))){
                    satisfiedChars--;
                }
                i++;
            }
            j++;
        }
        return minLen == 1001 ? "" : s.substring(startIdx,endIdx + 1);
    }
}
