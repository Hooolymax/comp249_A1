package Client;

//--------------------------------------------------------------------  
//Assignment 1
//Question 
//Written by Ignatina Alisa 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

public class Client {

    // variable declaration
    protected int id = 0;
    protected String name;
    protected String phone;
    protected String email;
    
    // default constructor
    public Client() {
        this.name = "n/a";
        this.phone = "n/a";
        this.email = "n/a";
        this.id ++;
    }

    // parameterized constructor
    public Client(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id ++;
    }

    // copy constructor
    public Client(Client aClient){
        this.name = aClient.name;
        this.phone = aClient.phone;
        this.email = aClient.email;
        this.id ++;
    }



}

