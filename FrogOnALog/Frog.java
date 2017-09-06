

public class Frog
{
    private String name;
    private String colour;
    private int position;
    
    public static int frogCout;
    
    public Frog(String name, String colour, int position)
    {
        this.name = name;
        this.colour = colour;
        this.position = position;
        
        frogCout++;
    }
    
    @Override
    public String toString()
    {
        return (this.name + ", " + this.colour + ", " + this.position);
    }
    
    //Getters
    public String getName() {return name;}
    public String getColour() {return colour;}
    public int getPosition() {return position;}
    public static int getFrogCout() {return frogCout;}
    
    //setters
    public void setName(String name) {this.name = name;}
    public void setColour(String colour){this.colour = colour;}
    public void setPosition(int position){this.position = position;}
}
