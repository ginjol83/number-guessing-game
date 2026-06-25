package org.example.utils;

public class Utils {
    public boolean isInteger(String number){
        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public  boolean isValidNumber (int number){
        return number<100 && 0<number;
    }
}
