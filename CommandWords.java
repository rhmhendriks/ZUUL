import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Ronald H.M. Hendriks
 * @version 0.2020.01.11
 */

public class CommandWords { 
    private HashMap<String, String> theCommandWords;

    /**
     * Constructor - initialise the command words. 
     */
    public CommandWords(){
        createCommandWords();
    }

    /** 
     * Creates the CommandWords
     */
    public void createCommandWords(){
        theCommandWords = new HashMap<>();
        theCommandWords.put("ga", "Ga naar een naastgelegen kamer door 'go <deurkleur> te typen.");
        theCommandWords.put("quit", "Stop het spel onmiddelijk.");
        theCommandWords.put("help", "Laat dit helpvenster zien, maar dit kost wel één leven.");
        theCommandWords.put("terug", "Ga terug naar de vorige kamer.");
        theCommandWords.put("rugzak", "Laat zien wat er in je tas zit.");
        theCommandWords.put("pak", "Pak een voorwerp op uit de huidige ruimte met 'pickup <voorwerp>'");
        theCommandWords.put("latenvallen", "Laat een voorwerp achter in de huidige ruimte.");
        theCommandWords.put("kijk", "Kijk door de ruimte en vind verborgen geheimen...");
        theCommandWords.put("tijd", "Kijk hoeveel tijd je nog over hebt.");
        theCommandWords.put("zetten", "Vind uit hoeveel zetten je nog hebt om het spel te spelen.");
    }

    /**
     * Check whether a given String is a valid command word.
     * @param commandToCheck  
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String commandToCheck){
        String valueToGet = theCommandWords.get(commandToCheck);
        if (valueToGet != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll(){
        for (String command : theCommandWords.keySet()){
            System.out.println("   " + command + "  -  " + theCommandWords.get(command));
        }
        System.out.println();
    }
}