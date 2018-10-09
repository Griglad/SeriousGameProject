import java.util.*;
import greenfoot.*;

/**
 * @author(Grigorios ladas)
 */
public class Strawberry extends food
{

    GreenfootImage img = new GreenfootImage("Strawberry.png");
    
    public Strawberry ()
    {
        img.scale(70,70);
        setImage(img);
        
        
    }
    public int getCalories()
    {
        return calories = 20;
    }
}
