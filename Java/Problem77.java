package project.euler.problems;

import java.util.*;

public class Problem77 {
    
    public static final int MAX = 1000000;
    
    public static final long[] soPF = sumOfPrimeFactors(MAX);
    
    public static final long[] pPCF = primePartitionCountingFunction(soPF);
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
       
        for(int i = 1; i < pPCF.length; i++){
            
            if(pPCF[i] >= 5000){
                
                System.out.println(i);
                
                break;
                
            }
            
            
        }
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
    public static long[] sumOfPrimeFactors(int n){ //Sums the prime factors of the numbers up to n, for example [0,0,2,3,2,.....sopf(n)]
        
        long[] result = new long[n + 1];
        
        Arrays.fill(result, 0);
        
        
        for(int p = 2; p < result.length; p++){
            
            if(result[p] == 0){
                
                for(int q = p; q < result.length; q += p){
                    
                    result[q] += p;
                    
                    
                    
                }
            }
        }
        return result;
    }
    
    public static long[] primePartitionCountingFunction(long[] soPF){
        
        long[] result = new long[soPF.length];
        
        result[1] = 0;
        
        
        long tempResult;
        
        for(int n = 2; n < result.length; n++){
            
            tempResult = 0;
            
            tempResult += soPF[n];
            
            for(int j = 1; j <= n - 1; j++){
                
                tempResult += soPF[j]*result[n - j];
                
            }
            
            result[n] = tempResult/n;
        }
        
        
        return result;
        
    }
    
    
}