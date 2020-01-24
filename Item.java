public class Item {
    
    String description;
    Boolean pickable;

    /**
     * constructor
     * @param newdescription
     */
    public Item(String newdescription, boolean isPickable) {
        description = newdescription;
        pickable = isPickable;
    }

    /**
     * gives the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gives the pickable
     * @return the pickable
     */
    public Boolean getPickable() {
        return pickable;
    }
}