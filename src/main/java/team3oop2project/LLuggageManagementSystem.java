package team3oop2project;

//Joshua Valentine Williams 816029885
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class LLuggageManagementSystem
{
    public static void main( String[] args)
    {
        /*  =>  This is simply the test ;3
        LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 00, 00);
        FFlight yyz = new FFlight("BW600", "POS", "YYZ", d);
        
        System.out.println(yyz);
        PPassenger p;
        String[] pps = {"TA890789", "BA321963", "LA445241"};
        String[] firstNames = {"Joe", "Lou", "Sid"};
        String[] lastNames = {"Bean", "Deer", "Hart"};
        
        for(int i = 0; i<3; i++)
        {
            p = new PPassenger(pps[i], firstNames[i], lastNames[i], "BW600");
            System.out.println(p);
            System.out.println(yyz.checkInLuggage(p));
        }
        System.out.println(yyz.printLLuggageManifest());
        */
        String flightNo, destination, origin;
        String passportNumber, firstName, lastName;
        LocalDateTime flightDate;
        //ignore this below
        flightDate = LocalDateTime.of(2023, 1, 1, 10, 00, 00);
        //ignore this above
        int d1, d2, d3, d4, d5, d6, i = 0;
        Scanner myReader, myReader2;
        ArrayList<FFlight> yyz = new ArrayList<FFlight>();
        FFlight tempFFlight = new FFlight("Just", "Ignore", "This", flightDate);
        
        //FFlights reading and printing
        System.out.println("FFlights:\n");
        try{
            File inputFFlights = new File("Assignment1FFlights.txt");
            myReader = new Scanner(inputFFlights);
            while (myReader.hasNext()) {
                flightNo = myReader.next();
                destination = myReader.next();
                origin = myReader.next();
                
                d1 = Integer.valueOf(myReader.next());
                d2 = Integer.valueOf(myReader.next());
                d3 = Integer.valueOf(myReader.next());
                d4 = Integer.valueOf(myReader.next());
                d5 = Integer.valueOf(myReader.next());
                d6 = Integer.valueOf(myReader.next());
                
                flightDate = LocalDateTime.of(d1, d2, d3, d4, d5, d6);
                tempFFlight = new FFlight(flightNo, destination, origin, flightDate);
                yyz.add(tempFFlight);
                System.out.println(tempFFlight);
                
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred! Assignment1FFlights.txt not found.");
            e.printStackTrace();
        }
        System.out.println("\n");
        
        
        //PPassengers reading and printing
        System.out.println("PPassengers:\n");
        try{
            File inputPPassengers = new File("Assignment1PPassengers.txt");
            myReader2 = new Scanner(inputPPassengers);
            PPassenger p;
            while (myReader2.hasNext()) {
                passportNumber = myReader2.next();
                firstName = myReader2.next();
                lastName = myReader2.next();
                flightNo = myReader2.next();
                
                p = new PPassenger(passportNumber, firstName, lastName, flightNo);
                
                for(int x = 0; x < yyz.size(); x++)
                {
                    if(  (yyz.get(x).getFFlightNo()).equals(flightNo)  )
                    {
                        tempFFlight = yyz.get(x);
                    }
                }
                
                System.out.println(tempFFlight.checkInLuggage(p));
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred! Assignment1PPassengers.txt not found.");
            e.printStackTrace();
        }
        System.out.println("\n");
        
        
        //Manifests
        String output;
        
        for(int y = 0 ; y < yyz.size() ; y++)
        {
            // output = "LUGGAGE MANIFEST FOR FLIGHT " + yyz.get(y).getFFlightNo() + ":" ;
            // System.out.println(output);
            // System.out.println("\n");
            System.out.println("FFlight " + yyz.get(y).getFFlightNo() + " " + yyz.get(y).printLLuggageManifest());
            System.out.println("\n");
        }
    }
}
