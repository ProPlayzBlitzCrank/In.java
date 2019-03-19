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
     
    defense = armor * speed;
    attack = weaponry * (temper + speed);
    danger = (attack + defense + health) * temper;
  }
  
  public void strike(MMMAnimal opp)
  {
    //a.strike(opp)
    int off = 0 + new Random().nextInt(this.attack);
    int def = 0 + new Random().nextInt(opp.defense);
    System.out.println(this.name + " striked " + opp.name + "!\n" + this.name + ", off = " + off + "\n" + opp.name +", blocked for\ndef = " + def);
    System.out.println();
    
    if (off > def)
    {
      opp.health = opp.health - (off - def);
      int lost = (off - def); // Displays how much health they lost
      System.out.println(opp.name + " lost " + lost + " health. " + opp.name + " now has " + opp.health);
    }
    else
    {
      if(this.health>5) // this will simulate an unsuccessful attack that tires the  attacker
      {
        this.health = this.health - 5;
        System.out.println(this.name + " lost 5 health. " + this.name + " now has " + this.health);
      }
      else
      {
        this.health = this.health - 1;
        System.out.println(this.name + " lost 1 health. " + this.name + " now has " + this.health);
      }
    }
  }
  
//  public boolean run (MMMAnimal opp)
//  {
//    if (this.danger < opp.danger)
//    {
//      if (this.speed > opp.speed)
//      {
//       if (this.temper < 5 )
//       {
//         int run = 0 + new Random().nextInt(opp.danger-this.danger);
//         if (run < this.danger)
//         {
//           return true; // runs away
//         }
//         else
//         {
//           return false; // stays in the fight
//         }
//       }
//      }
//    }
//    return false;
//  }
  
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
  
  public void opp ()
  {
    name = "Opponent";
    health = 1 + new Random().nextInt(100);
    weaponry = 1 + new Random().nextInt(10);
    armor = 1 + new Random().nextInt(10);
    speed = 1 + new Random().nextInt(10);
    temper = 1 + new Random().nextInt(10);
    
    for (int i = 0; i < turf.length; i++)
    {
      turf[i] = 1 + new Random().nextInt(10);
    }
    
    defense = this.armor * this.speed;
    attack = this.weaponry * (this.temper + this.speed);
    danger = (this.attack + this.defense + this.health) * this.temper;
  }
  
  
  public static void main (String [] args)
  {
    MMMAnimal a = new MMMAnimal();
    MMMAnimal b = new MMMAnimal();
    a.mmmAnimal(); // User creates animal
    a.showStats(); // Shows users animal stats
    b.opp(); // Creates opponent
    b.showStats(); // Displays opponents stats
    
    a.strike(b); // A striked B
    a.update(); // Sends update
    a.showStats(); // Displays update
    b.update(); // Updates B stats
    b.showStats(); // Displays B Stats
  } // psvm
}// class MMMAnimal
