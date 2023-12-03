public class leetCode14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = strs[0].length();
        String base = strs[0];
        for (int i=1; i<n; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                base = strs[i];
            }
        }
        int i=0;
        for (; i<n; i++) {
            if (base.length() == 0) break;
            int j=0;
            for (; j<base.length(); j++) {
                if (strs[i].charAt(j) != base.charAt(j)) break;
            }
            base = base.substring(0, j);
        }
        if (i == n) return base;
        return "";
    }
}
