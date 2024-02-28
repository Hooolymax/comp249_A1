//--------------------------------------------------------------------  
// Assignment 1
// Question 
// Written by Alisa Ignatina 40267100 and Jinghao Lai 40041316 
//--------------------------------------------------------------------
import java.util.Scanner;
import Item.*;
import Client.*;;

public class Driver {

    private Item[] items;
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

    public void addItem(){

    }

    public void deleteItem(){
        
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
