//Sharath Menon Programming Assignment 5
//file manages the appointment class derived from the occasion class

public class funOccasion extends event {

    //variables for the occasion class
    private String activity;
    private String information;

    //default constructor for the recreation class
    public funOccasion(){
        this.activity = null;
        this.information = null;
        this.head = null;
        this.location = null;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = 0;
        }
    }

    //copy constructor for the recreation class
    public funOccasion(final funOccasion toCopy){
        this.activity = toCopy.activity;
        this.information = toCopy.information;
        this.head = null;
        this.location = toCopy.location;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = toCopy.timeDate[i];
        }
    }

    //extended constructor for the recreation class
    public funOccasion(String setActivity, String setInfo, String addLocation, int day, int month, int year, int hour, int minute){
        this.activity = setActivity;
        this.information = setInfo;
        this.location = addLocation;
        this.timeDate[0] = month;
        this.timeDate[1] = day;
        this.timeDate[2] = year;
        this.timeDate[3] = hour;
        this.timeDate[4] = minute;
    }


    //virtual display function for recreation
    public void displayEvent(){
        System.out.println("TYPE OF ACTIVITY:  " + this.activity);
        System.out.println("FOCUS OF ACTIVITY: " + this.information);
        System.out.println("LOCATION:          " + this.location);
        System.out.println("DATE:              " + this.timeDate[0] + "/" + this.timeDate[1] + "/" + this.timeDate[2] + "   " + this.timeDate[3] + ":" + this.timeDate[4]);
        displayList(this.head);
    }
}
