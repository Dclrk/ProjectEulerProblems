package project.euler.problems;

import java.util.*;

public class Problem72 {
    
    
    public static void main(String args[]){
        
        int Max = (int)Math.pow(10, 6);
        
        int[] EulerTotient = EulerTotient(Max);
        
        long startTime =  System.nanoTime();
        
        long result = 0;
        
        for(int den = 2; den <= Max; den++){
            
            result += EulerTotient[den];
            
        }
        
        System.out.println(result);
        
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static int[] EulerTotient(int n){ //Returns an array of eulertotient function up to integer n. So the returned array will look like [1,1,1,2,2,.....p-1,...,]
        
        int[] result = new int[n + 1];
        
        int[][] fractions = new int[n + 1][2];
        
        
        for(int[] frac : fractions){
            
            
            frac[0] = 1;
            frac[1] = 1;
            
        }
        
        for(int p = 2; p < fractions.length; p++){
            
            if(fractions[p][1] == 1){ //This can only happen when they both are 1
                
                for(int q = p; q < fractions.length; q += p){
                    
                    fractions[q][0] *= p-1;
                    fractions[q][1] *= p;
                } 
            }
        }
        
        result[0] = 1;
        result[1] = 1;
        
        for(int i = 2; i < result.length; i++){
            
            result[i] = i / fractions[i][1] * fractions[i][0];
            
        }
        return result;
    }
    
    
    
    
}
