



import java.util.*;

import java.math.*;

public class Problem62Better {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        long root = 1;
        
        ArrayList<Long> finalResult = new ArrayList<>();

        ArrayList<Long>[] cubeFingerprints = new ArrayList[99999999];
        
        for(int i = 0; i < cubeFingerprints.length; i++){
            
            cubeFingerprints[i] = new ArrayList<>();
            
        }
        
        whileLoop:
        while(true){
            
            BigInteger Cube = BigInteger.valueOf(root).pow(3);
           
            int finger = numberFingerprint(Cube);
           
            cubeFingerprints[finger].add(root);
            
            if(cubeFingerprints[finger].size() >= 5){
                
              
                for(int i = 0; i < cubeFingerprints[finger].size(); i++){
                    
                    if(cubeFingerprints[finger].size() - i < 4){
                        
                        break;
                        
                    }
                    
                    long root1 = cubeFingerprints[finger].get(i);
                    
                    BigInteger Cube1 = BigInteger.valueOf(root1).pow(3);
                    
                    int Cube19 = numberofNines(Cube1);
                    
                    int Cube18 = numberofEightes(Cube1);
                    
                    finalResult.clear();
                    
                    finalResult.add(root1);
                    
                    for(int j = i + 1; j < cubeFingerprints[finger].size(); j++){
                       
                        
                        long root2 = cubeFingerprints[finger].get(j);
                        
                        BigInteger Cube2 = BigInteger.valueOf(root2).pow(3);
                        
                        int Cube29 = numberofNines(Cube2);
                        
                        int Cube28 = numberofEightes(Cube2);
                        
                        if(Cube19 == Cube29 && Cube18 == Cube28){
                            
                            finalResult.add(root2);
                            
                        }
                        
                    }
                    
                    if(finalResult.size() == 5){
                        
                        
                        BigInteger finalResultActually = BigInteger.valueOf(finalResult.get(0)).pow(3);
                        
                        System.out.println(finalResultActually);
                        
                        break whileLoop;
                        
                    }
                    
                }
                
            }

            root++;
        }
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
    }
    
    public static int numberofNines(BigInteger num){
        
        String Num = num.toString();
        
        int[] result = Num.chars().filter(x -> x - '0' == 9).toArray();
        
        return result.length;
    }
    
    public static int numberofEightes(BigInteger num){
        
        String Num = num.toString();
        
        int[] result = Num.chars().filter(x -> x - '0' == 8).toArray();
        
        return result.length;
    }
    
    public static int numberFingerprint(BigInteger num){

        int result = 0;
        
        int count;
        
        char[] Num = num.toString().toCharArray();
        
        for(int i = 7; i > -1; i--){
            
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
