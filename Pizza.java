import java.util.*;
import greenfoot.*;

/**
 * 
 * @author(Grigorios ladas)
 */
public class Pizza extends food
{
    
      GreenfootImage img = new GreenfootImage("pizza.png");
   
    

      public Pizza()
      {
          
           img.scale(140,130);
        setImage(img);
      
        
        
        
    }
    
    
    
     public int getCalories()
    {
        
        
        return calories = 800;
    }

   

   
}
