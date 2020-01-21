import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

 public class MiniGame {
    Random numberToGuessRand; // guessthenumber
    
    // Colors for text output
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * This is the constructor for all our minigames
     * 
     */
    public MiniGame(){
        // There is nothing to do here!
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
        System.out.println("Vul een getal in dat tussen de 10000 en 99999 ligt.  >");

        try {
            answerGiven = answerInputBar.nextInt();
            error = false;
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println(ANSI_RED + "Je kunt alleen cijfers invullen tussen 10000 en 99999!"  + ANSI_RESET);
            error = true;
        }

        while(error){
                System.out.println("Vul een getal in dat tussen de 10000 en 99999 ligt.  >");

            try {
                answerGiven = answerInputBar.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(ANSI_RED + "Je kunt alleen cijfers invullen tussen 10000 en 99999!" + ANSI_RESET);
                error = true;
            }
        }
        return answerGiven;
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

            

        // Now check what to to
            answer = guessTheNumerInputReviewer();

            while (!result){
                if (answer < numberToGuess){
                    System.out.println();
                    System.out.println(ANSI_YELLOW + "[" + numberToGuess + "]  " + "Het ingevoerde getal is te laag!"  + ANSI_RESET);
                } else if (answer > numberToGuess) {;
                    System.out.println();
                    System.out.println("[" + numberToGuess + "]  " + "Het ingevoerde getal is te hoog!!"  + ANSI_RESET);
                } else if (answer == numberToGuess){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println(ANSI_GREEN + "Gefeliciteerd! Je hebt het getal geraden! Het was: " + numberToGuess);
                    result = true;
                }
            }
            

    }
 }