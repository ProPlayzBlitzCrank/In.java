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
//    MMMAnimal copy = new MMMAnimal();
//    copy = other;
//    System.out.println("Copying " + other.name + " to " + copy.name);
//    this.showStats();
//    System.out.println("MMMAnimal is working!");
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
    
    favorite.modify(enviroment);
    underdog.modify(enviroment);
    
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
      if (favorite.attack >= 1)
      {
      favorite.strike(underdog);
      
      if (underdog.attack >= 1)
      {
        underdog.strike(favorite);
      }
      else 
      {
        break;
      }
      }

    
    // whoever has more health wins
    if (favorite.health > underdog.health)
    {
      System.out.println(favorite.name + " won the fight!\n");
      return favorite;
    }
    else
    {
      System.out.println(underdog.name + " won the fight!\n");
      return underdog;
    } 
  }
  
  public static void main (String [] args)
  {
    // "name", health, weaponry, armor, speed, temper, open field, forest, water/shoreline, tundra/arctic, mountain
////    MMMAnimal shane = new MMMAnimal("Shane", 50, 5, 10, 10, 3, 10, 10, 3, 8, 10); // Create 
////    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 100, 10, 10, 10, 10, 10, 10, 10, 10, 10); // Create dinosaur
//    MMMAnimal dinosaur = new MMMAnimal("Dinosaur", 1000, 100, 100, 1, 1, 100, 100, 100, 100, 100);
    
//    // Jump jump
//    MMMAnimal bengal = new MMMAnimal("Bengal Tiger", 80, 10, 6, 7, 10, 8, 10, 6, 8, 8);
//    MMMAnimal markhor = new MMMAnimal("Markhor", 65, 8, 8, 6, 6, 7, 5, 4, 10, 10);
//    bengal.strike(markhor);
//    MMMAnimal spinner = new MMMAnimal("Spinner Dolphin", 70, 7, 4, 7, 8, 0, 0, 10, 0, 0);
//    MMMAnimal bharal = new MMMAnimal("Bharal", 65, 8, 5, 6, 6, 7, 5, 4, 10, 10);
//    spinner.strike(bharal);
//    MMMAnimal serval = new MMMAnimal("Serval", 40, 8, 1, 8, 9, 6, 10, 7, 2, 4);
//    MMMAnimal impala = new MMMAnimal("Impala", 55, 5, 1, 10, 4, 10, 8, 3, 3, 4);
//    serval.strike(impala);
//    MMMAnimal sifaka = new MMMAnimal("Sifaka", 50, 5, 4, 5, 4, 6, 10, 4, 4, 4);
//    MMMAnimal springhare = new MMMAnimal("Springhare", 30, 4, 1, 10, 3, 10, 8, 3, 6, 5);
//    sifaka.strike(springhare);
//    MMMAnimal jackrabbit = new MMMAnimal("Jackrabbit", 25, 4, 1, 10, 3, 10, 8, 3, 6, 5);
//    MMMAnimal banded = new MMMAnimal("9 Banded Armadillo", 45, 2, 10, 2, 3, 8, 8, 2, 3, 2);
//    jackrabbit.strike(banded);
//    MMMAnimal klipspringer = new MMMAnimal("Klipspringer", 30, 4, 1, 8, 2, 10, 10, 1, 3, 6);
//    MMMAnimal wallaby = new MMMAnimal("Rock Wallaby", 35, 3, 4, 3, 5, 10, 10, 3, 3, 4);
//    klipspringer.strike(wallaby);
//    MMMAnimal stoat = new MMMAnimal("Stoat", 25, 4, 3, 3, 6, 7, 10, 7, 5, 5);
//    MMMAnimal spinifex = new MMMAnimal("Spinifex Hopping Mouse", 10, 2, 1, 10, 3, 5, 10, 0, 3, 6);
//    stoat.strike(spinifex);
//    MMMAnimal tenrec = new MMMAnimal("Streaked Tenrec", 15, 4, 4, 2, 3, 4, 9, 0, 4, 5);
//    MMMAnimal cat = new MMMAnimal("Ringtail Cat", 20, 3, 1, 4, 2, 4, 10, 3, 3, 5);
//    tenrec.strike(cat);
//    
//    // Waterfall
//    MMMAnimal moose = new MMMAnimal("Moose", 100, 9, 8, 7, 8, 9, 9, 6, 8, 6);
//    MMMAnimal manatee = new MMMAnimal("Manatee", 95, 4, 9, 5, 5, 0, 0, 10, 0, 0);
//    MMMAnimal tapir = new MMMAnimal("Lowland Tapir", 65, 6, 7, 7, 2, 3, 9, 7, 3, 2);
//    MMMAnimal peccary = new MMMAnimal("White-Lipped Peccary", 60, 7, 6, 6, 6, 4, 10, 6, 3, 2);
//    MMMAnimal beaver = new MMMAnimal("Beaver", 75, 6, 6, 5, 5, 2, 8, 10, 5, 1);
//    MMMAnimal fox = new MMMAnimal("Crab-Eating Fox", 55, 5, 3, 9, 8, 5, 8, 7, 4, 3);
//    MMMAnimal otter = new MMMAnimal("Marine Otter", 45, 4, 4, 10, 6, 2, 5, 9, 6, 7);
//    MMMAnimal flatHeaded = new MMMAnimal("Flat-Headed Cat", 30, 4, 4, 10, 9, 4, 7, 8, 4, 6);
//    MMMAnimal chevrotain = new MMMAnimal("Water Chevrotain", 20, 4, 2, 10, 4, 2, 6, 7, 2, 3);
//    MMMAnimal genet = new MMMAnimal("Aquatic Genet", 25, 3, 3, 8, 6, 2, 7, 8, 1, 1);
//    MMMAnimal moonrat = new MMMAnimal("Moonrat", 15, 3, 2, 9, 10, 3, 7, 7, 1, 3);
//    MMMAnimal mink = new MMMAnimal("Mink", 20, 3, 2, 9, 8, 2, 7, 8, 5, 2);
//    MMMAnimal rakali = new MMMAnimal("Rakali", 20, 3, 3, 7, 6, 2, 8, 7, 1, 0);
//    MMMAnimal oppossum = new MMMAnimal("Water Oppossum", 25, 3, 2, 6, 10, 2, 7, 7, 1, 3);
//    MMMAnimal vontsira = new MMMAnimal("Vontsira", 30, 5, 3, 4, 4, 3, 6, 7, 2, 3);
//    MMMAnimal bat = new MMMAnimal("Bulldog Bat", 5, 2, 1, 10, 1, 6, 8, 8, 0, 2);
    
//    shane.versus(dinosaur); // Shane vs Dinosaur! They will attack each other
    //MMMAnimal test = (dinosaur);
  } // psvm
}// class MMMAnimal

// Changes 
