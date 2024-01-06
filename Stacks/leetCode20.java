package Stacks;

import java.util.Stack;

public class leetCode20 {
        public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) return false;
                else {
                    Character a = stack.pop();
                    if (a == '(') continue;
                    else return false;
                }
            } else if (c == '}') {
                if (stack.empty()) return false;
                else {
                    Character a = stack.pop();
                    if (a == '{') continue;
                    else return false;
                }
            } else if (c == ']') {
                if (stack.empty()) return false;
                else {
                    Character a = stack.pop();
                    if (a == '[') continue;
                    else return false;
                }
            }
        }
        if (stack.empty())  return true;
        return false;
    }
}
