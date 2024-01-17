package project.euler.problems;

import java.util.*;

import java.io.*;

public class Problem54 {
    
    
    public static void main(String args[]) throws FileNotFoundException{
        
        long startTime =  System.nanoTime();
        
        File Pokerhands = new File("C:\\Users\\Darin\\Desktop\\PokerHands.txt");
        
        Scanner scan =  new Scanner(Pokerhands);
        
        
        for(int i = 0; i < 500; i++){
            
            String Player1 = scan.nextLine();
            
            Player1 = Player1.replaceAll("\\s", "");
            
            String Player2 = scan.nextLine();
            
            Player2 = Player2.replaceAll("\\s", "");
            
            
            char[] Player1Hand = Player1.toCharArray();
            
            char[] Player2Hand = Player2.toCharArray();
            
            
            ArrayList<Character> Player1Ranks = new ArrayList<>();
            
            ArrayList<Character> Player1Suit = new ArrayList<>();
            
            ArrayList<Character> Player2Ranks = new ArrayList<>();
            
            ArrayList<Character> Player2Suit = new ArrayList<>();
            
            for(int k = 0; k < Player1Hand.length; k += 2){
                
                Player1Ranks.add(Player1Hand[k]);
                
                Player2Ranks.add(Player2Hand[k]);
                
            }
            
            for(int k = 1; k < Player1Hand.length; k += 2){
                
                Player1Suit.add(Player1Hand[k]);
                
                Player2Suit.add(Player2Hand[k]);
                
            }
            
            
            
        }
        
        
        
        
        
        
        System.out.println("Time: " + (System.nanoTime() - startTime) + " nanoseconds");
        
    }
}
    
    
    
    
    
    
    
    


