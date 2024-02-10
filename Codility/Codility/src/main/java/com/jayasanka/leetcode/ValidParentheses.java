package com.jayasanka.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		boolean isValid = isValid("(())([])");
		System.out.println(isValid);

	}
	
	public static boolean isValid(String s) {
        char[] parantheses = s.toCharArray();
        Stack<Character> paranthesesStack = new Stack<Character>();

        for (char para : parantheses) {
            if (para == '(' || para == '[' || para == '{') {
                paranthesesStack.push(para);
            } else {
                if (paranthesesStack.isEmpty()) {
                    return false;
                } 
                
                char top = paranthesesStack.pop();
                if (((para == ')' && top != '(')) 
                    || ((para == ']' && top != '[')) 
                    || ((para == '}' && top != '{'))) {
                        return false;
                }
            }
        }

        return paranthesesStack.isEmpty();
    }

}
