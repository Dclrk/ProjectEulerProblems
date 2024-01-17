

import java.math.*;

public class Problem26 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int maxlength = 0;
            
        int maxD = 0;
        
        boolean bool;
        
        MathContext num = new MathContext(2048,RoundingMode.DOWN);
        
        for(int d = 2; d < 1000; d++){
            
            BigDecimal D = BigDecimal.ONE.divide(BigDecimal.valueOf(d), num);
            
            int length = 0;
            
            String newString = D.toString();
            
            if(newString.length() < 258){
                
                continue;
                
            }

            indexloop:
            for(int index = 2; index < newString.length(); index++){
                

                for(int l = 1; l < newString.length()/2 && index + l < newString.length(); l++){
                    
                     bool = false;
                  
                   String maybeString = newString.substring(index, index + l);
                   
                   
                   for(int a = 1; index + (a+1)*l + 1 < newString.length(); a++){
                       
                       
                       String newerString = newString.substring(index + a*l, index + (a+1)*l);

                       bool = maybeString.equals(newerString);
                       
                       if(!bool){
                           
                           break;
                       }
                       
                   }
                   
                   if(bool){
                       
                        length = l;
                       
                        break indexloop;
                   }
                }
            }
            
           
           if(length > maxlength){
               
               maxlength = length;
               
               maxD = d;
           }

        }

        System.out.println(maxD);
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
    
    
}
