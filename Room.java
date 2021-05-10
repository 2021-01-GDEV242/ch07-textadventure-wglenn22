import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    // stores exits of this room.
    private HashMap<String, Room> exits;
    
    private ArrayList<Item> items;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
       items = new ArrayList<Item>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are in " + description + "\n" + getItemsInRoom()+ 
        " "+ getExitString();
    }
    /**
     * Return items seen in a room
     */
    public String getItemsInRoom()
    {
        String roomItems = "The items you see are: " ;
        for(Item item : items){
         roomItems+= item.getItemDescription()+ "\n";
        }
        return roomItems;
    }
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    public void addItems(Item item){
        items.add(item);  
    }
    public ArrayList<Item> getRoomItems()
    {
        return items;
    }
    public Item getItem(String itemName)
    {
        for (int i =0; i < items.size(); i++)
        {
            if (items.get(i).getItemName().equalsIgnoreCase(itemName)){
            return items.get(i);
            }
        }
        return null;
    }
    
    public void removeItem(Item item)
    {
        for(int i =0; i < items.size(); i++)
        {
            if(items.get(i) == item){
                items.remove(item);
                break;
            }
            
        }
        
    }
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

