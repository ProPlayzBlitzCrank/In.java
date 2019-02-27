/* Practicing
 * Basics ( Variables -int, char... )
 * Methods
 * Loops
 * Decisions
 */

import java.util.Random;

class Big_Project
{
  public static void main (String [] args)
  {
    //Variables
    char command;
    
    // Starts/Ends the program
    do
    {
      Difficulty();
      System.out.println("Enter 'z' to play again");
      command = In.getChar();
    } while (command == 'z' || command == 'Z');
    System.out.println("Program is ending");
    
  } // public static void main
  
  public static void Difficulty()
  {
    //Variables
    char command;
    
    do
    {
      // Select a difficulty
      System.out.println("What lottery would you like to play?\n"
                           + "a) Lotto 6/49\n"
                           + "b) Make your own\n"
                           + "c) Quick Play");
      command = In.getChar();
      
    } while (command != 'a' && command != 'A' && command != 'b' && command != 'B' && command != 'c' && command != 'C');
    
    if (command == 'a' || command == 'A')
    {
      Lottery();
    }
    else if (command == 'b' || command == 'B')
    {
      CustomL();
    }
    else if (command == 'c' || command == 'C')
    {
      quickPlay();
    }
    
  } // Difficulty
  
  public static void Lottery()
  {
    // Variables
    int points = 0;
    int money = 0;
    int count = 1;
    
    // Array
    int[] userGuess = new int[6]; // Amount of times the user can guess a #
    int[] lotteryNumber = new int[6];
    
    int i = 0; // This will store the array (# guessed)
    int test; // Protects the array from being messed up
    
    for (i = 0; i < userGuess.length; i++) // Once (int i) reaches 6 stop the loop
    {  
      do
      {
        System.out.println("Select a number between 1-49" + " | (" + count + ")");
        test = In.getInt(); // Gets #
        if (test >= 50 || test <= 0) // Checks if # is allowed
        {
          // redo loop
        }
        else
        {
          userGuess[i] = test; // Adds the number to the array
        }
      } while (test >= 50 || test <= 0);
      System.out.println("Number [" + count + "] = " + userGuess[i] + " ");
      count++;
    }
    
    System.out.println("\nYour Guess");
    count = 1; // resets the count
    for (i = 0; i < userGuess.length; i++)
    {
      System.out.println("Number [" + count + "] = " + userGuess[i]); // Displays when they entered the # and what the # is
      count++;
    }
    
    // Generates random numbers
    count = 1;
    for (i = 0; i < lotteryNumber.length; i++)
    {
      lotteryNumber[i] = 1 + new Random().nextInt(49);
      System.out.println("Lottery Number [" + count + "] = " + lotteryNumber[i]);
      count++;
    }
    
    System.out.print("Lottery Numbers: ");
    for (i = 0; i < lotteryNumber.length; i++)
    {
      System.out.print(lotteryNumber[i] + " ");
    }
    System.out.println(); // Adding a new line
    System.out.print("Your Numbers: ");
    
    for (i = 0; i < userGuess.length; i++)
    {
      System.out.print(userGuess[i] + " ");
    }
    System.out.println(); // Adding new line
    
    // This will only allow the users number to count for one point
    // Example: Lottery Numbers: 1 5 10 15 20 25
    //            Users Numbers: 15 1 1 2 6 7
    // Points = 1 because it deletes 1 for the lottery numbers so it cant count as more points
    // Check 1st number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[0]) // Checks if the lotteryNumber and userGuess are the same
      {
        lotteryNumber[i] = 0; // removes number so they cant win it again
        points++;
        break;
      }
    }
    
    // Check 2nd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[1])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 3rd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[2])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 4th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[3])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 5th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[4])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 6th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[5])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Lottery winnings
    switch (points)
    {
      case 2:
        System.out.println("You matched 2 numbers");
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        System.out.println("You matched 3 numbers");
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        System.out.println("You matched 4 numbers");
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        System.out.println("You matched 5 numbers");
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
        System.out.println("You matched 6 numbers");
        money = 1000000;
        System.out.println("   $$$$$\\  $$$$$$\\   $$$$$$\\  $$\\   $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ \n"
                             + "   \\__$$ |$$  __$$\\ $$  __$$\\ $$ | $$  |$$  __$$\\ $$  __$$\\__$$  __|\n"
                             + "      $$ |$$ /  $$ |$$ /  \\__|$$ |$$  / $$ |  $$ |$$ /  $$ |  $$ |   \n"
                             + "      $$ |$$$$$$$$ |$$ |      $$$$$  /  $$$$$$$  |$$ |  $$ |  $$ |   \n"
                             + "$$\\   $$ |$$  __$$ |$$ |      $$  $$<   $$  ____/ $$ |  $$ |  $$ |   \n"
                             + "$$ |  $$ |$$ |  $$ |$$ |  $$\\ $$ |\\$$\\  $$ |      $$ |  $$ |  $$ |   \n"
                             + "\\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$ | \\$$\\ $$ |       $$$$$$  |  $$ |   \n"
                             + " \\______/ \\__|  \\__| \\______/ \\__|  \\__|\\__|       \\______/   \\__|   \n"
                             + "Money gained: $" + money);
        break;
      default:
        System.out.println("You matched " + points + " numbers");
        money = 0;
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
  } // Lottery
  
  public static void CustomL()
  {
    // Variables
    int customL = 0;
    int points = 0;
    int money = 0;
    int count = 1;
    // Arrays
    int[] userGuess = new int[6];
    int[] lotteryNumber = new int[6];
    
    // Random # generator select
    int i = 0; // This will store the array (# guessed)
    int test; // Protects the array from being messed up
    
    System.out.println("Select a # to play from");
    customL = In.getInt();
    for (i = 0; i < userGuess.length; i++) // Once (int i) reaches 6 stop the loop
    {  
      do
      {
        System.out.println("Select a number between 1-" + customL + " | (" + count + ")");
        test = In.getInt(); // Gets #
        if (test > customL || test <= 0) // Checks if # is allowed
        {
          // redo loop
        }
        else
        {
          userGuess[i] = test; // Adds the number to the array
        }
      } while (test > customL || test <= 0);
      System.out.println("Number [" + count + "] = " + userGuess[i] + " ");
      count++;
    }
    
    System.out.println("\nYour Guess");
    count = 1; // resets the count
    for (i = 0; i < userGuess.length; i++)
    {
      System.out.println("Number [" + count + "] = " + userGuess[i]); // Displays when they entered the # and what the # is
      count++;
    }
    
    // Generates random numbers
    count = 1;
    for (i = 0; i < lotteryNumber.length; i++)
    {
      lotteryNumber[i] = 1 + new Random().nextInt(customL);
      System.out.println("Lottery Number [" + count + "] = " + lotteryNumber[i]);
      count++;
    } 
    
    System.out.print("Lottery Numbers: ");
    for (i = 0; i < lotteryNumber.length; i++)
    {
      System.out.print(lotteryNumber[i] + " ");
    }
    System.out.println(); // Adding a new line
    System.out.print("Your Numbers: ");
    
    for (i = 0; i < userGuess.length; i++)
    {
      System.out.print(userGuess[i] + " ");
    }
    System.out.println(); // Adding new line
    
    // Check 1st number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[0]) // Checks if the lotteryNumber and userGuess are the same
      {
        lotteryNumber[i] = 0; // removes number so they cant win it again
        points++;
        break;
      }
    }
    
    // Check 2nd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[1])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 3rd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[2])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 4th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[3])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 5th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[4])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 6th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[5])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // If the user has 2-6 points check the case else (default) they didnt win
    switch (points)
    {
      case 2:
        System.out.println("You matched " + points + " numbers");
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        System.out.println("You matched " + points + " numbers");
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        System.out.println("You matched " + points + " numbers");
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        System.out.println("You matched " + points + " numbers");
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
        System.out.println("You matched " + points + " numbers");
        money = 1000000;
        System.out.println("   $$$$$\\  $$$$$$\\   $$$$$$\\  $$\\   $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ \n"
                             + "   \\__$$ |$$  __$$\\ $$  __$$\\ $$ | $$  |$$  __$$\\ $$  __$$\\__$$  __|\n"
                             + "      $$ |$$ /  $$ |$$ /  \\__|$$ |$$  / $$ |  $$ |$$ /  $$ |  $$ |   \n"
                             + "      $$ |$$$$$$$$ |$$ |      $$$$$  /  $$$$$$$  |$$ |  $$ |  $$ |   \n"
                             + "$$\\   $$ |$$  __$$ |$$ |      $$  $$<   $$  ____/ $$ |  $$ |  $$ |   \n"
                             + "$$ |  $$ |$$ |  $$ |$$ |  $$\\ $$ |\\$$\\  $$ |      $$ |  $$ |  $$ |   \n"
                             + "\\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$ | \\$$\\ $$ |       $$$$$$  |  $$ |   \n"
                             + " \\______/ \\__|  \\__| \\______/ \\__|  \\__|\\__|       \\______/   \\__|   \n"
                             + "Money gained: $" + money);
        break;
      default:
        System.out.println("You matched " + points + " numbers");
        money = 0;
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
    
    
  } // Custom Lotter()
  
  
  public static void quickPlay()
  {
    // Variables
    int i = 0;
    int points = 0;
    int money = 0;
    
    // Arrays
    int[] userGuess = new int[6];
    int[] lotteryNumber = new int[6];
    
    for (i = 0; i < userGuess.length; i++) // Once (int i) reaches 6 stop the loop
    {
      userGuess[i] = 1 + new Random().nextInt(49);
    }
     for (i = 0; i < lotteryNumber.length; i++) // Once (int i) reaches 6 stop the loop
    {
      lotteryNumber[i] = 1 + new Random().nextInt(49);
    }
    
    System.out.print("Lottery Numbers: ");
    for (i = 0; i < lotteryNumber.length; i++)
    {
      System.out.print(lotteryNumber[i] + " ");
    }
    System.out.println(); // Adding a new line
    System.out.print("Your Numbers: ");
    
    for (i = 0; i < userGuess.length; i++)
    {
      System.out.print(userGuess[i] + " ");
    }
    System.out.println(); // Adding new line
    
    // Check 1st number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[0]) // Checks if the lotteryNumber and userGuess are the same
      {
        lotteryNumber[i] = 0; // removes number so they cant win it again
        points++;
        break;
      }
    }
    
    // Check 2nd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[1])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 3rd number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[2])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 4th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[3])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 5th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[4])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // Check 6th number
    for (i = 0; i < lotteryNumber.length; i++)
    {
      if (lotteryNumber[i] == userGuess[5])
      {
        lotteryNumber[i] = 0;
        points++;
        break;
      }
    }
    
    // If the user has 2-6 points check the case else (default) they didnt win
    switch (points)
    {
      case 2:
        System.out.println("You matched " + points + " numbers");;
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        System.out.println("You matched " + points + " numbers");
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        System.out.println("You matched " + points + " numbers");
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        System.out.println("You matched " + points + " numbers");
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
        System.out.println("You matched " + points + " numbers");
        money = 1000000;
        System.out.println("   $$$$$\\  $$$$$$\\   $$$$$$\\  $$\\   $$\\ $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ \n"
                             + "   \\__$$ |$$  __$$\\ $$  __$$\\ $$ | $$  |$$  __$$\\ $$  __$$\\__$$  __|\n"
                             + "      $$ |$$ /  $$ |$$ /  \\__|$$ |$$  / $$ |  $$ |$$ /  $$ |  $$ |   \n"
                             + "      $$ |$$$$$$$$ |$$ |      $$$$$  /  $$$$$$$  |$$ |  $$ |  $$ |   \n"
                             + "$$\\   $$ |$$  __$$ |$$ |      $$  $$<   $$  ____/ $$ |  $$ |  $$ |   \n"
                             + "$$ |  $$ |$$ |  $$ |$$ |  $$\\ $$ |\\$$\\  $$ |      $$ |  $$ |  $$ |   \n"
                             + "\\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$ | \\$$\\ $$ |       $$$$$$  |  $$ |   \n"
                             + " \\______/ \\__|  \\__| \\______/ \\__|  \\__|\\__|       \\______/   \\__|   \n"
                             + "Money gained: $" + money);
        break;
      default:
        money = 0;
        System.out.println("You matched " + points + " numbers");
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
  } // QuickPlay
  
  
} // class
