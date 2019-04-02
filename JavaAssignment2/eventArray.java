//Sharath Menon Programming Assignment 5
//this file manages the functions and prototypes for the class that manages the array of events class
//import the libraries
import java.io.BufferedReader;
import java.io.FileReader;

public class eventArray {

    //private variables
    private event [] tracker;
    private int eventCount;

    //default constructor for the array class
    public eventArray(){
        this.tracker = new event[40];
        this.eventCount = 0;
    }

    //function to have the count
    public void getCount(){
        //output how many entries are stores and how many entries can be stored
        int remaining = 40 - this.eventCount;
        System.out.println("There are " + this.eventCount + " events in this tracker.");
        System.out.println("You have space for " + remaining + " more entries.");
    }

    public void importData(){

        event toInitial;
        char typeOccasion;
        int month, date, year, hour, minute;
        String firstSubject;
        String secondSubject;
        String toLocation;
        String firstDetail;
        String secondDetail;
        String thirdDetail;
        //the importing function has a try and catch block in case the importing function does not work properly
        try{
            FileReader toRead = new FileReader("events.txt");
            BufferedReader getBuffered = new BufferedReader(toRead);

            String aLine;
            //take a line from the file and parse it
            //thus separating the variables by the delimiter semicolon
            while ((aLine = getBuffered.readLine()) != null) {
                System.out.println(aLine);
                String[] toArray = aLine.split(";");
                typeOccasion = toArray[0].charAt(0);
                firstSubject = toArray[1];
                secondSubject = toArray[2];
                toLocation = toArray[3];
                month = Integer.parseInt(toArray[4]);
                date = Integer.parseInt(toArray[5]);
                year = Integer.parseInt(toArray[6]);
                hour = Integer.parseInt(toArray[7]);
                minute = Integer.parseInt(toArray[8]);
                firstDetail = toArray[9];
                secondDetail = toArray[10];
                thirdDetail = toArray[11];

                //filter by type of event
                if (typeOccasion == 'A') {
                    toInitial = new appointment(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }
                else if (typeOccasion == 'E') {
                    toInitial = new exam(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }
                else {
                    toInitial = new funOccasion(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }

                toInitial.insertDetail(firstDetail);
                toInitial.insertDetail(secondDetail);
                toInitial.insertDetail(thirdDetail);

                setIndices(toInitial, eventCount);
                ++this.eventCount;
            }
            toRead.close();

        }
        catch(Exception err){err.printStackTrace();}

    }

    //function to initialize to the array
    public void setToArray(event toInitial){
        setIndices(toInitial, eventCount);
        ++this.eventCount;
    }

    //this function uses the eventCount number to set an event to the array index
    public void setIndices(event toInitial, int toIndex){
        this.tracker[toIndex] = toInitial;
    }

    //function to display the entire data structure
    public void displayData(){
        for (int i = 0; i < eventCount; ++i){
            this.tracker[i].displayEvent();
        }
    }
}
