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
    Timer timer;
    int secondsPassed;
    TimerTask task;

    /**
     * Constructor voor objects van class Clock
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

    public void startClock(){
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}

