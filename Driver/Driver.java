//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------
import java.util.Scanner;
import Item.*;
import Client.*;;

public class Driver {

    private static Client[] clients = new Client[1];
    private static int numClient = 0;
    private static Item[] items = new Item[20];
    private static int count=0;
    private Journal[] journals;
    private Media[] medias;
    private static boolean quit = false; //flag to exit the program
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {

        
        // menu and welcome message
        System.out.println("Welcome to Alisa Ignatina 40267100 and Jinghao Lai 40041316 Library!");
        System.out.println("Do you want to get a menu (enter 1) or do you want to run a predefined/hard-coded scenario (enter 2)");
        int userInput = cin.nextInt();

        // menu
        // exception handling if user input is invalid
        if (userInput == 1){
            do{
                
                // display menu
                System.out.println("menu");
                userInput = cin.nextInt();
                // main menu loop for the interaction with a user
                switch(userInput){
                    // cases

                    case 4:
                        try{
                            
                            do{
                                addClient();
                                System.out.println("Do you want to add another client? ");
                            } while (cin.next().equals("yes"));

                        } catch (Exception IndexOutOfBoundsException){
                            System.out.println("The client was not added, not enough space");
                        }

                        break;


                    default:
                        // input = 0, quit
                        quit = true;
                        break;
                }
    
            } while (!quit); // condition to exit
            
        }


        // predefined/hard-coded scenario
        if (userInput == 2){

            // create 3 obj
            // create 3 users


        }

        
        
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
        
    }

    public static void addClient() throws Exception { // index out of range in clients array
        System.out.println("Enter client name: ");
        String name = cin.next();
        System.out.println("Enter client phone: ");
        String phone = cin.next();
        System.out.println("Enter client email: ");
        String email = cin.next();
        clients[numClient] = new Client(name, phone, email); // new client is added to clients array 
        System.out.println("The following client was created: " + clients[numClient].toString());
        numClient++;
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
