import java.util.ArrayList;

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
 * @author  Ronald H.M. Hendriks and Luc Willemse
 * @version 2019.01.08
 */

public class Player
{
    private String name;
    private int health;
    private int difficulty;
    private int lives;
    private int inventorySize;
    private int timeLimit;
    private int moves;
    ArrayList<Item> inventory; 

    /**
     * Intitialization of a player with the default settings but 
     * also with the wishes of the user. 
     * 
     * @param name
     */
    public Player(String name) {
        this.name = name;
        ArrayList<Item> inventory = new ArrayList<Item>(); 
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
                isGood = true;
            } else if (difficulty == 2){
                this.difficulty = difficulty;
                this.lives = 4;
                this.inventorySize = 3;
                this.health = 12;
                isGood = true;
            } else if (difficulty == 3){
                this.difficulty = difficulty;
                this.lives = 2;
                this.inventorySize = 1;
                this.health = 12;
                isGood = true;
            } else if (difficulty == 4){
                this.difficulty = difficulty;
                this.lives = 6;
                this.inventorySize = 5;
                this.health = 15;
                this.timeLimit = 900;
                isGood = true;
            } else if (difficulty == 5){
                this.difficulty = difficulty;
                this.lives = 4;
                this.inventorySize = 3;
                this.health = 12;
                isGood = true;
                this.timeLimit = 600;
            } else if (difficulty == 6){
                this.difficulty = difficulty;
                this.lives = 2;
                this.inventorySize = 1;
                this.health = 12;
                this.timeLimit = 450;
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
         * 
         */
        public void addLives(int NumberOfNewLives){
            this.lives = this.lives + NumberOfNewLives;
        }


    //////////////////////////////////////////////////////////
    // The methods below are used to return parameters of a //
    // player object like the name, difficulty and lives.   //
    //////////////////////////////////////////////////////////

        /**
         * This method is returning the name of the player
         * 
         * @return A string with the player's name
         */
        public String getName() {
            return this.name;
        }

        /**
         * This method is returning the health of the player
         * 
         * @return A integer with the health level of the player
         */
        public int getHealth() {
            return health;
        }

        /**
         * This method is returning the difficulty of the player
         * 
         * @return A integer with the difficulty level of the player
         */
        public int getDifficulty() {
            return difficulty;
        }

        /**
         * This method is looking at the amount of lives the player has left
         * 
         * @return An integer with the current amount of lives ♥. 
         */
        public int getLiveStatus() {
            return this.lives;
        }

        /**
         * This method is used to view the size of the players inventory
         * 
         * @return An integer with the size of the player his inventory
         */
        public int getInventSize() {
            return this.inventorySize;
        }

        /**
         * This method is used to return the timelimit
         * 
         * @return The time limit in seconds as integer. 
         */
        public int timeLimit() {
            return this.timeLimit;
        }

        /**
         * This method creates a graphical livestatus-bar
         * 
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
         * 
         * @param itemToAdd The item you want to add to the inventory
         * @return True is its added, False if it isn't
         */
        public boolean addToInventory(Item itemToAdd) {
            boolean result = false;
            if (this.inventory.size() <= inventorySize -1){
                this.inventory.add(itemToAdd);
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        public String getInventory() {
            String output = "";
            if (this.inventory.size() <= 0){
                for(int i = 0; i < this.inventory.size(); i++) {
                    output = i + " " + this.inventory.get(i).getDescription() + "   ";  
                }
            } else {
                output = "Je hebt niets bij je!";
            }
            return output;
        }

        public boolean inInventory(String toCheck){
            if (this.inventory.contains(toCheck)){
                return true;
            } else {
                return false;
            }
        }

        public boolean removeFromInventory(Item itemToRemove){
            if (this.inventory.remove(itemToRemove)){
                return true;
            } else {
                return false;
            }
        }

    }
