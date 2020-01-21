import java.util.Stack;
import java.util.Random;
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
    Random rand = new Random();
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> historyList;
    Room cel, gang, valkuil1, trap, valkuil2, hal, valkuil3, keuken, eetzaal, muur, gracht, trap2, valkuil4, poort, bos, thuis;
    Item keychain, glass, pan, rope, firestone, sword; 
    private Player activePlayer;
    private Clock activeClock;
    private Enemy activeEnemy;
    private boolean wantToQuit;

    
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
            activeEnemy = new Enemy();

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
            valkuil1 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Gebruik back om terug naar de hal te gaan.", true); // must have glass
            trap = new Room("Deze trap gaat maar tot en met de eerste verdieping van het kasteel. Je moet zo stil mogelijk van de trap af lopen. Beantwoord de volgende vraag goed, om ervoor te zorgen dat je zo stil mogelijk bent en je niet gesnapt wordt.", true); // must have glass
            valkuil2 = new Room("Helaas dit was de verkeerde deur, om geen leven kwijt te raken moet je de volgende vraag goed beantwoorden:", false);
            hal = new Room("Je loopt rustig en voorzichtig door de hal. Gelukkig maar dat je zo voorzichtig doet. Wanneer je halverwege de hal bent komt er een kok uit een van de deuren. Kijk rond om een verstop plek te vinden.", true); // must have the keychain 
            valkuil3 = new Room("Helaas dit was de verkeerde deur, om geen leven kwijt te raken moet je de volgende vraag goed beantwoorden:", false);
            keuken = new Room("Je doet de deur van de keuken zachtjes open en kruipt naar binnen achter een kastje. Je kijkt over het randje van het kastje om te zien of er koks in de keuken zijn. En ja, er staan 2 koks, druk bezig met het bereiden van het avond eten. Ze staan beiden met hun gezicht naar de deur waar jij naartoe moet. De enige optie is om ze allebei uit te schakelen. Je moet om je heen kijken om iets te vinden om de koks mee uit te schakelen.", true); // must have the sword
            eetzaal = new Room("De koks in de keuken waren nog druk bezig met het voorbereiden van het avond eten, dus de eetzaal is gelukkig nog leeg. Je staat voor een keuze. Je ziet namelijk een stuk touw in de hoek van de eetzaal liggen. Er is een raam in de eetzaal waardoor je zou kunnen ontsnappen met het touw. De andere keuze is de vuurstenen pakken die bij de openhaard liggen en de trap naar beneden te pakken. Kies welk voorwerp je wilt pakken. ga daarna naar de bijbehoorde kamer.", false);
            muur = new Room("Je hebt blijkbaar voor het touw gekozen. Je hangt aan het touw langs de muur. Onder je zit water, er zit namelijk een gracht om het kasteel heen. Je moet je heel langzaam laten zakken, om ervoor te zorgen dat de bewakers in de wachttorens je niet zien. Speel het volgende spel om ervoor te zorgen dat je je zo stil mogelijk naar beneden laat zakken. ", true); // must have the rope
            gracht = new Room("De gracht wordt erg goed in de gaten gehouden vanaf de bewakers toren. Een kleine beweging in het water en je wordt ontdekt. Het is al erg donker buiten, dus je kunnen niet goed in het water kijken, maar de horen het wel gelijk. Je besluit onderwater te zwemmen om op die manier zo min mogelijk geluid te maken. Het is een Breede gracht. Beantwoord de volgende vraag goed om ervoor te zorgen dat je lang genoeg je adem kan inhouden. ", false);
            trap2 = new Room("Je loopt de trap af, wanneer je bijna beneden bent hoor je geroesemoes en zie je dat de deur langzaam opengaat. Je moet zo snel mogelijk een verstop plek vinden. Beantwoord de volgende vraaggoed, zodat je zo snel mogelijk een verstopplek kan vinden.", true); // must have the firestone
            poort = new Room("De bewakers zijn druk in gesprek en letten niet goed op. Je doet de deur op een kiertje en kruipt stilletjes achter een kast die 2 meter van je vanaf staat. Je pakt je vuursteen. Met de vuursteen probeer je de kast in de brand te zetten. Beantwoord de volgende vraag goed, om de kast in brand te zetten ", false);
            bos = new Room("Je zit in het bos, je rent zo hardt als je kan weg, zodat je al zo ver mogelijk weg bent voordat ze erachter komen dat je ontsnapt bent. Je kijkt nog eens om er zeker van te zijn dat je niet achtervolgt wordt. Terwijl je achteromkijkt bots je tegen iets of iemand aan en valt op de grond. Kijk om je heen wat er is gebeurd.  ", false);
            thuis = new Room("Je bent veilig aangekomen bij je eigen kasteel, je hebt je koning gewaarschuwd voor de aanvalsplannen. nu maar lekker slapen en herstellen van het heftige avontuur.", false);

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
            bos.setExit("rcolor", thuis);
            
        // adding lookdescription to the rooms  
            cel.setLookDescription("Je ziet dat de bewaker een sleutelbos aan zijn broek heeft hangen. Aan jou de taak om ervoor te zorgen dat de bewaker dichter bijkomt, zodat jij de bewaker kan uitschakelen en zijn sleutel kan pakken om de cel te openen. Maar hoe ga je dit doen? Om hierachter te komen moet je de volgende vraag goed beantwoorden:");
            gang.setLookDescription("In de hoek van de gang zie je kast, kijk wat erin zit door middel van een spel:");
            valkuil1.setLookDescription("er is niet veel te zien");
            trap.setLookDescription("er is niet veel te zien");
            valkuil2.setLookDescription("er is niet veel te zien");
            hal.setLookDescription("Je ziet een harnas aan de zijkant van de hal staan, je besluit daar snel achter te gaan staan. De kok komt steeds dichterbij. Je moet zo stil mogelijk blijven staan, zodat de kok jou niet opmerkt. Beantwoord deze vraag goed om ervoor te zorgen dat jij zo stil mogelijk blijft staan.");
            keuken.setLookDescription("Je ziet een metalen pan in een open kastje staan. pak de pan");
            trap2.setLookDescription("Je ziet door de spleet van de deur dat er nog maar 2 wachters bij de poort van het kasteel zijn.");
            bos.setLookDescription("");

        // adding description 
            gang.setSecondDescription("Je zet het glas tegen de deur en drukt vervolgens je oor er tegenaan. Achter deur " + gang.getDirection(valkuil1) + " hoor je gekling van borden, achter de " + gang.getDirection(trap) + " deur hoor je helemaal niks, welke deur kies je? ");
            trap.setSecondDescription("Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap naar de begane grond zich aan de andere kant van het kasteel bevindt. Dit is de laatste deur waarvoor je een sleutel nodig hebt, maar er zijn 2 deuren. Kies door welke deur je wilt gaan.");
            hal.setSecondDescription("De kok loopt voorbij. Er staat een zwaart bij het harnas, neem deze mee, misschien komt die nog van pas! Je loopt door en komt weer voor 2 deuren te staan. Je hebt helaas niet gezien uit welke deur de kok kwam. Je wil naar de keuken. Maar welke deur lijdt naar de keuken? ");
            keuken.setSecondDescription("Met de pan in je hand kruip je steeds dichter naar de 2 koks toe. Je benadert ze van achteren. Je moet heel snel handelen wil je ze allebei kunnen uit schakelen. Beantwoord de volgende vraag goed om ervoor te zorgen dat je snel genoeg handelt.");
            muur.setSecondDescription("ga nu de gracht in.");
            gracht.setSecondDescription("ga uit de gracht.");
            trap2.setSecondDescription("Je rent zo snel mogelijk de trap af en verstopt je onder de trap. Je blijft er stil zitten. De mensen die op weg zijn naar de eetzaal lopen de trap op en merken niet dat jij er bent. Je wacht totdat ze de eetzaal in zijn. Je loopt naar de deur, kijk of je iets kan zien.");
            poort.setSecondDescription("Het is je gelukt je hebt de kast in brand gezet. Het is nog een klein vuurtje en het is de bewakers nog niet opgevallen. Snel kruip je weer terug naar de deur van de trap. De kast staat nu bijna helemaal in brand. De bewakers schrikken op uit in gesprek en rennen naar een andere kamer om emmers met water te pakken. Wanneer ze uit de kamer zijn loop je snel naar de poort. verlaat de kamer. ");
            bos.setSecondDescription("Gelukkig heb je een zwaard bij je. De bewaker rent namelijk op je af met getrokken zwaard. Ga het gevecht aan en schakel hem uit! gebruik hit");
        
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
                valkuil1.setItemForUnlocking(glass);
                trap.setItemForUnlocking(glass);
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

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("ga")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("rugzak")) {
            System.out.println(activePlayer.getInventory());
        }
        else if (commandWord.equals("oppakken")) {
            pickupItem(command);
        }
        else if (commandWord.equals("latenvallen")) {
            dropItem(command);
        }
        else if (commandWord.equals("kijk")) {
            useLook();
        }
        else if (commandWord.equals("terug")) {
            useBack();
        }
        else if (commandWord.equals("tijd")) {
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