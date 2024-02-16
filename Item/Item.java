package Item;
//--------------------------------------------------------------------  
//Assignment 1
//Question 1
//Written by Jinghao Lai 40041316 and   
//--------------------------------------------------------------------


public class Item {
  
protected String id;
protected String name;
protected String author;
protected int yearOfPublication;


//default constructor
public Item(){

    this.id="";
    this.name="";
    this.author = "";
    this.yearOfPublication=0;



}

//parameterized constructor

public Item(String name, String author, int yearOfPublication){

   
    this.name=name;
    this.author = author;
    this.yearOfPublication=yearOfPublication;


}

//copy constructor

public Item(Item otherItem){

   
    this.name=otherItem.name;
    this.yearOfPublication=otherItem.yearOfPublication;


}

//getter

public String getID(){

    return id;

}


public String getName(){

    return name;

}

public int getYearOfPublication(){
    
    return yearOfPublication;

}



//toString 

@Override

public String toString(){


    return" ID "+ id+" Name "+name+" Year of  Publication "+ yearOfPublication;

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
