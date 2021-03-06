import java.util.Random;

class SimpleMMMAnimal
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
    
    this.update();
  }
  
  public MMMAnimal (char env)
  {
    Random r = new Random (); 
    
    String [] names = { "Chazewuzzer", "Banded Beatbox", "Hyperpotamus", "Yellow-Bellied Cowherd", "Silky Sammidge",
      "Banana Rama", "Motley Croo", "Pink Floid", "Garbage Picker", "Icthius", "Red-Tailed Ringidoo", "Shart",
      "Finiky Eader", "Dyete Snapple", "Fig Newton", "Scorpinox", "Optimus Prime", "Moogatron", "Spiny Aunteater",
      "One-Eyed Peopleeater", "Catdog", "Danger Noodle", "Trash Panda", "River Scissors", "Unique Horn", "Doug"};
    this.name = names[r.nextInt(names.length)];
    this.health = r.nextInt(100)+1;
    this.weaponry = r.nextInt(11);
    this.armor = r.nextInt(11);
    this.speed = r.nextInt(11);
    this.temper = r.nextInt(10)+1;
    switch(env)
    {
      case 'L':
        this.turf[0]= r.nextInt(6)+5;
        this.turf[1]= r.nextInt(6)+5;
        this.turf[2]= r.nextInt(4);
        this.turf[3]= r.nextInt(4);
        this.turf[4]= r.nextInt(4);
        break;
      case 'W':
        this.turf[0]= r.nextInt(4);
        this.turf[1]= r.nextInt(4);
        this.turf[2]= r.nextInt(6)+5;
        this.turf[3]= r.nextInt(3);
        this.turf[4]= r.nextInt(3);
        break;
      case 'C':
        this.turf[0]= r.nextInt(4);
        this.turf[1]= r.nextInt(4);
        this.turf[2]= r.nextInt(6);
        this.turf[3]= r.nextInt(4)+7;
        this.turf[4]= r.nextInt(4)+7;
        break;
      default:
        this.turf[0]= r.nextInt(11);
        this.turf[1]= r.nextInt(11);
        this.turf[2]= r.nextInt(11);
        this.turf[3]= r.nextInt(11);
        this.turf[4]= r.nextInt(11);
    }
    this.update();
  }
  
    public MMMAnimal (MMMAnimal other) // Copy
  {
    this.name = other.name;
    this.health = other.health;
    this.weaponry = other.weaponry;
    this.armor = other.armor;
    this.speed = other.speed;
    this.temper = other.temper;
    this.turf[0] = other.turf[0];
    this.turf[1] = other.turf[1];
    this.turf[2] = other.turf[2];
    this.turf[3] = other.turf[3];
    this.turf[4] = other.turf[4];
    this.attack = other.attack;
    this.defense = other.defense;
    this.danger = other.danger;
  }
  
  // INSTANCE METHODS
  public void strike(MMMAnimal opp)
  {
    int off = 0 + new Random().nextInt(this.attack);
    int def = 0 + new Random().nextInt(opp.defense);
    
    if (off > def)
    {
      opp.health = opp.health - (off - def);
    }
    else
    {
      if(this.health>5) // this will simulate an unsuccessful attack that tires the  attacker
      {
        this.health = this.health - 5;
      }
      else
      {
        this.health = this.health - 1;
      }
    }
  }
  
  public boolean run (MMMAnimal opp)
  {
    int dangerCheck = opp.danger - this.danger;
    if (dangerCheck <= 0)
    {
      dangerCheck = 1;
    }
    int run = 1 + new Random().nextInt(dangerCheck);
    
    if (this.danger < opp.danger && this.speed > opp.speed && this.temper < 5 && run < this.danger)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public void showStats()
  {
    System.err.println("Animal Name: " + this.name);//display stats
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
  
  public void update() // Update
  {
    attack = this.weaponry*(this.temper+this.speed)+1;
    defense = this.armor * this.speed+1;
    danger = (this.attack + this.defense + this.health)*this.temper+1;
  }
  
  public void modify (int environment) // Modify
  {
    weaponry = weaponry *turf[environment];
    armor = weaponry *turf[environment];
    speed = speed*turf[environment];
    this.update();
  }
  
  public MMMAnimal versus (MMMAnimal opp) // Versus
  {
    MMMAnimal favorite = new MMMAnimal (this);
    MMMAnimal underdog = new MMMAnimal (opp);
    
    int enviroment = 0 + new Random().nextInt(turf.length);
    
    // selects turf > Modifies(turf) > updates + displays updated stats > checks if they can run > attacks until one is dead
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
    }
    else if (underdog.run(favorite) == true)
    {
    }
    
    // Attack each other while health is above 0
    while (favorite.health > 0 && underdog.health > 0)
    {
      if (favorite.attack == 0)
      {break;}
      if (underdog.attack == 0)
      {break;}
      if (favorite.attack > 0)
      {
        favorite.strike(underdog);
      }
      if (underdog.health <= 0)
      {
        break;
      }
      if (underdog.attack > 0)
      {
        underdog.strike(favorite);
      }
    }
    
    
    // whoever has more health wins
    if (favorite.health > underdog.health)
    {
      return this;
    }
    else
    {
      return opp;
    } 
  }
  
  public static void main (String [] args)
  {
    
  } // psvm
} // class MMMAnimal
