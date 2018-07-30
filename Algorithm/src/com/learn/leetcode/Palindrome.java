package com.learn.leetcode;

public class Palindrome {
	public boolean isPalindrome(String s) {
		if(null == s) return false;
        if("".equals(s)) return true;
        int left =0;
        int right = s.length()-1;
        while(left < right){
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if(!isAlphaNum(lch)) {
                left++;
             }
            else if(!isAlphaNum(rch)){
                right--;
            } 
            else if((lch-'A')%32 == (rch-'A')%32){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
	}
	private boolean isAlphaNum(char ch){
        if(ch >='a' && ch <='z') return true;
        if(ch >='A' && ch <='Z') return true;
        if(ch >='0' && ch <='9') return true;
        return false;
    }
	public static void main(String... args) {
		Palindrome palindrome = new Palindrome();
		boolean result = palindrome.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(result);
	}
}
