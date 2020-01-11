public class Player
{
    private String name;
    private int health;
    private int difficulty;
    // constructor 
    public Player(String name) {
        this.name = name;
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
    // get difficulty
    public int getDifficulty() {
        return difficulty;
    }
    // set difficulty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
