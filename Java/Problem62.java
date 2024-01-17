package project.euler.problems;

import java.util.*;

import java.math.*;


public class Problem62 {
    
    public static void main(String[] args){
            
        
        ArrayList<ArrayList<BigInteger>> Cubes = new ArrayList<>();
        
        initializePerfectCubeArray(Cubes);
        
        int root = 2;
        
        int[][] processedCubes = new int[10000][];
        
        ArrayList<Integer> tempRoots = new ArrayList<>();
        
        
        while(tempRoots.size() != 3){
            
            tempRoots.clear();
            
            root++;
            
            System.out.println(root);
            
            try{
                if(processedCubes[root].length > 0){
                    
                    System.out.println("We got here!!!");
                    
                    continue;
                }
            }
            catch(Exception e){
                
            }
            
            BigInteger Cube = BigInteger.valueOf(root).pow(3);
            
            ArrayList<BigInteger> CubePerms = toBigIntArray(permute(BigIntegertoIntArray(Cube)));
            
            Set<BigInteger> set = new HashSet<>(CubePerms);
            
            CubePerms.clear();
            
            for(BigInteger big : set){
                
                if(big.toString().length() < Cube.toString().length()){
                    
                    continue;
                    
                }
                
                CubePerms.add(big);
                
            }
            
            if(Cubes.get(Cubes.size() - 1).get(1).compareTo(CubePerms.get(CubePerms.size() - 1)) == -1){
                
                
                makeCubesbigger(Cubes , CubePerms.get(CubePerms.size() - 1));
                

                
            }
            
            for(BigInteger maybeCube : CubePerms){
                
                BigInteger newtons = newtonsMethod(maybeCube);
                
                int maybeRoot = Integer.parseInt(newtons.toString());
                
                for(int i = maybeRoot; i < Cubes.size(); i++){
                    
                    if(Cubes.get(i).get(1).compareTo(maybeCube) == 1){
                        
                        break;
                        
                    }
                    
                    if(Cubes.get(i).get(1).compareTo(maybeCube) == 0){
                        
                        tempRoots.add(maybeRoot);
                        
                    }
                }
            }
            
            for(int roots : tempRoots){
                
                processedCubes[roots] = tempRoots.stream().mapToInt(i -> i).toArray();
                
            }
        }
        
        System.out.println(root);
    }
    
    public static BigInteger newtonsMethod(BigInteger k){ //This method does Newtons Method to try to find the roots of y = f(x) - k
        
        BigDecimal Guess = BigDecimal.ONE;
        
        BigDecimal K = new BigDecimal(k);
        
        BigDecimal h = function(Guess,K).divide(functionDerivative(Guess), MathContext.DECIMAL32);
        
        
        while(h.abs().compareTo(EPSILON) == 1 || h.abs().compareTo(EPSILON) == 0){
            
            h = function(Guess,K).divide(functionDerivative(Guess),MathContext.DECIMAL32);
            
            Guess = Guess.add(BigDecimal.valueOf(-1).multiply(h));
            
        }
        
        return Guess.toBigInteger();
        
    }

    public static final BigDecimal EPSILON = BigDecimal.valueOf(0.001);
    
    public static BigDecimal function(BigDecimal x, BigDecimal k){ //function is y = x^3 - k
        
        
        return x.pow(3).add(BigDecimal.valueOf(-1).multiply(k));
        
    }
    
    public static BigDecimal functionDerivative(BigDecimal x){
        
        return BigDecimal.valueOf(3).multiply(x.pow(2));
        
    }
    
    public static int[] BigIntegertoIntArray(BigInteger num){
        
        String Num = num.toString();
        
        int[] result = Num.chars().map(i -> i - '0').toArray();
        
        return result;
        
    }
    
    public static ArrayList<BigInteger> toBigIntArray(List<List<Integer>> perms){
        
        ArrayList<BigInteger> result = new ArrayList<>();

        for(List<Integer> list :  perms){
            BigInteger res = BigInteger.ZERO;
            for(int num : list){

                res = res.multiply(BigInteger.TEN).add(BigInteger.valueOf(num));
            }
            
            result.add(res);
        }
        return result;
    }
    
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, nums, 0);
        
        return result;
    }
    
    public static void backtrack(List<List<Integer>> result, int[] nums, int start){
        if(start == nums.length){
            result.add(toList(nums));
        }
        else{
            for(int i = start; i < nums.length; i++){
                swap(i,start, nums);
                backtrack(result, nums, start + 1);
                swap(i, start, nums);
            }
        }
    }
    
    public static List<Integer> toList(int[] nums){
        List<Integer> res = new ArrayList<>();
        for(int i : nums){
            res.add(i);
        }
        
        return res;
    }
    
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void makeCubesbigger(ArrayList<ArrayList<BigInteger>> Cubes, BigInteger Num){
        
        
        BigInteger Root = Cubes.get(Cubes.size() - 1).get(0);
        
        //System.out.println("FirstNum: " + Root);
        
        while(Root.pow(3).compareTo(Num) == -1){
            
            Root = Root.add(BigInteger.ONE);
            
           // System.out.println("FirstNum + 1: " + Root);
            
            ArrayList<BigInteger> singularNewCube = new ArrayList<>();
            
            singularNewCube.add(Root);
            singularNewCube.add(Root.pow(3));
            
            Cubes.add(singularNewCube);
            
        }
    }
    
    public static void initializePerfectCubeArray(ArrayList<ArrayList<BigInteger>> Cubes){
        ArrayList<BigInteger> ZeroCube = new ArrayList<>();
        
        ZeroCube.add(BigInteger.ZERO);
        ZeroCube.add(BigInteger.ZERO);
        
        Cubes.add(ZeroCube);
        
        ArrayList<BigInteger> OneCube = new ArrayList<>();
        
        OneCube.add(BigInteger.ONE);
        OneCube.add(BigInteger.ONE);
        
        Cubes.add(OneCube);
    }
    
}
