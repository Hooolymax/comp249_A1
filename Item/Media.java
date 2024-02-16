package Item;
//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

public class Media extends Item{
    
    protected String type;
    protected int count = 0;

    public Media(){
        super();
        this.type = "n/a";
        count++;
        this.id = "M" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

    public Media(String name, String author, int yearOfPublication, String type){
        super(name, author, yearOfPublication);
        this.type = type;
        count++;
        this.id = "M" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

    public Media(Media aMedia){
        super(aMedia);
        this.type = aMedia.type;
        count++;
        this.id = "M" + ("0".repeat(7-Integer.toString(count).length())) + count;
    }

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
