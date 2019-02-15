import java.util.Random;

class Big_Project
{
  public static void main (String [] args)
  {
    //Variables
    char command;
    
    do
    {
      Lottery();
      command = In.getChar();
    } while (command == 'a');
    System.out.println("Program is ending");
    
    } // public static void
    

  
  public static void Lottery()
  {
    int trying = 0;
    System.out.println("Enter a 6 digit number");
    int guess = In.getInt();
    int random;
    
    do
    {
    trying++;
    // Random number from 100000 to 900000
    random = 100000 + new Random().nextInt(900000);

    System.out.println(trying + ": " + random + " = " + guess);
    } while (guess != random && trying <= 49);
    
    if (guess == random)
    {
      System.out.println("You won!");
    }
    else
    {
      System.out.println("You lose");
    }
    System.out.print("Submit a to try again");
  }

   
  
  
  
  
  
  
} // class
