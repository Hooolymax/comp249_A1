//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------
import java.util.Scanner;
import Item.*;
import Client.*;;

public class Driver {

    private static Item[] items=new Item[20];
    private static int count=0;//count the number of items added

    private static Client[]clients=new Client[10];
    private static int clientCount = 0; // count the number of clients added

    private Journal[] journals;
    private Media[] medias;
    private static boolean quit = false; //flag to exit the program


    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        // menu and welcome message
        int userInput = cin.nextInt();

        do{
            switch(userInput){
                // cases
                default:
                    // invalid input
                    quit = true;
                    break;
            }
        } while (!quit); // condition to exit
        
        
    }

    

    



    public void addItem(Item item){

        //check if the item already exists

        for (int i = 0; i < count; i++) {
            if (items[i].getId().equals(item.getId())) {
                System.out.println("Item with ID " + item.getId() + " already exists.");
                return;
            }
        }




        items[count] = item;
        count++;
        System.out.println("Item with ID " + item.getId() + " added successfully.");




    }

    public void deleteItem(String itemId){

    for (int i = 0; i < count; i++) {
        // Check the if item to be deleted exists  
        if (items[i].getId().equals(itemId)) {
            // Shift all items one position
            for (int j = i; j < count - 1; j++) {
                items[j] = items[j + 1];
            }
            items[count - 1] = null; 

            count--; // Decrease the count
            System.out.println("Item with ID " + itemId + " removed successfully.");

            return; 
        }
    }

    // case the item was not found
    System.out.println("Item with ID " + itemId + " not found.");




        
    }

    public void editItem(){

        //prompt the user to enter the item ID
        Scanner scannerEdit = new Scanner(System.in);
        System.out.println("Enter the ID of item you want to edit");

        // Read user input for item ID
        String itemId = scannerEdit.nextLine(); 

        //find the item in the array
        for (int i = 0; i < count; i++) {
            if (items[i].getId().equals(itemId)){

                System.out.println("Editing item with ID"+ items[i].getName()+items[i].getAuthor()+items[i].getYearOfPublication());

                System.out.println("Enter new name for the item.");
                String newName = scannerEdit.nextLine(); // Read new name
                items[i].setName(newName); // Set new name

                System.out.println("Enter new author for the item.");
                String newAuthor = scannerEdit.nextLine(); // Read new author
                items[i].setAuthor(newAuthor); // Set new author
    
                System.out.println("Enter new year of publication for the item.");
                int newYearOfPublication = Integer.parseInt(scannerEdit.nextLine()); // Read new year of publication
                items[i].setYearOfPublication(newYearOfPublication); // Set new year of publication
    
                System.out.println("Item updated successfully.");
                return; // Exit the method after editing



            }


            // If the item is not found
            System.out.println("Item with ID " + itemId + " not found.");


        }





        
    }

    


    public void addClient(){

        Scanner scClient = new Scanner(System.in);

        // Prompt for and read client details
        System.out.println("Enter client's name:");
        String name = scClient.nextLine();

        System.out.println("Enter client's phone number:");
        String phone = scClient.nextLine();

        System.out.println("Enter client's email address:");
        String email = scClient.nextLine();

        // Create a new Client object
        Client newClient = new Client(name, phone, email);

       

        // Add the new client to the array and increment the client count

        clients[clientCount] = newClient;
       
       
        clientCount++;

        System.out.println("New client added successfully.");
    }


        
    

    public void deleteClient(){
        
    }

    public void editClient(){
        
    }

    public void leaseItem(){

    }

    public void returnItem(){

    }

    public void showItems(){

    }

    public void showAllItems(){

    }

    public void getBiggestBook(){
        
    }

    public void copyBooks(){

    }
}
