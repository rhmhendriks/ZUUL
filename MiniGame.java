import java.util.Random;
/**
 * Write a description of class MiniGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniGame
{
    // instance variables - replace the example below with your own
    private int x;


    /**
     * Constructor for objects of class MiniGame
     */
    public MiniGame()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

     // fight game
    public void endFight(Player activePlayer, Enemy activeEnemy) { 

        Random rand = new Random();

        boolean playerAlive = true;
        boolean enenmyAlive = true;

        while (playerAlive && enenmyAlive) {

            int damageDone = rand.nextInt(activePlayer.getmaxAttackDamage());
            int damageTaken = rand.nextInt(activeEnemy.getEnemyMaxAttackDamage());

            activePlayer.setHealth(activePlayer.getHealth() - damageTaken);
            activeEnemy.setEnemyHealth(activeEnemy.getEnemyHealth() - damageDone);

            System.out.println("Je hebt de bewaker met " + damageDone + " geraakt, hij heeft nog " + activeEnemy.getEnemyHealth() + " levens");
            System.out.println("De bewaker heeft jou een klap gegeven van " + damageTaken + " je hebt nog " + activePlayer.getHealth() + " levens");

            if(activePlayer.getHealth() <= 0 || activeEnemy.getEnemyHealth() <= 0) {
                
                if (activeEnemy.getEnemyHealth() <= 0) {
                    enenmyAlive = false;
                } else {
                    if (activePlayer.getLiveStatus() > 1) {
                        activePlayer.lostLive();
                       } else {


                       }

            } else {
                System.out.println("blij aanvallen, geeft niet op!");
            }
        }
    }
}
