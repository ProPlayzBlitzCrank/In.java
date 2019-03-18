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
  
  public void mmmAnimal()
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
      turf [i] = In.getInt();
    }
    
    System.out.println();
    
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
    
    defense = this.armor * this.speed;
    System.out.println("\nDefense: " + this.defense);
    attack = this.weaponry * (this.temper + this.speed);
    System.out.println("Attack: " + this.attack);
    danger = (this.attack + this.defense + this.health) * this.temper;
    System.out.println("Danger: " + this.danger);
  }
  
  public void stats()
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
  }
  
  public void update()
  {
    System.out.println("\nUpdate!");
    attack = weaponry*(temper+speed);
    defense = armor * speed;
    danger = (attack + defense + health)*temper;
  }
  
  
  public static void main (String [] args)
  {
    MMMAnimal a = new MMMAnimal();
    a.mmmAnimal(); // Displays users animal stats
    
    // Testing update();
    a.weaponry = a.weaponry - 1; // Changes weapon damage by 1
    a.update(); // Sends update
    a.stats(); // Displays update
  } // psvm
}// class MMMAnimal
