

class Big_Project
{
  public static void main (String [] args)
  {
    //Variables
    char command;
    
    do
    {
      Random();
      command = In.getChar();
    } while (command == 'a');
    System.out.println("Program is ending");
    
    } // public static void
    
//    do
//    {
//    for(life=0; life<6; life++)
//    {
//      int random = (int)(Math.random() * 9 + 1);
//      System.out.println(random);
//    }
//    command = In.getChar();
//    } while (command == 'a');
  
  
    
    
    public static void Random()
    {
      int life;
      int guess;
      for(life=0; life<6; life++)
      {
        do
        {
        System.out.println("Enter a 6 digit number");
        guess = In.getInt();
        } while (guess == 123456);
      int random = (int)(Math.random() * 9 + 1);
      //System.out.println
      System.out.print(random);
      
      
      

      }
    }
  
  
  
  
  
  
} // class