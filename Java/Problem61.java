


import java.util.*;

import java.math.*;

public class Problem61 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        ArrayList<Integer> Triangle = generateSgonalNumbers(3, 1000, 9999);
        ArrayList<Integer> Square = generateSgonalNumbers(4, 1000, 9999);
        ArrayList<Integer> Pentagon = generateSgonalNumbers(5, 1000, 9999);
        ArrayList<Integer> Hexagon = generateSgonalNumbers(6, 1000, 9999);
        ArrayList<Integer> Heptagon = generateSgonalNumbers(7, 1000, 9999);
        ArrayList<Integer> Octagon = generateSgonalNumbers(8, 1000, 9999);
        
        int[][] PolygonalNumbers = new int[9][];
        
        PolygonalNumbers[3] = Triangle.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        PolygonalNumbers[4] = Square.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        PolygonalNumbers[5] = Pentagon.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        PolygonalNumbers[6] = Hexagon.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        PolygonalNumbers[7] = Heptagon.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        PolygonalNumbers[8] = Octagon.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        
        
        int[][][][] PolygonalNumbersStartEnd = new int[2][100][9][];
        
        
        for(int i = 0; i < 2; i++){
            
            for(int j = 10; j < 100; j++){
                
                for(int k = 3; k < 9; k++){
                    
                    ArrayList<Integer> tempArray = new ArrayList<>();
                    
                    for(int num : PolygonalNumbers[k]){
                        
                        String Num = Integer.toString(num);
                        
                        if(i == 0 && Integer.toString(j).equals(Num.substring(0, 2))){
                            
                            tempArray.add(num);
                            
                        }
                        else if(i == 1 && Integer.toString(j).equals(Num.substring(2, 4))){
                            
                            tempArray.add(num);
                        }
                                
                        PolygonalNumbersStartEnd[i][j][k] = tempArray.stream().mapToInt(a -> a).toArray();
                        
                    }
                }
            }
        }
        
        for(int octo : PolygonalNumbers[8]){

            int octofirsttwo = Integer.parseInt(Integer.toString(octo).substring(0,2));
            
            int octolasttwo = Integer.parseInt(Integer.toString(octo).substring(2,4));
            
            for(int polyIndex1 = 7; polyIndex1 > 2; polyIndex1--){
                
                try{
                    
                    for(int poly1 : PolygonalNumbersStartEnd[0][octolasttwo][polyIndex1]){
                        
                        int poly1lasttwo = Integer.parseInt(Integer.toString(poly1).substring(2,4));
                        
                        for(int polyIndex2 = 7; polyIndex2 > 2; polyIndex2--){
                            
                            if(polyIndex2 == polyIndex1){
                                
                                continue;
                                
                            }
                            
                            try{
                                
                                for(int poly2 : PolygonalNumbersStartEnd[0][poly1lasttwo][polyIndex2]){

                                    
                                    int poly2lasttwo = Integer.parseInt(Integer.toString(poly2).substring(2,4));
                                    
                                    for(int polyIndex3 = 7; polyIndex3 > 2; polyIndex3--){
                                        
                                        if(polyIndex3 == polyIndex1 || polyIndex3 == polyIndex2){
                                            
                                            continue;
                                            
                                        }
                                        
                                        try{
                                            
                                            for(int poly3 : PolygonalNumbersStartEnd[0][poly2lasttwo][polyIndex3]){

                                                
                                                int poly3lasttwo = Integer.parseInt(Integer.toString(poly3).substring(2,4));
                                                
                                                for(int polyIndex4 = 7; polyIndex4 > 2; polyIndex4--){
                                                    
                                                    if(polyIndex4 == polyIndex3 || polyIndex4 == polyIndex2 || polyIndex4 == polyIndex1){
                                                        
                                                        continue;
                                                        
                                                    }
                                                    
                                                    try{
                                                        
                                                        for(int poly4 : PolygonalNumbersStartEnd[0][poly3lasttwo][polyIndex4]){
                                                            
                                                            int poly4lasttwo = Integer.parseInt(Integer.toString(poly4).substring(2,4));
                                                            
                                                            for(int polyIndex5 = 7; polyIndex5 > 2; polyIndex5--){
                                                                
                                                                if(polyIndex5 == polyIndex4 || polyIndex5 == polyIndex3 || polyIndex5 == polyIndex2 || polyIndex5 == polyIndex1){
                                                        
                                                                    continue;
                                                        
                                                                }
                                                                
                                                                try{
                                                                    
                                                                    for(int poly5 : PolygonalNumbersStartEnd[0][poly4lasttwo][polyIndex5]){
                                                                        
                                                                        int poly5lasttwo = Integer.parseInt(Integer.toString(poly5).substring(2,4));
                                                                        
                                                                        if(poly5lasttwo == octofirsttwo){
                                                                            
                                                                            System.out.println(octo + poly1 + poly2 + poly3 + poly4 + poly5);
                                                                        }
                                                                        
                                                                    }
                                                                }
                                                                
                                                                catch(Exception e){}
                                                            }
                                                        }
                                                    }
                                                    catch(Exception e){}
                                                }
                                            }
                                        }
                                        catch(Exception e){}
                                    }
                                }
                            }
                            catch(Exception e){}
                        }
                    }
                }
                catch(Exception e){}
            }
        }
        long finishTime = System.nanoTime();
        
        BigDecimal timeinSeconds = (BigDecimal.valueOf(finishTime).add(BigDecimal.valueOf(-1*startTime))).divide(BigDecimal.valueOf(Math.pow(10, 9)));
        
        System.out.println("Time: " + timeinSeconds + " seconds");
    }
    
    
    
    public static ArrayList<Integer> generateSgonalNumbers(int s, int start, int end){ //Generates s-gonal Numbers where each polygonal number = x where start <= x <= end for all x.

            ArrayList<Integer> Result = new ArrayList<>();
            
            int n;
            
            if(s < 3 || end < start){
                
                return Result;
            
            }

            double approx = ((s-4) + Math.pow((s-4)*(s-4) + 8*(s-2)*start, 0.5))/(2*(s-2));
            
            String doubleString = Double.toString(approx);
            
            
            int periodIndex = doubleString.indexOf('.');
            
            String subString = doubleString.substring(0, periodIndex);
           
            
            if(subString.length() + 2 == doubleString.length()){
                
                n = Double.toString(approx).charAt(0) - '0';
                
            }
            
            else{

                n = Integer.parseInt(subString) + 1;
            }
           
            int PolygonalNumbersn = ((s-2)*n*n - (s-4)*n)/2;

            while(PolygonalNumbersn <= end){
                
                Result.add(PolygonalNumbersn);
                
                PolygonalNumbersn += (s - 2)*n + 1;
                
                n++;
                
            }
            return Result;
    }
}
