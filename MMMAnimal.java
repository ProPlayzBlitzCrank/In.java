import java.util.Random;

class MMMAnimal
{
  String name;
  int health;
  int weaponry;
  int armor;
  int speed;
  int temper;
  int[] turf = {0,0,0,0,0};
  int defense; // = armor * speed;
  int attack;  // = weaponry * (temper + speed);
  int danger;  // = (attack + defense + health) * temper;
  
  //CONSTRUCTOR METHODS
  public MMMAnimal()
  {
    System.out.println("What is the name of your animal");//name
    name = In.getString();
    do
    {
      System.out.println("How much health does your animal have? (1-100)");//health
      health = In.getInt();
    } while (health <= 0 || health >= 101);
    do
    {
      System.out.println("How much damage does your weapon do? (1-10)");//weapon
      weaponry = In.getInt();
    } while (weaponry <= 0 || weaponry >= 11);
    do
    {
      System.out.println("How much armor(1-10)");//armor
      armor = In.getInt();
    } while (armor <= 0 || armor >= 11);
    do
    {
      System.out.println("How much speed? (1-10)");//speed
      speed = In.getInt();
    } while (speed <= 0 || speed >= 11);
    do
    {
      System.out.println("How much temper? (1-10)");//speed
      temper = In.getInt();
    } while (temper <= 0 || temper >= 11);
    
    System.out.println("Turf");
    for (int i = 0; i < turf.length; i++)
    {
      System.out.println("1-10 (" + i + ")");
      switch (i)
      {
        case 0:
          System.out.println("open field");
          break;
        case 1:
          System.out.println("forest");
          break;
        case 2:
          System.out.println("water/shoreline");
          break;
        case 3:
          System.out.println("tundra/arctic");
          break;
        case 4:
          System.out.println("mountain");
      }
      turf [i] = In.getInt();
    }
    
    System.out.println();
    
    defense = armor * speed;
    attack = weaponry * (temper + speed);
    danger = (attack + defense + health) * temper;
  }
  
  public MMMAnimal (String n, int h, int w, int a, int s, int t, int turf0, int turf1, int turf2, int turf3, int turf4)
  {
    this.name = n;
    this.health = h; 
    this.weaponry = w;
    this.armor = a;
    this.speed = s;
    this.temper = t;
    this.turf[0] = turf0;
    this.turf[1] = turf1;
    this.turf[2] = turf2;
    this.turf[3] = turf3;
    this.turf[4] = turf4;
    
    defense = this.armor * this.speed;
    attack = this.weaponry * (this.temper + this.speed);
    danger = (this.attack + this.defense + this.health) * this.temper;
  }
  
  // INSTANCE METHODS
  public void strike(MMMAnimal opp)
  {
    //a.strike(opp)
    int off = 0 + new Random().nextInt(this.attack);
    int def = 0 + new Random().nextInt(opp.defense);
    System.out.println(this.name + " striked " + opp.name + "!\n"
                         + this.name + ", off = " + off + "\n"
                         + opp.name + ", def = " + def + "\n");
    
    if (off > def)
    {
      int oldHealth = opp.health;
      opp.health = opp.health - (off - def);
      int lost = (off - def); // Displays how much health they lost
      System.out.println("Total Damage = " + lost + "\n"
                           + opp.name + " lost " + lost + " health. " + opp.name + " went from " + oldHealth + " to " + opp.health + " hp");
      System.out.println();
    }
    else
    {
      if(this.health>5) // this will simulate an unsuccessful attack that tires the  attacker
      {
        int oldHealth = this.health;
        this.health = this.health - 5;
        System.out.println(this.name + " lost 5 health. " + this.name + " went from " + oldHealth + " to " + this.health + " hp");
        System.out.println();
      }
      else
      {
        this.health = this.health - 1;
        System.out.println(this.name + " lost 1 health. " + this.name + " now has " + this.health);
        System.out.println();
      }
    }
  }
  
  public boolean run (MMMAnimal opp)
  {
    int dangerCheck = opp.danger - this.danger;
    if (dangerCheck < 0)
    {
      dangerCheck = 1;
    }
    int run = 1 + new Random().nextInt(dangerCheck);
    
    if (this.danger < opp.danger && this.speed > opp.speed && this.temper < 5 && run < this.danger)
    {
      System.out.println(this.name + " ran away!");
      return true;
    }
    else
    {
      System.out.println(this.name + " cant run.");
      return false;
    }
  }
  
  public void showStats()
  {
    System.out.println("Animal Name: " + this.name);//display stats
    System.out.println("Health: " + this.health);
    System.out.println("Weaponry: " + this.weaponry);
    System.out.println("Armor: " + this.armor);
    System.out.println("Speed: " + this.speed);
    System.out.println("Temper: " + this.temper);
    
    System.out.print("Turf:");
    for (int i = 0; i < turf.length; i++)
    {
      System.out.print(" " + turf[i]);
    }
    
    System.out.println("\nDefense: " + this.defense);
    System.out.println("Attack: " + this.attack);
    System.out.println("Danger: " + this.danger);
    System.out.println();
  }
  
  public void update()
  {
    System.out.println("Update!");
    attack = weaponry*(temper+speed);
    defense = armor * speed;
    danger = (attack + defense + health)*temper;
  }
  
  
  public static void main (String [] args)
  {
    // "name", health, weaponry, armor, speed, temper, open field, forest, water/shoreline, tundra/arctic, mountain
    MMMAnimal shane = new MMMAnimal("Shane", 50, 5, 10, 10, 3, 10, 10, 3, 8, 10); // Create 
    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 100, 10, 10, 10, 10, 10, 10, 10, 10, 10); // Create dinosaur
//    MMMAnimal shane = new MMMAnimal("Shane", 50, 5, 10, 10, 3, 10, 10, 3, 8, 10);
//    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 1000, 100, 100, 1, 1, 100, 100, 100, 100, 100);
    shane.showStats(); // Shane's stats
    dinosaur.showStats(); // Dinosaur stats
    if (shane.run(dinosaur) == true)
    {}
    else
    {
    shane.strike(dinosaur); // Shane attacks Dinosaur
    shane.update();
    shane.showStats();
    dinosaur.update(); // Updates Dinosaurs stats
    dinosaur.showStats(); // Displays Dinosaurs stats
    }
    
    
  } // psvm
}// class MMMAnimal
