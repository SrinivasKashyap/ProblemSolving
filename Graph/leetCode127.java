package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create map to make wrodList searchable
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), true);
        }

        LinkedList<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.addFirst(new Pair<String, Integer>(beginWord, 1));
        visited.add(beginWord);

        while (q.size() > 0) {
            Pair<String, Integer> pair = q.removeLast();
            String word = pair.getKey();
            Integer steps = pair.getValue();

            if (word.equals(endWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder str = new StringBuilder();
                str.append(word);

                for (int j = 97; j <= 122; j++) {
                    char c = (char) j;
                    str.setCharAt(i, c);

                    String tempWord = str.toString();

                    if (null != map.get(tempWord) && !visited.contains(tempWord)) {
                        // System.out.println(tempWord + " " + steps);
                        if (tempWord.equals(endWord))
                            return (steps + 1);
                        visited.add(tempWord);
                        q.addFirst(new Pair<String, Integer>(tempWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
