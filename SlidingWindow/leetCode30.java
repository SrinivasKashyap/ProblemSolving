package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode30 {
        public List<Integer> findSubstring(String s, String[] words) {
        int n=words[0].length();
        int N=words.length;
        int i=0;
        int j=0;

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int x=0; x<N; x++) {
            Integer temp = map.get(words[x]);
            if (null == temp) temp = 1;
            else temp++;
            map.put(words[x], temp);
        }

        int len = s.length();
        if ((n*N)>len) {
            return result;
        }
        while((i+(N*n)-1)<len) {
            String sub = s.substring(i, i+n);
            Integer k = map.get(sub);
            if (null != k) {
                Map<String, Integer> visited = new HashMap<>();
                int wordCount = 0;
                visited.put(sub, 1);
                wordCount++;
                j=i+n;
                while(visited.size() < words.length && (j+n)<=len) {
                    String temp = s.substring(j, j+n);
                    Integer t = map.get(temp);
                    Integer count = visited.get(temp);
                    if (null != t && (null == count || count < t)) {
                        if (null == count)
                            visited.put(temp, 1);
                        else
                            visited.put(temp, count+1);
                        wordCount++;
                        j+=n;
                    } else {
                        break;
                    }
                }
                if (wordCount == words.length) result.add(i);
                // System.out.println(wordCount + " " + i);
            }
            i++;
        }
        return result;
    }
}
