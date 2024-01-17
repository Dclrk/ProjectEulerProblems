


import java.util.*;

public class Problem68 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int magicRingSides = 5;
        
        long biggestResult = 0;
        
        ArrayList<Integer> Numbers = new ArrayList();
        
        int[][] MagicRing = new int[magicRingSides][3];
        

        
        String[] Binaries = generateBinaryNumbersWithOnes(2*magicRingSides, magicRingSides).toArray(new String[0]);
        

       
        boolean[][] boolBinaries = toBooleanArray(Binaries);
        

        for(boolean[] Binary : boolBinaries){

            resetNumbers(Numbers,magicRingSides);
            
            ArrayList<Integer> OuterNodes = new ArrayList();
           

            for(int i = 0; i < Binary.length; i++){
                
                if(Binary[i]){
                    
                    OuterNodes.add(i + 1);
                    
                    Numbers.remove(Numbers.indexOf(i + 1));
                   
                }
            }
            
            if(Collections.min(OuterNodes) < Long.toString(biggestResult).charAt(0) - '0'){
                
                continue;
                
            }
            
            ArrayList<ArrayList<Integer>> OuterPerms = generatePermutations(OuterNodes.stream().mapToInt(x -> x).toArray());
            
            ArrayList<ArrayList<Integer>> InnerPerms = generatePermutations(Numbers.stream().mapToInt(x -> x).toArray()); 
            
            OuterPerms:
            for(ArrayList<Integer> OuterPerm : OuterPerms){

                for(int i = 0; i < OuterPerm.size(); i++){
                    
                    MagicRing[i][0] = OuterPerm.get(i);
                    
                }
                
                
                InnerPermLoop:
                for(ArrayList<Integer> InnerPerm : InnerPerms){
                    
                    for(int i = 0; i < InnerPerm.size(); i++){
                        
                        MagicRing[i][2] = InnerPerm.get(i);
                        
                        MagicRing[(i+1) % magicRingSides][1] = InnerPerm.get(i);

                    }
                    
                    if(allSumSame(MagicRing)){
                        
                        int[][] newMagicRing = reorderIntArray2D(MagicRing);
                        
                        String RingString = "";
                       
                        for(int[] Line : newMagicRing){
                            
                            for(int num : Line){
                                
                                RingString += num;
                            }
                        }
                       
                        long maybeBiggest = Long.parseLong(RingString);
                        
                        if(maybeBiggest > biggestResult){
                            
                            biggestResult = maybeBiggest;
                            
                        }
                    }    
                }
            }
        }
        
        System.out.println(biggestResult);
                
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
        
    }
    
    public static boolean allSumSame(int[][] MagicRing){
        
        boolean result = true;
        
        
        for(int i = 0; i < MagicRing.length; i++){
            
            
            result &= sumArray(MagicRing[i]) == sumArray(MagicRing[(i + 1) % MagicRing.length]);
            
        }
        
        return result;
    }
    
    public static int[][] reorderIntArray2D(int[][] array) {
        // Find the index of the array with the minimum value
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            int currentMin = array[i][0];
            if (currentMin < minValue) {
                minValue = currentMin;
                minIndex = i;
            }
        }

        // Reorder the array
        int[][] reorderedArray = new int[array.length][];
        System.arraycopy(array, minIndex, reorderedArray, 0, array.length - minIndex);
        System.arraycopy(array, 0, reorderedArray, array.length - minIndex, minIndex);

        // Copy the reordered array back to the original array
        System.arraycopy(reorderedArray, 0, array, 0, array.length);
        
        
        return reorderedArray;
    }
    
    public static void reverseArray(Object[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            Object temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }
    
    public static void resetMagicRing(int[][] MagicRing){
        
        
        for(int[] Line : MagicRing){
            
            Arrays.fill(Line, 0);
        }
    }
    
    public static void resetInnerRing(int[][] MagicRing){
        
        
        for(int[] Line : MagicRing) {
            
            for(int i = 1; i < Line.length; i++){
                
                Line[i] = 0;
                
            }
        }
        
        
    }
    
    public static int sumArray(int[] array) {
        
        return Arrays.stream(array).sum();
        
    }
    
    public static ArrayList<ArrayList<Integer>> generatePermutations(int[] array) {
        
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        
        generatePermutations(array.length, array, permutations);
        
        return permutations;
    }

    private static void generatePermutations(int n, int[] array, ArrayList<ArrayList<Integer>> permutations) {
        if (n == 1) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num : array) {
                permutation.add(num);
            }
            permutations.add(permutation);
        } else {
            for (int i = 0; i < n - 1; i++) {
                generatePermutations(n - 1, array, permutations);

                if (n % 2 == 0) {
                    swap(array, i, n - 1);
                } else {
                    swap(array, 0, n - 1);
                }
            }
            generatePermutations(n - 1, array, permutations);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static List<String> generateBinaryNumbersWithOnes(int numOfBits, int countOfOnes) {
        List<String> binaryNumbers = new ArrayList<>();
        
        generateBinaryNumbersWithOnesHelper(numOfBits, countOfOnes, 0, "", binaryNumbers);
        
        return binaryNumbers;
    }

    private static void generateBinaryNumbersWithOnesHelper(int numOfBits, int countOfOnes, int index, String current, List<String> result) {
        if (countOfOnes < 0 || countOfOnes > numOfBits - index) {
            return;  // Invalid countOfOnes for the remaining bits
        }

        if (index == numOfBits) {
            if (countOfOnes == 0) {
                result.add(current);
            }
            return;
        }

        // Exclude the current bit
        generateBinaryNumbersWithOnesHelper(numOfBits, countOfOnes, index + 1, current + "0", result);

        // Include the current bit
        generateBinaryNumbersWithOnesHelper(numOfBits, countOfOnes - 1, index + 1, current + "1", result);
    }
    
    
    public static boolean[][] toBooleanArray(String[] Binaries){
        
        boolean[][] result = new boolean[Binaries.length][Binaries[0].length()];
        
        for(int i = 0; i < Binaries.length; i++){
            
            for(int j = 0; j < Binaries[i].length(); j++){
                
                result[i][j] = Binaries[i].charAt(j) == '1';
                
            }
            
        }
        
        return result;
    }

    public static void resetNumbers(ArrayList<Integer> Numbers, int magicRingSides){
        
        Numbers.clear();
        
        for(int i = 1; i < magicRingSides*2 + 1; i++){
            
            Numbers.add(i);
            
        }
        
    }
}
