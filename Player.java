import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Class Player - The player of the game.
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

public class Player
{
    Random rand = new Random();
    private String name;
    private int health;
    private int maxAttackDamage;
    private int difficulty;
    private int lives;
    private int inventorySize;
    private int timeLimit;
    private int moves;
    private int questionChances;
    ArrayList<Item> inventory; 
    HashMap<Item, String> bag; 

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
     * Intitialization of a player with the default settings but 
     * also with the wishes of the user. 
     * 
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.bag = new HashMap<Item, String>();
    }

    //////////////////////////////////////////////////////////
    // The methods below are used to alter parameters of a  //
    // player object like the name, difficulty and lives.   //
    //////////////////////////////////////////////////////////

        /**
         * This method is used to set the players name.
         * 
         * @param name The name for the player
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Define the inventory size.
         * @param numbInventorySize the integer you wanna set the inventorysize to.
         */
        public void setInventorySize(int numbInventorySize)
        {
            this.inventorySize = numbInventorySize;
        }

        /**
         * Define the output of the health command
         * @param numbHealth The interger you wanne set the health to.
         */
        public void setHealth(int numbHealth)
        {
            this.health = numbHealth;
        }

        /**
         * Define the output of the damage command
         * @param numbdamage The interger you wanna set the max attack damage to.
         */
        public void setmaxAttackDamage(int numbmaxAttackDamage)
        {
            this.health = numbmaxAttackDamage;
        }

        /**
         * Define the output of the moves command
         * @param numbMoves The interger you wanne set the moves to.
         */
        public void setMoves(int numbMoves) 
        {
            this.moves = numbMoves;
        }

        /**
         * Define the output of the time limit command
         * @param numbTimeLimit The new time limit for the user.
         */
        public void setTimeLimit(int numbTimeLimit) 
        {
            this.timeLimit = numbTimeLimit;
        }


        /**
         * This method is used to set the difficulty of the game
         * 
         * @param difficulty an integer from 1 trough 6. 1 is easy, 2 moderate and 3 hard. 4 trough 6 are the same but without time limits
         */
        public boolean setDifficulty(int difficulty) {
            boolean isGood = false;
            if (difficulty < 1 || difficulty > 6){
                isGood = false;
            } else if (difficulty == 1){
                this.difficulty = difficulty;
                this.lives = 6;
                this.inventorySize = 5;
                this.health = 15;
                this.maxAttackDamage = 5;
                this.moves = 45;
                this.timeLimit = 999;
                this.questionChances = 3;
                isGood = true;
            } else if (difficulty == 2){
                this.difficulty = difficulty;
                this.lives = 4;
                this.inventorySize = 3;
                this.health = 12;
                this.maxAttackDamage = 4;
                this.moves = 35;
                this.timeLimit = 999;
                this.questionChances = 2;
                isGood = true;
            } else if (difficulty == 3){
                this.difficulty = difficulty;
                this.lives = 2;
                this.inventorySize = 1;
                this.health = 10;
                this.maxAttackDamage = 3;
                this.moves = 25;
                this.timeLimit = 999;
                this.questionChances = 1;
                isGood = true;
            } else if (difficulty == 4){
                this.difficulty = difficulty;
                this.lives = 6;
                this.inventorySize = 5;
                this.health = 15;
                this.maxAttackDamage = 5;
                this.moves = 45;
                this.timeLimit = 900;
                this.questionChances = 3;
                isGood = true;
            } else if (difficulty == 5){
                this.difficulty = difficulty;
                this.lives = 4;
                this.inventorySize = 3;
                this.health = 12;
                this.maxAttackDamage = 4;
                this.moves = 35;
                this.timeLimit = 600;
                this.questionChances = 2;
                isGood = true;
            } else if (difficulty == 6){
                this.difficulty = difficulty;
                this.lives = 2;
                this.inventorySize = 1;
                this.health = 10;
                this.maxAttackDamage = 3;
                this.moves = 2;
                this.timeLimit = 120;
                this.questionChances = 1;
                isGood = true;
            }
            return isGood;
        }

        /**
         * This method is used to withdraw a live of a player
         */
        public void lostLive(){
            this.lives = this.lives - 1;
            System.out.println("Je hebt een leven verloren! Je hebt er nog " + this.getLiveStatus() + " over!");
        }

        /**
         * This method is used to add lives to a player
         */
        public void addLives(int NumberOfNewLives){
            this.lives = this.lives + NumberOfNewLives;
        }


        /**
         * Used to remove 1 singele move point
         */
        
        public void withdrawMove(){
            moves = moves-1;
        }


    //////////////////////////////////////////////////////////
    // The methods below are used to return parameters of a //
    // player object like the name, difficulty and lives.   //
    //////////////////////////////////////////////////////////

        /**
         * This method is returning the name of the player
         * @return A string with the player's name
         */
        public String getName() {
            return this.name;
        }

        /**
         * This method is returning the health of the player
         * @return A integer with the health level of the player
         */
        public int getHealth() {
            return health;
        }

        /**
         * This method is returning the attack damage of the player
         * @return A integer with the attack damage level of the player
         */
        public int getmaxAttackDamage() {
            return maxAttackDamage;
        }

        /**
         * This method is returning the difficulty of the player
         * @return A integer with the difficulty level of the player
         */
        public int getDifficulty() {
            return difficulty;
        }

        /**
         * This method is looking at the amount of lives the player has left
         * @return An integer with the current amount of lives ♥. 
         */
        public int getLiveStatus() {
            return this.lives;
        }

        /**
         * This method is used to view the size of the players inventory
         * @return An integer with the size of the player his inventory
         */
        public int getInventSize() {
            return this.inventorySize;
        }

        /**
         * This method is used to return the moves
         * @return The time limit in seconds as integer. 
         */
        public int getMoves()
        {
            return this.moves;
        }

        /**
         * This method is used to return the timelimit
         * @return The time limit in seconds as integer. 
         */
        public int getTimeLimit() {
            return this.timeLimit;
        }

         /**
         * This method is used to return the number of chances for a question
         * @return The chances as integer. 
         */
        public int getChances() {
            return this.questionChances;
        }

        /**
         * This method creates a graphical livestatus-bar
         * @return An string containing the graphical livebar
         */
        public String createLivebar() {
            StringBuilder livebar = new StringBuilder();
            for (int l = 0; l <= this.getLiveStatus() -1; l++){
                livebar.append(" ♥");
            }
            return "(" + this.getLiveStatus() + ") " + livebar.toString();
        }

    //////////////////////////////////////////////////////////
    // The methods below are used to work with the invetory //
    // of the player. This section does view and modify!    //
    //////////////////////////////////////////////////////////

        /**
         * This method is used to add an item to 
         * the players personal inventory. 
         * @param itemToAdd The item you want to add to the inventory
         * @return True is its added, False if it isn't
         */
        public boolean addToInventory(Item itemToAdd) {
            boolean result = false;
            if (this.bag.size() <= inventorySize -1){
                this.bag.put(itemToAdd, itemToAdd.getDescription());
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        /**
         * This method is used to view the players inventory
         * @return An integer with the size of the player his inventory
         */
        public String getInventory() {
            // Lets initialize some local variables
                StringBuilder output = new StringBuilder();

            if (this.bag.size() <= 0){
                output.append("Je hebt niets bij je!");
            } else {
                for (Item i : bag.keySet()) {
                    output.append(bag.get(i));
                    output.append(" ");
                }
            }
            return output.toString();
        }

        /**
         * This method is used to check if an item is in inventory
         * the players personal inventory. 
         * @param toCheck The item you want to check in the inventory
         * @return True if its in inventory, False if its not in inventory
         */
        public boolean inInventory(String toCheck){
            if (this.bag.containsValue(toCheck)){
                return true;
            } else {
                return false;
            }
        }

        /**
         * picks up the actually item form the inventory
         * the players personal inventory. 
         * @param itemToGet The item you want to pick up form inventory
         * @return the flipped bag
         */
        public Item getItemAsObject(String itemToGet){
            HashMap<String, Item> flippedBag = new HashMap<String, Item>();

            for (Item i : bag.keySet()) {
                flippedBag.put(bag.get(i), i);
            }

            return flippedBag.get(itemToGet);

        }

        public boolean removeFromInventory(String itemToRemove){

            if (inInventory(itemToRemove)){
                bag.remove(this.getItemAsObject(itemToRemove));
                return true;
            } else {
                return false;
            }

    }
}
