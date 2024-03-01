package net.util;

public class DynamicArray {
    private Object array[];
    private int actualElement;
    private int sizeArray;
    
    public DynamicArray(){
        array = new Object[1];
        actualElement = 0;
        sizeArray = 1;
    }
    
    public void addElement(Object object){
        if(actualElement == sizeArray){
            doubleSize();
        }
        
        array[actualElement++] = object;
    }
    
    
    
    private void doubleSize(){
        Object temporalArray[] = null;
        temporalArray = new Object [sizeArray * 2];
        
        for(int i = 0; i < sizeArray; i++){
            temporalArray[i] = array[i];
        }
        
        array = temporalArray;
        sizeArray *= 2;
    }
    
    
}
