//Sharath Menon Programming Assignment 5

abstract public class event {

    protected listNode head;
    protected String location;
    protected int [] timeDate;

    //default constructor for events
    public event(){
        this.head = null;
        this.location = null;
        this.timeDate = new int[5];
        for (int i = 0; i < 5; ++i){
            this.timeDate[i] = 0;
        }
    }


    //extended constructor for events
    public event(String addLocation, int day, int month, int year, int hour, int minute){
        this.location = addLocation;
        this.timeDate[0] = month;
        this.timeDate[1] = day;
        this.timeDate[2] = year;
        this.timeDate[3] = hour;
        this.timeDate[4] = minute;
    }

    //this function compares two events to see if one event is later than another event
    //by comparing the dates and times
    //this function is for inserting into the tree
    public boolean laterThan(event toCompare){

        for (int j = 0; j < 5; ++j){
            if (this.timeDate[j] > toCompare.timeDate[j]){
                return true;
            }
        }
        return false;
    }

    //function to insert a detail
    public void insertDetail(String details){
        listNode temp = new listNode();
        temp.setDetail(details);
        if (this.head == null){
            this.head = new listNode(temp);
            return;
        }
        //insertLNode(this.head, temp);
        temp.setNext(this.head);
        this.head = temp;
        //this.head.displayLNode();
        displayList(this.head);
    }

    //private function to insert into the node
    protected listNode insertLNode(listNode head, listNode temp){
        if (head == null){
            head = new listNode(temp);
            return head;
        }
        head.setNext(insertLNode(head.getNext(), temp));

        //return the head
        return head;
    }

    //function to display the list
    //this function is protected so all the base classes can have access
    protected void displayList(listNode head){
        if(head == null)
            return;
        System.out.println("Displaying a detail");
        head.displayLNode();
        displayList(head.getNext());
    }

    //the pure abstract function for display event
    //this function is automatically implemented in the derived classes
    abstract public void displayEvent();
}
