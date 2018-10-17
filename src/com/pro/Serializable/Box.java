package com.pro.Serializable;

import java.io.*;

public class  Box implements Serializable  
{  
    private int width;  
    private int height;  
  
    public void setWidth(int width){  
        this.width  = width;  
    }  
    public void setHeight(int height){  
        this.height = height;  
    }  
  
    public static void main(String[] args){  
        Box myBox = new Box();  
        myBox.setWidth(50);  
        myBox.setHeight(30);  
  
        try{  
            FileOutputStream fs = new FileOutputStream("foo.txt");  
            ObjectOutputStream os =  new ObjectOutputStream(fs);  
            FileInputStream fis = new FileInputStream("foo.txt");
            ObjectInputStream is =  new ObjectInputStream(fis); 
            os.writeObject(myBox);  
            Box box=(Box)is.readObject();
            System.out.println("box:"+box.height+box.width);
            os.close();  
            is.close();
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
    }  
      
}  