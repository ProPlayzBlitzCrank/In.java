class Classroom2
{
  public static void runProgram(Student2 [] student)
  {  
    char command;
    do
    {
      // Ask how they would like the students organized of the list
      System.err.println("How would you like to see your classroom, " + student[0].teacher + "?\n"
                           + "a) Sort Average (Highest to lowest)\n"
                           + "b) Sort Average (Lowest to highest)\n"
                           + "c) Student Number (Lowest to highest)\n"
                           + "d) nothing\n"
                           + "e) Main Munu\n"
                           + "f) Exit Program");
      command = In.getChar();
      if (command == 'a' || command == 'A')
      {
        System.out.format("%60s", "^^^^");
        System.out.println();
        // Displays the formated string (not their information)
        student[0].categories();
        // Insertion Sorting
        for (int i = 0; i<student.length; i++)
        {
          // Checks if the student passes the class
          student[i].pass();
          for (int j = i; j>0; j--)
          {
            if (student[j].sort(student[j-1]))
            {
              Student2 swap = student[j];
              student[j] = student[j-1];
              student[j-1] = swap;
            }
          }
        }
        // Keep printing the students until it reaches the array length
        for (int i = 0; i<student.length; i++)
        {
          // Displays the formated string with their information
          student[i].displaykids();
        }
      }
      else if (command == 'b' || command == 'B')
      {
        System.out.format("%60s", "vvvv");
        System.out.println();
        // Displays the formated string (not their information)
        student[0].categories();  
        // Insertion Sorting
        for (int i = 0; i < student.length; i++)
        {
          // Checks if the student pass the class
          student[i].pass();
          for (int j = i; j>0; j--)
          {
            if (student[j].lowavg(student[j-1]))
            {
              Student2 swap = student[j];
              student[j] = student[j-1];
              student[j-1] = swap;
            }
          }
        }
        // Keep printing the students until it reaches the array length
        for (int i = 0; i<student.length; i++)
        {
          // Displays the formated string with their information
          student[i].displaykids();
        }
      }
      else if (command == 'c' || command == 'C')
      {
        System.out.format("%10s", "vvvv");
        System.out.println();
        
        student[0].categories();
        
        for (int i = 0; i < student.length; i++)
        {
          // Checks if the student pass the class
          student[i].pass();
          // Sorts student numbers from lowest to highest
          for (int j = i; j>0; j--)
          {
            if (student[j].sortSN(student[j-1]))
            {
              Student2 swap = student[j];
              student[j] = student[j-1];
              student[j-1] = swap;
            }
          }
        }
        // Keep printing the students until it reaches the array length
        for (int i = 0; i<student.length; i++)
        {
          // Displays the formated string with their information
          student[i].displaykids();
        }
      }
      else if (command == 'd' || command == 'D')
      {
        System.out.format("%60s", "----");
        System.out.println();
        // Displays the formated string (not their information)
        student[0].categories();  
        for (int i = 0; i<student.length; i++)
        {
          // Checks if the student pass the class
          student[i].pass();
          // Displays the formated string with their information
          student[i].displaykids();
        }
      }
      else if (command == 'e' || command == 'E') // Sends it back to the menu
      {
        break;
      }
      else if (command == 'f' || command == 'F')
      {
        System.exit(0);
      }
      
      System.out.println();
      System.out.println();
      
      System.err.println("Would you like to keep using this classroom?\n"
                           + "a) Yes keep using\n"
                           + "e) Main Menu\n"
                           + "f) Exit Program");
      command = In.getChar();
      if (command == 'e' || command == 'E')
      {
        break;
      }
      else if (command == 'f' || command == 'F')
      {
        System.exit(0);
      }
      System.out.println();
      System.out.println();
    } while (command >= 'a' && command >= 'A' || command <= 'f' || command <= 'F');
  }
  
  public static void main (String [] args)
  {
    char command;
    Student2 [] a = new Student2[2];
    Student2 [] b = new Student2[6];
    Student2 [] c = new Student2[30];
    
    // This shows that if someone has a different amount of projects assigned it wont show the a grades
    a[0] = new Student2(1234, "Mr. Bobber", "Bobber", 10, 50, 1, 100, 50, 60, 70, 86, 19, 49, 100);
    a[1] = new Student2(9999, "Mr. Bobber", "Bob", 5, 50, 60, 70, 80, 90, 9999999, 9999999, 9999999, 9999999, 9999999);
    
    // A classic way of making a classroom in the program
    b[0] = new Student2(1334, "Shane", "Bob", 10, 60, 65, 70, 75, 80, 100, 96, 56, 72, 72);
    b[1] = new Student2(1335, "Shane", "Bobber", 10, 26, 65, 70, 75, 80, 86, 45, 56, 59, 72);
    b[2] = new Student2(1336, "Shane", "Tom", 10, 86, 65, 50, 55, 90, 76, 55, 66, 49, 63);
    b[3] = new Student2(1337, "Shane", "asdfa", 10, 96, 75, 70, 75, 70, 76, 55, 66, 49, 63);
    b[4] = new Student2(1337, "Shane", "Zzz", 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    b[5] = new Student2(1337, "Shane", "Pefect", 10, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
    
    // Randomly generate a class of 30
    for (int i = 0; i<c.length; i++)
    {
      c[i] = new Student2(1);
    }
    
    // Main Menu (Program starts here)
    System.err.println("Welcome to the Grade Calculator!");
    do
    {
      System.out.println("What class would you like to load? \n"
                           + "a) Different amount of projects \n"
                           + "b) A classic classroom \n"
                           + "c) Random Classroom \n"
                           + "d) Setup new classroom \n"
                           + "f) Exit Program");
      command = In.getChar();
      
      if (command == 'a' || command == 'A')
      {
        runProgram(a);
      }
      else if (command == 'b' || command == 'B')
      {
        runProgram(b);
      }
      else if (command == 'c' || command == 'C')
      {
        runProgram(c);
      }
      else if (command == 'd' || command == 'D')
      {  
        // Manually input students
        System.out.println("How many students do you have?");
        int kids = In.getInt();
        // If kids doesnt match the requirements keep asking for how many students the classroom has
        while (kids < 1 || kids > 30 || kids >= 'a' && kids <= 'z' || kids >= 'A' && kids <= 'Z')
        {
          System.out.println("Please enter the correct amount of students you have. (1-30)");
          kids = In.getInt();
        }
        Student2 [] d = new Student2[kids];
        for (int i = 0; i<d.length; i++)
        {
          d[i] = new Student2();
        }
        runProgram (d);
      }
      else if (command == 'f' || command == 'f')
      {
        System.exit(0);
      }  
    } while (command != 'f' || command != 'F');
    
  } // End of psv
} // End of class