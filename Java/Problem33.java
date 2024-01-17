

import java.math.*;

import java.util.*;

public class Problem33 {
    
    public static final boolean[] Sieve = Sieve(100);
        
    public static final int[] Primes = makePrimes(Sieve);
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int numresult = 1;
        
        int denresult = 1;
        
        int result;
        
        MathContext num = new MathContext(2048,RoundingMode.DOWN);

        for(int n = 10; n < 100; n++){
            
            for(int d = n + 1; d < 100; d++){
                
                int[] intersection = primeFactorization(gcd(n,d));
                
                int newd = d;
                
                int newn = n;
                
                for(int factors : intersection){
                    
                    newd /= factors;
                    
                    newn /= factors;
                    
                }
                
                BigDecimal ReducedFrac = BigDecimal.valueOf(newn).divide(BigDecimal.valueOf(newd), num);
                
                int[] DumbFrac = removeCommonValues(n,d);
                
                if(DumbFrac[0] == 0 || DumbFrac[1] == 0 || nothingHappened(n,DumbFrac[0],d,DumbFrac[1]) || isTrivial(n,DumbFrac[0],d,DumbFrac[1])){
                    continue;
                }
                
                BigDecimal DumbFraction = BigDecimal.valueOf(DumbFrac[0]).divide(BigDecimal.valueOf(DumbFrac[1]),num);
                
                
                if(ReducedFrac.equals(DumbFraction)){
                    
                    
                    numresult *= n;
                    
                    denresult *= d;

                }
            }
        }
        
        int gcd = gcd(numresult,denresult);
        
        result = denresult / gcd;
        
        System.out.println(numresult + " / " + denresult);
        
        
        System.out.println(result);
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
    
    public static boolean isTrivial(int n, int n2, int d, int d2){
        return (n == n2*10 && d == d2 * 10);
    }
    
    public static boolean nothingHappened(int n, int n2, int d, int d2){
        
        return (n == n2 && d == d2);
        
    }
    
    public static int gcd(int a, int b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    public  static int[] removeCommonValues(int n, int d){
        
        String N = Integer.toString(n);
        
        String D = Integer.toString(d);
        
         //System.out.println("Original N: " + N);
        
        //System.out.println("Original D: " + D);
        
        for(int i = 0; i < N.length(); i++){
            
            for(int j = 0; j < D.length(); j++){
                
                if(N.charAt(i) == D.charAt(j)){
                    
                    N = N.replaceFirst(N.charAt(i) + "", "");
                    
                    D = D.replaceFirst(D.charAt(j) + "", "");
                    
                    
                    
                }
                
            }
            
        }
        
        
        return new int[]{Integer.parseInt(N),Integer.parseInt(D)};
    }
    
    public static int[] primeFactorization(int n){
        
        ArrayList<Integer> resultPrimes = new ArrayList<>();
        
        int index = 0;
        
        while(n > 1){
            
            if(n % Primes[index] == 0){
                
                n /= Primes[index];
                
                resultPrimes.add(Primes[index]);

            }
            else{
                
                index++;
                
            }
            
            
        }
        
        
        return resultPrimes.stream().mapToInt(i -> i).toArray();
        
    }
    
    public static int[] makePrimes(boolean[] Sieve){
        
        int length = Sieve.length;
        
        int index = 0;
        
        int[] result = new int[length];
        
        for(int i = 0; i < length; i++){
            
            if(Sieve[i]){
                
                result[index] = i;
                
                index++;
                
            }
            
        }
        
        
        return result;
        
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
