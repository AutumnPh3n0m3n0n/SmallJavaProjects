//Sharath Menon Programming Assignment 5
//file manages the appointment class derived from the event class

public class appointment extends event {

    //variables for the appointment class
    private String otherPerson;
    private String reason;

    //default constructor for the appointments class
    public appointment(){
        this.otherPerson = null;
        this.reason = null;
        this.head = null;
        this.location = null;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = 0;
        }
    }

    //copy constructor for the appointments class
    public appointment(String setMeeting, String setReason, String addLocation, int day, int month, int year, int hour, int minute){
        this.otherPerson = setMeeting;
        this.reason = setReason;
        this.location = addLocation;
        this.timeDate[0] = month;
        this.timeDate[1] = day;
        this.timeDate[2] = year;
        this.timeDate[3] = hour;
        this.timeDate[4] = minute;
    }

    //copy constructor for the appointments class
    public appointment(final appointment toCopy){
        this.reason = toCopy.reason;
        this.otherPerson = toCopy.otherPerson;
        this.head = null;
        this.location = toCopy.location;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = toCopy.timeDate[i];
        }
    }

    //virtual display function for appointments
    public void displayEvent(){
        System.out.println("APPOINTMENT");
        System.out.println("MEETING WITH: " + this.otherPerson);
        System.out.println("REASON:       " + this.reason);
        System.out.println("LOCATION:     " + this.location);
        System.out.println("DATE:         " + this.timeDate[0] + "/" + this.timeDate[1] + "/" + this.timeDate[2] + "   " + this.timeDate[3] + ":" + this.timeDate[4]);
        displayList(this.head);
    }
}

