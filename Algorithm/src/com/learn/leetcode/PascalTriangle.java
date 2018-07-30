package com.learn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		if (numRows < 1)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					List<Integer> last = result.get(i - 1);
					list.add(last.get(j - 1) + last.get(j));
				}
			}
			result.add(list);
		}
		return result;
	}

	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()){
                    return false;
                }
                char symbol = stack.pop();
                if(c == ')' && symbol != '('){
                    return false;
                }
                if(c == ']' && symbol != '['){
                    return false;
                }
                if(c == '}' && symbol != '{'){
                    return false;
                }
			}
		}
	    return stack.isEmpty();
       
    }
	
	

	public static void main(String... args) {
		PascalTriangle pt = new PascalTriangle();
		// List<List<Integer>> list = pt.generate(5);
		// System.out.println(list);
		System.out.println(pt.isValid("()[]{}"));

	}
}
