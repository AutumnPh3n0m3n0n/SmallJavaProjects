//Sharath Menon Programming Assignment 5
//file manages the appointment class derived from the exam class

public class exam extends event {

    //variables for the exam class
    private String subject;
    private String difficulty;

    //default constructor for the exam class
    public exam(){
        this.subject = null;
        this.difficulty = null;
        this.head = null;
        this.location = null;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = 0;
        }
    }

    //copy constructor for the exam class
    public exam(final exam toCopy){
        this.subject = toCopy.subject;
        this.difficulty = toCopy.difficulty;
        this.head = null;
        this.location = toCopy.location;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = toCopy.timeDate[i];
        }
    }

    //extended constructor for the exam class
    public exam(String setSubject, String setDifficulty, String addLocation, int day, int month, int year, int hour, int minute){
        this.subject = setSubject;
        this.difficulty = setDifficulty;
        this.location = addLocation;
        this.timeDate[0] = month;
        this.timeDate[1] = day;
        this.timeDate[2] = year;
        this.timeDate[3] = hour;
        this.timeDate[4] = minute;
    }


    //virtual display function for exams
    public void displayEvent(){
        System.out.println("EXAMS:");
        System.out.println("TEST SUBJECT: " + this.subject);
        System.out.println("DIFFICULTY:   " + this.difficulty);
        System.out.println("LOCATION:     " + this.location);
        System.out.println("DATE:         " + this.timeDate[0] + "/" + this.timeDate[1] + "/" + this.timeDate[2] + "   " + this.timeDate[3] + ":" + this.timeDate[4]);
        displayList(this.head);
    }
}
