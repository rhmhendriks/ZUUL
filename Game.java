import java.util.Stack;
import java.util.InputMismatchException;
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
 * @author  Ronald H.M. Hendriks, Nivard Ypey and Luc Willemse
 * @version 0.2020.01.11
 */

public class Game
{
    Random rand = new Random();
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> historyList;
    public Room cel, gang, valkuil1, trap, valkuil2, hal, valkuil3, keuken, keukenTafeltje, eetzaal, muur, gracht, trap2, valkuil4, poort, bos, thuis;
    private Item keychain, glass, pan, rope, firestone, sword; 
    private Player activePlayer;
    private Clock activeClock;
    private Enemy activeEnemy;
    private boolean finished = false;
    private MiniGame miniGames;
    private Questions questionLists;

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
        public static final String ANSI_BOLD = "\u001b[1m";
        public static final String ANSI_UNDERLINE= "\u001B[1m";
        public static final String ANSI_bBlack  = "\u001b[30;1m";
        public static final String ANSI_bGREEN = "\u001b[32;1m";
        public static final String ANSI_bRED = "\u001b[31;1m";
        public static final String ANSI_bYELLOW = "\u001b[33;1m";
        public static final String ANSI_bBLUE = "\u001b[34;1m";
        public static final String ANSI_bMAGENTA= "\u001b[35;1m;";


    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        historyList = new Stack<Room>();
        miniGames = new MiniGame();
        questionLists = new Questions();
    }

    /**
     * 
     * The main method for running outside of IDE
     */
    public static void main(String[] args) {
            Game game = new Game();
            game.play();
            if (!game.play()){
                game = null;
                game = new Game();
                game.play();
            }
    }
    
    /**
     * Main play routine.  Loops until end of play.
     * @return false if you have or to time, moves or lives
     */
    public Boolean play() 
    {            
        gameStarter();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        while (true == true){
            Command command = parser.getCommand();
            if (activeClock.getTimer() <= 0){
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "Je tijd is om!");
                System.out.println("Het is je niet gelukt om op tijd te ontsnappen!");
                System.out.println("De bewakers hebben je terug gebracht naar je Cel.");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                return false;
            } else if ((activePlayer.getMoves() <= 0)){
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "Je zetten zijn op!");
                System.out.println("Je hebt niet genoeg energie meer om iets te doen, hierdoor kun je ook niet meer rennen.");
                System.out.println("De bewakers hebben je meegesleept en terug geplaatst in je Cel. ");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                return false;
            } else if (activePlayer.getLiveStatus() <= 0) {
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED + "oh nee!, je hebt al je levens verloren!");
                System.out.println("Zonder levens kun je je niet meer verzetten tegen de bewakers.");
                System.out.println("De bewakers hebben je gevonden en weer naar de cel gebracht.");
                System.out.println();
                System.out.println();
                System.out.println("Het spel wordt nu opnieuw geladen... Een ogenblik geduld...." + ANSI_RESET);
                return false;
            } else {
                finished = processCommand(command);
            }
            
            if (finished){
                useQuit();
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
                System.out.println("-----------------------------------------------------------------------------------");
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

            //miniGames.endFight(activePlayer, activeEnemy);
        // Now we will start the game in the first room. 
            currentRoom = cel; 
            roomIntroducer(cel);
            
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
      
        // create the rooms
            cel = new Room("Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.", false, 2, 0);
            gang = new Room("Je bent ontsnapt uit de cel. Je staat nu in een lange gang met twee deuren aan het eind van deze gang. Je zit op de hoogste verdieping van het kasteel. Om bij de uitgang te komen, moet je opzoek naar de trap. Om te weten te komen door welke deur je moet, moet je goed luisteren wat er achter deze deur zich afspeelt. De deuren in het kasteel zijn erg dik, het is onmogelijk om met het blote oor te horen wat zich achter de deur bevindt. Kijk om je heen om te kijken of je iets om je heen kan gebruiken.", true, 2, 0); // must have the keychain
            valkuil1 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Beantwoord eerst de volgende vraag. Gebruik daarna back om terug naar de hal te gaan.", true, 1, 0); // must have glass
            trap = new Room("Deze trap gaat maar tot en met de eerste verdieping van het kasteel. Je moet zo stil mogelijk van de trap af lopen. Beantwoord de volgende vraag goed, om ervoor te zorgen dat je zo stil mogelijk bent en je niet gesnapt wordt.", true, 1, 0); // must have glass
            valkuil2 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Beantwoord eerst de volgende vraag. Gebruik daarna back om terug naar de hal te gaan.", false, 1 ,0);
            hal = new Room("Je loopt rustig en voorzichtig door de hal. Gelukkig maar dat je zo voorzichtig doet. Wanneer je halverwege de hal bent komt er een kok uit een van de deuren. Kijk rond om een verstop plek te vinden.", true, 2, 0); // must have the keychain 
            valkuil3 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Beantwoord eerst de volgende vraag. Gebruik daarna back om terug naar de hal te gaan.", false, 1, 0);
            keuken = new Room("Je doet de deur van de keuken zachtjes open en kruipt naar binnen achter een kastje. Je kijkt over het randje van het kastje om te zien of er koks in de keuken zijn. En ja, er staan 2 koks, druk bezig met het bereiden van het avond eten. Ze staan beiden met hun gezicht naar de deur waar jij naartoe moet. De enige optie is om ze allebei uit te schakelen. Je moet om je heen kijken om iets te vinden om de koks mee uit te schakelen.", true, 3, 0); // must have the sword
            keukenTafeltje = new Room("Je ziet een aantal borden met een deksel daarop, op het keukentafeltje staan.", false, 1, 0);
            eetzaal = new Room("De koks in de keuken waren nog druk bezig met het voorbereiden van het avond eten, dus de eetzaal is gelukkig nog leeg. Je staat voor een keuze. Je ziet namelijk een stuk touw in de hoek van de eetzaal liggen. Er is een raam in de eetzaal waardoor je zou kunnen ontsnappen met het touw. De andere keuze is de vuursteen te pakken die bij de openhaard ligt en de trap naar beneden te pakken. Kies welk voorwerp je wilt pakken. ga daarna naar de bijbehoorde kamer. maar voordat je dit gaat doen moet je eerst de volgende vraag beantwoorden.", false, 1, 0);
            muur = new Room("Je hebt blijkbaar voor het touw gekozen. Je hangt aan het touw langs de muur. Onder je zit water, er zit namelijk een gracht om het kasteel heen. Je moet je heel langzaam laten zakken, om ervoor te zorgen dat de bewakers in de wachttorens je niet zien. Speel het volgende spel om ervoor te zorgen dat je je zo stil mogelijk naar beneden laat zakken. ", true, 1, 0); // must have the rope
            gracht = new Room("De gracht wordt erg goed in de gaten gehouden vanaf de bewakers toren. Een kleine beweging in het water en je wordt ontdekt. Het is al erg donker buiten, dus ze kunnen niet goed in het water kijken, maar ze horen het wel gelijk. Je besluit onderwater te zwemmen om op die manier zo min mogelijk geluid te maken. Het is een Breede gracht. Beantwoord de volgende vraag goed om ervoor te zorgen dat je lang genoeg je adem kan inhouden. ", false, 1, 0);
            trap2 = new Room("Je hebt blijkbaar voor de vuursteen gekozen. Je loopt de trap af, wanneer je bijna beneden bent hoor je geroesemoes en zie je dat de deur langzaam opengaat. Je moet zo snel mogelijk een verstop plek vinden. Beantwoord de volgende vraag goed, zodat je zo snel mogelijk een verstopplek kan vinden.", true, 1, 0); // must have the firestone
            valkuil4 = new Room("Helaas achter deze deur zitten bewakers, je bent erbij. Je bent een leven kwijt. Beantwoord eerst de volgende vraag. Gebruik daarna back om terug naar de hal te gaan.", false, 1, 0);
            poort = new Room("De bewakers zijn druk in gesprek en letten niet goed op. Je doet de deur op een kiertje en kruipt stilletjes achter een kast die 2 meter van je vandaan staat. Je pakt je vuursteen. Met de vuursteen probeer je de kast in de brand te zetten. Beantwoord de volgende vraag goed, om de kast in brand te zetten ", false, 1, 0);
            bos = new Room("Je zit in het bos, je rent zo hardt als je kan weg, zodat je al zo ver mogelijk weg bent voordat ze erachter komen dat je ontsnapt bent. Je kijkt nog eens om er zeker van te zijn dat je niet achtervolgt wordt. Terwijl je achteromkijkt bots je tegen iets of iemand aan en val je op de grond. Kijk om je heen wat er is gebeurd.", false, 2, 0);
            thuis = new Room("Je bent veilig aangekomen bij je eigen kasteel, je hebt je koning gewaarschuwd voor de aanvalsplannen. nu maar lekker slapen en herstellen van het heftige avontuur.", false, 1, 0);

        // initialise room exits
            cel.setExit("rcolor", gang);
            gang.setExit("rcolor", valkuil1);
            gang.setExit("rcolor", trap);
            trap.setExit("rcolor", valkuil2);
            trap.setExit("rcolor", hal);
            hal.setExit("rcolor", valkuil3);
            hal.setExit("rcolor", keuken);
            keuken.setExit("rcolor", keukenTafeltje);
            keukenTafeltje.setExit("rcolor", eetzaal);
            eetzaal.setExit("rcolor", muur);
            eetzaal.setExit("rcolor", trap2);
            muur.setExit("rcolor", gracht);
            gracht.setExit("rcolor", bos);
            trap2.setExit("rcolor", valkuil4);
            trap2.setExit("rcolor", poort);
            poort.setExit("rcolor", bos);
            bos.setExit("rcolor", thuis);
            
        // adding lookdescription to the rooms  
            cel.setLookDescription("Je ziet dat de bewaker een sleutelbos aan zijn broek heeft hangen. Aan jou de taak om ervoor te zorgen dat de bewaker dichter bijkomt, zodat jij de bewaker kan uitschakelen en zijn sleutel kan pakken om de cel te openen. Om dit te doen moet je de volgende vraag goed beantwoorden:");
            gang.setLookDescription("In de hoek van de gang zie je kast, wanneer je in de kast kijkt zie je een glas liggen. pak dit glas om beter te kunnen luisteren wat er zich achter de deur bevindt. Om te weten te komen wat je hoort achter de deuren, moet je eerste de volgende vraag goed beantwoorden.");
            valkuil1.setLookDescription("er is niet veel te zien");
            trap.setLookDescription("Er is niet veel te zien");
            valkuil2.setLookDescription("er is niet veel te zien");
            hal.setLookDescription("Je ziet een harnas aan de zijkant van de hal staan, je besluit daar snel achter te gaan staan. De kok komt steeds dichterbij. Je moet zo stil mogelijk blijven staan, zodat de kok jou niet opmerkt. Beantwoord deze vraag goed om ervoor te zorgen dat jij zo stil mogelijk blijft staan.");
            valkuil3.setLookDescription("Er is niet veel te zien");
            keuken.setLookDescription("Je ziet een metalen pan in een open kastje staan. 'pak de pan'");
            keukenTafeltje.setLookDescription("Je ziet een aantal borden met een deksel daarop, op het keukentafeltje staan.");
            eetzaal.setLookDescription("Er is niet veel te zien");
            muur.setLookDescription("Er is niet veel te zien");
            gracht.setLookDescription("Er is niet veel te zien");
            trap2.setLookDescription("Je ziet door de spleet van de deur dat er nog maar 2 wachters bij de poort van het kasteel zijn.");
            valkuil4.setLookDescription("Er is niet veel te zien");
            poort.setLookDescription("Er is niet veel te zien");
            bos.setLookDescription("Wanneer je op kijkt zie je dat je tegen een bewaker aan ben gelopen. Gelukkig heb je een zwaard bij je. De bewaker rent namelijk op je af met getrokken zwaard. Ga het gevecht aan en schakel hem uit! gebruik hit ");

        // adding description 
            cel.setSecondDescription("het is je gelukt om de bewaker uit te schakelen. Pak nu de sleutel op, zodat je naar de volgende ruimt kan.");
            gang.setSecondDescription("Je zet het glas tegen de deur en drukt vervolgens je oor er tegenaan. Achter deur " + gang.getDirection(valkuil1) + " hoor je gekling van borden, achter de " + gang.getDirection(trap) + " deur hoor je helemaal niks, welke deur kies je? ");
            trap.setSecondDescription("Je bent gelukkig stil genoeg geweest. Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap naar de begane grond zich aan de andere kant van het kasteel bevindt. Dit is de laatste deur waarvoor je een sleutel nodig hebt, maar er zijn 2 deuren. Kies door welke deur je wilt gaan.");
            hal.setSecondDescription("De kok loopt voorbij. Er staat een zwaard bij het harnas, neem deze mee, misschien komt die nog van pas! Je loopt door en komt weer voor 2 deuren te staan. Je hebt helaas niet gezien uit welke deur de kok kwam. Je wil naar de keuken. Maar welke deur lijdt naar de keuken? kies een deur");
            keuken.setSecondDescription("Met de pan in je hand kruip je steeds dichter naar de 2 koks toe. Je benadert ze van achteren. Je moet heel snel handelen wil je ze allebei kunnen uit schakelen. Beantwoord de volgende vraag goed om ervoor te zorgen dat je snel genoeg handelt. ga daarna door naar de volgende ruimte.");
            keukenTafeltje.setSecondDescription("Hopelijk heb je lekker gegeten en ben je weer een beetje aangesterkt voor de rest van de onsnapping. Ga door naar de volgende ruimte");
            muur.setSecondDescription("Je bent stil genoeg geweest. Ga nu de gracht in.");
            gracht.setSecondDescription("Het is je gelukt! Ga uit de gracht.");
            trap2.setSecondDescription("Je rent zo snel mogelijk de trap af en verstopt je onder de trap. Je blijft er stil zitten. De mensen die op weg zijn naar de eetzaal lopen de trap op en merken niet dat jij er bent. Je wacht totdat ze de eetzaal in zijn. Je loopt naar de deur, kijk of je iets kan zien.");
            poort.setSecondDescription("Het is je gelukt je hebt de kast in brand gezet. Het is nog een klein vuurtje en het is de bewakers nog niet opgevallen. Snel kruip je weer terug naar de deur van de trap. De kast staat nu bijna helemaal in brand. De bewakers schrikken op uit in gesprek en rennen naar een andere kamer om emmers met water te pakken. Wanneer ze uit de kamer zijn loop je snel naar de poort. verlaat de kamer. ");
            bos.setSecondDescription("Je hebt de bewaker verslagen! Nu kan je eindelijk door rennen naar je eigen kasteel!");
        
        // create and assign items to an room
            // Create the items
                keychain = new Item("sleutelbos");  
                glass = new Item("glas");
                sword = new Item("zwaard");
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
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Speler: " + ANSI_BOLD + activePlayer.getName() + ANSI_RESET + "   " + "Levens: " + ANSI_RED + activePlayer.createLivebar() + ANSI_RESET + "   " + "Gezondheid: " + ANSI_BOLD +  activePlayer.getHealth() + ANSI_RESET);
        if(activePlayer.getDifficulty() != 999) {
            System.out.println("Je hebt nog" + ANSI_BOLD + activeClock.getTimer()/60 + ANSI_RESET + " minuten te spelen.");
            System.out.println(" ");
          } else {
            System.out.println(" ");
          }
        System.out.println("Jouw rugzak bevat:" + ANSI_BOLD +  activePlayer.getInventory() + ANSI_RESET);
        System.out.println(" ");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(" ");

        introducingRoom.printLongDescription(activePlayer); // print room introduction
        System.out.println(" ");
        
        if (introducingRoom == cel){
            printHelpCell();
        }
    }

    /**
     * removes all items from all rooms
     */
    private void cleanUpItems(){
        cel.removeAllItemsFromRoom();
        gang.removeAllItemsFromRoom();
        valkuil1.removeAllItemsFromRoom();
        trap.removeAllItemsFromRoom();
        valkuil2.removeAllItemsFromRoom();
        hal.removeAllItemsFromRoom();
        valkuil3.removeAllItemsFromRoom();
        keuken.removeAllItemsFromRoom();
        eetzaal.removeAllItemsFromRoom();
        muur.removeAllItemsFromRoom();
        gracht.removeAllItemsFromRoom();
        trap2.removeAllItemsFromRoom();
        valkuil4.removeAllItemsFromRoom();
        poort.removeAllItemsFromRoom();
        bos.removeAllItemsFromRoom();
        thuis.removeAllItemsFromRoom();
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
            System.out.println("Sorry, ik weet niet wat je bedoeld.");
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
            wantToQuit = useQuit();
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
        } else if (commandWord.equals("zetten")){
            System.out.println("Je hebt nog: " + activePlayer.getMoves() + " zetten over!");
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
            System.out.println("je hebt " + item + " achtergelaten in " + currentRoom.getShortDescription() + "!");
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
            System.out.println(ANSI_RED + "Je hebt niet aangegeven wat je wil opakken!"  + ANSI_RESET);
        }

        String item = command.getSecondWord();

        // Try to pick up the item.
        Item newItem = currentRoom.pickupItem(item);

        if (newItem == null) {
            System.out.println(ANSI_RED + "Helaas. Dit voorwerp is niet aanwezig in deze kamer!"  + ANSI_RESET);
        }
        else {
            
            if (activePlayer.addToInventory(newItem)){
                currentRoom.removeItem(item);
                System.out.println(ANSI_GREEN + "je hebt " + item + " opgepakt en draagt het nu bij je in je tas!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Je tas zit vol! Je moet eerst een item achterlaten om " + item + " te kunnen meenemen!" + ANSI_RESET);
            }
            
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
        System.out.println("Je kunt deze lijst bekijken met 'help'. ");
        System.out.println();
        System.out.println("Let op: het tonen van deze lijst kost je één leven, " );
        System.out.println("je mag ook naar de cel om de lijst te bijken. ");
        System.out.println();
        System.out.println();
        pressEnterToContinue();
        parser.showCommands();
    }

    /**
     * print the help
     */
    private void printHelp() 
    {
        Scanner helpConfirmation;
        Boolean confirmation;
        
        helpConfirmation = new Scanner(System.in);

        System.out.println("Je hebt 'help' gebruikt! Dat kost je één leven.");
        System.out.println("weet je zeker dat je een leven wilt betalen om ");
        System.out.println("hulp te krijgen? [Ja (true) / Nee (false)] ");
        confirmation = helpConfirmation.nextBoolean();
        

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
    }

    /**
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param command
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("waarheen?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Daar is geen deur!");
        }
        else {
                historyList.add(currentRoom);
                processLock(nextRoom);     
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit wat?");
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
        currentRoom.look(activePlayer);
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
        activePlayer.withdrawMove();
        currentRoom = roomtogobackto;
        roomIntroducer(currentRoom);
    }

    /**
     * the quit function of the game
     * @return the returnVar
     */
    private Boolean useQuit(){
        // creating variables for confirmation
            Scanner quitInput = new Scanner(System.in);
            Boolean answered = null;
            Boolean returnVar = false;
            Boolean answer = null;

        // ask the user if he wants to quit, and quit the game when asked. 
            while (answer == null){
                    System.out.println();
                    System.out.println("Wil je stoppen met het spel? Type 'true' voor ja of 'false' voor nee");
                try {
                    answer = quitInput.nextBoolean();
                    } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Je kunt alleen 'true' typen voor ja en 'false' voor nee!" + ANSI_RESET);
                    quitInput.next();
                }
                answered = true;
            }

            while (answered != null){
                if (answer){
                    System.out.println(ANSI_CYAN + "Bedankt voor het spelen!     Tot de volgende keer");
                    System.out.println("Dit venster kan nu worden gesloten!" + ANSI_RESET);
                    //cleanUpItems();
                    System.exit(0);
                    returnVar = true;
                } else if (!answer) {
                    returnVar = false;
                    roomIntroducer(currentRoom);
                    break;
                }
            }
        return returnVar;
    }

    /**
     * Check iof a room is locked and unlock when possibles
     * @param checkRoom the room you wanna check
     */
    private void processLock(Room checkRoom){

        if (!checkRoom.getLock()){
            currentRoom = checkRoom;
            activePlayer.withdrawMove();
            roomIntroducer(currentRoom);
        } else {
            Item neededForUnlock = checkRoom.getItemForUnlocking();
            if (!activePlayer.inInventory(neededForUnlock.getDescription())){
                System.out.println(checkRoom.getLockInstruction());
            } else {
                checkRoom.setLock(false);
                activePlayer.withdrawMove();
                currentRoom = checkRoom;
                roomIntroducer(currentRoom);
            }
        }
    }
}