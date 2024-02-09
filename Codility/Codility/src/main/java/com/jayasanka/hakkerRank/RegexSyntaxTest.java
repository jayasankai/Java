package com.jayasanka.hakkerRank;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexSyntaxTest {

	public static void main(String[] args) {
		String pattern = "[";
		
      	try {            
            Pattern.compile(pattern);
            System.out.println("Valid");
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid");
        }

	}

}
