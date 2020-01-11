import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;

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
    Room outside, theater, pub, lab, office, cel;
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
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        cel = new Room("Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.");

        outside.setLookDescription("Dit is de look beschrijving");

        // initialise room exits
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside

        inventory.add(new Item("key"));
    }

    /**
     * This method prints the current status of the player information
     * and introduces the room that the player is trying to access. 
     * @param introducingRoom The room to be introduced
     */
    private void roomIntroducer(Room introducingRoom){
        System.out.println("Speler :" + activePlayer.getName() + "   " + "Levens: " + activePlayer.createLivebar() + "   " + "Gezondheid: " + activePlayer.getHealth());
        System.out.println(" ");
        System.out.println("Je bezit:" );



        System.out.println(introducingRoom.getLongDescription()); // print room introduction
        
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
            historyList.add(currentRoom);
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


    /**
     * Back was entered. 
     * We go back to the last accesed room.
     */
    
    private void useBack(){
        Room roomtogobackto = historyList.pop();
        currentRoom = roomtogobackto;
        roomIntroducer(currentRoom);
    }

    private void gameStarter(){
        // We specify the needed local variables
            // Name input 
                Scanner playerName = new Scanner(System.in);
                Scanner playerNameConfirm = new Scanner(System.in);
                String choosenName;
                String confirmInputName;
            
            // Difficulty selection
                Scanner difLevel = new Scanner(System.in);
                Scanner difLevelConfirm = new Scanner(System.in);
                String choosenDifLevel;
                String confirmInputDifLevel;
                String printableDifLevel;
                int usableDifLevel;

        // Now we put the things on the screen
            // Set the Player Name
                printWelcome();
                System.out.println("---------------------------------------------------------");
                System.out.println("Wat is jouw naam?");
                choosenName = playerName.nextLine();

                System.out.println(" ");

                System.out.println("De door jouw gekozen naam is: " + choosenName);
                System.out.println("Is dit juist? [yes / no]");
                confirmInputName = playerNameConfirm.nextLine();

                while (confirmInputName != "yes"){
                    System.out.println(" ");
                    System.out.println("Wat is jouw naam?");
                    choosenName = playerName.nextLine();

                    System.out.println(" ");

                    System.out.println("De door jouw gekozen naam is: " + choosenName);
                    System.out.println("Is dit juist? [yes / no]");
                    confirmInputName = playerNameConfirm.nextLine();
                }
                
            // create some room
                System.out.println(" ");
                System.out.println(" ");
        
            // Set the difficulty
                System.out.println("Je kunt dit spel spelen op verschillende niveau's:");
                System.out.println("(1) Makkelijk   (2) Gemiddeld   (3) Moeilijk");
                System.out.println(" ");
                System.out.println("Of speel met een tijdslimiet voor meer uitdaging:");
                System.out.println("(4) Makkelijk   (5) Gemiddeld   (6) Moeilijk");
                System.out.println(" ");
                System.out.println("Op welk niveau wil je dit spel spelen? [nummer bijv. '2'] ");
                choosenDifLevel = difLevel.nextLine();

                System.out.println(" ");

                if (choosenDifLevel == "1"){
                    printableDifLevel = "Makkelijk";
                    usableDifLevel = 1;
                } else if (choosenDifLevel == "2"){
                    printableDifLevel = "Gemiddeld";
                    usableDifLevel = 2;
                } else if (choosenDifLevel == "3"){
                    printableDifLevel = "Moeilijk";
                    usableDifLevel = 3;
                } else  if (choosenDifLevel == "4"){
                    printableDifLevel = "Makkelijk (met tijd)";
                    usableDifLevel = 4;
                } else if (choosenDifLevel == "5"){
                    printableDifLevel = "Gemiddeld (met tijd)";
                    usableDifLevel = 5;
                } else if (choosenDifLevel == "6"){
                    printableDifLevel = "Moeilijk (met tijd)";
                    usableDifLevel = 6;
                } else { 
                    System.out.println(" ");
                    System.out.println("Op welk niveau wil je dit spel spelen? ");
                    choosenDifLevel = difLevel.nextLine();
                }

                System.out.println("Het door jouw gekozen niveau is: " + printableDifLevel);
                System.out.println("Is dit juist? [yes / no]");
                confirmInputDifLevel = difLevelConfirm.nextLine();

                while (confirmInputDifLevel != "yes"){
                    System.out.println(" ");
                    System.out.println("Op welk niveau wil je dit spel spelen? [nummer bijv. '2'] ");
                    choosenDifLevel = difLevel.nextLine();

                    System.out.println(" ");

                    System.out.println("Het door jouw gekozen niveau is: " + printableDifLevel);
                    System.out.println("Is dit juist? [yes / no]");
                    confirmInputDifLevel = difLevelConfirm.nextLine();
                }

                System.out.println(" ");

        // We are going to create the player with the given parameters
            Player activePlayer = new Player(choosenName);
            activePlayer.setDifficulty(usableDifLevel);

    }
}
