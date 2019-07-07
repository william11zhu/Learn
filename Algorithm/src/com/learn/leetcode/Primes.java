package com.learn.leetcode;

public class Primes {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] primes = new boolean[n+1];
        primes[0] = true;
        primes[1] = true;
        int count = 0;
        for(int i = 2;i<n+1;i++){
            if(primes[i] == false){
                count++;
                System.out.print(i+",");
                for(int j=i+i;j < n+1;j += i){
                    primes[j] = true;
                }
            }    
        }
        
        return count;
    }
    public static int calPrime(int n){
        if(n<=1){
            return 0;
        }
        byte[] origin = new byte[n+1];
        int count = 0;
        for(int i=2;i<n+1;i++){
            if(origin[i] == 0){
                count++;
                int k = 2;
                while(i*k<=n){
                    origin[i*k] = 1; 
                    k++;
                }
            }else{
                continue;
            }
        }
        return count;
    }
    public static void  main(String[] args) {
		Primes p = new Primes();
		p.countPrimes(10);
	}
}
