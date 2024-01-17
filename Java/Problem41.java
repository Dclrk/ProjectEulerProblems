

import java.util.Arrays;


public class Problem41 {
    
    public static boolean[] Primes = Sieve(987654321);
    

    public static void main(String[] args) {
        
        int result = 0;
        
        for(int i = 1; i <= 987654321; i++){
            
            if(Primes[i] && isPandigital(i)){
                result = i;
            }
            
        }
        
        System.out.println(result);

    }
    public static char[][] pandigital = new char[][]{
        
        "1".toCharArray(),
        "12".toCharArray(),
        "123".toCharArray(),
        "1234".toCharArray(),
        "12345".toCharArray(),
        "123456".toCharArray(),
        "1234567".toCharArray(),
        "12345678".toCharArray(),
        "123456789".toCharArray()
    };
    
    public static boolean isPandigital(int n){
        
        char[] c = Integer.toString(n).toCharArray();
        
        Arrays.sort(c);
        
        return Arrays.equals(c, pandigital[c.length - 1]);
        
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
