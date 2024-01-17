import java.util.*;

public class Problem49 {
    
    
    public static void main(String[] args){
        
        System.out.println("a" );
        
        boolean[] Sieve = Sieve(9999);
        
        
        int[][] perms = new int[9999][4];
        
        for(int i = 1000; i <= 9999; i++){
            if(!Sieve[i]){
                
            }
            else{
                
                int n = i;
                
                int length = Integer.toString(n).length();
                
                int[] arr = new int[length];
                
                while(n != 0){
                    
                    arr[length - 1] = n % 10;
                    
                    n /= 10;
                    
                    length--;
                }
                
                perms[i] = toIntArray(permute(arr));
            }
        }
        
        
        for(int a = 1000; a <= 9999; a++){
            for(int r = 1; a + 2*r <= 9999; r++){
                
               
                if(Sieve[a] && Sieve[a + r] && Sieve[a + 2*r] && contains(perms[a],a+r) && contains(perms[a], a + 2*r)){
                    
                  
                    System.out.println(a + "" + (int)(a + r) + "");
                    System.out.println(a + r +r);
                }
            }
        }
        
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
    
    public static boolean contains(int[] array, int num){
        for(int a : array){
            if(a == num){
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
    
    
    
    public static boolean[] Sieve(int n){
        
        boolean array[] = new boolean[n+1];
        
        for(int i = 0; i <= n; i++){
            
            array[i] = true;
        }
        
        array[0] = false;
        array[1] = false;
        
        for(int p = 2; p * p <= n; p++){
            
            if(array[p]){
                
                for(int q = p*p; q <= n; q += p){
                    
                    array[q] = false;
                }
            }
        }
        
        return array;
        
    }
}
