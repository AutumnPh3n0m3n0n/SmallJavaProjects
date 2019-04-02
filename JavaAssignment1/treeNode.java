//Sharath Menon CS202 Programming Assignment 4
//this page manages the functions for the tree node class

public class treeNode {

    private events occasion;
    private treeNode left;
    private treeNode right;

    public treeNode(){
        this.occasion = null;
        this.left = null;
        this.right = null;
    }

    //copy constructor for tree node
    public treeNode(final treeNode toCopy){
        if (toCopy.occasion instanceof exams){
            this.occasion = new exams ((exams)(toCopy.occasion));}
        else if (toCopy.occasion instanceof appointments){
            this.occasion = new appointments ((appointments)(toCopy.occasion));}
        else if (toCopy.occasion instanceof recreation){
            this.occasion = new recreation ((recreation)(toCopy.occasion));}

        this.left = null;
        this.right = null;
    }

    //function to set the event in the node
    public void setEvent(events addEvent){
        this.occasion = addEvent;
    }

    //function to set the node's left pointer
    public void setLeft(treeNode addLeft){
        this.left = addLeft;
    }

    //function to set the node's right pointer
    public void setRight(treeNode addRight){
        this.right = addRight;
    }

    //function to get the node's left pointer
    public treeNode getLeft(){
        return this.left;
    }

    //function to set the node's right pointer
    public treeNode getRight(){
        return this.right;
    }

    public void displayTNode(){
        this.occasion.displayEvent();
    }

    public boolean laterThan(treeNode toComparing){
        boolean ifLater = this.occasion.laterThan(toComparing.occasion);
        return ifLater;
    }
}
