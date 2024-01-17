

import java.util.*;
import java.io.*;

public class Problem59 {
    
    
    public static void main(String args[])throws FileNotFoundException{
        
        long startTime =  System.nanoTime();
        
        File file = new File("C:\\Users\\Darin\\Downloads\\0059_cipher.txt");
        
        Scanner scan = new Scanner(file);

        String File = scan.next();
        
        File = File.replaceAll("\\s+", "");
        
        String[] ASCII = File.split(",");
        
        System.out.println(Arrays.toString(ASCII));
        
        System.out.println(ASCII.length);
        
        
        
        for(int a = 97; a < 123; a++){
            
            for(int b = 97; b < 123; b++){
                
                
                CLoop:
                for(int c = 97; c < 123; c++){
                    
                    
                    int key = 485*(a + b + c);
                    
                    for(String string : ASCII){
                        
                        int num = Integer.parseInt(string);
                        
                        int decode = num ^ key;
                        
                        if(decode > 123 || decode < 92){
                            
                            continue CLoop;
                            
                        }
                        
                    }
                    
                    System.out.println(key);
                    
           
                }
                
            }
            
        }
        
        
        
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
}
