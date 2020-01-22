import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Ronald H.M. Hendriks and Luc Willemse
 * @version 2019.01.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private String lookDescription;
    private String secondDescription;
    private String direction;
    ArrayList<Item> items = new ArrayList<Item>();
    private Stack<String> colors;
    private boolean locked;
    private Item needForUnlock;
    private int questionLocation;
    private int gameLocation;
    private MiniGame miniGames;
    private Questions questionLists;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, boolean lockedYN, int theQuestionLocation, int theGameLocation) 
    {
        this.description = description;
        locked = lockedYN;
        questionLocation = theQuestionLocation;
        gameLocation = theGameLocation;
        exits = new HashMap<>();
        colors = new Stack<String>();
        miniGames = new MiniGame();
        questionLists = new Questions();


        // adding colors
            colors.add("blauw"); 
            colors.add("groen");
            colors.add("rood");
            colors.add("oranje");
            colors.add("geel");
            colors.add("paars");
            colors.add("zwart");
            colors.add("wit");
            colors.add("roze");
            colors.add("grijs");
        
        // now we shuffle the stack
            Collections.shuffle(colors);
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        if(direction == "rcolor") {
            direction = colors.pop();
        }

        exits.put(direction, neighbor);
    }

    /**
     * Define the output of the look command in the specified room
     * @param lookDescr The wanted output when a user uses "look" in this room.
     */
    public void setLookDescription(String lookDescr) 
    {
        this.lookDescription = lookDescr;
    }

    /**
     * Define the output of the second description command in the specified room
     * @param lookDescr The wanted output when a user uses "look" in this room.
     */

     public void setSecondDescription(String secondDescr)
     {
         this.secondDescription = secondDescr;
     }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public void printLongDescription(Player activePlayer)
    {
        System.out.println(description + ".\n" + getExitString());
        if (questionLocation == 1 || gameLocation == 1){
            int difficulty = activePlayer.getDifficulty();
            questionLists.getRandomQuestion(0, difficulty, activePlayer);
        }
    }

    /**
     * Return the second description of the room
     * @return A second description of this room
     */
    public void printSecondDescription(Player activePlayer)
    {
        System.out.println(secondDescription);
        if (questionLocation == 3 || gameLocation == 3){
            int difficulty = activePlayer.getDifficulty();
            questionLists.getRandomQuestion(0, difficulty, activePlayer);
        }
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString()
    {
        String returnString = "uitgangen: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getDirection(Room askedDirection)
    {
        // lets initilize some local variables
            HashMap<Room, String> flippedExits = new HashMap<Room, String>();

            // create a temporary fliped verion of teh exits hashmap
                for (String k : exits.keySet()) {
                    flippedExits.put(exits.get(k), k);
                }

            // get the color of a asked direction
                return flippedExits.get(askedDirection);
        }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /** 
     * get the items from the room
     * @param index The name of the object you want to have returned
     * @return The requested object
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * Method used to print the look descriptions about the room
     */
    public void look(Player activePlayer){
        System.out.println(this.lookDescription);
        System.out.println(" ");
        System.out.println(this.getRoomItems());
        System.out.println(description + ".\n" + getExitString());
        if (questionLocation == 2 || gameLocation == 2){
            int difficulty = activePlayer.getDifficulty();
            questionLists.getRandomQuestion(0, difficulty, activePlayer);
        }
    
    }

    /**
     * picks up the item
     * @param itemName name of the  item you picked up
     * @return null
     */
    public Item pickupItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getDescription().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * remove the item 
     * @param itemName name of the item you want to geremove
     */
    public void removeItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getDescription().equals(itemName)) {
                items.remove(i);
            }
        }
    }

    /**
     * set item in the room
     * @param newitem item name
     */
    public void setItem(Item newitem) {
        items.add(newitem);
    }

    
    /**
     * get description of the items in the room
     * @return De items in the rooms
     */
    public String getRoomItems() {
        String output = "";
        for(int i = 0; i < items.size(); i++) {
            output += i + " " + items.get(i).getDescription() + "   ";
        }
        return output;
    }

    /**
     * remove all the items from the room
     */
    public void removeAllItemsFromRoom(){
        this.items.clear();
    }

    /**
     * to lock the rooms
     * @param trueFalse if its open or closed
     */
    public void setLock(boolean trueFalse){
        locked = trueFalse;
    }

    /**
     * to look if the room is locked
     * @return if locked
     */
    public Boolean getLock(){
        return locked;
    }

    /**
     * setting an item to unlock the room
     * @param theItem name of the item you need to unlock the item
     */
    public void setItemForUnlocking(Item theItem){
        needForUnlock = theItem;
    }

    /**
     * get the item you nee to unlock the room
     * @return which item you need to have to unlock the room
     */
    public Item getItemForUnlocking(){
        return needForUnlock;
    }

    /**
     * to get see which item you need to unlock the room
     * @return the item you need
     */
    public String getLockInstruction(){
        StringBuilder output = new StringBuilder();
        output.append("Deze kamer kun je niet openen! Je hebt het volgende item nodig om deze kamer te openen ");
        output.append(needForUnlock.getDescription());
        output.append(".");
  
        return output.toString();
    }
}