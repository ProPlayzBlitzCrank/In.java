import java.util.Random;
class Student2
{
  int studentN;
  String teacher;
  String name;
  int project;
  int[] grade = {0,0,0,0,0,0,0,0,0,0};
  int sum;
  String pass;
  
  public Student2()
  {
    // Generate a random Student Number
    studentN = 1111 + new Random().nextInt(8888);                                                                        
    
    System.out.println("Teachers name: "); // Teachers Name
    teacher = In.getString();
    
    // How many projects they had that year in their class
    do
    {
      System.out.println("How many class projects (1-10): ");
      project = In.getInt();
    } while (project <= 0 || project > 10);
    
    // Name of the student
    System.out.println("Students name: ");
    name = In.getString();
    
    // Ask for marks until they put a mark for each project
    int j = 1; // J is the project number
    char command = 'a';
    for (int i = 0; i<project; i++)
    {
      while (grade[i] < 1 || grade[i] > 110)
      {
        System.out.println(name + " - Project " + j + ") ");
        grade[i] = In.getInt();
        
        if (grade[i] == 0)
        {
          System.out.println("Please confirm that " + name + ", will recieve a 0 for Project " + j + ") \n"
                            + "a) Confirm \n"
                            + "b) Decline");
          command = In.getChar();
          if (command == 'a' || command == 'A')
          {
            break;
          }
        }
      }
      j++; // Adds number to the project
    }
    
    // Finds the sum of all their grades
    this.gradeSum();
    this.sortGrade();
  }
  
  public Student2(int sn, String t, String n, int p, int g0, int g1, int g2, int g3, int g4, int g5, int g6, int g7, int g8, int g9)
  {
    this.studentN = sn;
    this.teacher = t;
    this.name = n;
    this.project = p;
    this.grade[0] = g0;
    this.grade[1] = g1;
    this.grade[2] = g2;
    this.grade[3] = g3;
    this.grade[4] = g4;
    this.grade[5] = g5;
    this.grade[6] = g6;
    this.grade[7] = g7;
    this.grade[8] = g8;
    this.grade[9] = g9;
    // Update their final grade
    this.gradeSum();
    this.sortGrade();
  }
  
  public Student2(int choose)
  {
    studentN = 1111 + new Random().nextInt(8888);  
    String [] teachers = {"Mr. Shane", "Mr. Bob", "Mr. Bobber"};
    teacher = teachers[choose]; // Decides teacher depending on what number they put in the "new Student2(#)"
    String [] names = {"OLIVIA", "RUBY", "EMILY", "RUBY", "GRACE", "JESSICA", "CHLOE", "SOPHIE", "LILY", "JACK", "OLIVER", "THOMAS", "HARRY", "JOSHUA", "ALFIE", "CHARLIE", "DANIEL", "JOHNSON", "JORDAN", "JONES", "SANDERS", "HAMILTON", "TAYLOR", "GIBSON", "JAMES", "TURNER", "GARCIA", "ARNOLD", "MARTIN"};
    name = names[0 + new Random().nextInt(names.length)];
    project = 10;
    grade[0] = 30 + new Random().nextInt(71);
    grade[1] = 30 + new Random().nextInt(71);
    grade[2] = 30 + new Random().nextInt(71);
    grade[3] = 30 + new Random().nextInt(71);
    grade[4] = 30 + new Random().nextInt(71);
    grade[5] = 30 + new Random().nextInt(71);
    grade[6] = 30 + new Random().nextInt(71);
    grade[7] = 30 + new Random().nextInt(71);
    grade[8] = 30 + new Random().nextInt(71);
    grade[9] = 30 + new Random().nextInt(71);
    
    this.gradeSum();
    this.sortGrade();
  }

  
  // Formated string so its looks nice when it prints to the screen
  public void categories()
  {
    System.out.format("|%-21s|%-15s|%-15s|%-15s|%-15s|%-15s", "Student #", "Teacher", "Name", "Final Grade", "Projects", "Grade");
    System.out.println();
  }
  
  // Formated string that will display their information
  public void displaykids()
  {
    // Changes how many chars the spacing of the format has to be to line everything properly
    if (this.sum < 10)
    {
      System.out.format("|%s%-15s|%-15s|%-15s|%s%-14s|%-15s|", "s19988", this.studentN, this.teacher, this.name, this.sum, this.pass, this.project);
      for (int i = 0; i<this.project; i++)
      {
        System.out.print(this.grade[i]);
        if (i+1 != this.project)
        {
          System.out.print(", ");
        }
      }
      System.out.println();
    }
    else if (this.sum >= 100)
    {
      System.out.format("|%s%-15s|%-15s|%-15s|%s%-12s|%-15s|", "s19988", this.studentN, this.teacher, this.name, this.sum, this.pass, this.project);
      for (int i = 0; i<this.project; i++)
      {
        System.out.print(this.grade[i]);
        if (i+1 != this.project)
        {
          System.out.print(", ");
        }
      }
      System.out.println();
    }
    else
    {
      System.out.format("|%s%-15s|%-15s|%-15s|%s%-13s|%-15s|", "s19988", this.studentN, this.teacher, this.name, this.sum, this.pass, this.project);
      for (int i = 0; i<this.project; i++)
      {
        System.out.print(this.grade[i]);
        if (i+1 != this.project)
        {
          System.out.print(", ");
        }
      }
      System.out.println();
    }
  }
  
  // Finds the sum of their grades
  public void gradeSum()
  {
    for (int i = 0; i<this.project; i++)
    {
      this.sum = this.sum + this.grade[i];
    }
    this.sum = this.sum / this.project;
  }
  
  // Sorts the higher average to the top
  public boolean sort(Student2 other)
  {
    return this.sum > other.sum;
  }
  
  // Sorts the lower average to the top
  public boolean lowavg(Student2 other)
  {
    return this.sum < other.sum;
  }
  
  public boolean sortSN(Student2 other)
  {
    return this.studentN < other.studentN;
  }
  
  // Checks if they passed the class
  public void pass()
  {
    if (sum >= 50)
    {
      pass = " - PASS";
    }
    else
    {
      pass = " - FAIL";
    }
  }
  
  // Sorts grades from lowest to highers
  public void sortGrade()
  {
    int n = project;
    for (int i = 1; i < n; ++i)
    {
      int key = grade[i];
      int j = i - 1;
      
      /* Move elements of arr[0..i-1], that are
       greater than key, to one position ahead
       of their current position */
      while (j >= 0 && grade[j] > key)
      {
        grade[j + 1] = grade[j];
        j = j - 1;
      }
      grade[j + 1] = key;
    }
  }
  
  
  public static void main (String [] args)
  {

  } // main
} // class

/* What did I do today?
 * June 3: Planning and setting some variables
 * June 4: Added a formatted display (Searching how to use all the forms of the formats)
 * June 5: Adding students to display and adjusting thing so it can be used to hard code them (public Student(variables))
 * June 6: Sorting grade average, classroom class (need to be able to allow more students)
 * June 9: Re wrote most of the code to work better with Classroom.java | Includes: public Student2(), displaykids(),| Added categories so it was easier to display stuff to the screen how I wanted it to display | Classroom2.java now allows a lot more students to be used
 * June 10: Added a random class generator
 * June 11: Adding error checks (checks for correct variable, tells them to fix mistake)
 * June 12: Added a grade sort (Grades are always lowest to highest), added student number sort
 * June 13: Says the teachers name when the sorting menu pops up | more error checks | Added a check so that format wouldn't be out of line if the sum was > 100 or < 10
 * June 17: Fixed an error where the user could put a letter as a number which would make the mark a 0 | Added an exit program and next classroom
 * June 18: Added a main menu to allow the user to use the program how they want and make it last forever
 *
 * Helped with using format
 * https://www.javatpoint.com/java-string-format
 *
 * Used for insertion sorting
 * https://www.geeksforgeeks.org/insertion-sort/
 */