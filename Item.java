public class Item {
    
    String description;

    /**
     * constructor
     * @param newdescription
     */
    public Item(String newdescription) {
        description = newdescription;
    }

    /**
     * gives the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}