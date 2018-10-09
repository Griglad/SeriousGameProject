import java.util.*;
import greenfoot.*;

/**
 * @author(Grigorios ladas)
 */
public class TitleScreen extends Actor
{
     public static final float FONT_SIZE = 15.0f;
    public static final int WIDTH = 1400;
    public static final int HEIGHT = 450;

    private String status = null;
    
    
    
    
    public TitleScreen(String status)
    {
    if (status == "start")
        {
            makeImage(startTitle());
        } 
    
    
        
    }
    

    
    
     private void makeImage(String title)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0,150,150, 200));
        image.fillRect(20, 20, WIDTH, HEIGHT);
        image.setColor(new Color(0, 130, 0, 128));
        image.fillRect(8, 8, 160, 80);
        Font font = image.getFont();
        font = font.deriveFont(15.0f);
        image.setFont(font);
        image.setColor(Color.YELLOW);
        image.drawString(title, 540,160);
        setImage(image);
 
    }
    
    
     public void act()
  
    {
        
        if (Greenfoot.isKeyDown("enter"))
        {
            
           
            
                Greenfoot.setWorld(new MyWorld());
            
    
           
        
    
    
    }
    
    
}
    
    
    
     public String startTitle()
    {
        String title = "WELCOME TO THE GAME  'MAINTAIN  YOUR BODY WEIGHT .' THE PURPOSE OF THE GAME IS MIKE MAINTAIN HIS\n WEIGHT IN HEALTHY LEVELS AND NOT EXCEED 7000 CALORIES IN A WEEK DEADLINE\nIN WHICH THE NUTRITIONIST ADVISED MIKE .\nPLAY BY CLICKING WITH THE MOUSE\nA GOOD WAY OF LIFE AND A PROPER DIET \nKEEP MIKE HEALTHY \n\n\nPRESS ENTER TO START ";
        return title;
    }
    
    
     
    
    
}
