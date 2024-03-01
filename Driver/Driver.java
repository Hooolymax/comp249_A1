//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------

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

        
        // welcome message
        System.out.println("Welcome to Alisa Ignatina 40267100 and Jinghao Lai 40041316 Library!");

        System.out.println("Do you want to get a menu (enter 1) or do you want to run a predefined/hard-coded scenario (enter 2)");
        int userInput = cin.nextInt();
        System.out.println();

        int id; int clientID; String itemID; String name, email, phone;

        // menu
        if (userInput == 1){
            do{
                
                // display menu
                System.out.println("Choose an option: ");
                System.out.println("*******************************************\r\n" + //
                                        "0 - quit\r\n" + //
                                        "1 - add an item\r\n" + //
                                        "2 - delete an item\r\n" + //
                                        "3 - change information of an item\r\n" + //
                                        "4 - list all books\r\n" + //
                                        "5 - list all journals\r\n" + //
                                        "6 - list all media \r\n" + //
                                        "7 - print all items (from all categories)\r\n" + //
                                        "8 - add a client \r\n" + //
                                        "9 - edit a client\r\n" + //
                                        "10 - delete a client\r\n" + //
                                        "11 - lease an item to a client \r\n" + //
                                        "12 - return an item from a client\r\n" + //
                                        "13 - show all items leased by a client\r\n" + //
                                        "14 - show all leased items (by all clients)\r\n" + //
                                        "15 - Display the biggest book \r\n" + //
                                        "16 - Make a copy of the books array\r\n" + //
                                        "*******************************************");
                System.out.println();
                userInput = cin.nextInt();

                try{
                
                    // main menu loop for the interaction with a user
                    switch(userInput){
                        
                        
                        // add an item
                        case 1:
                        {
                         // Initialize scanner for user input
                        Scanner scAddItem = new Scanner(System.in);

   
                        System.out.println("What type of item would you like to add? Enter book, journal or media.");
                        String itemType = scAddItem.nextLine().trim().toLowerCase(); // Normalize input

                        // Attributes for all item types
                        String newName, newAuthor, newType;
                        int newYearOfPublication, newNumberOfPages, newVolumeNumber;

                        // Add item based on user input
                        switch (itemType) {
                        case "book":
                        System.out.println("Enter Book Name:");
                        newName = scAddItem.nextLine();
                        System.out.println("Enter Author:");
                        newAuthor = scAddItem.nextLine();
                        System.out.println("Enter Year of Publication:");
                        newYearOfPublication = scAddItem.nextInt();
                        System.out.println("Enter Number of Pages:");
                        newNumberOfPages = scAddItem.nextInt();
                        scAddItem.nextLine(); // Clear scanner buffer

                        Book newBook = new Book(newName, newAuthor, newYearOfPublication, newNumberOfPages);
                        addItem(newBook);
                    break;

                     case "journal":
                     System.out.println("Enter Journal Name:");
                     newName = scAddItem.nextLine();
                     System.out.println("Enter Author:");
                     newAuthor = scAddItem.nextLine();
                     System.out.println("Enter Year of Publication:");
                     newYearOfPublication = scAddItem.nextInt();
                     System.out.println("Enter Volume Number:");
                     newVolumeNumber = scAddItem.nextInt();
                     scAddItem.nextLine(); // Clear scanner buffer

                     Journal newJournal = new Journal(newName, newAuthor, newYearOfPublication, newVolumeNumber);
                    addItem(newJournal);
                    break;

                    case "media":
                    System.out.println("Enter Media Name:");
                    newName = scAddItem.nextLine();
                    System.out.println("Enter Author:");
                    newAuthor = scAddItem.nextLine();
                    System.out.println("Enter Year of Publication:");
                    newYearOfPublication = scAddItem.nextInt();
                    scAddItem.nextLine(); // Clear buffer before reading next String
                    System.out.println("Enter the type");
                    newType = scAddItem.nextLine();

                    Media newMedia = new Media(newName, newAuthor, newYearOfPublication, newType);
                    addItem(newMedia);
                    break;

                 default:
                 System.out.println("Invalid item type entered.");
                break;

            }
    }




                        // delete an item
                        case 2:


                        // edit an item
                        case 3:

                        // list all books
                        case 4:
                            printBooks();
                        break;

                        // list all journals
                        case 5:
                            printJournals();
                        break;

                        // list all media
                        case 6:
                            printMedias();
                        break;

                        // list all items
                        case 7:
                            printItems();
                        break;

                        // add a client
                        case 8:
                            
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
                                } while (cin.nextLine().trim().toLowerCase().equals("yes"));

                            // index out of range in clients array
                            } catch (IndexOutOfBoundsException e){ 
                                System.out.println("The client was not added, not enough space");
                            }

                        break;

                        // delete a client
                        case 9:
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

                        // edit a client
                        case 10:
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
                        
                        // lease an item
                        case 11:

                            System.out.println("Enter ID of client to whom you want to lease the item: ");
                            clientID = cin.nextInt();
                            System.out.println("Enter ID of item you want to lease to the client: ");
                            itemID = cin.next();

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

                
                        // return an item from a client
                        case 12:

                        // show all items leased by a client
                        case 13:
                            System.out.println("Enter ID of client whos leased items you want to see: ");
                            clientID = cin.nextInt();
                            try{
                                showItemsLeasedByClient(clientID);
                            } catch (IllegalArgumentException e){
                                System.out.println("Illegal ID");
                            }

                        break;
                        
                    
                        // show all leased items (by all clients)
                        case 14:
                            showAllItemsLeased();
                        break;
                        





                        // Display the biggest book
                        case 15:
                            System.out.println(getBiggestBook().toString());
                        break;

                        // max
                        // Make a copy of the books array
                        case 16:
                        
                        default:
                            // input = 0, quit
                            quit = true;
                            break;
                    }

                // exception handling if user input is invalid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input"+ cin.nextLine()); // clear scanner
                } catch (Exception e1) {
                    System.out.println("Unexpected error occured:( Try to restart the program");
                }
                
    
            } while (!quit); // condition to exit
            
        }


        // predefined/hard-coded scenario
        if (userInput ==2 ){


            // Create at least 3 objects from each type of items
            Book book1 = new Book("The Lord of the Rings", "J.R.R Tolkien", 1954, 300);
            Book book2 = new Book("The Hobbit", "J.R.R Tolkien", 1952, 350);
            Book book3 = new Book("The Silmarillion", "J.R.R Tolkien", 1952, 280);

            Journal journal1 = new Journal("Journal 1", "Author D", 2024, 1);
            Journal journal2 = new Journal("Journal 2", "Author E", 2025, 2);
            Journal journal3 = new Journal("Journal 3", "Author F", 2022, 3);

            Media media1 = new Media("Media 1", "Author G", 2027, "Video");
            Media media2 = new Media("Media 2", "Author H", 2028, "Audio");
            Media media3 = new Media("Media 3", "Author I", 2029, "Interactive");

            // Display information of items
            System.out.println("Display the items information");
            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);

            System.out.println(journal1);
            System.out.println(journal2);
            System.out.println(journal3);

            System.out.println(media1);
            System.out.println(media2);
            System.out.println(media3);


            // Test the equality from same class

            System.out.println("");
            System.out.println("Test the equality");
            System.out.println("Is book1 equal to book2? " + book1.equals(book2)); // Expected: false
            System.out.println("Is book2 equal to book3? " + book2.equals(book3)); // Expected: false

          
            System.out.println("Is journal2 equal to journal3? " + journal2.equals(journal3)); // Expected: false
            System.out.println("Is journal1 equal to journal1? " + journal1.equals(journal1)); // Expected: true

           
            System.out.println("Is media1 equal to media3? " + media2.equals(media3)); // Expected: false
            System.out.println("Is media1 equal to media1? " + media1.equals(media1)); // Expected: true

            //Test the equality from different classes
            System.out.println("Is book1 equal to journal1? " + book1.equals(journal1)); // Expected: false
            System.out.println("Is journal3 equal to media3? " + journal3.equals(media3)); // Expected: false

            // Create an array for each one of the types of items and an array for all items
            Book[] booksArray = {book1, book2, book3};
            Journal[] journalsArray = {journal1, journal2, journal3};
            Media[] mediasArray = {media1, media2, media3};
            Item[] allItemsArray = {book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};

            // Create 3 Client1
            Client client1 = new Client("C1", "514-456-7890", "client1@gmail.com");
            Client client2 = new Client("C2", "514-765-4321", "client2@gmail.com");
            Client client3 = new Client("C3", "514-123-7890", "client3@gmail.com");




            // Display their information
            System.out.println("");
            System.out.println("Display the clients information");
            System.out.println(client1.toString());
            System.out.println(client2.toString());
            System.out.println(client3.toString());


        }

        
        
    }

    




    /*-----------------------------  method  -------------------------------*/

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



    public static void addItem(Item newItem){

        
        // Add item based on its specific type
    if (newItem instanceof Book) {
        if (numBooks >= maxnumBooks) {
            System.out.println("Cannot add new book, Book inventory is full.");
            return;
        }
        books[numBooks] = (Book) newItem;
        numBooks++;
    } else if (newItem instanceof Journal) {
        if (numJournals >= maxnumJournals) {
            System.out.println("Cannot add new journal, Journal inventory is full.");
            return;
        }
        journals[numJournals] = (Journal) newItem;
        numJournals++;
    } else if (newItem instanceof Media) {
        if (numMedias >= maxnumMedias) {
            System.out.println("Cannot add new media, Media inventory is full.");
            return;
        }
        medias[numMedias] = (Media) newItem;
        numMedias++;
    }

    // Add to the general items array regardless of type
    items[numItems] = newItem;
    numItems++;
    System.out.println("New item added successfully: " + newItem.toString());



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


    
    public static void printBooks(){
        for (int i = 0; i < numBooks; i++){
            System.out.println(books[i].toString());
        }
    }

   
    public static void printJournals(){
        for (int i = 0; i < numJournals; i++){
            System.out.println(journals[i].toString());
        }
    }

    
    public static void printMedias(){
        for (int i = 0; i < numMedias; i++){
            System.out.println(medias[i].toString());
        }
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


    public static boolean leaseItemToClient(String itemID, int clientID) throws IllegalArgumentException, IndexOutOfBoundsException {

        if (clients[findClientNumByID(clientID)].addLeasedItem(items[findItemNumByID(itemID)])){
            return true;
        } else{
        return false;
        }
    }

     
    public void returnItemFromClient(String itemID, int clientID) throws IllegalArgumentException, IndexOutOfBoundsException{
        try {
            int clientIndex = findClientNumByID(clientID);
            if (clientIndex == -1) { // Check if client exists
                System.out.println("Client with ID " + clientID + " does not exist.");
                return;
            }
    
            int itemIndex = findItemNumByID(itemID);
            if (itemIndex == -1) { // Check if item exists
                System.out.println("Item with ID " + itemID + " does not exist.");
                return;
            }
    
            // Attempt to remove the item from the client's list of leased items
            if (clients[clientIndex].removeLeasedItem(items[itemIndex])) {
                System.out.println("Item " + itemID + " successfully returned by client " + clientID + ".");
            } else {
                System.out.println("Failed to return item " + itemID + " by client " + clientID + ": item was not leased by this client.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid client or item ID.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Client or Item index out of bounds.");
        }





    }

    
    public static void showItemsLeasedByClient(int clientID) throws IllegalArgumentException{
        Item[] leasedItems = clients[findClientNumByID(clientID)].getLeasedItems();
        for (int i = 0; i < numClients; i++){
            System.out.println(leasedItems[i].toString());
        }
    }

     // max
    public static void showAllItemsLeased(){

        boolean foundLeasedItems = false;
        System.out.println("List of all leased items:");
    
        // Iterate through all clients
        for (int i = 0; i < numClients; i++) {
            Client client = clients[i]; // Get the current client
            Item[] leasedItems = client.getLeasedItems(); // Get the leased items for the current client
    
            // Check each item to see if it's leased
            for (int j = 0; j < client.maxNumOfLeasedItems; j++) {
                Item item = leasedItems[j];
                if (item != null) { // If there's an item in this slot
                    foundLeasedItems = true; // We have found at least one leased item
                    System.out.println("Client ID " + client.getId() + " (" + client.getName() + ") has leased item ID " + item.getId() + ": " + item.getName());
                }
            }
        }
    
        if (!foundLeasedItems) {
            System.out.println("No items are currently leased.");
        }


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
    public Book[] copyBooks(Book[] originalBooks) {
        if (originalBooks == null) {
            return null; 
        }
    
        // Initialize a new array
        Book[] copiedBooks = new Book[originalBooks.length];
    
        // Iterate through the original array, copying each Book
        for (int i = 0; i < originalBooks.length; i++) {
            if (originalBooks[i] != null) {
                copiedBooks[i] = new Book(originalBooks[i]); //use copy constructor
            } else {
                copiedBooks[i] = null;
            }
        }
    
        return copiedBooks; // Return the deep copy of the book array
    }
    


   

}
