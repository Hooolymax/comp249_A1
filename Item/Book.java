package Item;

//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

public class Book extends Item{

    private int numberOfPages; 



// Default Constructor

public Book(){

    super();
    this.numberOfPages=0;

}

// Parameterized Constructor

public Book(String name, String author, int yearOfPublication, int numberOfPages){

    super(name,author,yearOfPublication);
    this.numberOfPages=numberOfPages;
    this.id = "B" + (int)(Math.random() * 9000000);

}


 // Copy Constructor

 public Book(Book otherBook){
    super(otherBook);
    this.numberOfPages=otherBook.numberOfPages;
    this.id = "B" + (int)(Math.random() * 9000000);


 }

//getter


public int getNmuberOfPages(){
    return numberOfPages;
}
 
public String toString() {
    return "Book [number Of Pages=" + numberOfPages + "]" + " ID "+ id+" Name "+name+ " Author " + author + " Year of  Publication "+ yearOfPublication;
}



    
}
