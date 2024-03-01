package Item;

//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

public abstract class Item {
  
protected String id;
protected String name;
protected String author;
protected int yearOfPublication;
protected boolean isAvailable;




//default constructor
public Item(){

    this.id="";
    this.name="";
    this.author = "";
    this.yearOfPublication=0;
    this.isAvailable = true;



}

//parameterized constructor

public Item(String name, String author, int yearOfPublication){

   
    this.name=name;
    this.author = author;
    this.yearOfPublication=yearOfPublication;
    this.isAvailable = true;


}

//copy constructor

public Item(Item otherItem){

   
    this.name=otherItem.name;
    this.author = otherItem.author;
    this.yearOfPublication=otherItem.yearOfPublication;
    this.isAvailable = true;

}

//getter

public String getId(){

    return id;

}


public String getName(){

    return name;

}

public String getAuthor(){

    return author;

}


public int getYearOfPublication(){
    
    return yearOfPublication;

}

public boolean IsAvailable(){
    return isAvailable;
}


//setter

/*
public void setId(String id){

    this.id=id;
} 
*/


public void setName(String name){

    this.name=name;
}


public void setAuthor(String author){

    this.author=author;
}

public void setYearOfPublication(int yearOfPublication){

    this.yearOfPublication=yearOfPublication;


}

public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
}





//toString 

@Override

public String toString(){


    return" ID "+ id+" Name "+name+ "Author" + author + "Year of  Publication "+ yearOfPublication;

}




//equals

@Override
public boolean equals(Object obj) {
 
    if(obj ==null||getClass()!=obj.getClass())

    return false;



    Item other=(Item) obj;



    if(name.equals(other.name)&&yearOfPublication==(other.yearOfPublication))
    
    return true;

    else

    return false;
}






    
}
