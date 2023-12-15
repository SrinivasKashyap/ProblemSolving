package HashMap;

import java.util.HashMap;
import java.util.Map;

public class leetCode242 {
        public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        if (n != t.length()) return false;
        for (int i=0; i<n; i++) {
            Character c = s.charAt(i);
            Integer count = map.get(c);
            if (null == count) count = 0;
            map.put(c, ++count);
        }
         
        for (int i=0; i<n; i++) {
            Character c = t.charAt(i);
            Integer count = map.get(c);
            if (null == count || count == 0) return false;
            map.put(c, --count);
        }
        return true;
    }
}
