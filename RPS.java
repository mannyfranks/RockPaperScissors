import javax.swing.JOptionPane;

public class RPS{
   public static void main(String[] args) {
       //Variables and constants
       int user; //Take this out tomorrow
       int com;
       String userPick = " ";
       String comPick = " ";
       String message = " ";
       int gameCount = 1;
       int playerWins = 0;
       int userWins = 0;
       int comWins = 0;
       int tieGames = 0;
       final int NUM_GAMES = 10;

       //While loop controls the overall game structure
       while(gameCount <= NUM_GAMES){

           //Computer randomly chooses a number between 1 and 3
           com = 1 + (int)(Math.random() * 3);

           //reset the strings each time a new round is played
           userPick = "";
           message = "";


           //Validate the player data, allowing for some misspelling, loop the dialog prompt if the user does not give a valid selection
           while(!userPick.equalsIgnoreCase("ROCK") && !userPick.equalsIgnoreCase("PAPER") && !userPick.equalsIgnoreCase("SCISSORS")){
               userPick = JOptionPane.showInputDialog(null, "Please type one of the following: \nROCK \nPAPER \nSCISSORS");

               userPick = userPick.toLowerCase();
               //Now we have what the user typed, check if the first two characters are correct, asdsign the proper selection from there
               if(userPick.startsWith("ro")){
                   userPick = "ROCK";
               }
               else{
                   if(userPick.startsWith("pa")){
                        userPick = "PAPER";
                   }else{
                        if(userPick.startsWith("sc")) {
                            userPick = "SCISSORS";
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid Selection");
                        }
                   }
               }
           }

           //User chooses a number representing an item
           //user = Integer.parseInt(JOptionPane.showInputDialog(null, "A new challenger has appeared! \nPlease choose wisely:\n1 -- ROCK\n2 -- PAPER \n3 -- SCISSORS"));

           //Decision making process which assigns a string with the item name to the numeric choices


           //Computers String
           if(com == 1){
               comPick = "ROCK";
           }
           else{
               if(com == 2)
               {
                   comPick = "PAPER";
               }
               else{
                   comPick = "SCISSORS";
               }
           }

           //Game mechanics
           if(userPick.equalsIgnoreCase(comPick)) {
                tieGames++;
                message = "we have a tie";
           }else{
               //if not a tie
               if(userPick.equalsIgnoreCase("ROCK")) {
                    if(comPick.equalsIgnoreCase("PAPER")) {
                        //computer wins
                        comWins++;
                        message = "the computer has won";
                    }else{
                        //player wins
                        userWins++;
                        message = "you win";
                    }
               }
               //what if player didnt pick rock
               else{
                   if(userPick.equalsIgnoreCase("PAPER")) {
                        if(comPick.equalsIgnoreCase("SCISSORS")) {
                            comWins++;
                            message = "computer wins";
                        }else{
                            userWins++;
                            message = "You win!";
                        }
                   }
                   else{
                       if(comPick.equalsIgnoreCase("ROCK")) {
                        comWins++;
                        message = "computer wins";
                       }else{
                           userWins++;
                           message = "computer wins";
                       }
                   }               }
           }
           
           //We have everything we need, this is the output

JOptionPane.showMessageDialog(null, "You selsected " + userPick + "\nComputer selected " + comPick + "\nOutcome: " + message);

           //Increment the gameCount variable by 1
           gameCount++;
       }
       JOptionPane.showMessageDialog(null, "score after " + NUM_GAMES + " games. \nUser wins: " + userWins + "\nComputer wins: " + comWins + "\nTie games: " + tieGames);
   }
}
