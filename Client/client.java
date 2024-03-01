package Client;

import Item.*;

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
    private Item[] leasedItems;
    public final int maxNumOfLeasedItems = 10;
    private int numOfLeasedItems = 0;
    
    // default constructor
    public Client() {
        this.name = "n/a";
        this.phone = "n/a";
        this.email = "n/a";
        this.id ++;
        this.leasedItems = new Item[maxNumOfLeasedItems];
    }

    // parameterized constructor
    public Client(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id ++;
        this.leasedItems = new Item[maxNumOfLeasedItems];
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

    public Item[] getLeasedItems(){
        return leasedItems;
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

    public boolean addLeasedItem(Item item) throws IndexOutOfBoundsException {
        if (item.isAvailable()){
            leasedItems[numOfLeasedItems] = item;
            return true;
        } else {
            return false;
        }
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



    //remove leased item
    public boolean removeLeasedItem(Item item) {
        for (int i = 0; i < numOfLeasedItems; i++) {
            if (leasedItems[i].equals(item)) { // Check if this is the item to remove

                // Item found, shift all subsequent items one place
                for (int j = i; j < numOfLeasedItems - 1; j++) {
                    leasedItems[j] = leasedItems[j + 1];
                }
                leasedItems[numOfLeasedItems - 1] = null; 
                numOfLeasedItems--; // Decrement count of leased items
                item.setAvailable(true); // Set item available
                return true;
            }
        }
        return false; // Item not found in leased items
    }
    

}

