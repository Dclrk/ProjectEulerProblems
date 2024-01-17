

import java.util.*;

public class Problem32Better {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int finalresult = 0;
        
        
        ArrayList<Long> Points = new ArrayList<>();
        
        for(long l = 1L; l <= 493827160L; l++){
        
            if(containsDuplicates(Long.toString(l))){
                
                continue;
                
            }
            
            
            for(long j = 1L; l >= 2*j; j++){
                
                if(l % j == 0){
                    
                    long result = l / j;
                    
                    String string = Long.toString(result) + Long.toString(j) + Long.toString(l);
                    
                    if(string.length() > 9){
                        
                        break;
                        
                    }
                    
                    if(isPandigital(Integer.parseInt(string)) && !contains(Points, l)){
                        
                        Points.add(l);
                        
                        finalresult += l;
                        
                        System.out.println("Result: " + result);
                        
                        System.out.println("J: " + j);
                        
                        System.out.println(finalresult);
                        
                    }
                    
                }
                
                
            }
        
        
        
        
        }
        
        System.out.println(finalresult);
    
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
    
    public static boolean contains(ArrayList<Long> Points, long point){
        
        for(Long num : Points){
            
            if(num == point){
                
                return true;
                
            }
            
        }
        
        return false;
        
        
    }
    
    public static char[][] pandigital = new char[][]{
        
        "123456789".toCharArray()
            
    };
    
    public static boolean isPandigital(int n){
        
        char[] c = Integer.toString(n).toCharArray();
        
        Arrays.sort(c);
        
        return Arrays.equals(c, pandigital[0]);
        
    }
    
    public static boolean containsDuplicates(String string){
        
        for(int i = 0; i < string.length(); i++){
            
            for(int j = i + 1; j < string.length(); j++){
                
                if(string.charAt(i) == string.charAt(j)){
                    
                    return true;
                    
                }

            }

        }
        
        return false;

    }
    
    
}
