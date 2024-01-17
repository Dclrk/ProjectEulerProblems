

import java.util.*;


public class Problem42 {

    public static void main(String[] args) {
        
        long result = 0L;
        
        int[] Primes = new int[]{2,3,5,7,11,13,17};
        
        long[] Pandigitals = filter(toLongArray(permute(toIntArray(Long.toString(1023456789L).toCharArray()))));
        

            for(long i : Pandigitals){
                
                boolean bool = true;
            
                char[] nums = Long.toString(i).toCharArray();

                for(int d = 1; d <= 7; d++){


                    int a = Integer.parseInt(nums[d] + "" + nums[d + 1] + "" + nums[d + 2]);

                    bool &= (a % Primes[d - 1] == 0);

                    if(!bool){
                        break;
                    }

                }

                if(bool){
                    
                    result += i;


                }
            
        }
        
        System.out.println(result);
    }
    
    
    public static List<List<Long>> permute(int[] nums){
        List<List<Long>> result = new ArrayList<>();
        
        backtrack(result, nums, 0);
        return result;
    }
    
    public static void backtrack(List<List<Long>> result, int[] nums, int start){
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
    
    public static List<Long> toList(int[] nums){
        List<Long> res = new ArrayList<>();
        for(int i : nums){
            res.add((long) i);
        }
        
        return res;
    }
    
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static long[] toLongArray(List<List<Long>> perms){
        
        
        long[] result = new long[perms.size()];
        
        int index = 0;
        
        
        for(List<Long> list :  perms){
            long res = 0;
            for(long num : list){
                
                
                
                res = 10*res + num;
                
                
                
            }
            
            result[index] = res;
            
            index++;
        }
        
        
        return result;
    }
    
    public static int[] toIntArray(char[] arr){
        
        int[] result = new int[arr.length];
        
        int index = 0;
        
        for(char a : arr){
            
            result[index] = Character.getNumericValue(a);
            
            index++;
        }
        
        return result;
    }
    
    public static long[] filter(long[] arr){
        
        
        long[] result = new long[arr.length - 362880];
        
        int index = 0;
        
        for(long l : arr){
            if(Long.toString(l).length() == 10){
                
                result[index] = l;
                
                index++;
                
            }
            
            
        }
        
        return result;    
        
    }
}
