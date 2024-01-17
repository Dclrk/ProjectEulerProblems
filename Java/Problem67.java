


import java.util.*;

import java.io.*;



public class Problem67 {
    
    
    public static void main(String args[]) throws Exception{
        
        long startTime =  System.nanoTime();
        
        try{
            
            
            ArrayList<ArrayList<Integer>> Triangle = new ArrayList();
            
            File triangle = new File("C:\\Users\\Darin\\Desktop\\0067_triangle.txt");
            
            Scanner scanner = new Scanner(triangle);
            
            String str;
            
            while(scanner.hasNextLine()){
                
                ArrayList<Integer> tempTri = new ArrayList();
                
                str = scanner.nextLine();
                
                String[] Str = str.split("\\s+");
                
                for(String Num : Str){
                    
                    tempTri.add(Integer.valueOf(Num));
                    
                }
                
                
                Triangle.add(tempTri);
                
            }
           
            int[][] Tri = Triangle.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][] :: new);
            
            
            for(int i = Tri.length - 2; i >= 0; i--){
                
                for(int j = 0; j < Tri[i].length; j++){
                    
                    Tri[i][j] += Math.max(Tri[i + 1][j], Tri[i + 1][j + 1]);
                    
                }
                
            }
            
           System.out.println(Tri[0][0]);
  
            
        }
        
        
        catch(Exception e){
            
            throw e;
            
        }

        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
}
