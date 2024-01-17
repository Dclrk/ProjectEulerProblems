

import java.util.*;

public class Problem75 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        ArrayList<Long> PricipalPythagsSum = new ArrayList<>();
        
        ArrayList<Long> FilteredPythags;
        
        ArrayList<Long> Result = new ArrayList<>();
        
        
        for(long m = 1; m < 1500000; m++){
            
            for(long n = 1; m*(m + n) <= 750000 && n < m; n++){
                
                if(m % 2 == 1 && n % 2 == 1 || gcd(m,n) != 1){
                    continue;
                }
                
                PricipalPythagsSum.add(2*m*(m + n));
                
                if(m % 2 == 1){
                    n++;
                }

            }
            
        }
        
        Collections.sort(PricipalPythagsSum);
        
        FilteredPythags = (ArrayList) PricipalPythagsSum.clone();
        
        for(int i = 0; i < FilteredPythags.size(); i++){
            
            for(int j = i + 1; j < FilteredPythags.size(); j++){
                
                if(FilteredPythags.get(j) % FilteredPythags.get(i) == 0){
                    
                    FilteredPythags.remove(j);
                    
                    j--;
                    
                }
            }
        }
        
        for(long sum1 : FilteredPythags){
            
            KLoop:
            for(int k = 1; k * sum1 <= 1500000; k++){
                
                for(long sum2 : PricipalPythagsSum){
                    
                    if(sum1 == sum2){
                        
                        continue;
                        
                    }
                    
                    if(sum2 > sum1 * k){
                        
                        break;
                        
                    }
                    
                    if(sum1 * k % sum2 == 0){
                        
                        continue KLoop;
                        
                    } 
                }
                    
                Result.add(sum1 * k);
                
            }
            
        }
        
        System.out.println(Result.size());
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static long gcd(long a, long b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
}
