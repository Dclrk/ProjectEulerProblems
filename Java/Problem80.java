

import java.util.*;

import java.math.*;

public class Problem80 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        MathContext GoodDigits = new MathContext(102);
        //203
        
        BigDecimal Sqrt;
                
        BigInteger result = BigInteger.ZERO;
       
        for(int i = 2; i <= 100; i++){
            
            if(isPerfectSquare(i)){
                
                continue;
                
            }
            

            
            Sqrt = BigDecimal.valueOf(i).sqrt(GoodDigits);
            
            char[] sqrt = Sqrt.toString().toCharArray();

            for(int j = 0; j < 101; j++){
                
                if(j == 1){
                    
                    continue;
                    
                }
                
                result = result.add(BigInteger.valueOf(sqrt[j] - '0'));
                
            }
        }
        
        System.out.println(result);
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static boolean isPerfectSquare(int i){

        int root = (int) Math.sqrt(i);
        
        return root*root == i;
    }
    
    
}
