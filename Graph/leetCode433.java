package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class leetCode433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (int i = 0; i < bank.length; i++) {
            map.put(bank[i], true);
        }

        Character[] geneChar = new Character[4];
        geneChar[0] = 'A';
        geneChar[1] = 'C';
        geneChar[2] = 'G';
        geneChar[3] = 'T';

        Set<String> visited = new HashSet<>();
        LinkedList<Pair<String, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair<String, Integer>(startGene, 0));
        while (q.size() > 0) {
            Pair<String, Integer> pair = q.removeLast();
            String gene = pair.getKey();
            Integer mutations = pair.getValue();

            if (gene.equals(endGene))
                return mutations;

            // mutate the gene
            // choose char to mutate
            for (int i = 0; i < gene.length(); i++) {
                StringBuilder str = new StringBuilder();
                str.append(gene);
                char curr = gene.charAt(i);

                // mutate
                for (int j = 0; j < geneChar.length; j++) {
                    if (geneChar[j] == curr)
                        continue;
                    str.setCharAt(i, geneChar[j]);
                    String mutatedGene = str.toString();

                    if (null != map.get(mutatedGene) && map.get(mutatedGene) == true
                            && !visited.contains(mutatedGene)) {
                        visited.add(mutatedGene);
                        q.addFirst(new Pair<String, Integer>(mutatedGene, mutations + 1));
                    }
                }
            }
        }
        return -1;
    }
}
