


public class Problem58 {
    
    public static final boolean[] Sieve = Sieve((int)Math.pow(10,9));
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();

        
        int primes = 3;
        
        int length = 3;
        
        double diag = 5;
        
        double ratio = primes/diag;

        while(ratio >= 0.1){
            
            length += 2;
            
            diag += 4;
            
            for(int a = 1; a < 4; a++){
                
                if(Sieve[(int)Math.pow(length,2) - a*(length - 1)]){
                    
                    
                    primes++;
                }
            }
            
            ratio = primes/diag;

        }
        
        System.out.println(length);
        
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
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
