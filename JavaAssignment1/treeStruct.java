//Sharath Menon CS202 Programming Assignment 4
//this is the function page for the bst data structure class

//import libraries
import java.io.BufferedReader;
import java.io.FileReader;


public class treeStruct {
    private treeNode root;

    //default constructor for the bst data structure class
    public treeStruct(){
        this.root = null;
    }

    //importing function
    public void importContents(){
        //have the set of variables
        events toInitial;
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
                    toInitial = new appointments(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }
                else if (typeOccasion == 'E') {
                    toInitial = new exams(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }
                else {
                    toInitial = new recreation(firstSubject, secondSubject, toLocation, date, month, year, hour, minute);
                }

                toInitial.insertDetail(firstDetail);
                toInitial.insertDetail(secondDetail);
                toInitial.insertDetail(thirdDetail);
                setTNode(toInitial);


            }
            toRead.close();

        }
        catch(Exception err){err.printStackTrace();}


    }

    //function to set the tree node event
    public void setTNode(events toInsert)
    {
        treeNode toPut = new treeNode();
        toPut.setEvent(toInsert);
        root = insertTNode(this.root, toPut);
    }


    //function to insert a tree node into the bst
    private treeNode insertTNode(treeNode root, treeNode toPut){
        if (root == null) {
            //toPut.displayTNode();
            root = new treeNode(toPut);
            return root;
        }
        //recursive functions to insert into the left or right subtrees
        else if (toPut.laterThan(root)) {
            root.setRight(insertTNode(root.getRight(), toPut));
        }
        else{
            root.setLeft(insertTNode(root.getLeft(), toPut));
        }
        return root;
    }

    //public wrapper function to display the data
    public void displayData(){
        if(this.root == null) {
            System.out.println("PROBLEM ROOT = NULL");
            return;
        }
        displayData(this.root);
    }

    //private recursive function to display the data
    private void displayData(treeNode root){
        if (root == null)
            return;
        root.displayTNode();
        //use recursion to traverse the tree
        displayData(root.getLeft());
        displayData(root.getRight());
    }
}
