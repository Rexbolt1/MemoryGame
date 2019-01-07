/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Date;
/**
 *
 * @author rexbolt1
 */
public class UITile extends javax.swing.JLabel{
    GameLogic logic = new GameLogic();
    private JLabel label;
    private int position;
    private int number;
    private int tilenumber = 0;
    private int tilenumberTWO = 0;
    int check = 1;
    int click;
    int cardchecker = 1;
    int max = 36;
    String[] imgs = new String[GameLogic.NUM_TILES/2];
    
    
    public UITile() { //The () had label and Position in its fields
        this.label = label;
        this.position = position;
        this.addMouseListener(new MouseAdapter() {      //Event Handling with MouseAdapter //used to be label.addMouseListener
            public void mouseClicked(MouseEvent e){     //Inner Class: Anounymous Class
                doCheck();
                //Get Tiles[i], swap I with the UITile number
                //Set Tiles[tilenumber] with either the original image or the default
                //Pulling the cable the very uncool move
                //When clicked, getNumber, switch/set Image
            }
        });
            
        }
    
    //If the user clicked a tile, Gamelogic has to determine that choice becomes -1, 
    //then process user choice will always run with every mouse click on the card
    //


       public void doCheck(){
        if(check == 0){
            
            doClick();
            check = 1;
            System.out.println(check);
        }
        else{
            
            reverseClick();
            check = 0;
            System.out.println(check);
        }
    }
    //Has no card been selected? Then flip over the card
            //If there is, get 2nd number and check if it matches previous card
            //If not, put cards in default mode
            //If Yes, make cards "dissapear
    
    
    //TO DO (after shuffle): 
    //Get the images into their respective original image
    //When clicked the game takes the cards number
    //When you click another card it matches the number +/- 18
    //* Wait function goes here
    //If it isn't then both cards will go back to normal
    //If it does the card dissapears
    
    
    public void doClick(){
        System.out.println("You clicked tile " + getNumber()); // USE COUNT SOMEHOW HERE, its able to track your own values you click when picking a likt of 36 numbers randomly 
        ImageIcon icon = new ImageIcon("img.png");
        
        //Check if image has been clicked or not, can't be universal
        //If the image has been clicked then the tile itself would need to register it has been click and check that
        //So maybe a new method to check whether that image has been clicked
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        icon.setImage(img);
        this.setIcon(icon);
    }
    //configuration variables 
    public void reverseClick(){
        System.out.println("You clicked tile " + getNumber() + " state = true");
            tilenumber = getNumber(); //This needs to change so that it gets Count from Game logic, that way the tile object gets a new number allowing the Mainframe to easily track it
            imageReturn();
    }
    
    //The image checks first whether the tilenumber is less than 18, if it's less than 18 the program will get filenames that are 0-17
    //This means to get the a sides I am deliberatelly picking only the first 17 and vice versa for the b, this means that my program
    //is not actually picking the images randomly but doing it inentionally
    //my current goal is that
    //A: My program is able to pick the images randomly from the A side and pick the corresponding B side
    //B: The program also needs to factor a X amount of images
    //The main problem is the if as it is the only thing stopping me from picking the images randomly
    //perhaps I create a new variable that lets me pick 18 initial images at first with a array of names (while the -18 is linked to a counter
    //But that would mean I would need to factor Tohsaka, is to never ever put youself down 
   
    
    public void imageReturn(){
        if(tilenumber < 18){
                ImageIcon icon = new ImageIcon(tilenumber + "a.png"); //"tilenumber" is the value of each individual UI Tile, U ahve to swap this with something from Gamelogic in order to allow
                Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                icon.setImage(img);
                this.setIcon(icon);
                }
  
            else if(tilenumber > 17){
                ImageIcon icon = new ImageIcon((tilenumber - 18) + "b.png"); //CHANGE 18 TO SOMETHING UNIVERSAL SOON
                Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                icon.setImage(img);
                this.setIcon(icon);
                }
        }
    
        /*public void imageRGenerator(){
            int randomNums[] = new int[50];
            for(int r = 0; r < randomNums.length; r++){ //eventually 36 will turn to max, a variable able to manage the amount of images in the folder
                randomNums[r] = tilenumber;
                
            }
        } */

    
    public int getTilenumber(){
        return tilenumber;
    }

    public void setTilenumber(){
        this.tilenumber = tilenumber;
    }
    
    
    public int getNumber() { //Replace Nunber here Gamelogic.choice
        return number; // Encapsulation of Variables
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
        
        //I need a method on where the icons being generated are using the code of GameLogic 
        //For example when Tile A is clicked, the UITile class not the Gamelogic class is able to first get the count from Gamelogic
        //Then is able to identify whether 

//Bittersweet Memories, We drift though the heavens, HERE COMES MY TROUBLES
//Reading Steiner


    
 
    
    public JLabel getLabel() {
        return label;
    }

    public void setLabel() {
        this.label = label;
    }
    
    public int getPosition() {
        return position;
    }

    public void setPosition() {
        this.position = position;
    }

}
