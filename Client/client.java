package Client;

//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------


/** This class stores information about clients
 */
public class Client {

    // variable declaration
    private int id = 0;
    private String name;
    private String phone;
    private String email;
    
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

    // getters 
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return name + " has an ID " + id + ", phone " + phone + ", email " + email;
    }

    public boolean equals(Client aClient) {
        if (this.id == aClient.id) {
            return true;
        } else {
            return false;
        }
    }


}

