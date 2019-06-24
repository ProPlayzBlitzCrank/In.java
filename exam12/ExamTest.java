class ExamTest
{
  String firstNamesList;
  String lastNamesList;
  int [] marks = {0,0,0,0,0,0,0,0};
  double averages;
  
  public ExamTest()
  {
    System.out.println("(FIRST NAME, THEN LAST NAME)");
    firstNamesList = In.getString();
    lastNamesList = In.getString();
    System.out.println("Please enter all the grades for " + firstNamesList + " " + lastNamesList);
    for (int i = 0; i<8; i++)
    {
      System.out.print((i+1) + "/8");
      marks[i] = In.getInt();
    }
    System.out.println();
    findAverage();
  }
  
  /* Display
   * 
   * Passing
   * DEAN'S LIST
   * Last name, First name
   * Grade list
   * Average
   */
  public void display()
  {
    if (averages >= 50)
    {
      System.out.println(firstNamesList + " " + lastNamesList + " is currently passing");
    }
    else
    {
      System.out.println(firstNamesList + " " + lastNamesList + " is currently failing");
    }
    if (marks[0] >= 80 && marks[1] >= 80 && marks[2] >= 80 && marks[3] >= 80 && marks[4] >= 80 && marks[5] >= 80 && marks[6] >= 80 && marks[7] >= 80)
    {
      System.out.println(firstNamesList + " " + lastNamesList + " has made the DEAN'S LIST");
    }
    else
    {
      System.out.println("Sorry, " + firstNamesList + " " + lastNamesList + " did not make the DEAN'S LIST");
    }
    System.out.println(lastNamesList + ", " + firstNamesList);
    System.out.println("ASSISNMENT GRADES:");
    for (int i = 0; i<marks.length; i++)
    {
      System.out.println("\t#" + (i+1) + "\t" + marks[i]);
    }
    System.out.println("CURRENT AVERAGE: " + averages);
  }
  
  public void findAverage()
  {
    averages = (marks[0] + marks[1] + marks[2] + marks[3] + marks[4] + marks[5] + marks[6] + marks[7])/8;
  }
  
  public static double findAverage (int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8)
  {
    double avg = (a1+a2+a3+a4+a5+a6+a7+a8)/8;
    return avg;
  }
  
  public static void main (String [] args)
  {
    System.out.println("Please enter the class size");
    int classSize = In.getInt();
    
    ExamTest [] classroom = new ExamTest[classSize];
    for (int i = 0; i<classSize; i++)
    {
      classroom[i] = new ExamTest();
    }
    
    for (int i = 0; i<classroom.length; i++)
    {
      classroom[i].display();
    }
  }
}