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
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.*;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    private Room rooms[];
    private Scanner reader;
    private Player player;
    
    private int top;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        
        parser = new Parser();
        player = new Player();
        reader = new Scanner(System.in);
        
        rooms = new Room[50];
        top=-1;
    }
 
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room start, forestRight, forestLeft, forestBed, deepForest, 
        lowerDeepForest, deepDeepforest, deeperForest,lightClearing,deeperForestright
        ,upperForest,upperupperForest,northernForest,foolsForest,northForest,
        northwestForest,mistyForest,clearforestpath,foolinForest,clearForest,exit;
      
        Item lowerDeepForest_item, deepDeepforest_item, deeperForest_item,deeperForestright_item
        ,upperForest_item,upperupperForest_item,northernForest_item,foolsForest_item,northForest_item,
        northwestForest_item,mistyForest_item,clearforestpath_item,foolinForest_item,clearForest_item,exit_item
        ,fairy;
        
        
        //Create items
        
        
        //Item forestRight_item[] = {new Item("A rock","Looks skimable",10),
                                   //new Item("Moss covered stump","Hmm, doesnt moss point towards civilization?",45),
                                  // new Item("Fallen beehive","Looks empty",2)};
        
        
  
        
        mistyForest_item = new Item("Old nametag","Hmm its blank..",2);
        
        // create the rooms
        start = new Room("Lost in the forest of death");
        start.addItems(new Item("A stick","a thin stick",1));
        start.addItems(new Item("Crushed soda can","looks like a diet pepsi can",2));
        
        
        forestRight = new Room("In the right forrest");
        forestRight.addItems(new Item("A rock","Looks skimable",10));
        forestRight.addItems(new Item("Moss covered stump","Hmm, doesnt moss point towards civilization?",45));
        forestRight.addItems(new Item("Fallen beehive","Looks empty",2));
        
        forestLeft = new Room("In the forest left");
        forestLeft.addItems(new Item("Rusted key","Why would there be a door in a forest?",5));
        forestLeft.addItems(new Item("Crumbled paper","Its illegible",1));
        forestLeft.addItems(new Item("Animal carcus","Remains of a small animal",2));
        
        
        forestBed = new Room("In a computing lab");
        forestBed.addItems( new Item("Empty bottle","Smells like lavander",7));
        forestBed.addItems(new Item("Pink fairy dust","Do I hear an ocarina?",.05));
        
        
        deepForest = new Room("In the deep forest");
        deepForest.addItems(new Item("Rusted pendant","I wonder if its made of a precious metal",2));
        deepForest.addItems(new Item("Kazoo","I wonder if I blow it loud enough will help come?", 1.5)); 
        
        
        lowerDeepForest = new Room("In the lower deep forest");
        
        
        deepDeepforest = new Room("In the deep deep forest");
        lightClearing = new Room("In the light clearing");
        lightClearing.addItems(new Item("Creepy statuette","Looks familar...",7));
                              
      
        deeperForest = new Room("In the deeper forest");
        deeperForestright = new Room("In the deeper forest right");
        upperForest = new Room("In the upper forest");
        upperupperForest = new Room("In the upper Upper Forest");
        
        northernForest = new Room("In the northern Forest");
        northernForest.addItems(new Item(" Broken comapss","If only it worked..",6));
        
        
        
        foolsForest = new Room("Another Dead End");
        northForest = new Room("In the North Forest");
        northForest.addItems(new Item("Birds Nest","Could be useful..",4));
        
        
        
  
        northwestForest = new Room("In the northwest Forest");
        mistyForest = new Room("In the misty Forest");
        
        clearforestpath = new Room("In the clear forest path");
        foolinForest = new Room("In the foolin forest");
        clearForest = new Room("In the clear Forest");
        exit = new Room ("You are home free");
        
        
        // initialise room exits
        start.setExit("east", forestRight);
        start.setExit("south", forestBed);
        start.setExit("west", forestLeft);

        forestRight.setExit("west", start);

        forestLeft.setExit("east", start);

        forestBed.setExit("north", start);
        forestBed.setExit("east", deepForest);

        deepForest.setExit("west", forestBed);
        
        lowerDeepForest.setExit("north", deepForest);
        lowerDeepForest.setExit("south", deepDeepforest);
        
        
        deepDeepforest.setExit("north",lowerDeepForest);
        deepDeepforest.setExit("east", deeperForest);
        
        
        deeperForest.setExit("north", lightClearing);
        deeperForest.setExit("west",deepDeepforest);
        deeperForest.setExit("east",deeperForestright);
        
        deeperForestright.setExit("west",deeperForest);
        deeperForestright.setExit("north",upperForest);
        
        upperForest.setExit("north",upperupperForest);
        upperForest.setExit("south",deeperForest);
        
        upperupperForest.setExit("north",northernForest);
        upperupperForest.setExit("south",upperForest);
        
        
        northernForest.setExit("north",northForest);
        northernForest.setExit("south",upperForest);
        northernForest.setExit("west",foolsForest);
        
        foolsForest.setExit("east",northernForest );
        
        northForest.setExit("north", mistyForest);
        northForest.setExit("west", northwestForest );
        northForest.setExit("south", northernForest);
        
        mistyForest.setExit("south", northForest);
        mistyForest.addItems(new Item("Old nametag","Hmm its blank..",2));
        mistyForest.addItems(new Item("Fairy","Phae",1));
        
        
        northwestForest.setExit("east",northForest);
        northwestForest.setExit("north",clearforestpath);
        
        clearforestpath.setExit("north",clearForest);
        clearforestpath.setExit("west",foolinForest);
        clearforestpath.setExit("south",northwestForest);
        
        
        foolinForest.setExit("east", clearforestpath);
        
        
        clearForest.setExit("east", exit);
        clearForest.setExit("south", clearforestpath);
        
        exit.setExit(null, null);
        

        //currentRoom = start;  // start game outside
        player.setCurrentRoom(start);
        
        lastRoom = null;
        
        
    }
    private void createPlayer()
    {
        System.out.println("What was my name again?");
        String name = reader.nextLine();
        player.setPlayerName(name);
        createRooms();
        int strength = 40;
        int weight = 50;
        player.setMaximumInventory(weight);
        
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        createPlayer();
        
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
        System.out.println("Welcome to the forest of death");
        System.out.println("Can you escape?");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
        System.out.println();
        //createPlayer();
        System.out.println("I remember now, my name is " +player.getPlayerName());
        //System.out.println(player.getPlayerDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                 look();
                 break;
            case EAT:
                System.out.println("Yummy,yum,yum, yummy in my tummy tum, tum, tummy");
                break;
                
            case BACK:
                 backRoom();
                 break;
                 
            case PICKUP:
                 pickup(command);
                 break;
                 
            case DROP:
                 drop(command);
                 break;
                 
            case ADD:
                 add(command);
                 break;
            
            case ITEMS:
                 items(command);
                 break;
                 
            case SUMMON:
                 summonFairy(command);
                 break;
        }
        return wantToQuit;
    }
    /*
    private void pickup(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Please name the item to be picked up");
            return;
        }
        String itemName = command.getSecondWord();
        
        player.pickupItem(itemName);
    }
    */
    private void drop(Command command){
     player.dropTest();   
        
    }
    /**
     * Go to the last room and gives rundown on the room
     */
    
    private void backRoom()
    {
        
        player.movePlayerBackwards();
    }
    /**
     * Add room that the player is in to stack
     */
    private void push(Room room)
    {
        if(top == rooms.length-1){
          System.out.println("Room stack is at capacity");  
        }
        else{
          rooms[++top] = room;  
        }
    }
    private Room pop(){
     if(top < 0){
     System.out.println();
     return null;
        }
       else{
           return rooms[top--];
       
    }
    }
    
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the forest.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
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
        Room nextRoom = player.getPlayerExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //push(currentRoom); 
            //currentRoom = nextRoom;
            player.setPlayersNextRoom(nextRoom);
            System.out.println(player.getPlayerDescription());
        }
    }
    /**
    *Provides a discription of current room
    */
    private void look()
    {
      System.out.println(currentRoom.getLongDescription() + currentRoom.getItemsInRoom());  
        
    }
    private Room addItemsToRoom(Room room, Item items[]){
    for(int i = 0; i < items.length; i++){
        room.addItems(items[i]);
        
    }
    return room;
    
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
    public void summonFairy(Command command){    
        
        
        
        if(player.getHeldItem().equals("fairy")){
        player.summonFairy();
    }
    }
    public void pickup(Command command){
        System.out.println("Which item do you want to pickup?");
        String itemName = reader.nextLine();
        player.pickupTest(itemName);
        
        
    }
    public void add(Command command){
     System.out.println("Which item do you want to add to inventory?"); 
     String itemName = reader.nextLine();
     
     player.addItemToInventory(itemName);
    }
    public void items(Command command){
        
    System.out.println(player.displayInventory());    
    }
}
