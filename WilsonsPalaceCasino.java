/***********************************************************
/* Wilsons Palace Casino
/* by Shane Lemieux
/* In this game...
/* This game includes the following METHODS:
/* Shane - GUI + exit button, Loaning
/* Jake - Baccarat, exit code
/* Nicholas - Slot Machine
/* Allix - Craps
/* Hasher - Quiz
/**************************************************************/


// JAVAGUI
import java.awt.*;
import javax.swing.*;
import java.util.EventObject;
import java.awt.image.*;

//CRAPS
import java.util.Scanner;
import java.util.Random; 
//BACCARAT
import java.io.FileWriter;
import java.io.File;
import java.io.IOException; // Used in forcing rules on the 1st 'bout
//SLOTS
import java.util.*;

class CasinoOne
{
  static File file = new File("tmp.dat"); // Creates file object. It's public as it's needed in Baccarat
  
  public static void main(String[] args) throws IOException
  {
    int money = 500; // Money you start with
    int w = 150; // Size of the buttons
    int h = 75;
    // Variables for loaning
    int loansAvailable = 9;
    int loanClicks = 0;
    
    // Program info
    JFrame frame = new JFrame("Wilson's Palace Casino");
    frame.setSize(700,700); // Size of program
    frame.setLocation(0,0); // top left of the screen
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    // Enter the casino
    JButton button1 = new JButton("Start");
    JEventQueue event = new JEventQueue();
    event.listenTo(button1, "Button1");
    JBox body = JBox.vbox(button1);
    frame.add(JBox.vbox(JBox.vglue(),
                        JBox.hbox(JBox.hglue(), body, JBox.hglue()),
                        JBox.vglue()));
    frame.setVisible(true);
    event.waitEvent();
    body.removeAll();
    frame.repaint();
    
    // Casino Area
    // Buttons
    JButton craps = new JButton("Craps Game");
    JBox.setSize(craps, w, h);
    craps.setToolTipText("Play this game!");
    
    JButton slots = new JButton("Slots");
    JBox.setSize(slots, w, h);
    
    JButton quiz = new JButton("Quiz");
    JBox.setSize(quiz, w, h);
    
    JButton baccarat = new JButton("Baccarat");
    JBox.setSize(baccarat, w, h);
    
    JFormattedTextField loanmoney = new JFormattedTextField("$" + money + "\n Loans Available: 10");
    JBox.setSize(loanmoney, w,h);
    loanmoney.setEditable(false);
    
    JButton loan = new JButton("Loan");
    JBox.setSize(loan, w, h);
    loan.setToolTipText("We will loan you $500");
    
    JButton exit = new JButton("Exit");
    exit.setBackground(Color.RED);
    exit.setToolTipText("Close the program.");
    
    JTextField user = new JTextField("Please enter your username in the console.");
    JBox.setSize(user, 700, h); 
    user.setHorizontalAlignment(user.CENTER);
    user.setEditable(false);
    
    // Background Image
    ImageIcon casinoBackground = new ImageIcon ("background.png");
    JLabel background = new JLabel(casinoBackground);
    
    // Display
    JBox buttonFrame1 = JBox.vbox(
                                  JBox.hbox(exit),
                                  JBox.hbox(JBox.hglue(), user, JBox.hglue()),
                                  JBox.hbox(background),
                                  JBox.hbox(JBox.vglue(), loan, loanmoney, JBox.hglue(), JBox.vbox(craps, quiz), JBox.vbox(slots, baccarat))
                                 );
    
    
    
    frame.add(buttonFrame1); // Displays Buttons
    frame.validate();

    
    
    System.out.println("Welcome to Wilson's Palace! \n");
    System.out.println("Please enter your name: \n  ");
    String username = In.getString();
    System.out.println("Welcome, " + username + "! \n ");
    user.setText("Welcome, " + username + "!");

    
    JEventQueue games = new JEventQueue();
    games.listenTo(craps, "craps");
    games.listenTo(loan, "Loan");
    games.listenTo(slots, "slots");
    games.listenTo(quiz, "quiz");
    games.listenTo(baccarat, "baccarat");
    games.listenTo(exit, "exit");
    while(true)
    {
      if (loansAvailable != -1) // Allows the user to ask for a loan if they have enough, else it gets disabled
      {
        loan.setEnabled(true);
      }
      craps.setEnabled(true);
      slots.setEnabled(true);
      quiz.setEnabled(true);
      baccarat.setEnabled(true);
      EventObject eventss = games.waitEvent();
      String name = games.getName(eventss);
      // If game is running the buttons will be disabled (Once it loops back the buttons will be enabled again)
      craps.setEnabled(false);
      loan.setEnabled(false);
      slots.setEnabled(false);
      quiz.setEnabled(false);
      baccarat.setEnabled(false);
      if (name.equals("craps"))
      {
        money=craps(money);
        System.out.println("Returning to the main menu.");
        loanmoney.setValue("$" + money + "\n Loans Available: " + loansAvailable); // after every game update money on the main menu
      }
      else if (name.equals("Loan"))
      {
        if (loanClicks < 10)
        {
          loanClicks++;
          int currentMoney = money;
          int newMoney = currentMoney + 500;
          money = newMoney;
          loanmoney.setValue("$" + money + "\n Loans Available: " + loansAvailable);
          System.out.println(loanClicks + ": "+ currentMoney + " + 500 = " + money);
          loansAvailable--;
        }
      }
      else if (name.equals("slots"))
      {
        money=slots(money);
        System.out.println("Returning to the main menu.");
        loanmoney.setValue("$" + money + "\n Loans Available: " + loansAvailable);
      }
      else if (name.equals("quiz"))
      {
        money=quiz(money);
        System.out.println("Returning to the main menu.");
        loanmoney.setValue("$" + money + "\n Loans Available: " + loansAvailable);
      }
      else if (name.equals("baccarat"))
      {
        money = baccarat(money, false);
        System.out.println("Returning to the main menu.");
        loanmoney.setValue("$" + money + "\n Loans Available: " + loansAvailable);
      }
      else if (name.equals("exit"))
      {
        System.out.println("\nThank you for joining us today! We hope to see you again soon. \n ");
        file.delete(); // Deletes the file created in baccarat
        break;
      }
    }
  } 
  
  
// _______________________________________________________________________________________________________________________________________________
  
  // Created by Shane
  public static int loaning (int money)
  {
    money = money + 500;
    return money;
  }
  
  // Created by everyone else
  public static int baccarat (int money, boolean lobbyCheck) throws IOException
    
  { // Opening Main
    int baccaratLobbyOrMainLobby, baccaratContinueText;
    if (!lobbyCheck)
    {
      if(file.exists())
      { // Opening if the file exist 
        baccaratLobby(money);
      } // Closing if the file exist
      
      else 
      { // Opening if the file doesn't exist yet 
        FileWriter fw = new FileWriter(file); // Creates a Writer
        fw.write(" "); // Write temp data to tmp.dat (temporary data)
        fw.close(); // Closes the writer (so that another file can't be made)file
        
        
        System.out.print("\nHowdy! First time around these parts, partner? ");
        System.out.println("No worries! Allow me to give you the rundown on how good 'ol Baccarat works. \n ");
        System.out.println("(Type any key once you are ready to continue) \n ");
        baccaratContinueText = In.getInt();
        baccaratContinueText = 0;
        while (1 > (baccaratContinueText))
        { // Opening slowing down text output
          baccaratGeneralRules();
          System.out.println("\nYou got that pal? Well, I sure hope you did, cause now I'm gonna explain the way the bettin' works. \n ");
          System.out.println("(Type any key once you are ready to continue) \n ");
          baccaratContinueText = In.getInt();
          baccaratContinueText = 0;
          while (1 > (baccaratContinueText))
          { // Opening slowing down text output
            baccaratGamblingRules();
            System.out.println("\nAlrighty. That's enough from me - I hope that I didn't scare you away! I sure do talk a lot... ");
            System.out.println("\n(Type 1 if you want to head back to the Lobby) \n ");
            baccaratLobbyOrMainLobby = In.getInt();
            if (baccaratLobbyOrMainLobby == 1)
            { // Opening sending user to lobby
              System.out.println("\n\n\nWhat?! You're heading back to the lobby already? Well, if you want to, I guess I can't stop you... \n ");
              System.out.println("Hope to see you again soon! \n ");
              return (money); 
            } // Closing sending user to lobby
            
            else
            { // Opening sending user to the baccarat lobby
              baccaratLobby(money);
            } // Closing sending user to the baccarat lobby
            
          } // Closing slowing down text output
          
        } // Closing slowing down text output
        
      } // Closing if the file doesn't exist yet
      
    } // Closing lobby check
    
    System.out.println("\n\n\nWhat?! You're heading back to the lobby already? Well, if you want to, I guess I can't stop you... \n ");
    System.out.println("Hope to see you again soon! \n ");
    return (money); 
    
  } // Closing baccaratMain
  
  public static void baccaratLobby(int money) throws IOException
    
  { // Opening baccarat lobby
    int baccaratLobbySelection, baccaratRulesSelection;
    boolean baccaratRulesNeeded = true;
    
    System.out.println("\nYou currently have $" + money + ". \n ");
    System.out.println("What would you like to do? \n");
    System.out.println("  +  Type 1 for the Rules ");
    System.out.println("  +  Type 2 to Start the Game \n ");
    System.out.println("If you'd like to return to the lobby, enter any other input. \n ");
    baccaratLobbySelection = In.getInt();
    
    if (baccaratLobbySelection == 1)
    { // Opening Rules Selection
      
      while (baccaratRulesNeeded == true)
      { // Opening rules loop
        System.out.println("\nForgetting the rules, aren't ya? Well, what is it that you'd like to know? \n ");
        System.out.println("  +  Type 1 for the General Rules ");
        System.out.println("  +  Type 2 for the Gambling Rules \n ");
        System.out.println("If you'd like to return to the baccarat lobby, enter any other input. \n ");
        baccaratRulesSelection = In.getInt();
        if (baccaratRulesSelection == 1)
        { // Opening sending user to general rules
          baccaratGeneralRules();
          baccaratLobby(money);
        } // Closing sending user to general rules
        
        else if (baccaratRulesSelection == 2)
        { // Opening sending user to gambling rules
          baccaratGamblingRules();
          baccaratLobby(money);
        } // Closing sending user to gambling rules
        
        else
        { // Opening returning user to baccarat lobby from re-reading rules
          System.out.println("\nAlright, glad you've got it down now. Let's get playing already! \n ");
          baccaratRulesNeeded = false;
          baccaratLobby(money);
        } // Closing returning user to baccarat lobby from re-reading rules
        
      } // Closing rules loop
      
    } // Closing Rules Selection
    
    else if (baccaratLobbySelection == 2)
    { // Opening the Record Book
      baccaratGame(money);
    } // Closing the Record Book
    
    else
    { // Opening User Returns to Lobby
      baccarat(money, true);
    } // Closing User Returns to Lobby
    
  } // Closing baccarat lobby
  
  public static void baccaratGeneralRules()
    
  {
    System.out.println("\n\nFirst thing you need to know - Baccarat is a game of pure skill and has absolutely 0 luck involved. ");
    System.out.println("Who am I kidding. This is a gambling game! There is quite literally no real strategy to increase your odds.");
    System.out.print("\nYou're a bystander, spectating a game being played between two players. The two players are known as the Banker, and the ");
    System.out.println("Player. \n\nAt the start of a round, you may place a bet on either of the following 3 options: ");
    System.out.println("\n  -  The Player's hand; \n  -  The Banker's hand; \n  -  a Draw. \n ");
    System.out.println("Note, neither the banker's hand or the player's hands are associated with the player themselves or the casino/house. ");
    System.out.println("\nOnce bets are made, both the banker and the player are dealt two cards. ");
    System.out.println("Each number card from 2 through to 9 has a value equal to the number on the card. ");
    System.out.println("10s, Jacks, Queens and Kings have a value of 0. Aces have a value of 1. ");
    System.out.println("The winner is the one who's cards have a value that is closest to 9. ");
    System.out.println("\nIf the total of either the player or banker's hand has a value that exceeds 9, then the left-most digit is dropped. ");
    System.out.println("For example, say the player's hand consists of a 7 and a 8. The value of the hand, when added together, would be 15. ");
    System.out.println("However, as 15 is a double-digit number, it losses it's left-most digit. Therefore, a hand of 7 and 8 has a value of 5. ");
    System.out.println("\nBoth hands are revealed and tallied. The outcome is then revealed, and whoever's hand is closest to 9 wins the round. ");
    System.out.println("Then, any and all bettors will either gain or lose money according to the bets they made prior to the round starting. ");
    System.out.println("\nLastly, as most veteran Baccarat players may have noticed by now, there is no Dragon Bonus in this version of Baccarat. \n "); 
  }
  
  public static void baccaratGamblingRules()
    
  {
    System.out.println("\n\nYou may choose how you feel about the upcoming hand. You may either be: \n ");
    System.out.println("  +  Very confident; ");
    System.out.println("  +  Confident; ");
    System.out.println("  +  Unconfident; ");
    System.out.println("  +  Indecisive. \n ");
    System.out.println("How you feel about the upcoming round dictates which range of money you will randomly be betting with/for. ");
    System.out.println("Note, this value is unknown to the user, and won't be revealed until the end of the round. \n ");
    System.out.println("If you are \"Very Confident\", you're betting between 750 and 1500 dollars. ");
    System.out.println("If you are \"Confident\", you're betting between 250 and 500 dollars. ");
    System.out.println("If you are \"Unconfident\", you're betting between 1 and 100 dollars. ");
    System.out.println("If you are \"Indecisive\", you elect to pass on the round and do not place a bet. \n ");
    System.out.print("Note: If you do not have at least the maximum possible value of a certain bet, ");
    System.out.println("you will not be able to place that kind of bet. \n ");
    System.out.println("If your bet is successful, then the random amount that you had bet is doubled and returned to your pockets. ");
    System.out.println("However, if your bet is unsuccessful, then you lose all of your money that you had blindly bet with. \n ");
  }
  
  public static void baccaratGame(int money) throws IOException
  {
    int baccaratCardsDealt = 0, baccaratCardsRevealed = 0, baccaratCardsCorrectedAndAdded = 0, baccaratContinueText = 0; 
    int baccaratIntBankerCardA = 0, baccaratIntBankerCardB = 0, baccaratIntPlayerCardA = 0, baccaratIntPlayerCardB = 0, baccaratRoundWinner = 0;
    int baccaratUserBettingValue= 0, baccaratPrediction = 0, baccaratIntValueOfBankerHand = 0, baccaratIntValueOfPlayerHand = 0;
    
    while (baccaratRoundWinner == 0)
    { // Opening baccarat game being played
      System.out.println("\n\nYou currently have $" + money + ". \n"); 
      System.out.println("How you feelin' about this round, champ? \n ");
      System.out.println("  +  1 = Very Confident; \n  +  2 = Confident; \n  +  3 = Unconfident; \n  +  Other = Indecisive; \n ");
      baccaratUserBettingValue = In.getInt();
      if (baccaratUserBettingValue == 1)
      { // Opening checking if user has enough money to make very confident bet
        if (money < 1500)
        {
          System.out.println("\nWoah there, that's A LOT A money buddy. Seems your wallet isn't as confident as you are. You should make a smaller bet this round. \n ");
          baccaratUserBettingValue = In.getInt();
        }
        
        else if (money >= 1500)
        {} // Has enough money, continue
        
      }
      
      else if (baccaratUserBettingValue == 2)
      { // Opening checking if user has enough money to make very confident bet
        if (money < 500)
        {
          System.out.println("Woah there, that's A LOT A money buddy. Seems your wallet isn't as confident as you are. You should make a smaller bet this round. \n ");
          baccaratUserBettingValue = In.getInt();
        }
        
        else if (money >= 500) 
        {} // Has enough money, continue
        
      }
      
      else if (baccaratUserBettingValue == 3)
      { // Opening checking if user has enough money to make very confident bet
        if (money < 100)
        {
          System.out.println("Woah there, that's A LOT A money buddy. Seems your wallet isn't as confident as you are. You should make a smaller bet this round. \n ");
          baccaratUserBettingValue = In.getInt();
        }
        
        else if (money >= 100) 
        {} // Has enough money, continue
        
      }
      
      while  (baccaratUserBettingValue == 1 || baccaratUserBettingValue == 2 || baccaratUserBettingValue == 3)
      { // Opening if a bet is made on the round
        
        System.out.println("Oho! We got outselves a punter this time 'round. Place your bet bud, and start crossin' your fingers. \n ");
        System.out.println("  +  Type 1 to bet on the Banker ");
        System.out.println("  +  Type 2 to bet on the Player ");
        System.out.println("  +  Type 3 to bet on a Draw  \n ");
        baccaratPrediction = In.getInt();
        while (baccaratPrediction != 1 || baccaratPrediction != 2 || baccaratPrediction != 3)
        { // Opening if user doesn't make a prediction
          System.out.println("(That is not a proper prediction) \n "); 
          baccaratPrediction = In.getInt();
        } // Closing if user doesn't make a prediction
        break;
        
      } // Closing if a bet is made on the round
      
      while (baccaratCardsDealt != 4)
      { // Opening cards dealt loop
        baccaratCardsDealt ++;
        if (baccaratCardsDealt == 1)
        { // Opening 1 card is dealt
          baccaratIntBankerCardA = baccaratRandomizeCardValue();
        } // Closing 1 card is dealt
        
        else if (baccaratCardsDealt == 2)
        { // Opening 2 cards are dealt
          baccaratIntBankerCardB = baccaratRandomizeCardValue();
        } // Closing 2 cards are dealt
        
        else if (baccaratCardsDealt == 3)
        { // Opening 3 cards are dealt
          baccaratIntPlayerCardA = baccaratRandomizeCardValue();
        } // Closing 3 cards are dealt
        
        else if (baccaratCardsDealt == 4)
        { // Opening 4 cards are dealt
          baccaratIntPlayerCardB = baccaratRandomizeCardValue();
        } // Closing 4 cards are dealt
        
      } // Closing cards dealt loop
      
      while (baccaratCardsRevealed != 4)
      { // Opening cards revealed loop
        baccaratCardsRevealed ++;
        if (baccaratCardsRevealed <= 2)
        { // Opening banker's cards revealed loop
          
          if (baccaratIntBankerCardA == (baccaratIntBankerCardB))
          { // Opening both banker's cards are the same
            baccaratCardsRevealed ++; // Both of the banker's cards are done at once
            System.out.print("\nThe banker drew two ");
            baccaratRevealCards(baccaratIntBankerCardA);
            System.out.println("'s. \n ");
          } // Closing both banker's cards are the same
          
          else
          { // Opening banker's cards aren't the same
            if (baccaratCardsRevealed == 1)
            { // Opening banker's first card is revealed
              System.out.print("\nThe banker drew a");
              baccaratRevealCards(baccaratIntBankerCardA);
            } // Closing banker's first card is revealed
            
            else if (baccaratCardsRevealed == 2)
            { // Opening banker's second card is revealed
              System.out.print(" and a");
              baccaratRevealCards(baccaratIntBankerCardB);
              System.out.println(". \n ");
            } // Closing banker's second card is revealed
            
          } // Closing banker's cards aren't the same
          
        } // Closing banker's cards revealed 
        
        else 
        { // Opening player's cards revealed loop
          if ((baccaratIntPlayerCardA) == (baccaratIntPlayerCardB))
          { // Opening both player's cards are the same
            baccaratCardsRevealed ++; // Both of the player's cards are done at once
            System.out.print("The player drew two ");
            baccaratRevealCards(baccaratIntPlayerCardA);
            System.out.println("'s. \n ");
          } // Closing both player's cards are the same
          
          else 
          { // Opening player's cards aren't the same
            if (baccaratCardsRevealed == 3)
            { // Opening player's first card is revealed
              System.out.print("The player drew a");
              baccaratRevealCards(baccaratIntPlayerCardA);
            } // Closing player's first card is revealed
            
            else if (baccaratCardsRevealed == 4)
            { // Opening player's second card is revealed
              System.out.print(" and a");
              baccaratRevealCards(baccaratIntPlayerCardB);
              System.out.println(". \n ");
            } // Closing player's second card is revealed
            
          } // Closing player's cards aren't the same
          
        } // Closing player's cards revealed loop
        
      } // Closing cards revealed loop
      
      while (baccaratCardsCorrectedAndAdded != 4)
      { // Opening cards values corrected
        baccaratCardsCorrectedAndAdded ++;
        if (baccaratCardsCorrectedAndAdded == 1)
        { // Opening banker's first card is corrected
          baccaratIntBankerCardA = baccaratCorrectCardValues(baccaratIntBankerCardA);
        } // Closing banker's first card is corrected
        
        else if (baccaratCardsCorrectedAndAdded == 2)
        { // Opening banker's second card is corrected
          baccaratIntBankerCardB = baccaratCorrectCardValues(baccaratIntBankerCardB);
          baccaratIntValueOfBankerHand = ((baccaratIntBankerCardA) + (baccaratIntBankerCardB));
        } // Closing banker's second card is corrected
        
        else if (baccaratCardsCorrectedAndAdded == 3)
        { // Opening player's first card is corrected
          baccaratIntPlayerCardA = baccaratCorrectCardValues(baccaratIntPlayerCardA);
        } // Closing player's first card is corrected
        
        else if (baccaratCardsCorrectedAndAdded == 4)
        { // Opening player's second card is corrected
          baccaratIntPlayerCardB = baccaratCorrectCardValues(baccaratIntPlayerCardB);
          baccaratIntValueOfPlayerHand = (baccaratIntPlayerCardA + baccaratIntPlayerCardB);
        } // Closing player's second card is corrected
        
      } // Closing cards values corrected and added loop
      
      System.out.print("Therefore, the Banker's hand has a value of " + baccaratIntValueOfBankerHand);
      System.out.println(" and the Player's hand has a value of " + baccaratIntValueOfPlayerHand + " \n ");
      
      System.out.println("(Type any key once you are ready to continue) \n ");
      baccaratContinueText = In.getInt();
      baccaratContinueText = 0;
      while (1 > (baccaratContinueText))
      { // Opening slowing down text output
        break;
      } // Opening slowing down text output
      
      if (baccaratIntValueOfBankerHand > (baccaratIntValueOfPlayerHand))
      { // Opening banker wins
        baccaratRoundWinner = 1;
      } // Closing banker wins
      
      else if (baccaratIntValueOfBankerHand < (baccaratIntValueOfPlayerHand))
      { // Opening player wins
        baccaratRoundWinner = 2;
      } // Closing player wins
      
      else if (baccaratIntValueOfBankerHand == (baccaratIntValueOfPlayerHand))
      { // Opening nobody wins
        baccaratRoundWinner = 3;
      } // Closing nobody wins
      
      
      if (baccaratUserBettingValue == 1) 
      { // Opening very confident bet
        Random roller = new Random(); // Generates a new random value
        
        int baccaratRandomizedEarnings = roller.nextInt(1500)+1; //Here's where the earnings are randomized
        
        if (baccaratPrediction == (baccaratRoundWinner))
        { // Opening user wins
          System.out.println("You won $" + baccaratRandomizedEarnings + "! Congrats! \n ");
          money = (money) + (baccaratRandomizedEarnings);
        } // Closing user wins
        
        else
        { // Opening user loses
          System.out.println("You lose $" + baccaratRandomizedEarnings + "... :( \n ");
          money = (money) - (baccaratRandomizedEarnings);
        } // Closing user loses
        
      } // Closing very confident bet
      
      else if (baccaratUserBettingValue == 2)
      { // Opening confident bet
        Random roller = new Random(); // Generates a new random value
        
        int baccaratRandomizedEarnings = roller.nextInt(500)+1; //Here's where the earnings are randomized
        
        if (baccaratPrediction == (baccaratRoundWinner))
        { // Opening user wins
          System.out.println("You won $" + baccaratRandomizedEarnings + "! Congrats! \n ");
          money = (money) + (baccaratRandomizedEarnings);
        } // Closing user wins
        
        else
        { // Opening user loses
          System.out.println("You lose $" +baccaratRandomizedEarnings + "... :( \n ");
          money = (money) - (baccaratRandomizedEarnings);
        } // Closing user loses
        
      } // Closing confident bet
      
      else if (baccaratUserBettingValue == 3)
      { // Opening unconfident bet
        Random roller = new Random(); // Generates a new random value
        
        int baccaratRandomizedEarnings = roller.nextInt(100)+1; //Here's where the earnings are randomized
        
        if (baccaratPrediction == (baccaratRoundWinner))
        { // Opening user wins
          System.out.println("You won $" + baccaratRandomizedEarnings + "! Congrats! \n ");
          money = (money) + (baccaratRandomizedEarnings);
        } // Closing user wins
        
        else
        { // Opening user loses
          System.out.println("You lose $" +baccaratRandomizedEarnings + "... :( \n ");
          money = (money) - (baccaratRandomizedEarnings);
        } // Closing user loses
        
      } // Closing unconfident bet
      
      else
      {} // No bet was made
      
    } // Closing baccarat running
    System.out.println("\nWould you like to play again, my friend? \n ");
    System.out.println("(Type 1 if you'd like to play again. Otherwise, return to the baccarat lobby) \n ");
    int baccaratPlayAgain = In.getInt();
    if (baccaratPlayAgain == 1)
    { // Opening if the player wants to play baccarat again
      baccaratGame(money);
    } // Closing if the player wants to play baccarat again
    
    else
    { // Opening if the player wants to return to the baccarat lobby
      baccaratLobby(money);
    } // Opening if the player wants to return to the baccarat lobby
    
  } // Closing baccarat game being played
  
  public static int baccaratRandomizeCardValue()
  { // Opening randomizing the card value
    
    Random roller = new Random(); // Generates a new random value
    
    int baccaratCard = roller.nextInt(13)+1; //Here's where the card is given a random value between 1 and 13
    
    return (baccaratCard); // Sends back the random value of the card to the main method
    
  } // Closing randomizing the card value
  
  public static void baccaratRevealCards(int baccaratCard)
  { // Opening revealing the card value
    if (baccaratCard == 1)
    { // Opening random card is an ace
      System.out.print("n Ace");
    } // Closing random card is an ace
    
    else if (baccaratCard == 11)
    { // Opening random card is a jack
      System.out.print(" Jack");
    } // Closing random card is a jack
    
    else if (baccaratCard == 12)
    { // Opening random card is a queen
      System.out.print(" Queen");
    } // Closing random card is a queen
    
    else if  (baccaratCard == 13)
    { // Opening random card is a king
      System.out.print(" King");
    } // Closing random card is a king
    
    else
    { // Opening random card is a number
      System.out.print(" " + baccaratCard);
    } // Closing random card is a number
    
  } // Closing revealing the card value
  
  public static int baccaratCorrectCardValues(int baccaratCard)
  { // Opening correcting the card value 
    if (baccaratCard > 9)
    { // Opening card is a ten, jack, queen or king
      baccaratCard = 0;
    } // Closing card is a ten, jack, queen or king
    
    else {} // Card does not need to be corrected
    
    return (baccaratCard);
    
  } // Closing correcting the card value
  // End Of Jake Schliebener Baccarat Code
  // _______________________________________________________________________________________________________________________________________________
  
//---------------------------------------------------------------------------------------------------------------------------------------------------
  //_______________________________________________________________________________________________________________________________________________
  
  //_______________________________________________________________________________________________________________________________________________
  
/////////////////////////////////////////////
// Nicholas' Wilson's Palace Slot Machine //
////////////////////////////////////////////
  public static int slots (int tokens)
  {
    Scanner keyboard = new Scanner (System.in);
    int pull, afterTokens, spin1, spin2, spin3;
    String answer;
    
    System.out.println ("--Palace Slot Machine--");
    System.out.println ("Welcome to The Wilson's Palace Slot Machine! You have " + tokens + " Palace Tokens. Each spin costs 1 Palace Token. Would you like to play? (Y for yes, N for no)");
    answer = keyboard.next ();
    while (answer.equalsIgnoreCase ("Y"))
    {
      tokens = tokens - 1;
      spin1 = (int) (Math.random () * 3) + 1;
      spin2 = (int) (Math.random () * 3) + 1;
      spin3 = (int) (Math.random () * 3) + 1;
      if (spin1 == 1 && spin2 == 1 && spin3 == 1)
      {
        tokens = tokens + 4;
        System.out.println ("[" + spin1 + "]" + "[" + spin2 + "]" + "[" + spin3 + "] You gained 4 Palace Tokens!!!! You now have " + tokens + " Palace Tokens!");
      }
      else if (spin1 == 2 && spin2 == 2 && spin3 == 2)
      {
        tokens = tokens + 8;
        System.out.println ("You gained 8 Palace Tokens!!! You now have " + tokens + " tokens!");
      }
      else if (spin1 == 3 && spin2 == 3 && spin3 == 3)
      {
        tokens = tokens + 12;
        System.out.println ("You gained 12 Palace Tokens!!! You now have " + tokens + " tokens!");
      }
      else
      {
        System.out.println ("Ah man! You lose! You now have " + tokens + " tokens!");
      }
      System.out.println ("Would you like to play again? You have " + tokens + " tokens.");
      answer = keyboard.next ();
    }
    if (answer.equalsIgnoreCase ("N"));
    {
      System.out.println ("Thanks for playing at the Wilson's Palace Slot Machine! You ended with " + tokens + " tokens!");    
    }
    return(tokens); 
  }
  
//  //_______________________________________________________________________________________________________________________________________________
  
  //_______________________________________________________________________________________________________________________________________________
  /*******************************************************************************************************/
  /* Methods Project */
  /* ICS3U */
  /* by Allix Fletcher */
  /* last updated: 5/17/19 */
  /* */
  /* This program lets users play a version of craps. It uses methods and returns values.*/
  /*******************************************************************************************************/
  public static int craps (int bank)
  {
    Scanner input = new Scanner (System.in);
    int gameplay = 0;
    System.out.println("WELCOME TO CRAPS\nYou are the shooter.");
    System.out.println("Would you like to read the rules?");
    String rules = input.next();
    if (rules.equalsIgnoreCase("yes")){
      System.out.println("_____________________________________________________________________________________________\nCRAPS RULES");
      System.out.println("At the beginning of each round, you must make either a \"Pass Line\" or \"Don't Pass\" bet.");
      System.out.println("These bets are 1:1. A \"Pass Line\" bet is betting that you will roll a NATURAL (7 or 11).");
      System.out.println("A \"Don't Pass\" bet is betting that you will roll CRAPS (2, 3 or 12). Otherwise, if you ");
      System.out.println("roll a 4, 5, 6, 8, 9 or 10, that number is set as the POINT. To win a \"Pass Line\" bet you");
      System.out.println("must roll the POINT again before you roll a 7. A \"Don't Pass\" bet is won if a 7 is rolled");
      System.out.println("first. When \"Pass Line\" bets win, \"Don't Pass\" bets lose and vice versa.");
      System.out.println("\nWhen you set the POINT, you have the option to make a \"Free Odds\" bet. This means you are");
      System.out.println("betting the point will be rolled before a 7. The payout of these bets is the same as the odds");
      System.out.println("of rolling whichever number the POINT is. The payout for rolling a 10 or 4 is 2:1, rolling a ");
      System.out.println("5 or 9 is 3:2, and rolling a 6 or 8 is 6:5.");
      System.out.println("\nYou must bet in whole dollars (no cents) and cannot bet more money than you have. If you run");
      System.out.println("out of money you will not be permitted to continue.");
      System.out.println("_____________________________________________________________________________________________");
    }  
    
    if(bank <= 0){//don't let them play if they don't have enough money
      
      System.err.println("\nCurrent balance: $" + bank);
      System.out.println("You do not have enough money to play CRAPS.\nReturn to the MAIN MENU to take out a loan."); 
    }
    else if (bank > 0){
      do{
        bank = shoot(bank);//set the money to what they come out of a round with
        if (bank <= 0){//don't keep playing if you run out of money
          
          System.err.println("\nCurrent balance: $" + bank);//written separetly so this one can be red and angry
          System.out.println("You do not have enough money to play CRAPS.\nReturn to the MAIN MENU to take out a loan.");
          gameplay++;
        }
        else if (bank > 0){
          System.out.println("\nCurrent balance: $" + bank);
          System.out.println("CONTINUE? (yes/no)");
          String cont = input.next();
          
          if (cont.equalsIgnoreCase("no")){
            gameplay++;
          }
        }
      }while(gameplay==0);//loop to keep going into the gameplay (shoot) method
    }
    input.nextLine();
    System.out.println("Come Again Soon.");
    System.out.println("\nHIT ENTER TO EXIT.");
    input.nextLine();
    input.close();
    return (bank);
  }
  
  public static int roll () //rolls the dice (randomly)
  {
    Random rolldice = new Random ();
    return rolldice.nextInt(6)+1; //0-5 +1 means 1-6 (values a dice would have)
  } 
  
  
  public static int free (int bet, int situation)
  {
    int money = 0; //what will be returned (if they didn't make an free odds bet it returns zero to add to total)
    if (bet!=0){
      if (situation==4||situation==10){ //the odds for rolling a 10 or 4 are both 2-1
        money = bet*2;}
      else if (situation==5||situation==9){
        money = bet/2*3;}
      else if (situation==6||situation==8){
        money = bet/5*6;}
    }
    return money; //if they didn't make an free odds bet it returns zero to be added or subtracted from  total
  }
  
  
  public static int shoot (int balance)
  {
    Scanner input = new Scanner (System.in);  
    System.out.println("\nNEW COME OUT ROLL");
    String passbet = ""; //so it can be resolved in the do while
    int pbamount = 0;
    int foamount = 0;
    do{
      System.out.println("To begin the round, place either a \"Pass Line\" or \"Don't Pass\" bet.");
      passbet = input.nextLine(); //to accept the space between the words (if they type both words)
    }while (!passbet.equalsIgnoreCase("Pass Line")&&!passbet.equalsIgnoreCase("Don't Pass")&&!passbet.equalsIgnoreCase("Pass")&&!passbet.equalsIgnoreCase("Don't"));
    do{
      System.out.println("\nHow much would you like to bet?\n(must be greater than $0 and not exceed your current balance: $"+balance+")");
      pbamount = input.nextInt(); 
    }while (pbamount <= 0 || pbamount>balance); //makes sure the pass/don't pass bet is a valid #
    
    input.nextLine();//because the last input didn't take the enter (only the number)
    System.out.println("\nHIT ENTER TO ROLL THE DICE.");
    input.nextLine();
    int a = roll();//roll one die
    int b = roll();//roll the other
    int total = a + b;//compile total # rolled
    System.out.println("\nYou rolled " + a + " and " + b + " --> " + total);
    if(total==2||total==3||total==12){
      System.out.println("----CRAPS----");
      System.out.println("________________________________________________");
      System.out.println("Pass Line bets LOSE -------- Don't Pass bets WIN");
      System.out.println("________________________________________________");
      if(passbet.equalsIgnoreCase("Pass Line")||passbet.equalsIgnoreCase("Pass")){ //PASS LINE BETS LOSE
        balance = balance-pbamount; //subtracts bet from their money total
      }
      else if(passbet.equalsIgnoreCase("Don't Pass")||passbet.equalsIgnoreCase("Don't")){
        balance = balance+pbamount;
      }
    }
    else if (total==7||total==11){
      System.out.println("----NATURAL----");
      System.out.println("________________________________________________");
      System.out.println("Pass Line bets WIN -------- Don't Pass bets LOSE");
      System.out.println("________________________________________________");
      if(passbet.equalsIgnoreCase("Pass Line")||passbet.equalsIgnoreCase("Pass")){ //PASS LINE BETS WIN
        balance = balance+pbamount;
      }
      else if(passbet.equalsIgnoreCase("Don't Pass")||passbet.equalsIgnoreCase("Don't")){
        balance = balance-pbamount;
      }
    }
    else if (total==4||total==5||total==6||total==8||total==9||total==10){
      int point = total; //separate point and total variable because the Point was set but they'll keep rolling
      System.out.println("The Point is set to " + point + ".");
      System.out.println("Would you like to make a \"FREE ODDS\" bet? (yes/no)");
      String freeodds = input.next();
      if (freeodds.equalsIgnoreCase("yes")){
        if((balance-pbamount)<=0){ //don't let them bet if they don't have the money to
          System.out.println("You do not have enough money remaining to make another bet.");
        }
        else if ((balance-pbamount)>0){
          do{
            System.out.println("How much would you like to bet? (must not exceed balance)\nREMAINING BALANCE: $"+(balance-pbamount));
            foamount = input.nextInt();
            
          }while(foamount <= 0 || foamount>(balance-pbamount));//makes sure they give a valid sum
        }        
      }
      input.nextLine();
      System.out.println("HIT ENTER TO ROLL.");
      do{
        input.nextLine();
        a = roll();
        b = roll();
        total = a + b;
        System.out.println("\nThe Point is  " + point + ".\nYou rolled " + a + " and " + b + " --> " + total);
        if (total!=point && total!=7){
          System.out.println("ROLL AGAIN");
        }
      }while (total!=point && total!=7); //loops the rolling proccess until they hit the point or 7
      if (total==7){
        System.out.println("________________________________________________");
        System.out.println("Pass Line bets LOSE -------- Don't Pass bets WIN");
        if (freeodds.equalsIgnoreCase("yes")){ //only display free odds outcome if they made an odds bet
          System.out.println("              Free Odds bets LOSE");}
        System.out.println("________________________________________________");
        if(passbet.equalsIgnoreCase("Pass Line")||passbet.equalsIgnoreCase("Pass")){//PASS LINE BETS LOSE
          balance = balance-pbamount;
        }
        else if(passbet.equalsIgnoreCase("Don't Pass")||passbet.equalsIgnoreCase("Don't")){
          balance = balance+pbamount;
        }
        balance = balance - free(foamount, point); //free odds lose if 7 is rolled before point
      }
      else if (total==point){
        System.out.println("________________________________________________");
        System.out.println("Pass Line bets WIN -------- Don't Pass bets LOSE");
        if (freeodds.equalsIgnoreCase("yes")){
          System.out.println("              Free Odds bets WIN");}
        System.out.println("________________________________________________");
        if(passbet.equalsIgnoreCase("Pass Line")||passbet.equalsIgnoreCase("Pass")){//PASS LINE BETS WIN
          balance = balance+pbamount;
        }
        else if(passbet.equalsIgnoreCase("Don't Pass")||passbet.equalsIgnoreCase("Don't")){
          balance = balance-pbamount;
        }        
        balance = balance + free(foamount, point); //free odds win if point is rolled before 7
      }
    }
    input.close(); //stop resource leak
    return balance; //brings new balance back to main craps method
  } 
  
  
  //_______________________________________________________________________________________________________________________________________________
  
  
  /* last updated: 5/15/19 */
  /* */
  /* This program is made to test the user's intelligence about general knowledge that takes place around the whole world. This program uses a while loop and returns the values */
  /*******************************************************************************************************/
  public static int quiz (int tokens)
  {
    
    char answer;
    String modeOption;
    
    //display menu
    System.out.println("Welcome to the General Knowledge Quiz!");   
    System.out.println("______________________________________________________________________________________________________");
    System.out.println("|                                             Instructions:                                           |");
    System.out.println("|   You will receive a question and based on that question, there will be four options with A,B,C,D   |");
    System.out.println("|                                                                                                     |");
    System.out.println("|You must use these letters to answer- not the word. For example, if I ask, what does 'LOL' stand for?|");
    System.out.println("|                                                                                                     |");
    System.out.println("|                                         [A] Laugh out loud                                          |");
    System.out.println("|                                         [B] Lots of love                                            |");
    System.out.println("|                                         [C] Love our lord                                           |");
    System.out.println("|                                         [D] Like out lore                                           |");
    System.out.println("|                                                                                                     |");
    System.out.println("|            In this case, you would type 'A' or 'a' as that is the correct answer                    |");
    System.out.println("|                                                                                                     |");
    System.out.println("|      Please do not type in 'laugh out loud' as you are suppose to use the corresponding letter      |");
    System.out.println("|                                                                                                     |");
    System.out.println("|                                              GOOD LUCK!                                             |");
    System.out.println("|_____________________________________________________________________________________________________|");
    
    while(true) //while loop used
    {
      //choose which mode
      System.out.println("For easy mode, if you answer a question right, you gain 5 tokens. If you answer a question wrong, you lose 5 tokens.\n");
      System.out.println("For medium mode, if you answer a question right, you gain 10 tokens. If you answer a question wrong, you lose 10 tokens.\n");
      System.out.println("For hard mode, if you answer a question right, you gain 20 tokens. If you answer a question wrong, you lose 20 tokens.\n");
      System.out.println("Would you like [easy] mode, [medium] mode, or [hard] mode?");
      modeOption = In.getString();
      
      //easy mode
      if(modeOption.equals("easy") || modeOption.equals("Easy") || modeOption.equals("e") || modeOption.equals("E"))
      {
        //easy - question 1
        System.out.println("Which superhero can shoot out webs?");
        System.out.println("[A] Batman");
        System.out.println("[B] Luke Cage");
        System.out.println("[C] Spiderman");
        System.out.println("[D] Superman");
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 5;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 5;
        }
        //easy - question 2
        System.out.println("Which country is the most populated?");
        System.out.println("[A] Qatar");
        System.out.println("[B] China");
        System.out.println("[C] Canada");
        System.out.println("[D] Norway"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 5;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 5;
        }
        //easy - question 3
        System.out.println("How many World Wars have occured up to 2019?");
        System.out.println("[A] Twenty");
        System.out.println("[B] Three");
        System.out.println("[C] One");
        System.out.println("[D] Two"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 5;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 5;
        }
        //easy - question 4
        System.out.println("Which actor is known for playing a pirate?");
        System.out.println("[A] Johnny Depp");
        System.out.println("[B] Adam Sandler");
        System.out.println("[C] Brad Pitt");
        System.out.println("[D] Chris Pratt"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 5;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 5;
        }
        //easy - question 5
        System.out.println("Which religion follows Siddartha Gautama?");
        System.out.println("[A] Islam");
        System.out.println("[B] Buddhism");
        System.out.println("[C] Christianity");
        System.out.println("[D] Judaism"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 5;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 5;
        }
        
        
        System.err.println("Total Number of Tokens: " + tokens);
        
      }
      
      //medium mode
      if(modeOption.equals("medium") || modeOption.equals("Medium") || modeOption.equals("m") || modeOption.equals("M"))
      {
        //medium - question 1
        System.out.println("Which inventor invented basketball?");
        System.out.println("[A] William G. Morgan");
        System.out.println("[B] Johan Cruyff");
        System.out.println("[C] James Creightonaa");
        System.out.println("[D] James Naismith"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 10;
        }
        //medium - question 2
        System.out.println("Which artist made the famous 'Mona Lisa' painting?");
        System.out.println("[A] Leonardo da Vinci");
        System.out.println("[B] Pablo Picasso");
        System.out.println("[C] Vincent van Gogh");
        System.out.println("[D] Michelangelo"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 10;
        }
        //medium - question 3
        System.out.println("Which athlete below is Canadian?");
        System.out.println("[A] Usain Bolt");
        System.out.println("[B] David Ortiz");
        System.out.println("[C] Tyler Seguin");
        System.out.println("[D] José Bautista"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 10;
        }
        //medium - question 4
        System.out.println("Which American president was assasinated in a theater?");
        System.out.println("[A] John F. Kennedy");
        System.out.println("[B] Abraham Lincoln");
        System.out.println("[C] Harry S. Truman");
        System.out.println("[D] Bill Clinton"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 10;
        }
        //medium - question 5
        System.out.println("Which city is known for their production of soccer balls?");
        System.out.println("[A] Sialkot, Pakistan");
        System.out.println("[B] London, England");
        System.out.println("[C] Karbala, Iraq");
        System.out.println("[D] Kabul, Afghanistan"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 10;
        }
        //medium - question 6
        System.out.println("Which civil rights movement figure was not killed?");
        System.out.println("[A] Martin Luther King JR");
        System.out.println("[B] Malcolm X");
        System.out.println("[C] Rosa Parks");
        System.out.println("[D] Emmett Till"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 10;
        }
        //medium - question 7
        System.out.println("Which country is associated with communism?");
        System.out.println("[A] Iran");
        System.out.println("[B] United States");
        System.out.println("[C] Vietnam");
        System.out.println("[D] England"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 10;
        } 
        //medium - question 8
        System.out.println("Which national soccer team won the FIFA World Cup in 2014?");
        System.out.println("[A] Greenland");
        System.out.println("[B] Pakistan");
        System.out.println("[C] Denmark");
        System.out.println("[D] Germany"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 10;
        }
        //medium - question 9
        System.out.println("Who says 'Float like a butterfly, Sting like a bee'?");
        System.out.println("[A] Muhammad Ali");
        System.out.println("[B] Michael Jordan");
        System.out.println("[C] Wayne Gretzky");
        System.out.println("[D] Mike Tyson"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 10;
        }
        //medium - question 10
        System.out.println("Which artist is not from Canada?");
        System.out.println("[A] Tory Lanez");
        System.out.println("[B] The Weeknd");
        System.out.println("[C] Drake");
        System.out.println("[D] Eazy-E"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 10;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 10;
        }
        
        
        System.err.println("Total Number of Tokens: " + tokens);
      }
      
      //hard mode
      if(modeOption.equals("hard") || modeOption.equals("Hard") || modeOption.equals("h") || modeOption.equals("H"))
      {
        //hard - question 1
        System.out.println("Which NBA player has the most total points?");
        System.out.println("[A] Kareem Abdul Jabbar");
        System.out.println("[B] Lebron James");
        System.out.println("[C] Michael Jordan");
        System.out.println("[D] Kobe Bryant"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");  
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 20;
        }
        //hard - question 2
        System.out.println("How many cricket players exist on the roster?");
        System.out.println("[A]  5 players");
        System.out.println("[B]  7 players");
        System.out.println("[C] 11 players");
        System.out.println("[D] 22 players"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c')
        {
          System.err.println("Correct!");    
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 20;
        }
        //hard - question 3
        System.out.println("'And','but', and 'or' are examples of which grammar tool?");
        System.out.println("[A] Prepositions");
        System.out.println("[B] Verbs");
        System.out.println("[C] Adjectives");
        System.out.println("[D] Conjuctions"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 20;
        }
        //hard - question 4
        System.out.println("Which movie below is about a janitor who is able to solve complicated math problems?");
        System.out.println("[A] A Beautiful Mind");
        System.out.println("[B] Good Will Hunting");
        System.out.println("[C] The Man Who Knew Infinity");
        System.out.println("[D] Pi"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 20;
        }
        //hard - question 5
        System.out.println("Which book below is Shakespeare's shortest tragedy?");
        System.out.println("[A] Hamlet");
        System.out.println("[B] Othello");
        System.out.println("[C] Romeo and Juliet");
        System.out.println("[D] Macbeth"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");    
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 20;
        }
        //hard - question 6
        System.out.println("Around how many years did WW1 last?");
        System.out.println("[A]  4 years");
        System.out.println("[B] 10 years");
        System.out.println("[C]  5 years");
        System.out.println("[D]  8 years"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 20;
        }
        //hard - question 7
        System.out.println("What is the world's populated religion?");
        System.out.println("[A] Islam");
        System.out.println("[B] Hinduism");
        System.out.println("[C] Christanity");
        System.out.println("[D] Judaism"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 20;
        }
        //hard - question 8
        System.out.println("Which of these letters is not a vowel?");
        System.out.println("[A] A");
        System.out.println("[B] W");
        System.out.println("[C] O");
        System.out.println("[D] I"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 20;
        }
        //hard - question 9
        System.out.println("Newton is said to have been inspired by what to describe the theory of gravity?");
        System.out.println("[A] Hailstone");
        System.out.println("[B] Ladder");
        System.out.println("[C] Apple");
        System.out.println("[D] Rock"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 20;
        }
        //hard - question 10
        System.out.println("In the Harry Potter series, Harry must battle which evil wizard?");
        System.out.println("[A] Darth Vader");
        System.out.println("[B] Lord Voldemort");
        System.out.println("[C] Carnage");
        System.out.println("[D] Gargamel"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 20;
        }
        //hard - question 11
        System.out.println("Which option is not a name of a chocolate?");
        System.out.println("[A] Earth");
        System.out.println("[B] Milky Way");
        System.out.println("[C] Mars");
        System.out.println("[D] Galaxy"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 20;
        }
        //hard - question 12
        System.out.println("Which is the capital of Saudi Arabia?");
        System.out.println("[A] Dubai");
        System.out.println("[B] Mecca");
        System.out.println("[C] Medina");
        System.out.println("[D] Riyadh"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 20;
        }
        //hard - question 13
        System.out.println("Which year did India and Pakistan seperate?");
        System.out.println("[A] 1944");
        System.out.println("[B] 1939");
        System.out.println("[C] 1947");
        System.out.println("[D] 1898"); 
        answer = In.getChar();
        if(answer == 'C' || answer == 'c') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is C");
          tokens -= 20;
        }
        //hard - question 14
        System.out.println("Which scientist developed the theory of relativity?");
        System.out.println("[A] Charles Darwin");
        System.out.println("[B] Thomas Edison");
        System.out.println("[C] Isaac Newton");
        System.out.println("[D] Albert Einstein"); 
        answer = In.getChar();
        if(answer == 'D' || answer == 'd') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is D");
          tokens -= 20;
        }
        //hard - question 15
        System.out.println("Which of the following is not a biblical name?");
        System.out.println("[A] Thomas");
        System.out.println("[B] Mahershalalhazbaz");
        System.out.println("[C] Solomon");
        System.out.println("[D] David"); 
        answer = In.getChar();
        if(answer == 'A' || answer == 'a') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is A");
          tokens -= 20;
        }
        //hard - question 16
        System.out.println("Which fruit is considered as the 'king of fruits'?");
        System.out.println("[A] Apple");
        System.out.println("[B] Mango");
        System.out.println("[C] Grape");
        System.out.println("[D] Orange"); 
        answer = In.getChar();
        if(answer == 'B' || answer == 'b') 
        {
          System.err.println("Correct!");
          tokens += 20;
        }
        else
        {
          System.err.println("The correct answer is B");
          tokens -= 20;
        }
        
        
        System.err.println("Total number of tokens: " + tokens);
      }
      
      System.out.println("Would you like to play again? Y/N");
      String yesNo = In.getString();
      
      if (yesNo.equals("N") || yesNo.equals("n") )
        break;
    }
    return tokens;
  } //public static void quiz
  //_______________________________________________________________________________________________________________________________________________
  
} // Closing class