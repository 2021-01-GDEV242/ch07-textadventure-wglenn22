import java.util.*;
/**
 * Player class holds name, current room, and maximum weight of items a palyer can carry
 *
 * @author Wayne
 * @version 
 */
public class Player
{
    private String playerName;
    private Room currentRoom;
    private int inventoryWeight;
    private Stack<Room> rooms;
    private Item heldItem;
    private int playerStrength;
    public  ArrayList <Item>inventory = new ArrayList<Item>(); 
    
    /**
     * Constructor for objects of class player
     */
    public Player()
    {
        playerName ="";
        currentRoom = null;
        inventoryWeight = 50;
        rooms = new Stack<Room>();
        heldItem = null;
        playerStrength = 40;
    }
    public Player(String name, Room roomIn,int maxInv, int str)
    {
        this.playerName = name;
        this.currentRoom = roomIn;
        this.inventoryWeight = maxInv;
        rooms = new Stack<Room>();
        heldItem = null;
        this.playerStrength = str;
    }
    public void setHeldItem(Item selectedItem)
    {  
    
        heldItem = selectedItem;
    
    }
    public Item getHeldItem()
    {
        return heldItem;
    }
    public boolean Liftable(String itemName)
    {
        Item item = currentRoom.getItem(itemName);
        
        if(item == null){
        return false;
        }
         if(item.getWeight() < inventoryWeight && !alreadyHoldingSomething()) {
           
            
            return true;  
        
        }
        
        
        else{
            return false;
        }
        
    }
    public boolean Droppable(String itemName)
    {
       if(heldItem.getItemName().equalsIgnoreCase(itemName) && alreadyHoldingSomething()){
           
           return true;
        }
        else{
            return false;
        }
    }
    public boolean alreadyHoldingSomething()
    {
        if (heldItem != null){
            return true;
        }
        else{
            return false;
        }
    }
    public void pickupItem(String itemName)
    {
        if (Liftable(itemName)){
         Item item = currentRoom.getItem(itemName);
         setHeldItem(item);
         currentRoom.removeItem(item);
         
         System.out.println("You've picked up the item.");
         
        }
        else{
            if(alreadyHoldingSomething()){
                System.out.print("You are already holding something");
            }
            else{
                System.out.println("Sorry, charlie no such item is around...");
            }
            return;
        }
        
    }
    /**
     * Set player name
     */
    public void setPlayerName(String plName){
      this.playerName = plName;  
    }
    /**
     * Get player name
     */
    public String getPlayerName()
    {
        return this.playerName;
    }
    public void setPlayerStrength(int str)
    {
        this.playerStrength = str;
    }
    public int getPlayerStrength()
    {
        return playerStrength;
    }
    /**
     * Set current room
     */
    public void setCurrentRoom(Room roomIn){
        
        this.currentRoom = roomIn;
    }
    /**
     * Get current room
     */
    public Room getCurrentRoom()
    { 
       return this.currentRoom;
    }
    /**
     * Set inventory weight
     */
    public void setMaximumInventory(int maxInv){
        this.inventoryWeight = maxInv;
    }
   
    /**
     * Get inventory weight
     */
    public int getMaximumInventory()
    {
        return inventoryWeight;
    }
    /**
     * player description
     *
     * @param    a sample parameter for a method
     * @return    result
     */
    public String getPlayerDescription()
    {
        String result = "Player "+playerName+":";
        
        if(heldItem != null){
          result += "You are holding" + heldItem.getItemName(); 
          
        }
        
        result += currentRoom.getLongDescription();
        return result;
    }
    public Room getPlayerExit(String direction)
    {
        return currentRoom.getExit(direction);
    }
    
    
    public void setPlayersNextRoom(Room nextRoom){
        rooms.push(currentRoom);
        currentRoom = nextRoom;
    }
    public void movePlayerBackwards()
    { if(rooms.empty())
        {System.out.println("Its no good, you're back to where you were first lost already");
        
    }
    else{
        currentRoom = rooms.pop();
        System.out.println("Player " +playerName+": ");
        if(heldItem != null){
         System.out.println("You are holding" + heldItem.getItemName()); 
        }
        System.out.println(currentRoom.getLongDescription());
    }
    }
    public void summonFairy(){
    if(inventoryWeight + playerStrength < 100){
        System.out.println("You have summoned the fairy");
        inventoryWeight += 50;
        playerStrength += 50;
    }
        else{
            System.out.println("You can't call the fairy right now..");
            
        }
     
    }

    public void pickupTest(String itemName){
        ArrayList <Item> items = currentRoom.getRoomItems();
      boolean found = false;
      int n = 0;
     do{
         if(items.get(n).getItemName().equalsIgnoreCase(itemName)){
         found = true;
         
        }
        else{
            n++;
        }
        
        }
     while(!found && n < items.size());
     if(found){
     heldItem = items.remove(n);
     System.out.println(heldItem.getItemName());
        }
        else{
     System.out.println(found);
    }
        
    }
    public void dropTest(){
     ArrayList <Item> items = currentRoom.getRoomItems();
     
     if(heldItem != null){
         items.add(getHeldItem());
        System.out.println("You just dropped "+ getHeldItem().getItemName());
       setHeldItem(null);
        }
        else{
        System.out.println("But you're not holding anything...");
        }
    }
    public void addItemToInventory(String itemName){
      
        
        
        
        if(heldItem != null){
         inventory.add(heldItem);  
          System.out.println("You just dropped "+ getHeldItem().getItemName());
       setHeldItem(null);
        }
       
        else{
        System.out.println("Unable to add item to inventory...");
        }
        
    }
  public void removeItemFromInventory(String itemName){
    
    boolean empty = inventory.isEmpty();  
      
      if(empty == true){
      System.out.println("There is nothing in your inventory...");
    }
    else{
       inventory.remove(itemName);   
    }
    
}
public ArrayList<Item> displayInventory(){
 return inventory;
    
}
}
