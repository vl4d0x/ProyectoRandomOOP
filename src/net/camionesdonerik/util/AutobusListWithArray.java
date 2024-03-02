package net.camionesdonerik.util;

import net.camionesdonerik.model.Autobus;

public class AutobusListWithArray {
    private Autobus array[];
    private int actualElement;
    private int sizeArray;
    
    public AutobusListWithArray(){
        array = new Autobus[1];
        actualElement = 0;
        sizeArray = 1;
    }
    
    public void addElement(Autobus autobus){
        if(actualElement == sizeArray){
            doubleSize();
        }
        
        array[actualElement++] = autobus;
    }
    
    
    
    private void doubleSize(){
        Autobus temporalArray[] = null;
        temporalArray = new Autobus [sizeArray * 2];
        
        for(int i = 0; i < sizeArray; i++){
            temporalArray[i] = array[i];
        }
        
        array = temporalArray;
        sizeArray *= 2;
    }
    
    public Autobus[] getArray(){
        return array;
    }
    
}
