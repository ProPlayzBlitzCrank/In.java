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
                           + "c) Quick Play\n"
                           + "d) All Numbers");
      command = In.getChar();
      
      // Error Check
//    if (charArray.equals(command))
//    {
//      System.out.println("Please select a valid mode");
//    }
    } while (command != 'a' && command != 'A' && command != 'b' && command != 'B' && command != 'c' && command != 'C' && command != 'd' && command != 'D');
    
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
    else if (command == 'd' || command == 'D')
    {
      Checkallnumbers();
    }
    
  }
  
  
  
  public static void Lottery()
  {
    // Variables
    int rn1, rn2, rn3, rn4, rn5, rn6 = 0;
    int guess, guess2, guess3, guess4, guess5, guess6 = 0;
    int points = 0;
    int money = 0;
    
    // Select a # (# needs to be in between 1 and 49)
    do
    {
      System.out.println("Select a number between 1-49 | (1)");
      guess = In.getInt();
    } while (guess >= 50 || guess <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (2)");
      guess2 = In.getInt();
    } while (guess2 >= 50 || guess2 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (3)");
      guess3 = In.getInt();
    } while (guess3 >= 50 || guess3 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (4)");
      guess4 = In.getInt();
    } while (guess4 >= 50 || guess4 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (5)");
      guess5 = In.getInt();
    } while (guess5 >= 50 || guess5 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (6)");
      guess6 = In.getInt();
    } while (guess6 >= 50 || guess6 <= 0);
    
    // Generates a random #
    rn1 = 1 + new Random().nextInt(1);
    rn2 = 1 + new Random().nextInt(1);
    rn3 = 1 + new Random().nextInt(1);
    rn4 = 1 + new Random().nextInt(1);
    rn5 = 1 + new Random().nextInt(1);
    rn6 = 1 + new Random().nextInt(1);
    
    if (rn1 == guess)
    {
      System.out.println("$$$" + rn1 + " = " + guess + "$$$");
    }
    else
    {
      System.out.println(rn1 + " = " + guess);
    }
    
    if (rn2 == guess2)
    {
      System.out.println("$$$" + rn2 + " = " + guess2 + "$$$");
    }
    else
    {
      System.out.println(rn2 + " = " + guess2);
    }
    
    if (rn3 == guess3)
    {
      System.out.println("$$$" + rn3 + " = " + guess3 + "$$$");
    }
    else
    {
      System.out.println(rn3 + " = " + guess3);
    }
    
    if (rn4 == guess4)
    {
      System.out.println("$$$ " + rn4 + " = " + guess4 + " $$$");
    }
    else
    {
      System.out.println(rn4 + " = " + guess4);
    }
    
    if (rn5 == guess5)
    {
      System.out.println("$$$" + rn5 + " = " + guess5 + "$$$");
    }
    else
    {
      System.out.println(rn5 + " = " + guess5);
    }
    
    if (rn6 == guess6)
    {
      System.out.println("$$$" + rn6 + " = " + guess6 + "$$$");
    }
    else
    {
      System.out.println(rn6 + " = " + guess6);
    }
    
    // Displays the generated # and the # the user guessed
//    System.out.println(rn1 + " = " + guess);
//    System.out.println(rn2 + " = " + guess2);
//    System.out.println(rn3 + " = " + guess3);
//    System.out.println(rn4 + " = " + guess4);
//    System.out.println(rn5 + " = " + guess5);
//    System.out.println(rn6 + " = " + guess6);
    
    
    // Add points if they got a # correct
    if (rn1 == guess)
    {
      points = points + 1;
    }
    if (rn2 == guess2)
    {
      points = points + 1;
    }
    if (rn3 == guess3)
    {
      points = points + 1;
    }
    if (rn4 == guess4)
    {
      points = points + 1;
    }
    if (rn5 == guess5)
    {
      points = points + 1;
    }
    if (rn6 == guess6)
    {
      points = points + 1;
    }
    
    // If the user has 2-6 points check the case else (default) they didnt win
    switch (points)
    {
      case 2:
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
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
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
    
    
  } // Lottery()
  
  
  
  public static void CustomL()
  {
    // Variables
    int customL = 0;
    int rn1, rn2, rn3, rn4, rn5, rn6 = 0;
    int guess, guess2, guess3, guess4, guess5, guess6 = 0;
    int points = 0;
    int money = 0;
    
    // Random # generator select
    do
    {
      System.out.println("Select a # to play from");
      customL = In.getInt();
    } while (customL >= 1000001 || customL <= 0);
    
    // Select a # (# needs to be in between 1 and 49)
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (1)");
      guess = In.getInt();
    } while (guess > customL || guess <= 0);
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (2)");
      guess2 = In.getInt();
    } while (guess2 > customL || guess2 <= 0);
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (3)");
      guess3 = In.getInt();
    } while (guess3 > customL || guess3 <= 0);
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (4)");
      guess4 = In.getInt();
    } while (guess4 > customL || guess4 <= 0);
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (5)");
      guess5 = In.getInt();
    } while (guess5 > customL || guess5 <= 0);
    do
    {
      System.out.println("Select a number between 1-" + customL + " | (6)");
      guess6 = In.getInt();
    } while (guess6 > customL || guess6 <= 0);
    
    // Generates a random #
    rn1 = 1 + new Random().nextInt(customL);
    rn2 = 1 + new Random().nextInt(customL);
    rn3 = 1 + new Random().nextInt(customL);
    rn4 = 1 + new Random().nextInt(customL);
    rn5 = 1 + new Random().nextInt(customL);
    rn6 = 1 + new Random().nextInt(customL);
    
    // Displays the generated # and the # the user guessed
    System.out.println(rn1 + " = " + guess);
    System.out.println(rn2 + " = " + guess2);
    System.out.println(rn3 + " = " + guess3);
    System.out.println(rn4 + " = " + guess4);
    System.out.println(rn5 + " = " + guess5);
    System.out.println(rn6 + " = " + guess6);
    
    
    // Add points if they got a # correct
    if (rn1 == guess)
    {
      points = points + 1;
    }
    if (rn2 == guess2)
    {
      points = points + 1;
    }
    if (rn3 == guess3)
    {
      points = points + 1;
    }
    if (rn4 == guess4)
    {
      points = points + 1;
    }
    if (rn5 == guess5)
    {
      points = points + 1;
    }
    if (rn6 == guess6)
    {
      points = points + 1;
    }
    
    // If the user has 2-6 points check the case else (default) they didnt win
    switch (points)
    {
      case 2:
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
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
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
    
    
  } // Custom Lotter()
  
  public static void quickPlay()
  {
    // Variables
    int rn1, rn2, rn3, rn4, rn5, rn6 = 0;
    int guess, guess2, guess3, guess4, guess5, guess6 = 0;
    int points = 0;
    int money = 0;
    
    // User quick play #
    guess = 1 + new Random().nextInt(49);
    guess2 = 1 + new Random().nextInt(49);
    guess3 = 1 + new Random().nextInt(49);
    guess4 = 1 + new Random().nextInt(49);
    guess5 = 1 + new Random().nextInt(49);
    guess6 = 1 + new Random().nextInt(49);
    
    // Generates a random #
    rn1 = 1 + new Random().nextInt(49);
    rn2 = 1 + new Random().nextInt(49);
    rn3 = 1 + new Random().nextInt(49);
    rn4 = 1 + new Random().nextInt(49);
    rn5 = 1 + new Random().nextInt(49);
    rn6 = 1 + new Random().nextInt(49);
    
    // Displays the generated # and the # the user guessed
    System.out.println(rn1 + " = " + guess);
    System.out.println(rn2 + " = " + guess2);
    System.out.println(rn3 + " = " + guess3);
    System.out.println(rn4 + " = " + guess4);
    System.out.println(rn5 + " = " + guess5);
    System.out.println(rn6 + " = " + guess6);
    
    
    // Add points if they got a # correct
    if (rn1 == guess)
    {
      points = points + 1;
    }
    if (rn2 == guess2)
    {
      points = points + 1;
    }
    if (rn3 == guess3)
    {
      points = points + 1;
    }
    if (rn4 == guess4)
    {
      points = points + 1;
    }
    if (rn5 == guess5)
    {
      points = points + 1;
    }
    if (rn6 == guess6)
    {
      points = points + 1;
    }
    
    // If the user has 2-6 points check the case else (default) they didnt win
    switch (points)
    {
      case 2:
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
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
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
  }
  
  public static void Checkallnumbers()
  {
    // Variables
    int rn1, rn2, rn3, rn4, rn5, rn6 = 0;
    int guess, guess2, guess3, guess4, guess5, guess6 = 0;
    int points = 0;
    int money = 0;
    
    // Select a # (# needs to be in between 1 and 49)
    do
    {
      System.out.println("Select a number between 1-49 | (1)");
      guess = In.getInt();
    } while (guess >= 50 || guess <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (2)");
      guess2 = In.getInt();
    } while (guess2 >= 50 || guess2 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (3)");
      guess3 = In.getInt();
    } while (guess3 >= 50 || guess3 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (4)");
      guess4 = In.getInt();
    } while (guess4 >= 50 || guess4 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (5)");
      guess5 = In.getInt();
    } while (guess5 >= 50 || guess5 <= 0);
    do
    {
      System.out.println("Select a number between 1-49 | (6)");
      guess6 = In.getInt();
    } while (guess6 >= 50 || guess6 <= 0);
    
    // Generates a random #
    rn1 = 1 + new Random().nextInt(49);
    rn2 = 1 + new Random().nextInt(49);
    rn3 = 1 + new Random().nextInt(49);
    rn4 = 1 + new Random().nextInt(49);
    rn5 = 1 + new Random().nextInt(49);
    rn6 = 1 + new Random().nextInt(49);
    
    System.out.println(rn1);
    System.out.println(rn2);
    System.out.println(rn3);
    System.out.println(rn4);
    System.out.println(rn5);
    System.out.println(rn6);
    
    // User quick play #
    guess = 1 + new Random().nextInt(49);
    if (rn1 == guess && rn2 == guess && rn3 == guess && rn4 == guess && rn5 == guess && rn6 == guess)
    {
      points = points + 1;
      System.out.println(guess + " = " + guess);
    }
    guess2 = 1 + new Random().nextInt(49);
    if (rn1 == guess2 && rn2 == guess2 && rn3 == guess2 && rn4 == guess2 && rn5 == guess2 && rn6 == guess2)
    {
      points = points + 1;
      System.out.println(guess2 + " = " + guess2);
    }
    guess3 = 1 + new Random().nextInt(49);
    if (rn1 == guess3 && rn2 == guess3 && rn3 == guess3 && rn4 == guess3 && rn5 == guess3 && rn6 == guess3)
    {
      points = points + 1;
      System.out.println(guess3 + " = " + guess3);
    }
    guess4 = 1 + new Random().nextInt(49);
    if (rn1 == guess4 && rn2 == guess4 && rn3 == guess4 && rn4 == guess4 && rn5 == guess4 && rn6 == guess4)
    {
      points = points + 1;
      System.out.println(guess4 + " = " + guess4);
    }
    guess5 = 1 + new Random().nextInt(49);
    if (rn1 == guess5 && rn2 == guess5 && rn3 == guess5 && rn4 == guess5 && rn5 == guess5 && rn6 == guess5)
    {
      points = points + 1;
      System.out.println(guess5 + " = " + guess5);
    }
    guess6 = 1 + new Random().nextInt(49);
    if (rn1 == guess6 && rn2 == guess6 && rn3 == guess6 && rn4 == guess6 && rn5 == guess6 && rn6 == guess6)
    {
      points = points + 1;
      System.out.println(guess6 + " = " + guess6);
    }
    
    
    switch (points)
    {
      case 2:
        money = 5;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 3:
        money = 50;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 4:
        money = 1000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 5:
        money = 500000;
        System.out.println("You won!\n"
                             + "Money gained: $" + money);
        break;
      case 6:
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
        System.out.println("You lost!\n"
                             + "Money gained: $" + money);
        break;
    }
    
    
  } // Checkallnumbers
  
  
} // class
