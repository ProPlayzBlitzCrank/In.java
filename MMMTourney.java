class MMMTourney
{
  public static void 
    drama (int time)
  {
    try
    {
      Thread.sleep(time);
    }
    catch(InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    } 
  }
  
  public static MMMAnimal [] sort (MMMAnimal [] list)
  {
    MMMAnimal temp;
    for(int i = 1 ; i< list.length ; i++)
    {
      for(int j = 1 ; j < list.length ; j++)
      {
        if( (list[j].attack+list[j].defense+list[j].health) < (list[j].attack+list[j].defense+list[j].health))
        {
          temp = list[j];
          list[j] = list[j-1];
          list[j-1] = temp;
        }
      }
    }
    return list;
  }
  
  public static void tournament (MMMAnimal [] field)
  {
    MMMAnimal [] roundTwo = new MMMAnimal [8];
    MMMAnimal [] roundThree = new MMMAnimal [4];
    MMMAnimal finalist1;
    MMMAnimal finalist2;
    MMMAnimal champ;
    
    field = sort (field);
    
    System.err.println("ROUND ONE");
    System.out.println(field[0].name + "(" + field[0].danger + ")");
    System.out.println(field[15].name + "(" + field[15].danger + ")");
    System.out.println();
    System.out.println(field[7].name + "(" + field[7].danger + ")");
    System.out.println(field[8].name + "(" + field[8].danger + ")");
    System.out.println();
    System.out.println(field[4].name + "(" + field[4].danger + ")");
    System.out.println(field[11].name + "(" + field[11].danger + ")");
    System.out.println();
    System.out.println(field[3].name + "(" + field[3].danger + ")");
    System.out.println(field[12].name + "(" + field[12].danger + ")");
    System.out.println();
    System.out.println(field[2].name + "(" + field[2].danger + ")");
    System.out.println(field[13].name + "(" + field[13].danger + ")");
    System.out.println();
    System.out.println(field[5].name + "(" + field[5].danger + ")");
    System.out.println(field[10].name + "(" + field[10].danger + ")");
    System.out.println();
    System.out.println(field[6].name + "(" + field[6].danger + ")");
    System.out.println(field[9].name + "(" + field[9].danger + ")");
    System.out.println();
    System.out.println(field[1].name + "(" + field[1].danger + ")");
    System.out.println(field[14].name + "(" + field[14].danger + ")");
    System.out.print("HIT ENTER TO CONTINUE");
    In.getInt();
    
    System.err.println("1st SEED vs. 16th SEED");
    roundTwo[0] = field[0].versus(field[15]);
    System.err.println("8th SEED vs. 9th SEED");
    roundTwo[1] = field[7].versus(field[8]);
    System.err.println("5th SEED vs. 12th SEED");
    roundTwo[2] = field[4].versus(field[11]);
    System.err.println("4th SEED vs. 13th SEED");
    roundTwo[3] = field[3].versus(field[12]);
    System.err.println("3rd SEED vs. 14th SEED");
    roundTwo[4] = field[2].versus(field[13]);
    System.err.println("6th SEED vs. 11th SEED");
    roundTwo[5] = field[5].versus(field[10]);
    System.err.println("7th SEED vs. 10th SEED");
    roundTwo[6] = field[6].versus(field[9]);
    System.err.println("2nd SEED vs. 15th SEED");
    roundTwo[7] = field[1].versus(field[14]);
    
    System.err.println("ELITE EIGHT");
    System.out.println(roundTwo[0].name + "(" + roundTwo[0].danger + ")");
    System.out.println(roundTwo[1].name + "(" + roundTwo[1].danger + ")");
    System.out.println();
    System.out.println(roundTwo[2].name + "(" + roundTwo[2].danger + ")");
    System.out.println(roundTwo[3].name + "(" + roundTwo[3].danger + ")");
    System.out.println();
    System.out.println(roundTwo[4].name + "(" + roundTwo[4].danger + ")");
    System.out.println(roundTwo[5].name + "(" + roundTwo[5].danger + ")");
    System.out.println();
    System.out.println(roundTwo[6].name + "(" + roundTwo[6].danger + ")");
    System.out.println(roundTwo[7].name + "(" + roundTwo[7].danger + ")");
    System.out.print("HIT ENTER TO CONTINUE");
    In.getInt();
    
    if(roundTwo[0].danger>roundTwo[1].danger)
    {
      roundThree[0] = roundTwo[0].versus(roundTwo[1]);
    }
    else
    {
      roundThree[0] = roundTwo[1].versus(roundTwo[0]);
    }
    if(roundTwo[2].danger>roundTwo[3].danger)
    {
      roundThree[1] = roundTwo[2].versus(roundTwo[3]);
    }
    else
    {
      roundThree[1] = roundTwo[3].versus(roundTwo[2]);
    }
    if(roundTwo[4].danger>roundTwo[5].danger)
    {
      roundThree[2] = roundTwo[4].versus(roundTwo[5]);
    }
    else
    {
      roundThree[2] = roundTwo[5].versus(roundTwo[4]);
    }
    if(roundTwo[6].danger>roundTwo[7].danger)
    {
      roundThree[3] = roundTwo[6].versus(roundTwo[7]);
    }
    else
    {
      roundThree[3] = roundTwo[7].versus(roundTwo[6]);
    }
    
    System.err.println("FINAL FOUR");
    System.out.println(roundThree[0].name + "(" + roundThree[0].danger + ")");
    System.out.println(roundThree[1].name+ "(" + roundThree[1].danger + ")");
    System.out.println();
    System.out.println(roundThree[2].name+ "(" + roundThree[2].danger + ")");
    System.out.println(roundThree[3].name+ "(" + roundThree[3].danger + ")");
    System.out.print("HIT ENTER TO CONTINUE");
    In.getInt();
    if(roundThree[0].danger>roundTwo[1].danger)
    {
      finalist1 = roundThree[0].versus(roundThree[1]);
    }
    else
    {
      finalist1 = roundThree[1].versus(roundThree[0]);
    }
    if(roundTwo[2].danger>roundTwo[3].danger)
    {
      finalist2 = roundThree[2].versus(roundThree[3]);
    }
    else
    {
      finalist2 = roundThree[3].versus(roundThree[2]);
    }
    
    System.err.println("FINAL");
    System.out.println(finalist1.name+ "(" + finalist1.danger + ")");
    System.out.println(finalist2.name+ "(" + finalist2.danger + ")");
    In.getInt();
    System.out.println();
    if(finalist1.danger>finalist2.danger)
    {
      champ = finalist1.versus(finalist2);
    }
    else
    {
      champ = finalist2.versus(finalist1);
    }
    
    System.out.println("And the winner is .................");
    drama(2000);
    System.out.println(" the .........................");
    drama(4000);
    System.err.println("*******"+champ.name+"*******");
  }
  
  public static void main (String [] args)
  {
    MMMAnimal [] competitors = new MMMAnimal [16]; // jumpjump animals
    MMMAnimal [] arrayR = new MMMAnimal[16]; // random animals
    MMMAnimal [] arrayP = new MMMAnimal[16]; // waterfalls animals
    
// Random
    for(int i = 0; i<arrayR.length; i++) // generates random animals
    {
      arrayR[i] = new MMMAnimal('L');
    }
    
// Waterfall
    arrayP[0] = new MMMAnimal("Moose", 100, 9, 8, 7, 8, 9, 9, 6, 8, 6);
    arrayP[1] = new MMMAnimal("Manatee", 95, 4, 9, 5, 5, 0, 0, 10, 0, 0);
    arrayP[2] = new MMMAnimal("Lowland Tapir", 65, 6, 7, 7, 2, 3, 9, 7, 3, 2);
    arrayP[3] = new MMMAnimal("White-Lipped Peccary", 60, 7, 6, 6, 6, 4, 10, 6, 3, 2);
    arrayP[4] = new MMMAnimal("Beaver", 75, 6, 6, 5, 5, 2, 8, 10, 5, 1);
    arrayP[5] = new MMMAnimal("Crab-Eating Fox", 55, 5, 3, 9, 8, 5, 8, 7, 4, 3);
    arrayP[6] = new MMMAnimal("Marine Otter", 45, 4, 4, 10, 6, 2, 5, 9, 6, 7);
    arrayP[7] = new MMMAnimal("Flat-Headed Cat", 30, 4, 4, 10, 9, 4, 7, 8, 4, 6);
    arrayP[8] = new MMMAnimal("Water Chevrotain", 20, 4, 2, 10, 4, 2, 6, 7, 2, 3);
    arrayP[9] = new MMMAnimal("Aquatic Genet", 25, 3, 3, 8, 6, 2, 7, 8, 1, 1);
    arrayP[10] = new MMMAnimal("Moonrat", 15, 3, 2, 9, 10, 3, 7, 7, 1, 3);
    arrayP[11] = new MMMAnimal("Mink", 20, 3, 2, 9, 8, 2, 7, 8, 5, 2);
    arrayP[12] = new MMMAnimal("Rakali", 20, 3, 3, 7, 6, 2, 8, 7, 1, 0);
    arrayP[13] = new MMMAnimal("Water Oppossum", 25, 3, 2, 6, 10, 2, 7, 7, 1, 3);
    arrayP[14] = new MMMAnimal("Vontsira", 30, 5, 3, 4, 4, 3, 6, 7, 2, 3);
    arrayP[15] = new MMMAnimal("Bulldog Bat", 5, 2, 1, 10, 1, 6, 8, 8, 0, 2);
    
    
// Jump jump
    competitors[0] = new MMMAnimal("Bengal Tiger", 80, 10, 6, 7, 10, 8, 10, 6, 8, 8);
    competitors[1] = new MMMAnimal("Markhor", 65, 8, 8, 6, 6, 7, 5, 4, 10, 10);
    competitors[2] = new MMMAnimal("Spinner Dolphin", 70, 7, 4, 7, 8, 0, 0, 10, 0, 0);
    competitors[3] = new MMMAnimal("Bharal", 65, 8, 5, 6, 6, 7, 5, 4, 10, 10);
    competitors[4] = new MMMAnimal("Serval", 40, 8, 1, 8, 9, 6, 10, 7, 2, 4);
    competitors[5] = new MMMAnimal("Impala", 55, 5, 1, 10, 4, 10, 8, 3, 3, 4);
    competitors[6] = new MMMAnimal("Sifaka", 50, 5, 4, 5, 4, 6, 10, 4, 4, 4);
    competitors[7] = new MMMAnimal("Springhare", 30, 4, 1, 10, 3, 10, 8, 3, 6, 5);
    competitors[8] = new MMMAnimal("Jackrabbit", 25, 4, 1, 10, 3, 10, 8, 3, 6, 5);
    competitors[9] = new MMMAnimal("9 Banded Armadillo", 45, 2, 10, 2, 3, 8, 8, 2, 3, 2);
    competitors[10] = new MMMAnimal("Klipspringer", 30, 4, 1, 8, 2, 10, 10, 1, 3, 6);
    competitors[11] = new MMMAnimal("Rock Wallaby", 35, 3, 4, 3, 5, 10, 10, 3, 3, 4);
    competitors[12] = new MMMAnimal("Stoat", 25, 4, 3, 3, 6, 7, 10, 7, 5, 5);
    competitors[13] = new MMMAnimal("Spinifex Hopping Mouse", 10, 2, 1, 10, 3, 5, 10, 0, 3, 6);
    competitors[14] = new MMMAnimal("Streaked Tenrec", 15, 4, 4, 2, 3, 4, 9, 0, 4, 5);
    competitors[15] = new MMMAnimal("Ringtail Cat", 20, 3, 1, 4, 2, 4, 10, 3, 3, 5);
    System.err.println("16 animals loaded correctly :)\n");
    
// tournament starts
    tournament (competitors);
    tournament (arrayP);
    tournament (arrayR);
    
  }
  
  
  
}
