package project.euler.problems;

import java.util.*;

public class Problem73 {
    
    
    public static void main(String args[]){
        
        double onethird = (double) 1/3;
        
;
        
        long result = 0;
        
        long startTime =  System.nanoTime();
        
        for(int den = 5; den <= 12000; den++){
            
            for(int num = 1 + (int)(den * onethird); (double) num / den < 0.5; num++){
                
                if(gcd(num,den) != 1){
                    
                    continue;
                }
                result++;
            }
            
        }
        
       
        System.out.println(result);
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static int gcd(int a, int b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    
}
