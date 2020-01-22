import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
 * @author  Ronald H.M. Hendriks, Nivard Ypey and Luc Willemse
 * @version 2019.01.08
 */

 
public class Question
{
    // Initialization of the needed variables
        private String question;
        private ArrayList<String> answers;
        private int diffeculty;
        private int category;
        private String answerString;
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
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).contains("*")){
                rightAnswer = answers.get(i);
            }
          }

        // Now we will fill the other variables
            question = theQuestion;
            diffeculty = theDiffeculty;
            category = theCategory;

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
        System.out.println("oh oow! This difficulty level is invalid! please pick between 0 and 6");
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
            System.out.println("[" + alphabet.get(i) + "]" + " " + answers.get(i));
        }
    } else { 
        System.out.println("Type het antwoord ");
    }
}

public boolean processQuestion(){
    // create local variables
        Scanner answerBar = new Scanner(System.in);
        String givenAnswer = null;
        int givenAnswerint = 0;
        Boolean rightAnswerGiven = false;

    // Now we do the logic
        while (!rightAnswerGiven){
            // Print to screen
                System.out.println("Om verder te gaan moet je de volgende vraag beantwoorden:");
                System.out.println();
                System.out.println(question);
                System.out.println();
                printAnswerOptions();
                System.out.println();
                System.out.println(">");
                givenAnswer = answerBar.nextLine();

            // Check the answer
                if (givenAnswer == "A"){
                    givenAnswerint = 0;
                } else if (givenAnswer == "B") {
                    givenAnswerint = 1;
                } else if (givenAnswer == "C") {
                    givenAnswerint = 2;
                } else if (givenAnswer == "D") {
                    givenAnswer = "D";
                } else if (givenAnswer == "E") {
                    givenAnswer = "E";
                } else if (givenAnswer == "F") {
                    givenAnswer = "F";
                } else if (givenAnswer == "G") {
                    givenAnswer = "G";
                } else if (givenAnswer == "H") {
                    givenAnswer = "H";
                } else if (givenAnswer == "I") {
                    givenAnswer = "I";
                } else if (givenAnswer == "J") {
                    givenAnswer = "J";
                } else if (givenAnswer == "K") {
                    givenAnswer = "K";
                } else if (givenAnswer == "L") {
                    givenAnswer = "L";
                } else if (givenAnswer == "M") {
                    givenAnswer = "M";
                } else if (givenAnswer == "N") {
                    givenAnswer = "N";
                } else if (givenAnswer == "O") {
                    givenAnswer = "O";
                } else if (givenAnswer == "P") {
                    givenAnswer = "P";
                } else if (givenAnswer == "Q") {
                    givenAnswer = "Q";
                } else if (givenAnswer == "R") {
                    givenAnswer = "R";
                } else if (givenAnswer == "S") {
                    givenAnswer = "S";
                }else if (givenAnswer == "T") {
                    givenAnswer = "T";
                } else if (givenAnswer == "U") {
                    givenAnswer = "U";
                } else if (givenAnswer == "V") {
                    givenAnswer = "V";
                } else if (givenAnswer == "W") {
                    givenAnswer = "W";
                } else if (givenAnswer == "X") {
                    givenAnswer = "X";
                } else if (givenAnswer == "Y") {
                    givenAnswer = "Y";
                } else if (givenAnswer == "Z") {
                    givenAnswer = "Z";
                }

                if (givenAnswer == null){
                    System.out.println(ANSI_RED + "Je hebt geen antwoord ingevuld!" + ANSI_RESET);
                } else if () {
                    System.out.println(ANSI_RED + "Dit antwoord is helaas niet goed! Je hebt een leven verloren! Je kunt het nog een keer proberen." + ANSI_RESET);
                } else ( ) {
                    System.out.println(ANSI_RED + " " + ANSI_RESET);
                }
        }
}

}

25