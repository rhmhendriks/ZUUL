import java.util.HashMap;

/**
 * Write a description of class Description here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Description
{
    public static void main(String[] args) {
    // Create an hashmap object called Indroctions
    HashMap<Room, String> introductions = new HashMap<String, String>();

    // Add keys and values (Room, Description)
    introductions.put("Cell", "Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.");
    introductions.put("Gang", "Je bent ontsnapt uit de cel. Je staat nu in een lange gang met twee deuren aan het eind van deze gang. Je zit op de hoogste verdieping van het kasteel. Om bij de uitgang te komen, moet je opzoek naar de trap. Om te weten te komen door welke deur je moet, moet je goed luisteren wat er achter deze deur zich afspeelt. De deuren in het kasteel zijn erg dik, het is onmogelijk om met het bloten oor te horen wat zich er achter de deur bevindt");
    introductions.put("Trap", "Deze trap gaat maar tot en met de eerste verdieping van het kasteel. Omdat je tijdens jouw spionage missie al op de eerste verdieping bent geweest van het kasteel, weet je dat de trap naar de begane grond zich aan de andere kant van het kasteel bevindt. Dit is de laatste deur waarvoor je een sleutel nodig hebt, maar er zijn 2 deuren. Doormiddel van een spel kom je te weten welke deur je nodig hebt. Beantwoord de volgende som, om te weten welke deur je moet openen.");
    introductions.put("Hal", "Je loopt rustig en voorzichtig door de hal. Gelukkig maar dat je zo voorzichtig doet. Wanneer je halverwege de hal bent komt er een kok uit een van de deuren. Kijk rond om een verstop plek te vinden.");
    introductions.put("Keuken", "Je doet de deur van de keuken zachtjes open en kruipt naar binnen achter een kastje. Je kijkt over het randje van het kastje om te zien of er koks in de keuken zijn. En ja, er staan 2 koks, druk bezig met het bereiden van het avond eten. Ze staan beiden met hun gezicht naar de deur waar jij naartoe moet. De enige optie is om ze allebei uit te schakelen. Je moet om je heen kijken om iets te vinden om de koks mee uit te schakelen.");
    introductions.put("Eetzaal", "Je zit in de cel. Er zit een bewaker voor de cel. De bewaker zit op veilige afstand, zodat jij hem niet kan aanraken.");
    }
    /**
     * Constructor for objects of class Description
     */
    public Description()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
