import java.util.*;

import java.math.*;


public class Problem24 {
    
    public static ArrayList<String> answer = new ArrayList<>();
    
    
    
    
    public static void main(String[] args){
        
        
        String a = "0123456789";
        
        ArrayList<String> Array = permutations("",a);
        
        
        Set<String> set = new HashSet<>(answer);
        answer.clear();
        answer.addAll(set);
        
        Collections.sort(answer);
        
        System.out.println(answer.get(999999));
        
        
    }
    
    public static ArrayList<String> permutations(String candidate, String remaining){
        
        
        
        if (remaining == null) {
            return answer;
        }
 
        if (remaining.length() == 0) {
            
            
            answer.add(candidate);
            
        }
 
        for (int i = 0; i < remaining.length(); i++)
        {
            String newCandidate = candidate + remaining.charAt(i);
 
            String newRemaining = remaining.substring(0, i) +
                    remaining.substring(i + 1);
 
            permutations(newCandidate, newRemaining);
        }
        
        return answer;
    }
    
   
    
}
