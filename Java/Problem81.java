package project.euler.problems;

import java.util.*;

import java.io.*;

public class Problem81 {
    
    
    public static void main(String args[]) throws FileNotFoundException{
        
        long startTime =  System.nanoTime();
       
        
        File FileMatrix = new File("C:\\Users\\Darin\\Downloads\\0081_matrix.txt");
        
        Scanner scan = new Scanner(FileMatrix);
        
        int[][] Matrix = new int[80][80];
        
        String Line;
        
        int index = 0;
        
        while(scan.hasNextLine()){
            
            Line = scan.nextLine();
            
            String[] Ints = Line.split(",");
            
            for(int i = 0; i < Matrix.length; i++){
                
                Matrix[index][i] = Integer.parseInt(Ints[i]);
                
            }
            
            index++;
            
        }
        
        

        
        
        for(int j = 78; j >= 0; j--){
            
            for(int a = 79; a >= j; a--){
                
                if(a == 79){
                    
                    Matrix[j][a] += Matrix[j+1][a];
                    
                    Matrix[a][j] += Matrix[a][j+1];
                    
                    
                }
                
                else if(j == a){
                    
                    Matrix[j][a] += Math.min(Matrix[j][a+1], Matrix[j+1][a]);
                    
                }
                
               
                else{
                    
                    Matrix[j][a] += Math.min(Matrix[j+1][a], Matrix[j][a+1]);
                    
                    Matrix[a][j] += Math.min(Matrix[a+1][j], Matrix[a][j+1]);
                    
                    
                    
                }
                
            }
        }
        
        for(int[] Array : Matrix){
            
            
            System.out.println(Arrays.toString(Array));
            
            
        }
        
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    
    
    
    
}
