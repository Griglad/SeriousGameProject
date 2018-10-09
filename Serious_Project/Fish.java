import java.util.*;
import greenfoot.*;

/**
 * @author(Grigorios ladas)
 */
public class Fish extends food
{
GreenfootImage img = new GreenfootImage("fish.png");
    public Fish()
    {
         img.scale(140,130);
        setImage(img);
      
        
    }
    
    
    
    
        
     public int getCalories()
    {
        
        
        return calories = 150;
    }

   

    
}
