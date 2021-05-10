
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables 
    private String Description;
    private String name;
    private double Weight;
    
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        Description = "";
        name ="";
        Weight = 0.0;
    }
    /**
     * Sete the instance variables with parameter values
     */
    public Item(String name, String desc, double wgt)
    {
        this.name = name;
        Description = desc;
        Weight = wgt;
        
    }
    public String getItemName()
    {
        return name;
    }
    public double getWeight()
    {
       return Weight; 
    }
    /**
     * Returns a discription of items in a room
     * 
     * @return A description of the item weight
     */
    public String getItemDescription()
    {
        String itemName = "Item Name: "+ name + "\n";
        itemName += "Item Description: " + Description +"\n";
        itemName += "Item Weight: "+ Weight;
        
        itemName = itemName + "\n There is a fairy nearby!";
        return itemName;
    }
    
}
