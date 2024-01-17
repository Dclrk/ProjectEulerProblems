package project.euler.problems;

import java.util.*;

public class Problem74 {
    
    public static final int MAX = (int) Math.pow(10, 6);
    
    public static final int[] factorials = Factorials(9);
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int[] dFChains = new int[MAX + 1];
        
        int result = 0;
        
        Arrays.fill(dFChains, 0);
        
        
        NumLoop:
        for(int num = 3; num < dFChains.length; num++){
            
            if(dFChains[num] != 0){
                
                continue;
                
            }
            
            ArrayList<Integer> Chain = new ArrayList();
            
            Chain.add(num);
            
            int nextInt = digitFactorial(num);
            
            //System.out.println("WERE HERE1!!!!!");
            
            while(!Chain.contains(nextInt)){
                
                try{
                    if(dFChains[nextInt] != 0){

                        setUpdFChains(dFChains, Chain, nextInt);
                        
                        //System.out.println("Chain length of " + num + " is " + (dFChains[nextInt] + Chain.size()));
                        
                        //System.out.println("dFChains[nextInt]: " + dFChains[nextInt]);
                        
                        //System.out.println("Chain: " + Chain);
                        
                        //System.out.println("------------------");

                        //Add code for the permutations of num

                        continue NumLoop;

                    }
                }
                catch(Exception e){}

                Chain.add(nextInt);

                nextInt = digitFactorial(nextInt);
            }
            
            //dFChains[num] = Chain.size();
            
            //System.out.println("Chain length of " + num + " is " + Chain.size());
             
            //System.out.println("Chain: " + Chain);
            
            //System.out.println("------------------");
            
            //System.out.println("WERE HERE2!!!!!");
            
            setUpdFChains(dFChains, Chain, nextInt);
        }
        
        for(int i = 0; i < dFChains.length; i++){
            
            
            
            if(dFChains[i] == 3){
 
                result++;
            }
            
        }
        
        System.out.println(result);
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static void setUpdFChains(int[] dFChains, ArrayList<Integer> Chain, int nextInt){
        
        System.out.println("Chain: " + Chain);
        
        System.out.println("Next Int: " + nextInt);
        
        int index = Chain.indexOf(nextInt);
            
        for(int i = 0; i < Chain.size(); i++){

            int link = Chain.get(i);

            //Add in a loop over the permutations of link

            if(i < index){
                
                try{
                    dFChains[link] = Chain.size() - i;
                    
                    System.out.println("dFChains of " + link + " is " + (Chain.size() - i));
                }
                catch(Exception e){}
            }
            else{
                
                try{
                    dFChains[link] = Chain.size() - index;
                    
                    System.out.println("dFChains of " + link + " is " + (Chain.size() - index));
                }
                catch(Exception e){}
            }
            
            System.out.println("-------------------");
        }
        
    }

    public static int digitFactorial(int n){
        
        int result = 0;
        
        char[] num = Integer.toString(n).toCharArray();
        
        
        for(char number : num){
            
            
            result += factorials[number - '0'];
            
        }
        
        return result;
    }
    
    public static int[] Factorials(int n){ //Makes array of factorials in the form [1,1,2,6,20,...,n!]
        
        int[] result = new int[n+1];
        
        result[0] = 1;
        
        for(int i = 1; i < result.length; i++){
            
            result[i] = i*result[i-1];
            
        }
        
        return result;
    }
    
    
}
