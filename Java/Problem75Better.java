package project.euler.problems;

import java.util.*;

public class Problem75Better {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        ArrayList<Long> PricipalPythagsSum = new ArrayList<>();
        
        ArrayList<Long> Result = new ArrayList<>();
        
        
        for(long m = 1; m < 1500000; m++){
            
            for(long n = 1; m*(m + n) <= 750000 && n < m; n++){
                
                if(m % 2 == 1 && n % 2 == 1 || gcd(m,n) != 1){
                    continue;
                }
                
                //System.out.println("M,N: " + m + " " + n);
                
                //System.out.println(2*m*(m + n));
                
                PricipalPythagsSum.add(2*m*(m + n));
                
                if(m % 2 == 1){
                    n++;
                }

            }
            
        }
        
        System.out.println(PricipalPythagsSum);
        
        for(long sum : PricipalPythagsSum){
            
            for(int k = 1; k * sum <= 1500000; k++){
                
                Result.add(k * sum);
                
            }
        }
        
        Collections.sort(Result);
        
        System.out.println(Result);

        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static long gcd(long a, long b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    
}
