

import java.util.*;


public class Problem38 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        List<Long> Pandigitals = new ArrayList<>();
        
        
        for(int i = 1; i < 10000; i++){
            
            int n = 2;
            
            String I = Integer.toString(i);

            while(I.length() < 9){
                
                I += Integer.toString(n*i);
         
                
                n++;
                
                
            }
            
            long num = Long.parseLong(I);
            
            
            if(isPandigital(num)){

                Pandigitals.add(num);
                
            }

        }
        
        System.out.println(Collections.max(Pandigitals)); 
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
       
        
    }
    
    public static char[][] pandigital = new char[][]{
        
        "1".toCharArray(),
        "12".toCharArray(),
        "123".toCharArray(),
        "1234".toCharArray(),
        "12345".toCharArray(),
        "123456".toCharArray(),
        "1234567".toCharArray(),
        "12345678".toCharArray(),
        "123456789".toCharArray()
    };
    
    public static boolean isPandigital(long n){
        
        char[] c = Long.toString(n).toCharArray();
        
        if(c.length >= 10){
            return false;
        }
        
        Arrays.sort(c);
        
        return Arrays.equals(c, pandigital[c.length - 1]);
        
    }
    
    
}
