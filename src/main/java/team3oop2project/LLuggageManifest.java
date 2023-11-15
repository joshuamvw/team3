package team3oop2project;

//Joshua Valentine Williams 816029885
import java.util.ArrayList;
public class LLuggageManifest 
{
    private ArrayList<LLuggageSlip> slips;
    
    //Accessors
    
    private ArrayList<LLuggageSlip> getSlips()
    {
        return slips;
    }
    
    //Constructor
    public LLuggageManifest()
    {
        slips = new ArrayList<LLuggageSlip>();
    }
    
    public String addLuggage(PPassenger p, FFlight f)
    {
        String output;
        LLuggageSlip temp ;
        int numLuggage = p.getNumLuggage();
        double numAllowed = (f.getAllowedLuggage(p.getCabinClass()));
        int numExcess = numLuggage - (int)numAllowed;
        String label;
        
        if(numLuggage == 0)
        {
            output = p.toString() + "\nNo Luggage to add.";
        }
        else
        {
            
            
            if(numExcess <= 0)
            {
                numExcess = 0;
                for(int x = 0; x < numLuggage; x++)
                {
                    temp = new LLuggageSlip(p, f);
                    slips.add(temp);
                }
            }
            else{
                label = "" + getExcessLuggageCost(numLuggage, (int)numAllowed);
                for(int x = 0; x < numLuggage; x++)
                {
                    temp = new LLuggageSlip(p, f, label);
                    slips.add(temp);
                }
            }

            
            output = p.toString() + "\nPieces Added: (" + numLuggage + ") Excess Cost: " + getExcessLuggageCostByPPassenger(p.getPassportNumber());
            
            
        }
        
        return output;
    }
    
    private double getExcessLuggageCost(int numPieces, int numAllowedPieces)
    {
        // put your code here
        double x;
        if(numPieces > numAllowedPieces)
        {
            x = (numPieces - numAllowedPieces) * 35;
        }
        else
        {
            x = 0;
        }
        
        return x;
    }
    
    public String getExcessLuggageCostByPPassenger(String passportNumber)
    {
        LLuggageSlip slip;
        int luggageCount;
        PPassenger tempPPassenger;
        char type;
        int numAllowed = 0;
        
        
        int i = 0;
        slip = slips.get(i);
        
        while(i < slips.size() && slip.hasOwner(passportNumber) == false)
        {
            slip = slips.get(i);
            i++;
        }
        tempPPassenger = slip.getOwner();
        luggageCount = tempPPassenger.getNumLuggage();
        type = tempPPassenger.getCabinClass();
        
        //hmmmmm
        if(type == 'F'){
            numAllowed = 3;
        }
        if(type == 'B'){
            numAllowed = 2;
        }
        if(type == 'P'){
            numAllowed = 1;
        }
        if(type == 'E'){
            numAllowed = 0;
        }
        //hmmmmm
        
        
        String output = "$" + getExcessLuggageCost(luggageCount, numAllowed);
        return output;
        
    }
    
    public String toString()
    {
        String information = "LUGGAGE MANIFEST:";
        LLuggageSlip temp2;
        
        for(int i = 0; i < this.slips.size() ; i++)
        {
            temp2 = slips.get(i);
            information += "\n";
            information += temp2.toString();
        }
        
        return information;
    }
}
