package team3oop2project;


//Joshua Valentine Williams 816029885
public class LLuggageSlip
{
    private PPassenger owner;
    private static int luggageSlipIDCounter = 0;
    private String luggageSlipID;
    private String label;

    //Accessors
    
    public PPassenger getOwner(){
        return owner;
    }
    
    public int getLLuggageSlipIDCounter(){
        return luggageSlipIDCounter;
    }
    
    public String getLLuggageSlipID(){
        return luggageSlipID;
    }
    
    public String getLabel(){
        return label;
    }
    
    //Constructor 
    
    public LLuggageSlip(PPassenger p, FFlight f)
    {
        this.owner = p;
        luggageSlipIDCounter += 1;
        this.luggageSlipID = p.getFFlightNo() +  "_" + p.getLastName() +  "_" + getLLuggageSlipIDCounter();
        this.label = "";
    }

    public LLuggageSlip(PPassenger p, FFlight f, String label)
    {
        // initialise instance variables
        this.owner = p;
        luggageSlipIDCounter += 1;
        this.luggageSlipID = p.getFFlightNo() +  "_" + p.getLastName() +  "_" + getLLuggageSlipIDCounter();
        this.label = label;
    }
    
    public boolean hasOwner(String passportNumber)
    {
        if(this.owner.getPassportNumber() == passportNumber)
        {
            return true;
        }
        
        return false;
    }
    
    public String toString()
    {
        String information;
        if(getLabel() == "")
        {
            information = getLLuggageSlipID() + " " + getOwner().toString();
        }
        else
        {
            information = getLLuggageSlipID() + " " + getOwner().toString() + " $" + getLabel();
        }
        return information;
    }
}
