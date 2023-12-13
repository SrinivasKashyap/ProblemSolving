package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class leetCode3 {
        public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();

        int i=0, j=0;
        int len = 0;
        while (j<n) {
            char c = s.charAt(j);
            Integer index = map.get(c);
            if (null == index || index == -1) {
                if ((j-i+1) > len) len = j-i+1;
                map.put(c, j);
            } else {
                while (i<=index) {
                    map.put(s.charAt(i), -1);
                    i++;
                }
                map.put(c, j);
            }
            j++;
        }
        if ((j-i) > len) len = j-i+1;
        return len;
    }
}
