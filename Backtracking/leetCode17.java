package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode17 {
    public List<String> letterCombinations(String digits) {
        // map numbers to letters
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        dfs(result, digits, map, 0, new StringBuilder());

        return result;
    }

    public void dfs(List<String> result, String digits, Map<Character, String> map, int i,
            StringBuilder str) {
        if (i == digits.length()) {
            result.add(str.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));

        for (int j = 0; j < letters.length(); j++) {
            str.append(letters.charAt(j));
            dfs(result, digits, map, i + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
