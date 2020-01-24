import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Ronald H.M. Hendriks, Nivard Ypey and Luc Willemse
 * @version 2020.01.20
 */

 public class MiniGame {
    Random numberToGuessRand = new Random();// guessthenumber
    private Stack<String> colors;
    
    // Colors for text output
    // enable the use of color in the text output. 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001b[1m";
    public static final String ANSI_UNDERLINE= "\u001B[1m";
    public static final String ANSI_bBlack  = "\u001b[30;1m";
    public static final String ANSI_bGREEN = "\u001b[32;1m";
    public static final String ANSI_bRED = "\u001b[31;1m";
    public static final String ANSI_bYELLOW = "\u001b[33;1m";
    public static final String ANSI_bBLUE = "\u001b[34;1m";
    public static final String ANSI_bMAGENTA= "\u001b[35;1m";


    /**
     * This is the constructor for all our minigames
     * 
     */
    public MiniGame(){
        colors = new Stack<String>();

        // adding colors
        // adding colors
        colors.add(ANSI_BLUE + "blauw" + ANSI_RESET); 
        colors.add(ANSI_GREEN + "groen" + ANSI_RESET);
        colors.add(ANSI_RED + "rood" + ANSI_RESET);
        colors.add(ANSI_YELLOW + "geel" + ANSI_RESET);
        colors.add(ANSI_PURPLE + "paars" + ANSI_RESET);
        colors.add(ANSI_bBlack + "zwart" + ANSI_RESET);
        colors.add(ANSI_WHITE + "wit" + ANSI_RESET);
        colors.add(ANSI_bMAGENTA + "roze" + ANSI_RESET);
        ;
    }

    /**
     * 
     */
    private int guessTheNumerInputReviewer(){

        // create the stuff we need
        Scanner answerInputBar = new Scanner(System.in); 
        int answerGiven = 1;
        Boolean error = true;

        // now we let the user answer and we check for errors
        System.out.println("Vul een getal in dat tussen de 0 en 99999 ligt.");

        try {
            System.out.print("> ");
            answerGiven = answerInputBar.nextInt();
            error = false;
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println(ANSI_RED + "Je kunt alleen cijfers invullen tussen 0 en 99999!"  + ANSI_RESET);
            error = true;
        }

        while(error){
                System.out.println("Vul een getal in dat tussen de 0 en 99999 ligt. ");

            try {
                answerGiven = answerInputBar.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(ANSI_RED + "Je kunt alleen cijfers invullen tussen 0 en 99999!" + ANSI_RESET);
                error = true;
            }
        }
        return answerGiven;
    }

    /** 
     * Help method witch is waiting for the user to press enter
     */
    private void pressEnterToContinue()
    { 
           System.out.println("Druk op enter om verder te gaan");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }

    /**
     * This minigame is like lower or higher, at every time this game starts
     * a random number between 10000 and 99999
     */
    public void guessTheNumber(){
        // create what we need
            Boolean result = false;
            int answer;

        // create a random integer
            int numberToGuess = numberToGuessRand.nextInt(99999);

        // explain the game
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Voor deze opdracht moet je een getal van 5 tekens raden.");
        System.out.println("Voor elke waarde die je invoert wordt er verteld of je getal te hoog of te laag is.");
        System.out.println("Blijf raden totdat je het juiste getal hebt, dan kun je verder!");
        System.out.println();
        System.out.println("het spel start wanneer je op enter drukt. ");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        pressEnterToContinue();
            

        // Now check what to to
            while (!result){
                answer = guessTheNumerInputReviewer();
                if (answer < numberToGuess){
                    System.out.println();
                    System.out.println(ANSI_YELLOW + "[" + answer + "]  " + "Het ingevoerde getal is te laag!"  + ANSI_RESET);
                } else if (answer > numberToGuess) {;
                    System.out.println();
                    System.out.println(ANSI_RED + "[" + answer + "]  " + "Het ingevoerde getal is te hoog!!"  + ANSI_RESET);
                } else if (answer == numberToGuess){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println(ANSI_GREEN + "Gefeliciteerd! Je hebt het getal geraden! Het was: " + numberToGuess + ANSI_RESET);
                    result = true;
                }
            }
            

    }
     // fight game
    public void endFight(Player activePlayer, Enemy activeEnemy) { 
        // Lets setup some variables
            Random rand;
            boolean playerAlive;
            boolean enenmyAlive;
            Scanner endGameParser;
            String userinput;

        // lets initialize the variables where needed
            rand = new Random();
            playerAlive = true;
            enenmyAlive = true;
            endGameParser = new Scanner(System.in);

        // Print to the screen

            System.out.println();
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println();

        // The game is in a while loop where all the magic happends
            while (playerAlive && enenmyAlive) {

                // Let's use the custom parser to make sure no commands can be used
                    System.out.print("> ");
                    userinput = endGameParser.nextLine();

                    // let's also check what the user wanted to do
                        if (userinput.equalsIgnoreCase("status")){
                            System.out.println("Jij hebt nog een gezondheid van: " + activePlayer.getHealth());
                            System.out.println("De bewaker heeft nog een gezondheid van: " + activePlayer.getHealth());

                         } else if (userinput.equalsIgnoreCase("slaan")) {
                            // Radom select what damage is beiing done
                                int damageDone = rand.nextInt(activePlayer.getmaxAttackDamage());
                                int damageTaken = rand.nextInt(activeEnemy.getEnemyMaxAttackDamage());
                            
                            // update objects healt parameters
                                activePlayer.setHealth(activePlayer.getHealth() - damageTaken);
                                activeEnemy.setEnemyHealth(activeEnemy.getEnemyHealth() - damageDone);

                            // tell the user what happaend
                                System.out.println( ANSI_CYAN + "Je hebt de bewaker met " + damageDone + " geraakt, hij heeft nog " + activeEnemy.getEnemyHealth() + " vechtlevens" + ANSI_RESET);
                                System.out.println( ANSI_YELLOW + "De bewaker heeft jou een klap gegeven van " + damageTaken + " je hebt nog " + activePlayer.getHealth() + " vechtlevens"  + ANSI_RESET);
                                System.out.println();
                                System.out.println();

                            
                            // now check the consuquences
                                if(activePlayer.getHealth() <= 0 || activeEnemy.getEnemyHealth() <= 0) {
                                    // either the player or the enemy died now we find out who
                                    if (activeEnemy.getEnemyHealth() <= 0) {
                                        // the enemy died! the player won.
                                        System.out.println( ANSI_GREEN + "Je hebt de bewaker uitgeschakeld! Gefeliciteerd! Je wordt nu teruggestuurd naar het spel als je op neter drukt."  + ANSI_RESET);
                                        pressEnterToContinue();
                                        System.out.println();
                                        System.out.println();
                                        System.out.println("---------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println();
                                        enenmyAlive = false;
                                    } else {
                                        // The player died
                                        if (activePlayer.getLiveStatus() > 1) {
                                            // can continue with a new live.
                                            System.out.println(ANSI_RED + "De bewaker heeft je verslagen! Je zult een leven verliezen maar je krijgt nog een kans!" + ANSI_RESET);
                                            System.out.println(ANSI_RED + "Versla de bewaker voor al je levens op zijn! Druk op enter om door te gaan" + ANSI_RESET);
                                            pressEnterToContinue();
                                            System.out.println();
                                            activePlayer.lostLive();
                                            System.out.println();
                                            System.out.println();
                                        } else {
                                            // cant continue has to startover
                                            System.out.println(ANSI_RED + "De bewaker heeft je verslagen en je hebt je laatste leven verloren!" + ANSI_RESET);
                                            System.out.println(ANSI_RED + "Gebruik een willekeurig commado om het spel opnieuw te starten!" + ANSI_RESET);
                                            System.out.println();
                                            break;
                                        } // no more lives
                                    } // enemy still alive

                                } else { 
                                System.out.println("Blijf aanvallen, geef niet op!");
                                }// both alive
                        } // command was hit
                //endGameParser.next();
            } // Game while loop
    }//method


    public String generateString(int length){
        Clock gameTimer;

        //Select usable charaters to be inserted into the String to be generated
        String usableCharacters = "QWERTYUIOPASDFGHJKLZXCVBNM" + "qwertyuiopasdfghjklzxcvbnm" + "1234567890";
        //Create a StringBuilder
        StringBuilder randomStringBuilder = new StringBuilder(length);
        //Now we create random characters and add them to the String
        for(int i = 0; i < length; i++){
            int index = (int)(usableCharacters.length() * Math.random());

            randomStringBuilder.append(usableCharacters.charAt(index));
        }
        //Now we return the generated String
        return randomStringBuilder.toString();
    }

public void typingGame(){
            //Create the needed variables
                String answer;
                int rightanswers = 0;
                String currentword;
                Clock gameTimer;

            //Create the Scanner for inserting answers
                Scanner wordInputBar = new Scanner(System.in);
            
            //Explain the game
                System.out.println("Bij dit spel krijg je een willekeurig gegenereerd woord te zien voor 10 seconden.");
                System.out.println("Probeer in die tijd het woord juist te typen, voor elk juist woord krijg je een punt");
                System.out.println("Als je vijf punten hebt behaald, kun je verder!");
                pressEnterToContinue();

            //If the answer is equal to the String printed on screen, add a point to RightAnswer and print a different String
            while (rightanswers < 5){
                System.out.println("hallo");
                currentword = generateString(10); //Generate a random String and insert that String into currentword
                gameTimer = new Clock(18);
                gameTimer.startClock();

                    //Print the currentword on the screen
                        System.out.println("Het woord dat je moet overtypen is: " + ANSI_BLUE + currentword + ANSI_RESET + " en je hebt nog " + gameTimer.getTimer() + " seconden om dit te doen!");
                        System.out.print("> ");
                        answer = wordInputBar.nextLine();

                    // check if input matches the random string
                    if (gameTimer.getTimer() <= 0){
                        System.out.println(ANSI_RED + "Je hebt niet op tijd geantwoord" + ANSI_RESET);
                    } else {
                    if (!answer.equals(currentword)){
                        System.out.println(ANSI_YELLOW + "Helaas, je hebt het woord fout getypt" + ANSI_RESET);
                    } else if (answer.equals(currentword)){
                        rightanswers = rightanswers + 1;
                        System.out.println(ANSI_GREEN + "Goed antwoord! Je hebt nu " + rightanswers + "/5 punten" + ANSI_RESET);
                    }

                } // time up!
                
            } // while good < 5
            System.out.println(ANSI_GREEN + "Goed gedaan! Je hebt alle vijf punten, en kan weer verder!" + ANSI_RESET);
    }


    public void plateGame(Player activePlayer){
        // Now whe create the needed variables
            Scanner plateInputBar = new Scanner(System.in);
            int numberOfPlates = 0;
            Stack<Integer> contentsPossibilities = new Stack<Integer>();
            HashMap<String, Integer> platesContent = new HashMap<String, Integer>();
            int numberEmpty = 0;
            Boolean plateChoosen = false;
            String choice;

        //Explain the game
            System.out.println();
            System.out.println();
            System.out.println("Je hebt trek gekregen van al het rennen door het kasteel, dus besluit om te kijken wat er op de borden ligt.  ");
            System.out.println("Elk bord heeft een andere kleur deksel, het is aan jouw om een kluer te kiezen. ");
            System.out.println("Je mag er maar een kiezen, als het bord leeg is zul je met lege maag door moeten spelen!");
            System.out.println();
            pressEnterToContinue();

        // set parameters
            if (activePlayer.getDifficulty() == 1 || activePlayer.getDifficulty() == 4){
                numberOfPlates = 3;
                numberEmpty = 0;
            } else if(activePlayer.getDifficulty() == 2 || activePlayer.getDifficulty() == 5){
                numberOfPlates = 4;
                numberEmpty = 1;
            } else if (activePlayer.getDifficulty() == 3 || activePlayer.getDifficulty() == 6){
                numberOfPlates = 5;
                numberEmpty = 2;
            }
        
        // initialize the game
            contentsPossibilities.add(1);
            contentsPossibilities.add(2);
            contentsPossibilities.add(3);

            for (int j=0; j < numberEmpty; j++){
                contentsPossibilities.add(0);
            }

            Collections.shuffle(contentsPossibilities);
            Collections.shuffle(colors);

            for (int i=0; i < numberOfPlates; i++){
                String color = colors.pop();
                platesContent.put(color, contentsPossibilities.pop());
            }

        // Now lets start the game
            while (!plateChoosen){

                // present the plates to the user
                    System.out.print("De deksels hebben de volgende kleuren: ");
                    for (String c : platesContent.keySet()) {
                        System.out.print(c + "  ");
                      }

                // we ask the user for input
                    System.out.println("> ");
                    choice = plateInputBar.nextLine();

                // check input
                Room output = null;

                for (String colorKey : platesContent.keySet()) {
                    if (colorKey.contains(choice)){
                        choice = colorKey;
                    }
                }

                // check if the color platye exitst
                    if (platesContent.containsKey(choice)){
                        int livesToAdd = platesContent.get(choice);
                        if (livesToAdd > 0){
                            System.out.println(ANSI_GREEN + "Je hebt een bord gekozen met een heerlijke energiereep! Deze heeft jouw " + livesToAdd + " levens opgeleverd!" + ANSI_RESET);
                            activePlayer.addLives(livesToAdd);
                            pressEnterToContinue();
                            System.out.println();
                            plateChoosen = true;
                        } else if (livesToAdd == 0){
                            System.out.println(ANSI_YELLOW + "Jammer dit bord was leeg! dit levert je helemaal niets op. Druk op enter om verder spelen! " + ANSI_RESET);
                            activePlayer.addLives(livesToAdd);
                            pressEnterToContinue();
                            System.out.println();
                            plateChoosen = true;
                    }
            }
            




            
        




    }
}


}