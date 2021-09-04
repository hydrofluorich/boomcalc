/* Combustion calculator Java draft
 * Complete combustion only, includes coefficients of 1
 * Co-created with Kelly Lang, February 2019
 */
import java.io.*;
import java.util.*;

public class Combust {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("This is the Java draft of The World's Best Combustion Calculator!");
        System.out.println("Currently, we can only do complete combustion.");
        System.out.println("To begin, please enter a hydrocarbon.");
        
        String hydrocarbon = in.nextLine();
        
        double o2 = 0;
        double co2 = 0;
        double h2o = 0;
        
        int c = 0;
        int h = 0;
        int o = 0;
        
        int coeff = 1;
        
        for(int i = 0; i<hydrocarbon.length(); i++){
            String storage = "";
            if(hydrocarbon.charAt(i) == 'C'){
                for(int j = i; j<hydrocarbon.length()-1; j++){
                    if(hydrocarbon.charAt(j+1) <60){
                        storage+=Character.toString(hydrocarbon.charAt(j+1));
                    } else {
                        break;
                    }
                }
                if(storage.equals("")){
                    c+=1;
                } else {
                    c += Integer.parseInt(storage);
                }
                
            } else if(hydrocarbon.charAt(i) == 'H'){
                for(int j = i; j<hydrocarbon.length()-1; j++){
                    if(hydrocarbon.charAt(j+1) <60){
                        storage+=Character.toString(hydrocarbon.charAt(j+1));
                    } else {
                        break;
                    }
                }
                if(storage.equals("")){
                    h+=1;
                } else {
                    h += Integer.parseInt(storage);
                }
            } else if(hydrocarbon.charAt(i) == 'O'){
                for(int j = i; j<hydrocarbon.length()-1; j++){
                    if(hydrocarbon.charAt(j+1) <60){
                        storage+=Character.toString(hydrocarbon.charAt(j+1));
                    } else {
                        break;
                    }
                }
                if(storage.equals("")){
                    o+=1;
                } else {
                    o += Integer.parseInt(storage);
                }
            }
        }
        
        co2 = c;
        h2o = h/2.0;
        o2 = co2 + h2o/2.0 - o/2.0;
        
        boolean possible = true;
        
        if(o2 == Math.round(o2)) {
        	
        } else if(o2*2 == Math.round(o2*2)) {
        	coeff*=2;
        	o2*=2;
        	h2o*=2;
        	co2*=2;
        } else if(o2*4 == Math.round(o2*4)) {
        	coeff*=4;
        	o2*=4;
        	h2o*=4;
        	co2*=4;
        } else {
        	possible = false;
        }
        
        if(coeff <= 0 || o2 <= 0|| co2 <= 0||h2o <= 0){
            possible = false;
        }
        
        if(possible) {
        	System.out.println(coeff+hydrocarbon+" + "+(int)o2+"O2 -> "+(int)co2+"CO2 + "+(int)h2o+"H2O");
        } else {
        	System.out.println("Impossible");
        }
        
    }
}