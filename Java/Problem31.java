


public class Problem31 {
    
     public static void main(String[] args) {
        
        int OneHundredp = 100;
        
        int Fiftyp = 50;
        
        int Twentyp = 20;
        
        int Tenp = 10;
        
        int Fivep = 5;
        
        int Twop = 2;
        
        int Onep = 1;
        
        int result = 1;
        
        
        for(int a = 0; a <= 2; a++){                            //a = # of OneHundredp
            
            for(int b = 0; b <= 4; b++){                        //b = # of Fiftyp
                
                if(a*OneHundredp + b*Fiftyp > 200){
                    
                    break;
                    
                }
                else if(a*OneHundredp + b*Fiftyp == 200){
                    
                    result += 1;
                    break;
                    
                }
                
                for(int c = 0; c <= 10; c++){                   //c = # of Twentyp
                    
                    if(a*OneHundredp + b*Fiftyp + c*Twentyp > 200){
                    
                        break;
                    
                    }
                    else if(a*OneHundredp + b*Fiftyp + c*Twentyp == 200){

                        result += 1;
                        break;

                    }
                    
                    for(int d = 0; d <= 20; d++){               //d = # of Tenp
                        
                        if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp > 200){
                    
                            break;

                        }
                        else if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp == 200){

                            result += 1;
                            break;

                        }

                        for(int e = 0; e <= 40; e++){           //e = # of 5p
                            
                            if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep > 200){
                    
                                break;

                            }
                            else if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep == 200){

                                result += 1;
                                break;

                            }
                            
                            for(int f = 0; f <= 100; f++){      //f = # of 2p
                                
                                if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep + f*Twop> 200){
                    
                                    break;

                                }
                                else if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep + f*Twop == 200){

                                    result += 1;
                                    break;

                                }
                            
                                
                                for(int g = 0; g <= 200; g ++){
                                    
                                    if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep + f*Twop + g*Onep> 200){
                    
                                        break;

                                    }
                                    else if(a*OneHundredp + b*Fiftyp + c*Twentyp + d*Tenp + e*Fivep + f*Twop + g*Onep == 200){
                                      

                                        result += 1;
                                        break;

                                    }
                                    
                                   
                                    
                                }
                                
                            }
                            
                        }
                        
                        
                        
                    }
                    
                }
                
            }
            
            
        }
        
        System.out.println(Integer.toString(result));
        
    }
     
     
    
}
