import java.util.*;
import java.io.File;

public class MazeofDoom{
    public static void main(String args[]){
        
       printFile("/projects/CS-150-LAB/README.md"); 
        
        Scanner direct = new Scanner(System.in);                                                                                                                                                                                                      
        
        System.out.println();
        System.out.println("      MMMMMMM     MMMMMM      AAAAAAAAA     ZZZZZZZZZ     EEEEEEEEEEE        OOOOOOOOOOO     FFFFFFFFFFF       DDDDDDDDD      OOOOOOOOOOO");
        System.out.println("      MMMM   MMMMM   MMMM     AA    AAA     ZZ    ZZZ     EEE                OOO      OO     FF                DD     DDD     OOO      OO"); 
        System.out.println("      MMMM    MMM    MMMM     AA    AAA          ZZZ      EE                 OO        O     FF                DD      DD     OO        O");
        System.out.println("      MMMM    MMM    MMMM     AAAAAAAAA         ZZZ       EEEEEEEEE          OO        O     FFFFFFFF          DD       D     OO        O");
        System.out.println("      MMMM    MM     MMMM     AA    AAA        ZZZ        EE                 OO        O     FF                DD      DD     OOOOOOOOOOO");
        System.out.println("      MMMM           MMMM     AA    AAA      ZZZ    Z     EEE                OOO      OO     FF                DD     DDD     OOOOOOOOOOO");
        System.out.println("      MMMM           MMMM     AA    AAA     ZZZZZZZZZ     EEEEEEEEEEE        OOOOOOOOOOO     FF                DDDDDDDDD      OOOOOOOOOOO");
        System.out.println();
        System.out.println();
        System.out.println("WELCOME TO THE MAZE OF DOOM!!!");
        System.out.println();
      
        int doomcap = 0;
        int stageamount = 0;
        int choice = 0;
        int ender = 0;
        
        while(choice == 0){
              
        System.out.println("Would you like to play on Easy, Medium, or Hard mode?");
        System.out.println();
        
        Scanner difficult = new Scanner(System.in);
        String difficulty = difficult.nextLine();
        difficulty = difficulty.toLowerCase();
        
        if (difficulty.equals("easy")){
            doomcap = 5;
            stageamount = 3;
            choice ++;
            
        }else if(difficulty.equals("medium")){
            doomcap = 3;
            stageamount = 5;
            choice ++;
            
        }else if(difficulty.equals("hard")){
            doomcap = 2; 
            stageamount = 10;
            choice ++;
            
        }else if(difficulty.equals("quit")){
            choice ++;
            ender++;
        }else{

            System.out.println("That was not a choice. Try again.");
        }
    }
    if(ender != 1){
        System.out.println();
        System.out.println("You must make it through the maze without recieving  " + doomcap + "Doom Points. \nDoom Points are rewarded to those who choose the wrong path.\nYou must make it through " + stageamount + " layers before recieving the " + doomcap +" Doom Points! GOOD LUCK.");
        
        int doompoints = 0;
        int stages = 1;
        String answer;
        
        while(doompoints < (doomcap) && stages < (stageamount + 1) && ender != 1){
            
        stagepoints(doompoints, stages, doomcap, stageamount);
        double num = (Math.random() * 10);
            if (num > 5){
                answer = "right";
            }else{
                answer = "left";
            }
        System.out.println(num); 
        String direction = direct.nextLine();
        direction = direction.toLowerCase();
        
        yes(direction, answer);
        System.out.println("You chose " + direction + " and the right direction is " + answer + ".");
        System.out.println();

        if (yes(direction, answer) == 1){
            if (stages != (stageamount - 1)){
                pathcorrect(stages);
            }
            stages++;
    
        }else if (yes(direction, answer) == 3){
            pathquit(ender);
            ender++;
        }else if(yes(direction, answer) == 0){
            pathnull();
        }else if(yes(direction, answer) == 2){
            
            if (doompoints != (doomcap - 1)){
                pathwrong(doompoints);
            }
            doompoints++;
        }   
    }
    if (doompoints >= doomcap){
        System.out.println("You have failed to navigate the Maze of Doom because you reached " + doomcap + " Doom Points. You reached stage " + stages + ". You Lose! HaHaHaHa");
    }
    if (stages >= stageamount){
        System.out.println("You have navigated through the Maze of Doom without reaching " + doomcap + "Doom Points! You Win!");
    }}}
    public static int yes(String choice, String answer){
            if (choice.equals(answer)){
                return 1;
            }else if(choice.equals("right")){
                return 2;
            }else if(choice.equals("left")){
                return 2;
            }else if(choice.equals("quit")){
                return 3;
            }else{
                return 0;
            }
        }      
    public static void printFile(String filename){
        try{
            Scanner reader = new Scanner(new File(filename)); 
            while(reader.hasNext()){
                System.out.println(reader.nextLine()); 
            }
        }catch(Exception e){
            System.out.println("no file found"); 
        }
    }
    public static void stagepoints(int doom, int stage, int doomcap, int stageamount){
        System.out.println("You are currently on Stage " + stage + " And you have " + doom + " Doom points! You can choose left or right. Which direction will you go? ");
        System.out.println("You have " + (stageamount - stage + 1) + " stage(s) to complete. You can earn " + (doomcap - doom) + " more Doom Point(s) before you fail.");
        System.out.println();
    }
    public static int pathcorrect(int stages){
        System.out.println("You chose correctly. You progress one stage and do not earn a Doom Point! How lucky!");
        return stages;
    }
    
    public static int pathwrong(int Doompoints){
        System.out.println("You chose incorrectly. You do not progress to the next stage and you earn a Doom Point! HaHaHaHa \nYou are set on a new path so you can't cheat!!");
        return Doompoints;   
        }
    public static void pathnull(){
        System.out.println("You chose a nonexistsant answer.");
    }
    public static int pathquit(int ender){
        System.out.println("You have quit");
        return ender ++;
    }
 }   
