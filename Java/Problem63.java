


import java.math.*;

public class Problem63 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int n;
        
        int count = 1; //This is the 1 = 1^1 case
        
        
        for(int i = 2; i < 10; i++){ //Checking if leng(i^n) = i^n
            
            
            n = 1;
            
            nloop:
            while(true){
                BigInteger len = BigInteger.valueOf(i).pow(n);
                
                if(len.toString().length() < n){
                    
                    break;
                    
                }
     
                n++;
                count++;
            }
        }
        
        System.out.println(count);

        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
}
