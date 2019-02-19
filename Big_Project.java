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
    
  } // public static void
  
  public static void Difficulty()
  {
    //Variables
    char command;
    char check[] = {'a', 'A', 'b', 'B'};
    
    do
    {
    // Select a difficulty
    System.out.println("What lottery would you like to play?\n"
                         + "a) Lotto 6/49\n"
                         + "b) Make your own");
      command = In.getChar();
    
    // Error Check
    if (command != 'a' || command != 'A' || command != 'b' || command != 'B')
    {
      System.out.println("Please select a valid mode");
    }
    } while (check.equals(command));
    
    if (command == 'a' || command == 'A')
    {
      Lottery();
    }
    else if (command == 'b' || command == 'B')
    {
      CustomL();
    }
    else if (command != 'a' || command != 'A' || command != 'b' || command != 'B')
    {
      System.out.println("Please select a valid mode");
    }
  }
  
  
  
  public static void Lottery()
  {
    // Variables
    int random, rn2, rn3, rn4, rn5, rn6 = 0;
    int guess, guess2, guess3, guess4, guess5, guess6 = 0;
    int points = 0;
    int money = 0;
    
    // Select a # (# needs to be in between 1 and 49)
    do
    {
      System.out.println("Select a number between 1-49");
      guess = In.getInt();
    } while (guess >= 50 || guess <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess2 = In.getInt();
    } while (guess2 >= 50 || guess2 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess3 = In.getInt();
    } while (guess3 >= 50 || guess3 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess4 = In.getInt();
    } while (guess4 >= 50 || guess4 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess5 = In.getInt();
    } while (guess5 >= 50 || guess5 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess6 = In.getInt();
    } while (guess6 >= 50 || guess6 <= 0);
    
    // Generates a random #
    random = 1 + new Random().nextInt(1);
    rn2 = 1 + new Random().nextInt(1);
    rn3 = 1 + new Random().nextInt(1);
    rn4 = 1 + new Random().nextInt(1);
    rn5 = 1 + new Random().nextInt(1);
    rn6 = 1 + new Random().nextInt(1);

    // Displays the generated # and the # the user guessed
    System.out.println(random + " = " + guess);
    System.out.println(rn2 + " = " + guess2);
    System.out.println(rn3 + " = " + guess3);
    System.out.println(rn4 + " = " + guess4);
    System.out.println(rn5 + " = " + guess5);
    System.out.println(rn6 + " = " + guess6);
    
    
    // Add points if they got a # correct
    if (random == guess)
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
    
    // Using the # check to check if they won any money
    if (points == 1 || points == 0)
    {
      money = 0;
      System.out.println("You lost!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 2)
    {
      money = 5;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 3)
    {
      money = 50;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 4)
    {
      money = 1000;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 5)
    {
      money = 500000;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 6)
    {
      money = 1000000;
      System.out.println("You won the jackpot!\n"
                           + "Money gained: $" + money);
    }
    
    
  } // Lotter()
  
  
  
  public static void CustomL()
  {
    // Variables
    int customL = 0;
    int random, rn2, rn3, rn4, rn5, rn6 = 0;
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
      System.out.println("Select a number between 1-49");
      guess = In.getInt();
    } while (guess >= customL || guess <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess2 = In.getInt();
    } while (guess2 >= customL || guess2 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess3 = In.getInt();
    } while (guess3 >= customL || guess3 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess4 = In.getInt();
    } while (guess4 >= customL || guess4 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess5 = In.getInt();
    } while (guess5 >= customL || guess5 <= 0);
    do
    {
      System.out.println("Select a number between 1-49");
      guess6 = In.getInt();
    } while (guess6 >= customL || guess6 <= 0);
    
    // Generates a random #
    random = 1 + new Random().nextInt(customL);
    rn2 = 1 + new Random().nextInt(customL);
    rn3 = 1 + new Random().nextInt(customL);
    rn4 = 1 + new Random().nextInt(customL);
    rn5 = 1 + new Random().nextInt(customL);
    rn6 = 1 + new Random().nextInt(customL);

    // Displays the generated # and the # the user guessed
    System.out.println(random + " = " + guess);
    System.out.println(rn2 + " = " + guess2);
    System.out.println(rn3 + " = " + guess3);
    System.out.println(rn4 + " = " + guess4);
    System.out.println(rn5 + " = " + guess5);
    System.out.println(rn6 + " = " + guess6);
    
    
    // Add points if they got a # correct
    if (random == guess)
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
    
    // Using the # check to check if they won any money
    if (points == 1 || points == 0)
    {
      money = 0;
      System.out.println("You lost!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 2)
    {
      money = 5;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 3)
    {
      money = 50;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 4)
    {
      money = 1000;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 5)
    {
      money = 500000;
      System.out.println("You won!\n"
                           + "Money gained: $" + money);
    }
    else if (points == 6)
    {
      money = 1000000;
      System.out.println("You won the jackpot!\n"
                           + "Money gained: $" + money);
    }
    
    
  } // Lotter()
  
  
  
} // class
