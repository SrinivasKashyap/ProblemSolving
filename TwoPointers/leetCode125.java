package TwoPointers;

public class leetCode125 {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length() - 1;
        while (i<j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') 
            || (a >= '0' && a <= '9')) 
            && ((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') 
            || (b >= '0' && b <= '9'))) {
                if ((a >= 'A' && a <= 'Z')) a+=('a'-'A');
                if ((b >= 'A' && b <= 'Z')) b+=('a'-'A');
                if (a != b) {
                    return false;
                }
                i++;
                j--;
            } else if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') 
            || (a >= '0' && a <= '9')) {
                j--;
            } else if ((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') 
            || (b >= '0' && b <= '9')) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
