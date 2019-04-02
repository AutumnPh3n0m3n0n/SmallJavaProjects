//Sharath Menon Programming Assignment 5
//main file for the fifth programming assignment

import java.util.Scanner;

public class Program5 {
    public static void main(String args[]) {
        //have all the variables ready
        Scanner toRead = new Scanner(System.in);
        event toPutInsert;
        char choice;
        char again;
        String subject1;
        String subject2;
        String setLocation;
        String getDetail;
        int year = 2018;
        int minute, hour, day, month;

        eventArray DataStructure = new eventArray();
        DataStructure.importData();
        System.out.println("The events have been uploaded!");
        System.out.println("Welcome to Sharath's event planning program.");
        System.out.println("The time uses the international 24-hour format instead of the standard 12-hour format.");
        System.out.println("8:30 means 8:30AM and 20:30 means 8:30PM. 12:00 means noon and 00:00 means midnight");
        System.out.println("The year is 2018 by default but you can adjust the time and date.\n");

        do {
            do {
                System.out.println("Enter an A to set an appointment");
                System.out.println("Enter an E to set an appointment");
                System.out.println("Enter an O for another type of event");
                choice = toRead.next().charAt(0);
                choice = Character.toUpperCase(choice);
            } while (choice != 'A' && choice != 'E' && choice != 'O');

            if (choice == 'A') {
                System.out.println("You have selected Appointment");
                System.out.print("Who are you meeting with?   ");
                subject1 = toRead.next();
                System.out.print("What is the purpose of this appointment   ");
                subject2 = toRead.next();
            } else if (choice == 'E') {
                System.out.println("You have selected Exam");
                System.out.print("What if the exam about?   ");
                subject1 = toRead.next();
                System.out.print("How difficult is this exam?  ");
                subject2 = toRead.next();
            } else {
                System.out.println("You have selected Other");
                System.out.print("What other event is this?   ");
                subject1 = toRead.next();
                System.out.print("What is the purpose of this appointment   ");
                subject2 = toRead.next();
            }
            System.out.print("Where is this event's location?   ");
            setLocation = toRead.next();
            System.out.println("Enter the date and time for the event. The hours are in   ");
            do {
                System.out.print("MONTH (enter number between 1 and 12):   ");
                month = toRead.nextInt();
                toRead.nextLine();
            } while (month > 12 || month < 1);
            do {
                System.out.print("DATE (enter number between 1 and 31):    ");
                day = toRead.nextInt();
                toRead.nextLine();
            } while (day > 31 || day < 1);
            do {
                System.out.print("HOUR( enter number between 0 and 23):    ");
                hour = toRead.nextInt();
                toRead.nextLine();
            } while (hour > 23 || hour < 0);
            do {
                System.out.print("MINUTE (enter number between 0 and 60):  ");
                minute = toRead.nextInt();
                toRead.nextLine();
            } while (minute >= 60 || minute <= 0);

            if (choice == 'A') {
                toPutInsert = new appointment(subject1, subject2, setLocation, day, month, year, hour, minute);
            } else if (choice == 'E') {
                toPutInsert = new exam(subject1, subject2, setLocation, day, month, year, hour, minute);
            } else {
                toPutInsert = new funOccasion(subject1, subject2, setLocation, day, month, year, hour, minute);
            }
            do {
                System.out.print("Enter in a detail:  ");
                getDetail = toRead.next();
                toPutInsert.insertDetail(getDetail);
                System.out.print("Would you like to enter in another detail? (Press Y for Yes)   ");
                again = toRead.next().charAt(0);
                again = Character.toUpperCase(again);
            } while (again == 'Y');

            DataStructure.setToArray(toPutInsert);

            System.out.print("Would you like to insert another entry: Press Y for Yes)  ");
            again = toRead.next().charAt(0);
            again = Character.toUpperCase(again);
        } while (again == 'Y');

        System.out.println("Here is the data structure:  ");

        //display the data structure
        DataStructure.displayData();
    }

}
