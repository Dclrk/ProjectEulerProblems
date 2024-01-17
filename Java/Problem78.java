package project.euler.problems;

import java.util.*;

import java.math.*;

public class Problem78 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        ArrayList<BigInteger> Partitions = new ArrayList();
        Partitions.add(BigInteger.ONE);
        Partitions.add(BigInteger.ONE);
        
        int i = 1;
        
        BigInteger PofI;

        
        
        while(!Partitions.get(i).mod(BigInteger.valueOf(10000000)).equals(BigInteger.ZERO)){
            
            i++;
            
            PofI = BigInteger.ZERO;

            int index;
            
            BigInteger OneorNegativeOne;
            
            for(int k = -((int) Math.sqrt(24*i + 1) - 1)/6; k < 0; k++){
                
                index = k*(3*k - 1)/2;
                
                OneorNegativeOne = BigInteger.valueOf((int)Math.pow(-1,k+1));

                PofI = PofI.add(Partitions.get(i - index).multiply(OneorNegativeOne));
                
            }
            
            for(int k = 1; k <= ((int) Math.sqrt(24*i + 1) + 1)/6; k++){
                
                index = k*(3*k - 1)/2;
                
                OneorNegativeOne = BigInteger.valueOf((int)Math.pow(-1,k+1));

                PofI = PofI.add(Partitions.get(i - index).multiply(OneorNegativeOne));
                
            }
            
            Partitions.add(PofI);
        }
        
        System.out.println(Partitions.size() - 1);
        
        
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static long[] partitionFunction(int n){ //Generates an long array of the partition function up to int n, so for example [0,1,2,3,5,....,p(n)]
        
        long[] result = new long[n + 1];
        
        result[0] = 1;
        result[1] = 1;
        
        long PofI;
        
        for(int i = 2; i < result.length; i++){
            
            PofI = 0;
            
            int index;
            
            for(int k = -((int) Math.sqrt(24*i + 1) - 1)/6; k < 0; k++){
               
                index = k*(3*k - 1)/2;

                PofI += Math.pow(-1, k + 1)*result[i - index];
            }
            
            for(int k = 1; k <= ((int) Math.sqrt(24*i + 1) + 1)/6; k++){
                
                index = k*(3*k - 1)/2;

                PofI += Math.pow(-1, k + 1)*result[i - index];
            }
            
            result[i] = PofI;

        }
        
        return result;
    }
    
    
}
