import java.util.ArrayList;
import java.util.List;

public class leetCode68 {
        public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int len = 0;
        int wordCount = 0;
        for (int i=0; i<words.length; i++) {
            len += words[i].length();
            if ((len + wordCount) > maxWidth) {
              StringBuilder temp = new StringBuilder();
                int wordLen = len - words[i].length();
                int spaceLen = maxWidth - wordLen;
              if (wordCount == 1) {
                temp.append(words[i-wordCount]);
                for (int j=0; j<spaceLen; j++) {
                    temp.append(" ");
                }
              } else {
                int space = spaceLen/(wordCount - 1);
                int extraSpace = spaceLen%(wordCount-1);
                while(wordCount>0) {
                  temp.append(words[i-wordCount]);
                  int j=0; 
                  while (j<space && wordCount > 1) {
                    temp.append(" ");
                    j++;
                  }
                  if (extraSpace > 0) temp.append(" ");
                  extraSpace--;
                  wordCount--;
                }
              }
              result.add(temp.toString());
              i--;
              wordCount=0;
              len=0;
            } else if (i==words.length-1) {
              StringBuilder temp = new StringBuilder();
              int spaceLen = 0;
              if (wordCount == 0)
                spaceLen = maxWidth - (len);
              else 
                spaceLen = maxWidth - (len+wordCount);
              while (wordCount>=0) {
                temp.append(words[i-wordCount]);
                if (wordCount>0) temp.append(" ");
                wordCount--;
              }
                for (int j=0; j<spaceLen; j++) {
                    temp.append(" ");
                }
                result.add(temp.toString());              
            } else {
              wordCount++;
            }
        }
        return result;
    }
}
