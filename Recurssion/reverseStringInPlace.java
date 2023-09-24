public class reverseStringInPlace {
    public void reverseString(char[] s) {
        util(0, s, s.length);
    }
    public void util(int i, char[] s, int n) {
        if (i >= s.length/2 || null == s) {
            return;
        }
        util(i+1, s, n);
        System.out.println("Swapping " + i + " " + (n-1-i));
        char temp = s[i];
        s[i] = s[n-1 - i];
        s[n-1 - i] = temp;
    }
}
