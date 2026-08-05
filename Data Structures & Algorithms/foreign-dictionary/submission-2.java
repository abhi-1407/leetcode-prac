class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for (String word : words) {
        for (char c : word.toCharArray()) {
            graph.putIfAbsent(c, new ArrayList<>());
            indegree.putIfAbsent(c, 0);
           }
       }

       for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && w1.length() > w2.length()) {
                return "";
            }
        }
    
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            char ch = queue.poll();
            res.append(ch);
            for(char c : graph.get(ch)){
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0){
                    queue.offer(c);
                }
            }
        }
        if(res.length() != indegree.size()){
           return "";
        }
        return res.toString();
    }
}
