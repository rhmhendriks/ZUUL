import java.util.Random;

/**
 * class Enemy - geef hier een beschrijving van deze class
 *
 * @author (Luc Willemse)
 * @version (20-01-2020)
 */
public class Enemy
{
    // instance variables - vervang deze door jouw variabelen
    Random rand = new Random();
    int enemyHealth = 10;
    int enemyMaxAttackDamage = 3;


    /**
     * Constructor voor objects van class Enemy
     */
    public Enemy()
    {
        // geef de instance variables een beginwaarde
        
    }

    public void setEnemyHealth(int numbEnenmyHealth){
        this.enemyHealth = numbEnenmyHealth;
    }

    public void setEnemyMaxAttackDamage(int numbEnemyMaxAttackDamage){
        this.enemyMaxAttackDamage = numbEnemyMaxAttackDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyMaxAttackDamage() {
        return enemyMaxAttackDamage;
    }

    /**
     * Voorbeeld van een method - schrijf hier jouw comment
     *
     * @param  y    deze method krijgt deze parameter mee in de aanroep
     * @return    deze method geeft de som van x en y terug
     */
    
}
