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
    Room cel, gang, valkuil1, trap, valkuil2, hal, valkuil3, keuken, eetzaal, muur, gracht, trap2, valkuil4, poort, bos;
    Item keychain, glass, pan, rope, firestone, sword; 
    private Player activePlayer;
    private Clock activeClock;
    private boolean wantToQuit;
    private boolean finished = false;

    // enable the use of color in the text output. 
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        historyList = new Stack<Room>();
        boolean wantToQuit = false;
    }

    /**
     * 
     * The main method for running outside of IDE
     */
    public static void main(String[] args) {
        while (true == true){
            Game game = null;
            game = new Game();
            game.play();
            if (game.play()){
                break;
            }
        }
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

        // time starter
        if(activePlayer.getTimeLimit() != 999) {
            activeClock = new Clock(activePlayer.getTimeLimit());
            activeClock.startClock();
            }
        
        // Now we will start the game in the first room. 
            currentRoom = cel; 
            roomIntroducer(cel);
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
      
        // create the rooms
            cel = new Room("Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.", false);
            gang = new Room("Je bent ontsnapt uit de cel. Je staat nu in een lange gang met twee deuren aan het eind van deze gang. Je zit op de hoogste verdieping van het kasteel. Om bij de uitgang te komen, moet je opzoek naar de trap. Om te weten te komen door welke deur je moet, moet je goed luisteren wat er achter deze deur zich afspeelt. De deuren in het kasteel zijn erg dik, het is onmogelijk om met het bloten oor te horen wat zich er achter de deur bevindt.", true); // must have the keychain
            valkuil1 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Gebruik back om terug naar de hal te gaan.", false);
            trap = new Room("Deze trap gaat maar tot en met de eerste verdieping van het kasteel. Je moet zo stil mogelijk van de trap af lopen. Beantwoord de volgende vraag goed, om ervoor te zorgen dat je zo stil mogelijk bent en je niet gesnapt wordt.", true);
            valkuil2 = new Room("Helaas dit was de verkeerde deur, om geen leven kwijt te raken moet je de volgende vraag goed beantwoorden:", false);
            hal = new Room("Je loopt rustig en voorzichtig door de hal. Gelukkig maar dat je zo voorzichtig doet. Wanneer je halverwege de hal bent komt er een kok uit een van de deuren. Kijk rond om een verstop plek te vinden.", true); // must have the keychain 
            valkuil3 = new Room("dskskf", false);
            keuken = new Room("dskskf", true); // must have the sword
            eetzaal = new Room("dskskf", false);
            muur = new Room("dskskf", true); // must have the rope
            gracht = new Room("dskskf", false);
            trap2 = new Room("dskskf", true); // must have the firestone
            poort = new Room("dskskf", false);
            bos = new Room("dskskf", false);

        // initialise room exits
            cel.setExit("rcolor", gang);
            gang.setExit("rcolor", valkuil1);
            gang.setExit("rcolor", trap);
            trap.setExit("rcolor", valkuil2);
            trap.setExit("rcolor", hal);
            hal.setExit("rcolor", valkuil3);
            hal.setExit("rcolor", keuken);
            keuken.setExit("rcolor", eetzaal);
            eetzaal.setExit("rcolor", muur);
            eetzaal.setExit("rcolor", trap2);
            muur.setExit("rcolor", gracht);
            gracht.setExit("rcolor", bos);
            trap2.setExit("rcolor", valkuil4);
            trap2.setExit("rcolor", poort);
            poort.setExit("rcolor", bos);
            
        // adding lookdescription to the rooms  
            cel.setLookDescription("Je ziet dat de bewaker een sleutelbos aan zijn broek heeft hangen. Aan jou de taak om ervoor te zorgen dat de bewaker dichter bijkomt, zodat jij de bewaker kan uitschakelen en zijn sleutel kan pakken om de cel te openen. Maar hoe ga je dit doen? Om hierachter te komen moet je de volgende vraag goed beantwoorden:");
            gang.setLookDescription("In de hoek van de gang zie je kast, kijk wat erin zit door middel van een spel:");
            valkuil1.setLookDescription("er is niet veel te zien");
            trap.setLookDescription("er is niet veel te zien");
            valkuil2.setLookDescription("er is niet veel te zien");
            hal.setLookDescription("Je ziet een harnas aan de zijkant van de hal staan, je besluit daar snel achter te gaan staan. De kok komt steeds dichterbij. Je moet zo stil mogelijk blijven staan, zodat de kok jou niet opmerkt. Beantwoord deze vraag goed om ervoor te zorgen dat jij zo stil mogelijk blijft staan.");

        // adding description 
            gang.setSecondDescription("Je zet het glas tegen de deur en drukt vervolgens je oor er tegenaan. Achter deur " + gang.getDirection(valkuil1) + " hoor je gekling van borden, achter de " + gang.getDirection(trap) + " deur hoor je helemaal niks, welke deur kies je? ");
            trap.setSecondDescription("Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap naar de begane grond zich aan de andere kant van het kasteel bevindt. Dit is de laatste deur waarvoor je een sleutel nodig hebt, maar er zijn 2 deuren. Kies door welke deur je wilt gaan.");
            hal.setSecondDescription("De kok loopt voorbij. Je loopt door en komt weer voor 2 deuren te staan. Je hebt helaas niet gezien uit welke deur de kok kwam. Je wil naar de keuken. Maar welke deur lijdt naar de keuken? ");

        // create and assign items to an room
            // Create the items
                keychain = new Item("sleutelbos");  
                glass = new Item("glas");
                sword = new Item("zwaart");
                pan = new Item("pan");
                rope = new Item("touw");
                firestone = new Item("vuursteen");


            // Assign items to a room
                cel.setItem(keychain); 
                gang.setItem(glass);
                hal.setItem(sword);
                keuken.setItem(pan);
                eetzaal.setItem(rope);
                eetzaal.setItem(firestone);

            // set items for unlock
                gang.setItemForUnlocking(keychain);
                hal.setItemForUnlocking(keychain);
                keuken.setItemForUnlocking(sword);
                muur.setItemForUnlocking(rope);
                trap2.setItemForUnlocking(firestone);

    }
    /**
     * This method prints the current status of the player information
     * and introduces the room that the player is trying to access. 
     * @param introducingRoom The room to be introduced
     */
    private void roomIntroducer(Room introducingRoom){
        System.out.println("Speler: " + activePlayer.getName() + "   " + "Levens: " + activePlayer.createLivebar() + "   " + "Gezondheid: " + activePlayer.getHealth());
        System.out.println("Je bezit:" + activePlayer.getInventory());
        if(activePlayer.getDifficulty() != 999) {
          System.out.println(activeClock.getTimer()/60 + " minuten");
        } else {
            System.out.println();
        }
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
    public boolean play() 
    {            
        gameStarter();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        Boolean returnVariable = true;
        
        while (! finished || activeClock.getTimer() > 0 || activePlayer.getMoves() > 0 || activePlayer.getLiveStatus() > 0) {
            if (activeClock.getTimer() <= 0){
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "Je tijd is om!");
                System.out.println("Het is je niet gelukt om op tijd te ontsnappen!");
                System.out.println("De bewakers hebben je terug gebracht naar je Cel.");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                returnVariable = false;
            } else if ((activePlayer.getMoves() <= 0)){
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "Je zetten zijn op!");
                System.out.println("Je hebt niet genoeg energie meer om iets te doen, hierdoor kun je ook niet meer rennen.");
                System.out.println("De bewakers hebben je meegesleept en terug geplaatst in je Cel. ");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                returnVariable = false;
            } else if (activePlayer.getLiveStatus() <= 0) {
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "oh nee!, je hebt al je levens verloren!");
                System.out.println("Zonder levens kun je je niet meer verzetten tegen de bewakers.");
                System.out.println("De bewakers hebben je gevonden en weer naar de cel gebracht.");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                returnVariable = false;
            } else {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }

        System.out.println(ANSI_CYAN + "Bedankt voor het spelen!     Tot de volgende keer");
        System.out.println("Dit venster kan nu worden gesloten!" + ANSI_RESET);

        }
        return returnVariable;
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
        else if (commandWord.equals("time")) {
            if (activePlayer.getDifficulty() >= 4) {
            System.out.println(activeClock.getTimer());
            } else {
                System.out.println("De moeilijkheidsgraad die jij hebt gekozen bevat geen tijdslimiet");
            }
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

        if (!activePlayer.inInventory(item)){
            System.out.println(item + " zit niet in de tas! Probeer het opnieuw!");
        } else {
            Item tempItem = activePlayer.getItemAsObject(item);
            activePlayer.removeFromInventory(tempItem.getDescription());
            currentRoom.setItem(tempItem);
            System.out.println("je hebt " + item + " achtergelaten in " + currentRoom + "!");
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
            activePlayer.addToInventory(newItem);
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
        Boolean confirmation = helpConfirmation.nextBoolean();
        

        if (confirmation) {
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
            System.out.println();
            System.out.println("je hebt de keuzen uit de volgende " + currentRoom.getExitString());
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
                activePlayer.remMove();
                processLock(nextRoom);     
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

    /**
     * Check iof a room is locked and unlock when possible
     * 
     * @param checkRoom the room you wanna check
     */
    private void processLock(Room checkRoom){

        if (!checkRoom.getLock()){
            currentRoom = checkRoom;
            roomIntroducer(currentRoom);
        } else {
            Item neededForUnlock = checkRoom.getItemForUnlocking();
            if (!activePlayer.inInventory(neededForUnlock.getDescription())){
                System.out.println(checkRoom.getLockInstruction());
            } else {
                checkRoom.setLock(false);
                currentRoom = checkRoom;
                roomIntroducer(currentRoom);
            }
        }
    }
}