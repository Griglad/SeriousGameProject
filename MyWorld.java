import java.util.*;
import greenfoot.*;
import greenfoot.Font;
/**
 * 
 * @author(Grigorios ladas)
 */
public class MyWorld extends World
{

    Actor person = null;
    Actor foods[][];
    private PersonScore person_score;
    private TitleScreen startImage;
   
  
    private boolean flag = false;
 
    /**
     * Constructor for objects of class MyWorld.
     */
    
    
    
     public MyWorld()
    {
        super(820, 500, 1);
        this.startImage = new TitleScreen("start");
        addObject(startImage,160,90);
        this.initialize();
    }
    
    public void initialize()
    
    
    {
        person_score = new PersonScore();
       
        addObject(new Τable(),getWidth()/2, getHeight()/2);
        addObject(person_score, getWidth()/2, 0);

        setPerson(person_score.getStatusPerson());
        
        
        
        
        foods = new Actor[3][]; //0=breakfast, 1=lunch, 2=dinner
        
        foods[0] = new Actor[6]; //all breakfast foods
        foods[0][0] = new Bread();
        foods[0][1] = new Juice_orange();
        foods[0][2] = new Cheesecake();
        foods[0][3] = new Milk();
        foods[0][4] = new Cup_tea();
        foods[0][5] = new Banana();
        
        
        
        
        foods[1] = new Actor[6]; //all lunch foods
        foods[1][0] = new Spaghetti();
        foods[1][1] = new Burger_spaghetti();
        foods[1][2] = new Salad();
        foods[1][3] = new Cola();
        foods[1][4] = new Fish();
        foods[1][5] = new Apple();
        
        
       
        
        
        foods[2] = new Actor[6]; //all dinner foods
        foods[2][0] = new Hamburger();
        foods[2][1] = new Steak_egg();
        foods[2][2] = new Cake_torte();
        foods[2][3] = new Salad();
        foods[2][4] = new Pizza();
        foods[2][5] = new Strawberry();
        
        setfoodsInTable(0); //morning food
    }
    
    
    public void setfoodsInTable(int type) {
        
        
        
        
        removeObjects(getObjects(food.class));
       
        this.shuffleActorArray(foods[type]);
        for (int i=0; i<foods[type].length; i++) {
            addObject(foods[type][i], i*130 + 50 , getHeight()*2/3);
        }
        
        setPaintOrder(food.class,Τable.class);
    }
    
    
   static void shuffleActorArray(Actor[] ar)
   {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          Actor a = ar[index];
          ar[index] = ar[i];
          ar[i] = a;
        }
   }
      private void showcalories()
    {
        showText("CALORIES " + person_score.sum_calories, 75 ,30 );

    }
   
    
   
    int times=0;
    
    int stage=0;
    public void act(){
     
           
        
        {
            if((Greenfoot.isKeyDown("enter")))
            {
                removeObject(startImage);
                flag = true;
            }
           
            
            if (flag)
            {
        
        showcalories();
         if(Greenfoot.mouseClicked(null)) {
          
            Actor target=(Actor)Greenfoot.getMouseInfo().getActor();
           
           
            if (target instanceof food) {
                Greenfoot.playSound("slurp.wav");
                removeObject(target);
                food f = (food)target;
                person_score.addCalories(f.getCalories());
                times++;
                if (times>1) {
                    setNextStage();
                    person_score.nextStepDay();
  
                    setPerson(person_score.getStatusPerson());
         
                    
                    
                    if (person_score.sum_calories < 7000 && person_score.day == 7 ) {
                       Greenfoot.playSound("congratulations.mp3");
                       showText("CONGRATULATIONS! YOU MADE MIKE KEEP HIS\nWEIGHT IN NORMAL LEVELS¨", getWidth()/2,90);
                       Greenfoot.stop();
                       
                    }
                    
           
                    
                    
                    
                   
                    
                    
                    if (person_score.sum_calories >= 7000) {
                         Greenfoot.stop();
                        Greenfoot.playSound("game-over.wav");
                        showText("UNFORTUNATELY THE DIET YOU ARE FOLLOWING IS NOT RIGHT\nAND MIKE KEEPS GAINING WEIGHT",getWidth()/2,90);
                       
                        this.initialize();
                        
                    }
                    
                    
       
                    
                    
                    times=0;
                }
            }
            

        }
    }
}
}
    
    

    public void setNextStage() {
        stage++;
        stage = stage % 3;
        setfoodsInTable(stage);

    }
    
    
    //level=0,1,2,3
    public void setPerson(int level) {
       
        
        //System.out.println(level);
        removeObject(this.person);
        switch (level) {
          case 0:
            this.person = new Normal_fat();
            break;
            
          case 1:
            this.person = new Middle_fat();
            
             break;
          case 2:
            this.person = new Enough_fat();
            break;
          case 3:
            this.person = new Very_fat();
            break;
        }
        
        addObject(this.person,getWidth()/2, getHeight()/2);
        
    }
}

