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

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        colors = new Stack<String>();

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
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return the second description of the room
     * @return A second description of this room
     */
    public String getSecondDescription()
    {
        return secondDescription;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    private String getDirection(Room askedDirection)
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
    public void look(){
        System.out.println(this.lookDescription);
        System.out.println(" ");
        System.out.println(this.getRoomItems());
    }

    public Item pickupItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getDescription().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void removeItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getDescription().equals(itemName)) {
                items.remove(i);
            }
        }
    }

    // set item in the room
    public void setItem(Item newitem) {
        items.add(newitem);
    }
    // get description of the items in the room
    public String getRoomItems() {
        String output = "";
        for(int i = 0; i < items.size(); i++) {
            output += i + " " + items.get(i).getDescription() + "   ";
        }
        return output;
    }
}