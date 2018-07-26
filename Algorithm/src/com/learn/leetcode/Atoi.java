package com.learn.leetcode;

public class Atoi {
	 public int myAtoi(String str) {
	        if(null == str || "".equals(str)) return 0;
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<str.length();i++){
	            char ch = str.charAt(i);
	            if(ch == ' ' && sb.length() < 2) {
	                continue;
	            }
	            else if(ch >='0' && ch <='9'){
	                sb.append(ch);
	                
	            }else if(ch =='+' || ch=='-'){
	                sb.insert(0,ch);
	            }else{
	                break;
	            }
	        }
	        
	        String s = sb.toString();
	        if(s.compareTo("+"+Integer.MAX_VALUE) < 0){
	            return Integer.MAX_VALUE;
	        }else if(s.compareTo(Integer.MIN_VALUE+"") > 0){
	            return Integer.MIN_VALUE;
	        }else{
	            return Integer.parseInt(s);
	        }
	        
	    }
	 
	 public static void main(String... args){
		 System.out.println("b".compareTo("a"));
		 Atoi atoi = new Atoi();
		 int result = atoi.myAtoi("43");
		 System.out.println(result);
	 }
}
