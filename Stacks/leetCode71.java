package Stacks;

import java.util.Stack;

public class leetCode71 {
        public String simplifyPath(String path) {
        int periodCount = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        for (int i=0; i<path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (word.toString().equals(".")) {
                    word = new StringBuilder();
                    periodCount = 0;
                    continue;
                } else if (word.toString().equals("..")) {
                    if (!stack.empty()) stack.pop();
                    word = new StringBuilder();
                } else {
                    if (word.length() > 0) {
                        stack.push(word.toString());
                        word = new StringBuilder();
                    }  
                }
                periodCount = 0;
                continue;
            }
            word.append(c);
        }
        if (word.length() > 0) {
            if (word.toString().equals("..") && !stack.empty()) stack.pop();
            else if (!word.toString().equals("..") 
            && !word.toString().equals(".")) stack.push(word.toString());
            word = new StringBuilder(); 
        }
        Stack<String> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        while (!temp.empty()) {
            word.append('/').append(temp.pop());
        }
        if (word.length() == 0) word.append('/');
        return word.toString();
    }
}
