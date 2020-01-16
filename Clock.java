import java.util.Scanner;
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
        public int getTimer() {
            return this.secondsPassed;
        }

        public void timeUp() {
            Scanner whatToDo = new Scanner(System.in);
            while(this.secondsPassed == 0) {
                System.out.println("De tijd is op. Je kan gebruik maken van de volgende commandos:");
                System.out.println("'quit' om te stoppen, of 'startover' om opnieuw te beginnen");
                System.out.println();
                System.out.print("> ");     // print prompt

                String inputLine = whatToDo.nextLine();
                if(inputLine.contains("quit") || inputLine.contains("startover")) {

                }
            }
        }
}

