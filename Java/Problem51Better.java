import java.util.*;

public class Problem51Better {
    
    public static final boolean[] Sieve = Sieve(99999999);
    
    
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        boolean[][][] binaries = new boolean[10][][];
        
        for(int i = 2; i < binaries.length; i++){
            
            binaries[i] = createBinaries(i);
            
        }
        
        Iloop:
        for(int i = 11; i < Sieve.length; i++){
            
            int l = Integer.toString(i).length();
            
            if(!Sieve[i]){
                
                continue;
                
            }
            
            ArrayList<Integer> Primes = new ArrayList<>();
            
            for(boolean[] B : binaries[l]){
                
                
                char[] I = Integer.toString(i).toCharArray();
                
                Primes.clear();
                
                int a1 = 0;
                
                if(B[0]){
                    
                    a1 = 1;
                    
                }
                
                
                for(int a = a1; a < 10; a++){
                    
                    for(int k = 0; k < B.length; k++){
                        
                        if(B[k]){
                            
                            I[k] = Integer.toString(a).charAt(0);
                            
                        }
                        
                        
                    }
                    
                    int maybePrime = charArraytoInt(I);
                
                    if(Sieve[maybePrime]){
                        
                        Primes.add(maybePrime);

                    }
                    
                    
                }
                
                if(Primes.size() == 8){
                    
                    Collections.sort(Primes);
                    
                    System.out.println(Primes.get(0));
                    
                    break Iloop;
                }
                
                
                
            }
            
            
        }
        
        
        
        
        
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
    
    public static int charArraytoInt(char[] num) throws NumberFormatException{
        
        int result = 0;
        
        for(int i = 0; i < num.length; i++){
            
            int digit = (int)num[i] - (int)'0';
            
            if(digit < 0 || digit > 9) throw new NumberFormatException();
            
            result *= 10;
            result += digit;
            
        }
        
        return result;
        
    }
    
    public static boolean[][] createBinaries(int l){ // Creates array like {1,0,1,0,1} or {0,0,1,0,1,1} where the length of each array = l = length
        
        
        boolean[][] binaryResult = new boolean[(int)Math.pow(2, l) - 1][9];
        
        int index = 0;
        
        for(int b = 1; b <= (1 - Math.pow(2, l))/(1 - 2); b++){
            
            
            
            String B = Integer.toBinaryString(b);
            
            if(B.length() < l){
                
                String Zeros = "0".repeat(l - B.length());
                
                
                B = Zeros.concat(B);
                
            }
            
            
            boolean[] bool = toBooleanArray(B);
            
            
            binaryResult[index] = bool;

            index++;
            
        }
        
        
        
        return binaryResult;
        
    }
    
    
    public static boolean[] toBooleanArray(String B){
        
        boolean[] result = new boolean[B.length()];
        
        int index = 0;
        
        for(int i = 0; i < B.length(); i++){
            
            result[index] = (B.charAt(i) == '1');
            
            index++;

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
