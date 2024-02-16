package Item;

//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

public class Journal extends Item{
    
    protected int volNum;
    protected int count = 0;

    public Journal(){
        super();
        this.volNum = 0;
        count++;
        this.id = "J" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

    public Journal(String name, String author, int yearOfPublication, int volNum){
        super(name, author, yearOfPublication);
        this.volNum = volNum;
        count++;
        this.id = "J" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

    public Journal(Journal aJournal){
        super(aJournal);
        this.volNum = aJournal.volNum;
        count++;
        this.id = "J" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

    public int getVolNum() {
        return volNum;
    }

    public void setVolNum(int volNum) {
        this.volNum = volNum;
    }



}