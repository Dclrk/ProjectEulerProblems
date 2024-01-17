


import java.util.*;

import java.math.*;


public class Problem66 {
    
    
    public static void main(String args[]){
        
        long startTime =  System.nanoTime();
        
        int numGCD;
        
        int denGCD;
        
        int realGCD;
        
        int floor;
        
        int largestD = 0;
        
        BigInteger BiggestNum = BigInteger.ZERO;
        
        for(int D = 2; D < 1001; D++){
            
            if(isPerfectSquare(D)){
                continue;
            }
                    
            ArrayList<Integer> ContFractRep = new ArrayList<>();
            
            ContFractRep.add((int)Math.sqrt(D));
            
            IntegerExtension Numerator = new IntegerExtension(-(int)Math.sqrt(D), 1, D);

            IntegerExtension Denominator = new IntegerExtension(1,0,D);

            IntegerExtension tempExtension;

            
            WhileLoop:
            while(true){

                tempExtension = Denominator;

                Denominator = Numerator;

                Numerator = tempExtension;

                Numerator = Numerator.multiply(Denominator.getConjugate());

                Denominator = Denominator.multiply(Denominator.getConjugate());


                numGCD = gcd(Numerator.getIntegerPart(),Numerator.getProductPart());

                denGCD = gcd(Denominator.getIntegerPart(),Denominator.getProductPart());

                realGCD = gcd(numGCD,denGCD);

                Numerator = Numerator.divide(realGCD);

                Denominator = Denominator.divide(realGCD);

                floor = Numerator.floor() / Denominator.getIntegerPart();
                
                ContFractRep.add(floor);
                
                BigInteger BigNum = BigInteger.valueOf(ContFractRep.get(ContFractRep.size() - 1));
                
                BigInteger BigDen = BigInteger.ONE;
                
                BigInteger tempNum;
                
                BigInteger gcd;
                
                for(int index = ContFractRep.size() - 2; index > -1; index--){
                    
                    
                    tempNum = BigNum;
                    
                    BigNum = BigDen;
                    
                    BigDen = tempNum;
                    
                    BigNum = BigNum.add(BigDen.multiply(BigInteger.valueOf(ContFractRep.get(index))));
                    
                    gcd = BigNum.gcd(BigDen);
                    
                    BigNum = BigNum.divide(gcd);
                    
                    BigDen = BigDen.divide(gcd);
                }
               
                if((BigNum.pow(2).subtract(BigDen.pow(2).multiply(BigInteger.valueOf(D)))).equals(BigInteger.ONE)){
                    
                    if(BigNum.compareTo(BiggestNum) == 1){
                        
                        
                        BiggestNum = BigNum;
                        
                        largestD = D;
                        
                    }
                    break;
                }
                
                Numerator = Numerator.subtract(floor * Denominator.getIntegerPart());
            }
        }
        
        System.out.println(largestD);
        
        long finishTime = System.nanoTime();
        
        double timeinSeconds = (finishTime - startTime)/Math.pow(10, 9);
        
        System.out.println("Time: " + timeinSeconds + " seconds");
    }
    
    public static class IntegerExtension{
        
        
        public static final IntegerExtension ONE = new IntegerExtension(1,0,0);
        
        
        
        private final int i1; //Integer part
        
        private final int p1; //Product part of 2*sqrt(n). p1 = 2 here
        
        private final int r1; //Base of the root, for example sqrt(2), r1 = 2
        
        
        
        public IntegerExtension(int a, int b, int c){
            
            this.i1 = a;
            
            this.p1 = b;
            
            this.r1 = c;
            
        }
        
        public int floor(){
            
            return i1 + p1* (int) Math.sqrt(r1);
            
        }
        
        public IntegerExtension getConjugate(){
            
            return new IntegerExtension(-i1,p1,r1);
        
        }
        
        public IntegerExtension add(final IntegerExtension int1, final IntegerExtension int2){
            
            return new IntegerExtension(int1.i1 + int2.i1, int1.p1 + int2.p1, int1.r1);
            
        }
        public IntegerExtension add(final IntegerExtension int1){
            
            return add(this,int1);
            
        }
        
        public IntegerExtension add(final IntegerExtension int1, final int int2){
            
            return new IntegerExtension(int1.i1 + int2, int1.p1, int1.r1);
            
        }
        public IntegerExtension add(final int int2){
            
            return add(this,int2);
            
        }
        
        public IntegerExtension subtract(final IntegerExtension int1, final int int2){
            
            return new IntegerExtension(int1.i1 - int2, int1.p1, int1.r1);
            
        }
        public IntegerExtension subtract(final int int2){
            
            return subtract(this,int2);
            
        }
        
        public IntegerExtension multiply(final IntegerExtension int1, final IntegerExtension int2){
            
            int IntPart = int1.i1*int2.i1 + int1.p1*int2.p1*int1.r1;
            
            int ProductPart = int1.i1*int2.p1 + int1.p1*int2.i1;
            
            return new IntegerExtension(IntPart,ProductPart,int1.r1);
            
        }
        public IntegerExtension multiply(final IntegerExtension int1){
            
            return multiply(this,int1);
            
        }
        
        public IntegerExtension divide(final IntegerExtension int1, int i){
            
            return new IntegerExtension(int1.i1/i, int1.p1/i, int1.r1);
            
        }
        public IntegerExtension divide(int i){
            return divide(this,i);
        }
        
        public int getIntegerPart(final IntegerExtension int1){
            
            return int1.i1;
            
        }
        public int getIntegerPart(){
            
            return getIntegerPart(this);
            
        }
        
        public int getProductPart(final IntegerExtension int1){
            
            return int1.p1;
            
        }
        public int getProductPart(){
            
            return getProductPart(this);
            
        }

        @Override
        public String toString(){
            
            final StringBuilder s = new StringBuilder();
            
            s.append(i1).append("+").append(p1).append("sqrt(").append(r1).append(")");
            
            return s.toString();
            
        }
        
    }
    
    public static int gcd(int a, int b) {
        
        if (b==0) return a;
        
        return gcd(b,a%b);
    }
    
    public static boolean isPerfectSquare(int x){
        
        int sr = (int)Math.sqrt(x);
        
        return sr * sr == x;
        
    }
}
