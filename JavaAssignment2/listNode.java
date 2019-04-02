//Sharath Menon Programming Assignment 5
//file manages the linear linked list

public class listNode {

    protected listNode next;
    protected String details;

    //default constructor for the list node
    public listNode(){
        this.details = null;
        this.next = null;
    }

    //copy constructor for list node
    public listNode(final listNode toCopy){
        this.details = toCopy.details;
        this.next = null;
    }

    //function to set the next pointer
    public void setNext(listNode adding){
        this.next = adding;
    }

    //function to set the detail in the node
    public void setDetail(String details){
        this.details = details;
    }

    //function to get the next pointer
    public listNode getNext(){
        return this.next;
    }

    //function to display the node
    public void displayLNode(){
        System.out.println("NOTE:  " + this.details);
    }


}
