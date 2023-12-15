package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode290 {
        public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, Boolean> map2 = new HashMap<>();

        List<String> words = new ArrayList<String>();

        /*The below code extracts an array of words from the sentence in s
        We can do the same using String[] words = s.split(" ")*/
        StringBuilder str = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ') str.append(s.charAt(i));
            else {
                str.trimToSize();
                words.add(str.toString());
                str = new StringBuilder();
            }
            if (i == s.length()-1) {
                str.trimToSize();
                words.add(str.toString());
            }
        }

        if (pattern.length() != words.size()) return false;

        for (int i=0; i<words.size(); i++) {
            String word = words.get(i);
            Character c = map1.get(word);
            Character letter = pattern.charAt(i);
            if (null != c) {
                if (c != letter) return false;
            } else {
                if (null != map2.get(letter)) return false;
                else {
                    map1.put(word, letter);
                    map2.put(letter, true);
                }
            }
        }

        return true;
    }
}
