package team3oop2project;

//Joshua Valentine Williams 816029885
import java.time.LocalDateTime;
public class FFlight
{
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LLuggageManifest manifest;

    //Accessors
    
    public String getFFlightNo(){
        return flightNo;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public LocalDateTime getFFlightDate(){
        return flightDate;
    }
    
    public LLuggageManifest getManifest(){
        return manifest;
    }
    
    //Constructor
    
    public FFlight(String flightNo, String destination, String origin, LocalDateTime flightDate)
    {
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = new LLuggageManifest();
    }

    public String checkInLuggage(PPassenger p)
    {
        String output = "Invalid flight";
        if((this.flightNo).equals(p.getFFlightNo()))
        {
           output = this.manifest.addLuggage(p, this);
        }
        
        return output;
    }
    
    public String printLLuggageManifest( )
    {
        String output2 = this.manifest.toString();
        return output2;
    }
    
    public int getAllowedLuggage(char cabinClass)
    {
        if(cabinClass == 'F'){
            return 3;
        }
        if(cabinClass == 'B'){
            return 2;
        }
        if(cabinClass == 'P'){
            return 1;
        }
        if(cabinClass == 'E'){
            return 0;
        }
        
        return -1;
    }
    
    public String toString()
    {
        String information = getFFlightNo() + " DESTINATION: " + getDestination() + " ORIGIN: " + getOrigin() + " " + getFFlightDate();
        return information;
    }
}
