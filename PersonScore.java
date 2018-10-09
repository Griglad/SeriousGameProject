
import java.util.*;
import greenfoot.*;
import greenfoot.Font;
//import java.awt.Font;
/*
 * @author(Grigorios ladas)
 */

public class PersonScore extends Actor
{
   
  protected int day; //day 1,2,3,4
  protected int part_of_day; //0=morning,1=noon,2=evening
  String part_of_day_labels[] = new String[]{"morning","noon","evening"};
  
  protected int sum_calories ; 
  
  
  GreenfootImage grp;


  

  public PersonScore(){
       
  }
  
  
   public void act() 
   {
       MyWorld w = (MyWorld)getWorld();
       grp = new GreenfootImage(getWorld().getWidth(),100);
       grp.setFont( new Font(true, true, 24));
       
       boolean isOver = false;
       boolean isWin = false;
       
       if (!isOver && !isWin) {
          
           
           grp.setColor(Color.BLUE);
           grp.drawString("Day " + (this.day+1) + " / " + this.part_of_day_labels[this.part_of_day], getWorld().getWidth()-200,100);
       }
       
       
      
       
       
       
       
       
       
       
     
       
       
       if(this.sum_calories>= 3000 && this.sum_calories<6000)
       {
           grp.setColor(Color.RED);
           grp.setFont(new Font(true,true , 27));
           grp.drawString("YOUR CALORIES ARE INCREASING BE CAREFULL",w.getWidth()/2-290,70);
           
           
           setImage(grp);
        }
      
       
        
       setImage(grp);
   }
   
  
   public int getStatusPerson(){
       if (this.sum_calories<3000) {
           return 0;
       } else if (this.sum_calories>=3000 && this.sum_calories<6000) {
          
           return 1;
           
       } else if (this.sum_calories>=7000 && this.sum_calories<9000) {
           return 2;
       } else {
           return 3;
       }
    }
     
    public void nextStepDay()
    {
        this.part_of_day++;
        if (this.part_of_day>2) {
            this.day++;
            this.part_of_day = 0;
            
            
        }
        
    }
    
    public void addCalories(int calories)
    {
        this.sum_calories+=calories;
       
    }
    
    
}
