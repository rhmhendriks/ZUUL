import java.util.Set;
import java.util.HashMap;

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
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String lookdescriptionString;
    private final String description;
    private final HashMap<String, Room> exits; // stores exits of this room.
    
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(final String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(final String direction, final Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Define the look description of the room
     * 
     * @param lookDescription the text displayed when the look command is given
     */
    public void setLookDescription(String lookDescription) {
        lookdescriptionString = lookDescription;
    }

    /**
     * @return The short description of the room (the one that was defined in the
     *         constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form: You are in the kitchen. Exits:
     * north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north west".
     * 
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        final Set<String> keys = exits.keySet();
        for (final String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(final String direction) 
    {
        return exits.get(direction);
    }

    /**
     * @return The description for when the look command is given.
     */
    public String getLookDescription() {
        return lookdescriptionString;
    }
}

