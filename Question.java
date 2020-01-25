import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class Question - The questions of the games
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Player" represents the person playing the game. A player object stores 
 * some important user specific settings like the name of the user and the 
 * diffeculty of the game. 
 * 
 * The player object also stores some realtime game information like the 
 * time that the user is playing, how many lives the player has left and the 
 * amount of batlehealth that the player has left. 
 * 
 * @author  Ronald Hendrik Meulenkamp Hendriks, Nivard Ypey and Luc Willemse
 * @version 2.0.0
 */

 
public class Question
{
    // Initialization of the needed variables
        private String question;
        private ArrayList<String> answers;
        private int diffeculty;
        private int category;
        private String answerString = null;
        private String rightAnswer;
        private ArrayList<String> alphabet;

    
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
        public static final String ANSI_bMAGENTA= "\u001b[35;1m;";

    /** 
    * Below is the contructor of a basic question. 
    * @param theQuestion The question that will be displayed
    * @param theAnswers The answer(s) of the question as single string (open question) or comma seperated (multiplechoice) Please include (*) by the right answer!
    * @param theDiffeculty The Difficulty level the question can be used. (ex. 1,2 or 3)
    * @param theCategory The catgory for the question (ex. java=1, php=2 and OSes=3).
    */
    public Question(String theQuestion, String theAnswers, int theDiffeculty, int theCategory){
        // Let's initialize some local variables
            String[] answerStringMul;
            List<String> listOfCSV;
        
        // Now we will prepare the creaton of the arrayList
            if (theAnswers.contains(",")){
                // Split the string up in a temporary array
                    answerStringMul = theAnswers.split("\\s*[,]\\s*");
                // Let's put the values in a temporary list
                    listOfCSV = Arrays.asList(answerStringMul);
                // Now we will create the definitive Arraylist for the question
                    answers = new ArrayList<String>(listOfCSV);
            } else { 
                answers = null;
                answerString = theAnswers;
            }

        // Now we get the right answer from the arraylist
        if (answers != null){
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).contains("*")){
                    rightAnswer = answers.get(i);
                }
            }
        } else {
            rightAnswer = answerString;
        }

        // Now we will fill the other variables
            question = theQuestion;
            diffeculty = theDiffeculty;
            category = theCategory;
            alphabet = new ArrayList<String>();

        // create alphabet array
          alphabet.add("A");
          alphabet.add("B");
          alphabet.add("C");
          alphabet.add("D");
          alphabet.add("E");
          alphabet.add("F");
          alphabet.add("G");
          alphabet.add("H");
          alphabet.add("I");
          alphabet.add("J");
          alphabet.add("K");
          alphabet.add("L");
          alphabet.add("M");
          alphabet.add("N");
          alphabet.add("O");
          alphabet.add("P");
          alphabet.add("Q");
          alphabet.add("R");
          alphabet.add("S");
          alphabet.add("T");
          alphabet.add("U");
          alphabet.add("V");
          alphabet.add("W");
          alphabet.add("Q");
          alphabet.add("Y");
          alphabet.add("Z");
    }

/////////////////////////////////////////////////
// The methods below can be used to alter the  //
// parameters for a specific question like the //
// answers, the question or the category.      //
/////////////////////////////////////////////////

/**
 * Set a new question for a question object. 
 * 
 * @param newQuestion The question that you want to save in a object
 */
public void setQuestion(String newQuestion){
    question = newQuestion;
}

/**
 * set the answers of the questions
 * @param newAnswers
 */
public void setAnswers(String newAnswers){
// Let's initialize some local variables
    String[] answerStringMul;
    List<String> listOfCSV;

// Clear the current answers Arraylist
    answers = null;

    if (newAnswers.contains(",")){
        // Split the string up in a temporary array
            answerStringMul = newAnswers.split("\\s*[,]\\s*");
        // Let's put the values in a temporary list
            listOfCSV = Arrays.asList(answerStringMul);
        // Now we will create the definitive Arraylist for the question
            answers = new ArrayList<String>(listOfCSV);
    } else { 
        answers = null;
        answerString = newAnswers;
    }

}

/**
 * set the difficulty of the questions
 * @param newDifLevel
 */
public void setDifficulty(int newDifLevel){
    if (newDifLevel <= 6 && newDifLevel > 0){
        diffeculty = newDifLevel;
    } else { 
        System.out.println(ANSI_RED + "oh oow! This difficulty level is invalid! please pick between 0 and 6" + ANSI_RESET);
        System.out.println();
    }
}

/**
 * set the categorys
 * @param newCategory
 */
public void setCategory(int newCategory){
    category = newCategory;
}

/////////////////////////////////////////////////
// The methods below can be used to show the   //
// parameters for a specific question like the //
// answers, the question or the category.      //
/////////////////////////////////////////////////

/**
 * get the questions of the game
 * @return the question
 */
public String getQuestion(){
    return question;
}

/**
 * get an answer out of the arraylist
 * @return 
 */
public ArrayList<String> getAnswers(){
    if (this.answers == null){
        return this.getAnswer();
    } else {
        return answers;
    }
}

/**
 * to get the answers list.
 * @return the answers
 */
public ArrayList<String> getAnswer(){
    ArrayList<String> returnarray = new ArrayList<String>();
    returnarray.add(answerString);
    return returnarray;
}

/**
 * get the difficulty of the questions
 * @return the difficulty
 */
public int getdiffeculty(){
    return diffeculty;
}

/**
 * to get the category for they questions
 * @return the category
 */
public int getCategory(){
    return category;
}

//////////////////////////////////////////////////////
// Below whe have all of the advaced methods like   //
// processing a question.                           //
//////////////////////////////////////////////////////

public void printAnswerOptions(){
    if (answers != null){
        Collections.shuffle(this.answers);
        for (int i = 0; i < answers.size(); i++){
            String   tmpString = answers.get(i).replace('*', ' ');
            System.out.println("[" + alphabet.get(i) + "]" + " " + tmpString);
        }
    } else { 
        System.out.println("Type het antwoord ");
    }
}

public boolean processQuestion(Player activePlayer){
    // create local variables
        Scanner answerBar = new Scanner(System.in);
        String givenAnswer = null;
        int givenAnswerint = 999;
        Boolean rightAnswerGiven = false;
        int numberOfTries = activePlayer.getChances();
        String answerForTesting = null;
        Boolean useArrayList;
        int numberOfAnswers;


    // Now we do the logic
        while (!rightAnswerGiven){
            // Print to screen
                System.out.println();
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Om verder te gaan moet je de volgende vraag beantwoorden:");
                System.out.println();
                System.out.println(ANSI_bBLUE + question + ANSI_RESET);
                System.out.println();
                printAnswerOptions();
                System.out.println();
                System.out.print(">");
                try {
                    givenAnswer = answerBar.nextLine();
                    System.out.println();
                } catch (NoSuchElementException e){
                    System.out.println(ANSI_YELLOW + "Dit antwoord is ongeldig! probeer het opnieuw!" + ANSI_RESET);
                    System.out.println();
                }

            // Check the answer
            if (givenAnswer != null){
                if (givenAnswer.equalsIgnoreCase("A")){
                    givenAnswerint = 0;
                } else if (givenAnswer.equalsIgnoreCase("B")) {
                    givenAnswerint = 1;
                } else if (givenAnswer.equalsIgnoreCase("C")) {
                    givenAnswerint = 2;
                } else if (givenAnswer.equalsIgnoreCase("D")) {
                    givenAnswerint = 3;
                } else if (givenAnswer.equalsIgnoreCase("E")) {
                    givenAnswerint = 4;
                } else if (givenAnswer.equalsIgnoreCase("F")) {
                    givenAnswerint = 5;
                } else if (givenAnswer.equalsIgnoreCase("G")) {
                    givenAnswerint = 6;
                } else if (givenAnswer.equalsIgnoreCase("H")) {
                    givenAnswerint = 7;
                } else if (givenAnswer.equalsIgnoreCase("I")) {
                    givenAnswerint = 8;
                } else if (givenAnswer.equalsIgnoreCase("J")) {
                    givenAnswerint = 9;
                } else if (givenAnswer.equalsIgnoreCase("K")) {
                    givenAnswerint = 10;
                } else if (givenAnswer.equalsIgnoreCase("L")) {
                    givenAnswerint = 11;
                } else if (givenAnswer.equalsIgnoreCase("M")) {
                    givenAnswerint = 12;
                } else if (givenAnswer.equalsIgnoreCase("N")) {
                    givenAnswerint = 13;
                } else if (givenAnswer.equalsIgnoreCase("O")) {
                    givenAnswerint = 14;
                } else if (givenAnswer.equalsIgnoreCase( "P")) {
                    givenAnswerint = 15;
                } else if (givenAnswer.equalsIgnoreCase("Q")) {
                    givenAnswerint = 16;
                } else if (givenAnswer.equalsIgnoreCase("R")) {
                    givenAnswerint = 17;
                } else if (givenAnswer.equalsIgnoreCase("S")) {
                    givenAnswerint = 18;
                }else if (givenAnswer.equalsIgnoreCase("T")) {
                    givenAnswerint = 19;
                } else if (givenAnswer.equalsIgnoreCase( "U")) {
                    givenAnswerint = 20;
                } else if (givenAnswer.equalsIgnoreCase("V")) {
                    givenAnswerint = 21;
                } else if (givenAnswer.equalsIgnoreCase("W")) {
                    givenAnswerint = 22;
                } else if (givenAnswer.equalsIgnoreCase("X")) {
                    givenAnswerint = 23;
                } else if (givenAnswer.equalsIgnoreCase("Y")) {
                    givenAnswerint = 24;
                } else if (givenAnswer.equalsIgnoreCase("Z")) {
                    givenAnswerint = 25;
                } else {
                    
                }
            } else {
                System.out.println(ANSI_YELLOW + "Er is geen antwoordt ingevuld!" + ANSI_RESET);
                System.out.println();
            }

            // now we will set the answer to a dynamicly checkable variable
                if (givenAnswerint != 999){
                    useArrayList = true;
                    if (givenAnswerint <= answers.size()-1){
                        try {
                        answerForTesting = answers.get(givenAnswerint);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(ANSI_YELLOW + "Dit was geen antwoordmogelijkheid!" + ANSI_RESET);
                            break;
                        }

                    } 
                } else {
                    useArrayList = false;
                    answerForTesting = givenAnswer;
                }

                if (answerForTesting == null){
                    System.out.println(ANSI_YELLOW + "Je hebt geen antwoord ingevuld!" + ANSI_RESET);
                    System.out.println();
                } else if (!answerForTesting.equalsIgnoreCase(rightAnswer)) {
                    activePlayer.lostLive();

                    // Let's find out how to check if user can continue
                        if (useArrayList){
                            numberOfAnswers = answers.size()-1;
                        } else {
                            numberOfAnswers = 10;
                        }


                        if (answers != null && numberOfAnswers >= 2 && numberOfTries >= 1){
                            numberOfTries--;
                            if (useArrayList){answers.remove(givenAnswerint);}
                            System.out.println(ANSI_RED + "Dit antwoord is helaas niet goed! Je kunt het nog een keer proberen." + ANSI_RESET);
                            System.out.println();
                            if (answerForTesting.equals("CheatDontwantaquestion!")) {
                                System.out.println(ANSI_PURPLE + "Hmmmmm. Je hebt een cheat gebruikt, Valsspeler! De vraag is over geslagen. Je hebt het leven terug!" + ANSI_RESET);
                                System.out.println();
                                activePlayer.setHealth(activePlayer.getHealth()+1);
                                rightAnswerGiven = true;
                            }

                        } else if (answerString != null || numberOfTries < 1 || numberOfAnswers < 2){
                            System.out.println(ANSI_RED + "Dit antwoord is helaas niet goed!" + ANSI_RESET);
                            System.out.println();
                            if (answerForTesting.equals("CheatDontwantaquestion!")) {
                                System.out.println(ANSI_PURPLE + "Hmmmmm. Je hebt een cheat gebruikt, Valsspeler! De vraag is over geslagen. Je hebt het leven terug!" + ANSI_RESET);
                                System.out.println();
                                activePlayer.setHealth(activePlayer.getHealth()+1);
                                rightAnswerGiven = true;
                            }
                            break;
                        }
                        if (activePlayer.getLiveStatus() < 1){
                            System.out.println(ANSI_RED + "Je levens zijn op! Gebruik een willekeurig commando om opnieuw te starten." + ANSI_RESET);
                            System.out.println();
                            rightAnswerGiven = true;
                            
                        }
                    System.out.println();

                } else if (answerForTesting.equalsIgnoreCase(rightAnswer)) {
                    System.out.println(ANSI_GREEN + "Goed zo! Dat was het juiste antwoord! Je kunt nu verder spelen " + ANSI_RESET);
                    System.out.println();
                    rightAnswerGiven = true;

                }
        }
        return rightAnswerGiven;
    }
}
