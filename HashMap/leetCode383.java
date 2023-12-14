package HashMap;

import java.util.HashMap;
import java.util.Map;

public class leetCode383 {
        public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            Integer count = map.get(c);
            if (null == count) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }
        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.get(c);
            if (null == count || count == 0) return false;
            else {
                map.put(c, --count);
            } 
        }
        return true;
    }
}
