import java.util.Timer;
import java.util.TimerTask;

/**
 * class Clock - geef hier een beschrijving van deze class
 *
 * @author Ronald Hendrik Meulenkamp Hendriks, Nivard Ypey and Luc Willemse
 * @version 2.0.0
 */
public class Clock
{
    Timer timer;
    int secondsPassed;
    TimerTask task;

    /**
     * Constructor voor objects van class Clock
     * @param timeLimit
     */
    public Clock(int timeLimit)
    {
        timer = new Timer();
        secondsPassed = timeLimit;
        task = new TimerTask(){
            public void run() {
                secondsPassed--;    
            }
        };
    }

    /**
     * start the clock
     */
    public void startClock(){
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    /**
     * Define the output of the timer command
     * @param numbTimer The wanted output when a user uses "time".
    */
    public void setTimer(Timer numbTimer)
    {
        this.timer = numbTimer;
    }
        
    /**
    * This method is returning the time thats remaining
    * 
    * @return A integer with the time of the game
    */
    public int getTimer() 
    {
        return this.secondsPassed;
    }
}

