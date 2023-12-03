public class leetCode58 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;
        boolean flag = false;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                flag = true;
                len+=1;
            }
            if (s.charAt(i) == ' ' && flag) break;
        }
        return len;
    }
}
