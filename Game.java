import java.util.Stack;
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
 * @author  Ronald H.M. Hendriks, Nivard and Luc Willemse
 * @version 0.2020.01.11
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> historyList;
    Room cel, gang, hal, trap, valkuil, keuken;
    private Player activePlayer;
        


    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        historyList = new Stack<Room>();
    }

    /**
     * The main method for running outside of IDE
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    /**
     * This method is used to get the game starting
     * by making a player with personal settings
     * like the player name and difficulty level
     */
    private void gameStarter(){
        // We specify the needed local variables
            // Name input 
                Scanner playerName = new Scanner(System.in);
                Scanner playerNameConfirm = new Scanner(System.in);
                String choosenName;
                boolean confirmInputName;
            
            // Difficulty selection
                Scanner difLevel = new Scanner(System.in);
                Scanner difLevelConfirm = new Scanner(System.in);
                String choosenDifLevel;
                boolean confirmInputDifLevel;
                int usableDifLevel;

        // Now we put the things on the screen
            // Set the Player Name
                printWelcome();
                System.out.println(" ");
                System.out.println("---------------------------------------------------------");
                System.out.println(" ");
                System.out.println("Wat is jouw naam?");
                choosenName = playerName.nextLine();

                System.out.println(" ");

                System.out.println("De door jouw gekozen naam is: " + choosenName);
                System.out.println("Is dit juist? [Ja (true) / Nee (false)]");
                confirmInputName = playerNameConfirm.nextBoolean();

                while (!confirmInputName){
                    System.out.println(" ");
                    System.out.println("Wat is jouw naam?");
                    choosenName = playerName.nextLine();

                    System.out.println(" ");

                    System.out.println("De door jouw gekozen naam is: " + choosenName);
                    System.out.println("Is dit juist? [Ja (true) / Nee (false)]");
                    confirmInputName = playerNameConfirm.nextBoolean();
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
                usableDifLevel = Integer.parseInt(choosenDifLevel);

                System.out.println(" ");

                System.out.println("Het door jouw gekozen niveau is: " + choosenDifLevel);
                System.out.println("Is dit juist? [Ja (true) / Nee (false)]");
                confirmInputDifLevel = difLevelConfirm.nextBoolean();

                while (!confirmInputDifLevel || usableDifLevel < 1 || usableDifLevel > 6){
                    System.out.println(" ");
                    System.out.println("Op welk niveau wil je dit spel spelen? [nummer bijv. '2'] ");
                    choosenDifLevel = difLevel.nextLine();

                    System.out.println(" ");

                    System.out.println("Het door jouw gekozen niveau is: " + choosenDifLevel);
                    System.out.println("Is dit juist? [Ja (true) / Nee (false)]");
                    confirmInputDifLevel = difLevelConfirm.nextBoolean();
                }

                System.out.println(" ");

        // We are going to create the player with the given parameters
            activePlayer = new Player(choosenName);
            activePlayer.setDifficulty(usableDifLevel);
        
        // Now we will start the game in the first room. 
            roomIntroducer(cel);
            currentRoom = cel;

        // time starter
                

        // Temporary for testing parameters
            activePlayer.inventory.add(new Item("key"));

        // Lets close our scanners    
            playerName.close();
            playerNameConfirm.close();
            difLevel.close();
            difLevelConfirm.close();
    }

    /**
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
            trap.setSecondDescription("Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap n");
    }
    /**
     * This method prints the current status of the player information
     * and introduces the room that the player is trying to access. 
     * @param introducingRoom The room to be introduced
     */
    private void roomIntroducer(Room introducingRoom){
        System.out.println("Speler: " + activePlayer.getName() + "   " + "Levens: " + activePlayer.createLivebar() + "   " + "Gezondheid: " + activePlayer.getHealth());
        System.out.println("Je bezit:" + activePlayer.getInventory());
        System.out.println(" ");

        System.out.println(introducingRoom.getLongDescription()); // print room introduction
        System.out.println(" ");
        
        if (introducingRoom == cel){
            printHelpCell();
        }
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        gameStarter();

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
        System.out.println("Welkom bij ons spel!");
        System.out.println("Dit is een nieuwe minder saaie verzie van ZUUL");
        System.out.println();
        pressEnterToContinue();
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
            activePlayer.getInventory();
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
            useBack();
        }
        // else command not recognised.
        return wantToQuit;
    }

    /**
     * This method is used to drop an item from the bag
     * @param command The command to be processed.
     */
    private void dropItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("Wat wil je achterlaten?");
        }

        String item = command.getSecondWord(); // Get the item the player wants to drop

        /**
        // Find the item to drop
        Item newItem = null;
        int index = 0;
        for(int i = 0; i < activePlayer.inventory.size(); i++) {
            newItem = activePlayer.inventory.get(i);
            index = i;
        }

        if (newItem == null) {
            System.out.println(item + " zit niet in de tas! Probeer het opnieuw!");
        }
        
        else {
            activePlayer.inventory.remove(index);
            currentRoom.setItem(new Item(item));
            System.out.println("je hebt " + item + " achtergelaten in " + currentRoom + "!");
        }
        */

        if (!activePlayer.inInventory(item)){
            System.out.println(item + " zit niet in de tas! Probeer het opnieuw!");
        } else if (activePlayer.removeFromInventory(item)) {

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
            System.out.println("Je hebt niet aangegeven wat je wil opakken!");
        }

        String item = command.getSecondWord();

        // Try to pick up the item.
        Item newItem = currentRoom.pickupItem(item);

        if (newItem == null) {
            System.out.println("Helaas. Dit voorwerp is niet aanwezig in deze kamer!");
        }
        else {
            activePlayer.inventory.add(newItem);
            currentRoom.removeItem(item);
            System.out.println("je hebt " + item + " opgepakt en draagt het nu bij je in je tas!");
        }
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelpCell() 
    {
        System.out.println("Op de muur staat geschreven welke acties je kunt");
        System.out.println("gebruiken tijdens deze game.");
        System.out.println();
        System.out.println("Je kunt deze lijst opnieuw tonen met 'help', ");
        System.out.println("maar denk eraan: het tonen van deze lijst kost");
        System.out.println("je één leven.");
        System.out.println();
        System.out.println("Natuurlijk kun je ook altijd weer naar de cel om ");
        System.out.println("om de lijst op de muur te bekijken. ");
        System.out.println();
        parser.showCommands();
    }

    private void printHelp() 
    {
        Scanner helpConfirmation = new Scanner(System.in);

        System.out.println("Je hebt 'help' gebruikt! Dat kost je één leven.");
        System.out.println("weet je zeker dat je een leven wilt betalen om ");
        System.out.println("hulp te krijgen? [Ja (true) / Nee (false)] ");
        

        if (helpConfirmation.nextBoolean()){
            activePlayer.lostLive();
            System.out.println();
            System.out.println("Op de muur staat geschreven welke acties je kunt");
            System.out.println("gebruiken tijdens deze game.");
            System.out.println();
            System.out.println("Je kunt deze lijst opnieuw tonen met 'help', ");
            System.out.println("maar denk eraan: het tonen van deze lijst kost");
            System.out.println("je één leven.");
            System.out.println();
            System.out.println("Natuurlijk kun je ook altijd weer naar de cel om ");
            System.out.println("om de lijst op de muur te bekijken. ");
            System.out.println();
            parser.showCommands();
        }
        helpConfirmation.close();
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
            roomIntroducer(currentRoom);
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
     * Help method witch is waiting for the user to press enter
     */
    private void pressEnterToContinue()
    { 
           System.out.println("Druk op enter om verder te gaan");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
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

    
}
