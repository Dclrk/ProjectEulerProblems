


import java.util.*;

public class Problem52 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        
        XLoop:
        for(int x = 1; x < Math.pow(10, 10); x++){
            
            
            int[] Perms = toIntArray(permute(InttoIntArray(x)));
            
            for(int a = 2; a < 7; a++){
                
                if(!contains(Perms,a*x)){
                    
                    continue XLoop;
                    
                }

            }
            
            System.out.println(x);
            
            break;
            
            
        }
        
        
        
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
    
    public static boolean contains(int[] Perms, int x){
        
        for(int a : Perms){
            
            if(a == x){
                
                return true;
                
            }
            
        }
        
        return false;
        
        
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
    
    public static int[] toIntArray(List<List<Integer>> perms){
        
        
        int[] result = new int[perms.size()];
        
        int index = 0;
        
        
        for(List<Integer> list :  perms){
            
            int res = 0;
            
            for(int num : list){

                res = 10*res + num;

            }
            
            result[index] = res;
            
            index++;
        }
        return result;
    }
    
    public static int[] InttoIntArray(int num){
        
        String temp = Integer.toString(num);
        
        int[] result = new int[temp.length()];
        
        
        for(int i = 0; i < temp.length(); i++){
            
            
            result[i] = temp.charAt(i) - '0';
            
        }
        
        return result;
    }
        
        
        
        
    
    
}
