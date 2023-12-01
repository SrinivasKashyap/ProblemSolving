public class leetCode12 {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int i=0;
        while(num>0) {
            int n = num%10;
            num/=10;
            if (i==0 && n==4) {
                s.append('V');
                s.append('I');
            } else if (i==0 && n==9) {
                s.append('X');
                s.append('I');
            } else if (i==0 && n<4) {
                for (int j=0; j<n; j++) {
                    s.append('I');
                }
            } else if (i==0 && n<9) {
                for (int j=0; j<(n%5); j++) {
                    s.append('I');
                }
                s.append('V');
            } else if (i==1 && n==4) {
                s.append('L');
                s.append('X');
            } else if (i==1 && n==9) {
                s.append('C');
                s.append('X');
            } else if (i==1 && n<4) {
                for (int j=0; j<n; j++) {
                    s.append('X');
                }
            } else if (i==1 && n<9) {
                for (int j=0; j<(n%5); j++) {
                    s.append('X');
                }
                s.append('L');
            } else if (i==2 && n==4) {
                s.append('D');
                s.append('C');
            } else if (i==2 && n==9) {
                s.append('M');
                s.append('C');
            } else if (i==2 && n<4) {
                for (int j=0; j<n; j++) {
                    s.append('C');
                }
            } else if (i==2 && n<9) {
                for (int j=0; j<(n%5); j++) {
                    s.append('C');
                }
                s.append('D');
            } else if (i==3) {
                for (int j=0; j<n; j++) {
                    s.append('M');
                }
            }
            i++;
        }
        return s.reverse().toString();
    }
}
