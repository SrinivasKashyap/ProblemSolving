public class leetCode13 {
    public int romanToInt(String s) {
        int x=0;
        int n= s.length();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                x+=1000;
            } else if (c == 'D') {
                x+=500;
            } else if (c == 'C' && (i+1)<n && s.charAt(i+1) == 'D') {
                x+=400;
                i+=1;
            } else if (c == 'C' && (i+1)<n && s.charAt(i+1) == 'M') {
                x+=900;
                i+=1;
            } else if (c == 'C') {
                x+=100;
            } else if (c == 'X' && (i+1)<n && s.charAt(i+1) == 'L') {
                x+=40;
                i+=1;
            } else if (c == 'X' && (i+1)<n && s.charAt(i+1) == 'C') {
                x+=90;
                i+=1;
            } else if (c == 'X') {
                x+=10;
            } else if (c == 'I' && (i+1)<n && s.charAt(i+1) == 'X') {
                x+=9;
                i+=1;
            } else if (c == 'I' && (i+1)<n && s.charAt(i+1) == 'V') {
                x+=4;
                i+=1;
            } else if (c == 'I') {
                x+=1;
            } else if (c == 'V') {
                x+=5;
            } else if (c == 'L') {
                x+=50;
            }
        }
        return x;
    }
}
