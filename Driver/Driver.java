//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------
import java.util.Scanner;
import Item.*;
import Client.*;;

public class Driver {

    private static Client[] clients = new Client[20];
    private static int numClient = 0;
    private static Item[] items = new Item[20];
    private static int count=0;
    private static Book[]  books;
    private Journal[] journals;
    private Media[] medias;
    private static boolean quit = false; //flag to exit the program
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {

        
        // menu and welcome message
        System.out.println("Welcome to Alisa Ignatina 40267100 and Jinghao Lai 40041316 Library!");
        System.out.println("Do you want to get a menu (enter 1) or do you want to run a predefined/hard-coded scenario (enter 2)");
        int userInput = cin.nextInt();
        int id; String name, email, phone;

        // menu
        // exception handling if user input is invalid
        if (userInput == 1){
            do{
                
                // display menu
                System.out.println("menu");
                userInput = cin.nextInt();
                // main menu loop for the interaction with a user
                switch(userInput){
                    
                    case 1:


                    case 2:


                    case 3:


                    case 4:
                        
                        try{     
                            do{
                                System.out.println("Enter client name: ");
                                name = cin.next();
                                System.out.println("Enter client phone: ");
                                phone = cin.next();
                                System.out.println("Enter client email: ");
                                email = cin.next();

                                addClient(name, phone, email);

                                System.out.println("The following client was created: " + clients[numClient].toString());

                                System.out.println("Do you want to add another client? ");
                            } while (cin.next().equals("yes"));

                        // index out of range in clients array
                        } catch (Exception IndexOutOfBoundsException){ 
                            System.out.println("The client was not added, not enough space");
                        }

                        break;

                    case 5:

                        System.out.println("Enter client ID you want to delete: ");
                        id = cin.nextInt(); 
                        if (deleteClient(id)){
                            System.out.println("The client was removed successfully");
                        } else {
                            System.out.println("The client was not found");
                        }


                        break;

                    case 6:

                        System.out.println("Enter client ID you want to edit: ");
                        id = cin.nextInt(); 
                        System.out.println("Enter new name for the client");
                        name = cin.next();
                        System.out.println("Enter new phone for the client");
                        phone = cin.next();
                        System.out.println("Enter new email for the client");
                        email = cin.next();
                        if (editClient(id, name, phone, email)){
                            System.out.println("The client was edited successfully: " + clients[numClient].toString());
                        } else {
                            System.out.println("The client was not found");
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


    // max
    public static void printBooks(){

    }

    // alisa
    public static void printJournals(){
        
    }

    // max
    public static void printMedias(){
        
    }

    // alisa
    public static void printItems(){
        
    }


    public static void addClient(String name, String phone, String email) throws Exception { 

            clients[numClient] = new Client(name, phone, email); // new client is added to clients array 
    
            numClient++;

    }

   
    public static boolean deleteClient(int id){

        for (int i=0; i<clients.length; i++){
            if (clients[i].getId() == id){
                // shift items after to the one position to the left
                for (int j = i; j < numClient - 1; j++) {
                    clients[j] = clients[j + 1];
                }
                clients[numClient-1] = null;
                numClient--;
                return true;
            }
        }
        // if client was not found
        return false;
    }


    public static boolean editClient(int id, String name, String phone, String email){
        for (int i=0; i<clients.length; i++){
            if (clients[i].getId() == id){
                clients[i].setName(name);
                clients[i].setPhone(phone);
                clients[i].setEmail(email);
                return true;
            }
        }
        // if client was not found
        return false;
    }

    // alisa
    public void leaseItem(){

    }

     // max
    public void returnItem(){

    }

    // alisa
    public void showItemsLeasedByClient(){

    }

     // max
    public void showAllItemsLeased(){

    }

    // alisa
    public static Book getBiggestBook(){
        int max = 0;
        int maxi = -1;
        for (int i = 0; i < books.length; i++){
            if (books[i].getNmuberOfPages() > max){
                max = books[i].getNmuberOfPages();
                maxi = i;
            }
        }
        
        return books[maxi];
        
    }
 
    //max
    public void copyBooks(){

    }
}
