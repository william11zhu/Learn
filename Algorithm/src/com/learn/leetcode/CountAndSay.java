package com.learn.leetcode;

public class CountAndSay {
	 public String countAndSay(int n) {
	        if(n < 1) return null;
	        String tmpSay = "1";
	        for(int i=1;i<n;i++){
	        	StringBuilder sbSay = new StringBuilder();
	            char ch = tmpSay.charAt(0);
	            int count = 0;
	            for(int j=0;j<tmpSay.length();j++){
	                
	                if (ch == tmpSay.charAt(j)){
	                    count++;
	                }else{
	                    sbSay.append(count);
	                    sbSay.append(tmpSay.charAt(j-1));
	                    ch = tmpSay.charAt(j);
	                    count = 1;
	                }
	                
	            }
	            sbSay.append(count);
	            sbSay.append(tmpSay.charAt(tmpSay.length()-1));
	            tmpSay = sbSay.toString();
	            System.out.println(tmpSay);
	        }
	        return tmpSay;
	    }
	 
	 
	 public static void main(String... args){
		 CountAndSay cas = new CountAndSay();
		 String str = cas.countAndSay(6);
		 System.out.println(str);
	 }
}
