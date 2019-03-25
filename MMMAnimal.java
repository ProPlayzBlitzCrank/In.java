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
    
    this.showStats();
  }
  
  // INSTANCE METHODS
  public void strike(MMMAnimal opp)
  {
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
      this.update(); // Update attacking user
      opp.update(); // Update defending user
    }
    else
    {
      if(this.health>5) // this will simulate an unsuccessful attack that tires the  attacker
      {
        int oldHealth = this.health;
        this.health = this.health - 5;
        System.out.println(this.name + " lost 5 health. " + this.name + " went from " + oldHealth + " to " + this.health + " hp");
        System.out.println();
        this.update(); // Update attacking user
        opp.update(); // Update defending user
      }
      else
      {
        this.health = this.health - 1;
        System.out.println(this.name + " lost 1 health. " + this.name + " now has " + this.health);
        System.out.println();
        this.update(); // Update attacking user
        opp.update(); // Update defending user
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
      System.out.println(this.name + " ran away!\n");
      return true;
    }
    else
    {
      System.out.println(this.name + " cant run.\n");
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
    int oldAttack = attack;
    int oldDefense = defense;
    int oldDanger = danger;
    
    attack = weaponry*(temper+speed);
    defense = armor * speed;
    danger = (attack + defense + health)*temper;
    
    if (oldAttack != attack || oldDefense != defense || oldDanger != danger) // if any of the stats were changed display them
    {
      System.out.println(this.name + "'s stats were update!");
      this.showStats();
    }
  }
  
  public MMMAnimal (MMMAnimal other)
  {
    MMMAnimal copy = new MMMAnimal(other);
    System.out.println("Copying " + other.name + " to " + copy.name);
    copy.showStats();
    System.out.println("MMMAnimal is working!");
  }
  
  public void modify (int environment)
  {
    weaponry = weaponry *turf[environment];
    armor = weaponry *turf[environment];
    speed = speed*turf[environment];
  }
  
  public MMMAnimal versus (MMMAnimal opp)
  {
    MMMAnimal favorite = this;
    MMMAnimal underdog = opp;
    
    int enviroment = 0 + new Random().nextInt(turf.length);
    
    System.out.println(favorite.name +  " vs " + underdog.name);
    System.out.println(favorite.danger +  " danger " + underdog.danger);
    System.out.println(favorite.health + " health " + underdog.health);
    System.out.println(favorite.armor + " armor " + underdog.armor);
    System.out.println(favorite.speed + " speed " + underdog.speed);
    System.out.println(favorite.temper + " temper " + underdog.temper);
    switch (enviroment)
    {
      case 0:
        System.out.println("Todays battle will take place on: open field");
        break;
      case 1:
        System.out.println("Todays battle will take place on: forest");
        break;
      case 2:
        System.out.println("Todays battle will take place on: water/shoreline");
        break;
      case 3:
        System.out.println("Todays battle will take place on: tundra/arctic");
        break;
      case 4:
        System.out.println("Todays battle will take place on: mountain");
        break;
    }
    System.out.println(favorite.turf[enviroment] + " turf advantage " + underdog.turf[enviroment] + "\n");
    
    favorite.modify(enviroment);
    underdog.modify(enviroment);
    
    // run check
    if (favorite.run(underdog) == true)
    {
      underdog.showStats();
      System.out.println(favorite.name + " ran away./n" + underdog.name + " wins!");
    }
    else if (underdog.run(favorite) == true)
    {
      favorite.showStats();
      System.out.println(underdog.name + " ran away./n" + favorite.name + " wins!");
    }
    
    // Attack each other while health is above 0
    while (favorite.health >= 0 && underdog.health >= 0)
    {
      favorite.strike(underdog);
      underdog.strike(favorite);
    }
    
    // whoever has more health wins
    if (favorite.health > underdog.health)
    {
      System.out.println(favorite.name + " won the fight!");
      return favorite;
    }
    else
    {
      System.out.println(underdog.name + " won the fight!");
      return underdog;
    } 
  }
  
  public static void main (String [] args)
  {
    // "name", health, weaponry, armor, speed, temper, open field, forest, water/shoreline, tundra/arctic, mountain
    MMMAnimal shane = new MMMAnimal("Shane", 50, 5, 10, 10, 3, 10, 10, 3, 8, 10); // Create 
    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 100, 10, 10, 10, 10, 10, 10, 10, 10, 10); // Create dinosaur
//    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 1000, 100, 100, 1, 1, 100, 100, 100, 100, 100);
    
    shane.versus(dinosaur); // Shane vs Dinosaur! They will attack each other
    
  } // psvm
}// class MMMAnimal

// Changes 
// • added showStats() in MMMAnimal (removed showStats() from psvm)
// • fixed update
// • added do{} statement to attack each other until one of them are dead
// • removed run check from strike method -> added to versus
