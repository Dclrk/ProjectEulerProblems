


import java.math.*;

public class Problem65 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int[] eArray = new int[100];
        
        int count = 1;
        
        long result = 0;
        
        BigInteger numerator = BigInteger.ONE;
        
        BigInteger denominator = BigInteger.ONE;
        
        BigInteger tempNum;
        
        BigInteger gcd;
        
        eArray[0] = 2;
        
        eArray[1] = 1;
        
        for(int k = 2; k < eArray.length; k ++){
            
            if(k % 3 == 2){
                eArray[k] = 2*count;
                
                count++;
            }
            else{
                eArray[k] = 1;
            }
            
        }
        
        for(int index = eArray.length - 2; index > -1; index--){
            
            tempNum = numerator;
            
            numerator = denominator;
            
            denominator = tempNum;
            
            
            numerator = numerator.add(denominator.multiply(BigInteger.valueOf(eArray[index])));
            

            
            gcd = numerator.gcd(denominator);
            
            numerator = numerator.divide(gcd);
            
            denominator = denominator.divide(gcd);
            
        }
        
        String num = numerator.toString();
        
        for(int i = 0; i < num.length(); i++){
            
            result += num.charAt(i) - '0';
            
        }
        
        System.out.println(result);
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
}
