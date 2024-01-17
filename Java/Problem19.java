/**
 * 
 * 

    You are given the following information, but you may prefer to do some research for yourself.

        1 Jan 1900 was a Monday.
        Thirty days has September,
        April, June and November.
        All the rest have thirty-one,
        Saving February alone,
        Which has twenty-eight, rain or shine.
        And on leap years, twenty-nine.
        A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 */



public class Problem19 {
    
   public static final int[][] offset = defineOffSet();
    

   public static void main(String[] args){
       
       int result = 0;
       
       
       for(int year = 1901; year <= 2000; year++){
           
           for(int month = 1; month <= 12; month++){
               
               if(GaussAlgorithm(year,month, 1) == 0){
                   

                   result++;
               }
               
           }
       }
       
       System.out.println(result);

   }
   
   

   public static int GaussAlgorithm(int A, int M, int D){ //A is Year, M is Month, D is Day
       
       
       if(isLeapYear(A)){
           
           
           return (D + offset[M - 1][1] + 5*((A - 1) % 4) + 4*((A - 1) % 100) + 6*((A - 1) % 400)) % 7;
           
       }
       
       
        return (D + offset[M - 1][0] + 5*((A - 1) % 4) + 4*((A - 1) % 100) + 6*((A - 1) % 400)) % 7;
   }
   
   public static boolean isLeapYear(int A){
       
       return (A % 4 == 0) && (A % 100 != 0 || A % 400 == 0);
       
   }
   
   public static int[][] defineOffSet(){
       
       int[][] offset = new int[12][2];
       
       offset[0] = new int[]{0,0}; //January Offset
       offset[1] = new int[]{3,3};
       offset[2] = new int[]{3,4};
       offset[3] = new int[]{6,0};
       offset[4] = new int[]{1,2};
       offset[5] = new int[]{4,5};
       offset[6] = new int[]{6,0};
       offset[7] = new int[]{2,3};
       offset[8] = new int[]{5,6};
       offset[9] = new int[]{0,1};
       offset[10] = new int[]{3,4};
       offset[11] = new int[]{5,6};
       
       return offset;
   }
    
}
