package project.euler.problems;

import java.util.*;

public class Problem71 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        double result = 0;
        
        int resultNum = 0;
        
        double threeFraction = (double) 3/7;
        
        for(int den = 1000000; den > 2; den--){
            
            for(int num = (int)(den* threeFraction); num < den; num--){
                
                if(gcd(num,den) != 1){
                    
                    continue;
                }
                
                double frac = (double) num / den;
                
                if(frac < result){
                    
                    break;
                }
                
                if(frac == threeFraction){
                    
                    continue;
                    
                }
                
                result = (double) num / den;

                resultNum = num;
                
            }
        }
        
        System.out.println(resultNum);
        
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
    public static int gcd(int a, int b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    
}
