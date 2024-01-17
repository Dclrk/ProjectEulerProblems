package project.euler.problems;

import java.util.*;

import java.math.*;

public class Problem70 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int realResult = 0;
        
        double result = Double.MAX_VALUE;
        
        int[] EulerTotient = EulerTotient((int) Math.pow(10, 7));
        
        for(int i = 2; i < EulerTotient.length; i++){
            
            double tempResult = Double.MAX_VALUE;
            
            if(numberFingerprint(i) == numberFingerprint(EulerTotient[i])){
                
                tempResult = (double) i / EulerTotient[i];
            }
            
            if(tempResult < result){
                
                realResult = i;
                
                result = tempResult;
                
            }
            
            
            
        }
        
        System.out.println(realResult);
       
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static int[] EulerTotient(int n){ //Returns an array of eulertotient function up to integer n. So the returned array will look like [1,1,1,2,2,.....p-1,...,]
        
        int[] result = new int[n];
        
        int[][] fractions = new int[n][2];
        
        
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
    
    public static int gcd(int a, int b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    public static int numberFingerprint(int num){

        int result = 0;
        
        int count;
        
        char[] Num = Integer.toString(num).toCharArray();
        
        for(int i = 9; i > -1; i--){
            
            count = 0;
            
            for(char number : Num){
                
                if(number - '0' == i){
                    
                    count++;
                }
            }
            result = result*10 + count;
        }
        return result;
    }
}
