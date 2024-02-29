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
    private static int count=0;
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
        
    }

    public void addClient(){
        
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
