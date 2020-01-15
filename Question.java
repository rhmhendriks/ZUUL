import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // Now we will fill the other variables
            question = theQuestion;
            diffeculty = theDiffeculty;
            category = theCategory;
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

public void setAnswers(String newAnswers){
// Let's initialize some local variables
    String[] answerString;
    List<String> listOfCSV;

// Clear the current answers Arraylist
    answers = null;

// Now we will prepare the creaton of the arrayList
    // Split the string up in a temporary array
        answerString = newAnswers.split("\\s*[,]\\s*");
    // Let's put the values in a temporary list
        listOfCSV = Arrays.asList(answerString);
    // Now we will create the definitive Arraylist for the question
        answers = new ArrayList<String>(listOfCSV);

}

public void setDifficulty(int newDifLevel){
    if (newDifLevel <= 6 && newDifLevel > 0){
        diffeculty = newDifLevel;
    } else { 
        System.out.println("oh oow! This difficulty level is invalid! please pick between 0 and 6");
    }
}

public void setCategory(int newCategory){
    category = newCategory;
}

/////////////////////////////////////////////////
// The methods below can be used to show the   //
// parameters for a specific question like the //
// answers, the question or the category.      //
/////////////////////////////////////////////////

public String getQuestion(){
    return question;
}

public ArrayList<String> getAnswers(){
    if (this.answers == null){
        return this.getAnswer();
    } else {
        return answers;
    }
}


public ArrayList<String> getAnswer(){
    ArrayList<String> returnarray = new ArrayList<String>();
    returnarray.add(answerString);
    return returnarray;
}

public int getdiffeculty(){
    return diffeculty;
}

public int getCategory(){
    return category;
}

}

