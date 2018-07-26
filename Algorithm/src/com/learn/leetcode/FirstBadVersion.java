package com.learn.leetcode;

public class FirstBadVersion {
	
	private int version;
	
	public FirstBadVersion(int version){
		this.version = version;
	}
	
    public int firstBadVersion(int n) {
        
    	 int l = 1;
         int r = n;
         while (l<r){
             int mid = l + (r-l)/2;
             if (isBadVersion(mid)){
                 r = mid;
             }else{
                 l = mid +1;
             }
         }
         return l;
       
    }
    
    public boolean isBadVersion(int version){
    	return this.version > version ? false : true;
    }
    
    public static void main(String[] args){
    	FirstBadVersion fbv = new FirstBadVersion(1702766719);
    	int badVersion = fbv.firstBadVersion(2126753390);
    	System.out.println(badVersion);
    }
}
