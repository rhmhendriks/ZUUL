import java.util.HashMap;

public class Player
{
    private String name;
    private Room currentRoom;
    private HashMap<String, Item> itemsCarring;

    // constructor 
    public Player(String name) {
        this.name = name;
        itemsCarring = new HashMap<String, Item>();
    }
    // in what room the player is
    public Room getCurrentPlayerRoom() {
		return currentRoom;
    }
    // get player name
    public String getPlayerName() {
		return name;
    }
    // set player name
    public void setPlayerName(String name) {
		this.name = name;
    }
    
}
