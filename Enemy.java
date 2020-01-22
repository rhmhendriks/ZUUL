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

    /**
     * set the enemy health
     * @param numbEnenmyHealth 
     */
    public void setEnemyHealth(int numbEnenmyHealth){
        this.enemyHealth = numbEnenmyHealth;
    }

    /**
     * set the enemy max attack damage
     * @param numbEnemyMaxAttackDamage
     */
    public void setEnemyMaxAttackDamage(int numbEnemyMaxAttackDamage){
        this.enemyMaxAttackDamage = numbEnemyMaxAttackDamage;
    }

    /**
     * get the enemey health
     * @return the enemey health
     */
    public int getEnemyHealth() {
        return enemyHealth;
    }

    /**
     * get the enemy max attack damage
     * @return the enemy max attack damage
     */
    public int getEnemyMaxAttackDamage() {
        return enemyMaxAttackDamage;
    }
}
