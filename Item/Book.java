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

public Book(String id, String name, String author, int yearOfPublication, int numberOfPages){

    super(name,author,yearOfPublication);
    this.numberOfPages=numberOfPages;
    this.id = "B" + (int)(Math.random() * 9000000);

}


 // Copy Constructor

 public Book(Book otherBook){
    super(otherBook);
    this.numberOfPages=otherBook.numberOfPages;


 }

//getter


public int getNmuberOfPages(int numberOfPages){
    return numberOfPages;
}
 




    
}
