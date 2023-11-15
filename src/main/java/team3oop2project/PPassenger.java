package team3oop2project;

//Joshua Valentine Williams 816029885
import java.util.Random;
public class PPassenger
{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    //Accessors
    
    public String getPassportNumber(){
        return passportNumber;
    }
    
    public String getFFlightNo(){
        return flightNo;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getNumLuggage(){
        return numLuggage;
    }
    
    public char getCabinClass(){
        return cabinClass;
    }
    
    //Constructor
    
    public PPassenger(String passportNumber, String firstName, String lastName, String flightNo)
    {
        // initialise instance variables
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        assignRandomCabinClass();
    }

    private void assignRandomCabinClass( )
    {
        // put your code here
        Random r = new Random();
        int someRandomInt = r.nextInt(4);
        
        if(someRandomInt == 0)
        {   this.cabinClass = 'F';
        }
        if(someRandomInt == 1)
        {   this.cabinClass = 'B';
        }
        if(someRandomInt == 2)
        {   this.cabinClass = 'P';
        }
        if(someRandomInt == 3)
        {   this.cabinClass = 'E';
        }
        
        this.numLuggage = someRandomInt;
    }
    
    public String toString()
    {
        String information = "PP NO. " + getPassportNumber() + " NAME: " + getFirstName().substring(0,1) + "." + getLastName() + " NUMLUGGAGE: " + getNumLuggage() + " CLASS: " + getCabinClass();
        return information;
    }
}
