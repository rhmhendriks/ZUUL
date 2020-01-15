import java.util.Timer;
import java.util.TimerTask;

/**
 * class Clock - geef hier een beschrijving van deze class
 *
 * @author (Luc Willemse)
 * @version (15-01-2020)
 */
public class Clock
{
    Timer timer = new Timer();
    int secondsPassed = activePlayer.getTimeLimit();
    TimerTask task = new TimerTask(){
    
        @Override
        public void run() {
            secondsPassed--;     
        }
    };

    /**
     * Constructor voor objects van class Clock
     */
    public Clock()
    {
        // geef de instance variables een beginwaarde
        x = 0;
    }

    /**
     * Voorbeeld van een method - schrijf hier jouw comment
     *
     * @param  y    deze method krijgt deze parameter mee in de aanroep
     * @return    deze method geeft de som van x en y terug
     */
    public int voorbeeldMethod(int y)
    {
        // schrijf hier jouw code
        return x + y;
    }
}
