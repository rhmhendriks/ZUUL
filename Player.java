public class Player
{
    private String name;
    private Room currentRoom;
    private int health;

    // constructor 
    public Player(String name) {
        this.name = name;
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
    // get health
    public int getHealth() {
        return health;
    }
}
