import java.util.Stack;
import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Ronald H.M. Hendriks and Luc Willemse
 * @version 0.2020.01.11
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> historyList;
    Room outside, theater, pub, lab, office, cel, hal, trap, valkuil;
    ArrayList<Item> inventory = new ArrayList<Item>(); 
    private Player player;   
    

    /**
     * Create the game and initialise its internal map.
     */

    public Game() 
    {
        createRooms();
        parser = new Parser();
        historyList = new Stack<Room>();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    /**historyListhistoryList
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
      
        // create the rooms
            cel = new Room("Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.");
            hal = new Room ("Je bent ontsnapt uit de cel. Je staat nu in een lange gang met twee deuren aan het eind van deze gang. Je zit op de hoogste verdieping van het kasteel. Om bij de uitgang te komen, moet je opzoek naar de trap. Om te weten te komen door welke deur je moet, moet je goed luisteren wat er achter deze deur zich afspeelt. De deuren in het kasteel zijn erg dik, het is onmogelijk om met het bloten oor te horen wat zich er achter de deur bevindt.");
            trap = new Room("Deze trap gaat maar tot en met de eerste verdieping van het kasteel. Je moet zo stil mogelijk van de trap af lopen. Beantwoord de volgende vraag goed, om ervoor te zorgen dat je zo stil mogelijk bent en je niet gesnapt wordt.");

        // initialise room exits
            cel.setExit("blauw", hal);
            hal.setExit("rood", valkuil);
            hal.setExit("blauw", trap);
            trap.setExit("blauw", valkuil);

        // adding lookdescription to the rooms  
            cel.setLookDescription("Je ziet dat de bewaker een sleutelbos aan zijn broek heeft hangen. Aan jou de taak om ervoor te zorgen dat de bewaker dichter bijkomt, zodat jij de bewaker kan uitschakelen en zijn sleutel kan pakken om de cel te openen. Maar hoe ga je dit doen? Om hierachter te komen moet je de volgende vraag goed beantwoorden:");
            hal.setLookDescription("In de hoek van de gang zie je kast, kijk wat erin zit door middel van een spel:");
            trap.setLookDescription("er is niet veel te zien");

        // adding description 
            hal.setSecondDescription("Je zet het glas tegen de deur en drukt vervolgens je oor er tegenaan. Achter de roden deur hoor je gekling van borden, achter de  deur hoor je helemaal niks, welke deur kies je? ");
            trap.setSecondDescription("Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap naar de begane grond zich aan de andere kant van het kasteel bevindt. Dit is de laatste deur waarvoor je een sleutel nodig hebt, maar er zijn 2 deuren. Kies of je door de rode of de blauwe deur wil.");
            
        

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("inventory")) {
            printInventory();
        }
        else if (commandWord.equals("pickup")) {
            pickupItem(command);
        }
        else if (commandWord.equals("drop")) {
            dropItem(command);
        }
        else if (commandWord.equals("look")) {
            useLook();
        }
        else if (commandWord.equals("back")) {
            
        }
        // else command not recognised.
        return wantToQuit;
    }

    /**
     * drop item
     * @param command The command to be processed.
     */
    private void dropItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("drop What?");
        }

        String item = command.getSecondWord();

        // Try to leave current room.
        Item newItem = null;
        int index = 0;
        for(int i = 0; i < inventory.size(); i++) {
            newItem = inventory.get(i);
            index = i;
        }

        if (newItem == null) {
            System.out.println("that item is not in your bag");
        }
        else {
            inventory.remove(index);
            currentRoom.setItem(new Item(item));
            System.out.println("je hebt dit item laten vallen:" + item);
        }
    }

    /**
     * pick up item
     * @param command The command to be processed.
     */
    private void pickupItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Pick up What?");
        }

        String item = command.getSecondWord();

        // Try to pick up the item.
        Item newItem = currentRoom.pickupItem(item);

        if (newItem == null) {
            System.out.println("");
        }
        else {
            inventory.add(newItem);
            currentRoom.removeItem(item);
            System.out.println("je hebt dit op gepakt:" + item);
        }
    }

    private void printInventory() {
        String output = "";
        for(int i = 0; i < inventory.size(); i++) {
            output += i + " " + inventory.get(i).getDescription() + "   ";  
        }
        System.out.println("je hebt deze items momenteel bij je");
        System.out.println(output);
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription()); 
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * "look" was entered. Now we will print the look output
     * of the current room.
     */
    private void useLook(){
        currentRoom.look();
    }

}
