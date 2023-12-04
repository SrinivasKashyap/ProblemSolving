public class leetCode6 {
    public String convert(String s, int r) {
        StringBuilder result = new StringBuilder();
        if (s.length() < r) return s;
        if (r == 1) return s;
        for (int i=0; i<r; i++) {
            result.append(s.charAt(i));

            for (int j=i; j<s.length();) {
                j+=((r-1)*2);
                if (i!=0 && i<(r-1)) {
                    int temp = j-(2*i);
                    if (temp >= 0 && temp<s.length()) result.append(s.charAt(temp));
                }
                if (j<s.length()) result.append(s.charAt(j));
            }
        }
        return result.toString();
    }
}
