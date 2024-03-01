//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;
import Item.*;
import Client.*;;

public class Driver {

    private final static int maxnumClients = 30;
    private static Client[] clients = new Client[maxnumClients];
    private static int numClients = 0;

    private final static int maxnumItems = 30;
    private static Item[] items = new Item[maxnumItems];
    private static int numItems=0;

    private final static int maxnumBooks = 10;
    private static Book[]  books = new Book[maxnumBooks];
    private static int numBooks=0;

    private final static int maxnumJournals = 10;
    private static Journal[] journals = new Journal[maxnumJournals];
    private static int numJournals=0;

    private final static int maxnumMedias = 10;
    private static Media[] medias = new Media[maxnumMedias];
    private static int numMedias=0;

    private static boolean quit = false; //flag to exit the program

    static Scanner cin = new Scanner(System.in);
   

    public static void main(String[] args) {

        
        // menu and welcome message
        System.out.println("Welcome to Alisa Ignatina 40267100 and Jinghao Lai 40041316 Library!");
        System.out.println("Do you want to get a menu (enter 1) or do you want to run a predefined/hard-coded scenario (enter 2)");
        String userInput = cin.next();
        int id; String name, email, phone;

        // menu
        // exception handling if user input is invalid
        if (userInput.equals("1")){
            do{
                
                // display menu
                System.out.println("menu");
                userInput = cin.next();

                try{
                
                // main menu loop for the interaction with a user
                switch(userInput){
                    
                    case "1":


                    case "2":


                    case "3":


                    case "4":
                        
                        try{     
                            do{
                                System.out.println("Enter client name: ");
                                name = cin.next();
                                System.out.println("Enter client phone: ");
                                phone = cin.next();
                                System.out.println("Enter client email: ");
                                email = cin.next();

                                addClient(name, phone, email);

                                System.out.println("The following client was created: " + clients[numClients-1].toString());

                                System.out.println("Do you want to add another client? ");
                            } while (cin.next().equals("yes"));

                        // index out of range in clients array
                        } catch (IndexOutOfBoundsException e){ 
                            System.out.println("The client was not added, not enough space");
                        }

                        break;

                    case "5":
                        try{
                            System.out.println("Enter client ID you want to delete: ");
                            id = cin.nextInt(); 
                            if (deleteClient(id)){
                                System.out.println("The client was removed successfully");
                            } else {
                                System.out.println("The client was not found");
                            }

                        // index out of range in clients array
                        } catch (IndexOutOfBoundsException e){ 
                            System.out.println("The client was not added, not enough space");
                        }

                        break;

                    case "6":
                        try {
                            System.out.println("Enter client ID you want to edit: ");
                            id = cin.nextInt(); 
                            System.out.println("Enter new name for the client");
                            name = cin.next();
                            System.out.println("Enter new phone for the client");
                            phone = cin.next();
                            System.out.println("Enter new email for the client");
                            email = cin.next();
                            if (editClient(id, name, phone, email)){
                                System.out.println("The client was edited successfully: " + clients[numClients].toString());
                            } else {
                                System.out.println("The client was not found");
                            }

                        // index out of range in clients array
                        } catch (IndexOutOfBoundsException e){ 
                            System.out.println("The client was not added, not enough space");
                        }
                        break;
                    

                    case "10":
                        System.out.println("Enter ID of client to whom you want to lease the item: ");
                        int clientID = cin.nextInt();
                        System.out.println("Enter ID of item you want to lease to the client: ");
                        String itemID = cin.next();
                        try{
                            if (leaseItemToClient(itemID, clientID)){
                                System.out.println("The item was added successfully");
                            } else {
                                System.out.println("The item is not available");
                            }
                            break;
                        
                        } catch (IllegalArgumentException e1) {
                            System.out.println("No client or item found");
                        } catch (IndexOutOfBoundsException e2) {
                            System.out.println("Not enough space");
                        }

                        break;

                    default:
                        // input = 0, quit
                        quit = true;
                        break;
                }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input"+ cin.next());
                }
                
    
            } while (!quit); // condition to exit
            
        }


        // predefined/hard-coded scenario
        if (userInput.equals("2") ){

            // create 3 obj
            // create 3 users


        }

        
        
    }

    

    public static int findItemNumByID(String id) throws IllegalArgumentException {
        for (int i = 0; i< numItems; i++){
            if (items[i].getId().equals(id)){
                return i;
            }
        }
        throw new IllegalArgumentException("This item ID does not exist");
    }

    public static int findClientNumByID(int id) throws IllegalArgumentException{
        for (int i = 0; i< numClients; i++){
            if (clients[i].getId() == (id)){
                return i;
            }
        }
        throw new IllegalArgumentException("This client ID does not exist");
    }



    public void addItem(Item item){

        //check if the item already exists

        for (int i = 0; i < numItems; i++) {
            if (items[i].getId().equals(item.getId())) {
                System.out.println("Item with ID " + item.getId() + " already exists.");
                return;
            }
        }




        items[numItems] = item;
        numItems++;
        System.out.println("Item with ID " + item.getId() + " added successfully.");




    }

    public void deleteItem(String itemId){

    for (int i = 0; i < numItems; i++) {
        // Check the if item to be deleted exists  
        if (items[i].getId().equals(itemId)) {
            // Shift all items one position
            for (int j = i; j < numItems - 1; j++) {
                items[j] = items[j + 1];
            }
            items[numItems - 1] = null; 

            numItems--; // Decrease the count
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
        for (int i = 0; i < numItems; i++) {
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

   
    public static void printJournals(){
        for (int i = 0; i < numJournals; i++){
            System.out.println(journals[i].toString());
        }
    }

    // max
    public static void printMedias(){
        
    }

    
    public static void printItems(){
        for (int i = 0; i < numItems; i++){
            System.out.println(items[i].toString());
        }
    }


    public static void addClient(String name, String phone, String email) throws IndexOutOfBoundsException { 

            clients[numClients] = new Client(name, phone, email); // new client is added to clients array 
    
            numClients++;

    }

   
    public static boolean deleteClient(int id) throws IllegalArgumentException{

        int i = findClientNumByID(id);

        // if client was not found
        if (i == -1){
            return false;
        }

        // shift items after to the one position to the left
        for (int j = i; j < numClients - 1; j++) {
            clients[j] = clients[j + 1];
        }
        clients[numClients-1] = null;
        numClients--;
        return true;
            
        
    }


    public static boolean editClient(int id, String name, String phone, String email) throws IllegalArgumentException{
        int i = findClientNumByID(id);

        // if client was not found
        if (i == -1){
            return false;
        }

        clients[i].setName(name);
        clients[i].setPhone(phone);
        clients[i].setEmail(email);
        return true;
            
        
    }

    // alisa
    public static boolean leaseItemToClient(String itemID, int clientID) throws IllegalArgumentException, IndexOutOfBoundsException {

        if (clients[findClientNumByID(clientID)].addLeasedItem(items[findItemNumByID(itemID)])){
            return true;
        } else{
        return false;
        }
    }

     // max
    public void returnItemFromClient(){

    }

    // alisa
    public void showItemsLeasedByClient(){

    }

     // max
    public void showAllItemsLeased(){

    }

    
    public static Book getBiggestBook(){
        int max = 0;
        int maxi = -1;
        for (int i = 0; i < numBooks; i++){
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
