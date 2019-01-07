/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author rexbolt1
 */
public class GameLogic extends MainFrame {

/**
 *
 * @author rexbolt1
 */

    private int tilestate;
    //private int doesmatch;
    //int tilechecker = 0;
    int currentChoice;
    //Tile tilelogic = new Tile();
    int count;
    static final int NUM_TILES = 16; //time being, the final int and its value
    int[] tiles = new int[NUM_TILES]; //going to be 15 numbers
    boolean[] matched = new boolean[NUM_TILES];
   
    //NEXT PROJECT: 
    //Array of Jlabels/Tiles: JLabel[]labels = new JLabel/Tile[NUM_TILES] So I have to recreate the set of tiles being generated
    //by using This classes Final int, (SOLVED)
    //String imgs = new String[NUM_TILES/2]; Convert
    //That String is the list of images that will take the value of each Tile to get the right corresponding image change
    //the If statement when setting tile names (this code is in the Tile class)
    //int[] tiles = logic.getTiles(); Convert, when getting the list, use this method
    //for(int i = 0; i < tiles; i++){ Convert
    //labels[i].setImage(imgs[tiles[i]]); Convert
    //labels.setID(tiles[i); Convert
    


    public GameLogic(){
        //initialize game
        //Set up the game
        //What is Europe XD
        //Fill up the tile array with 1,1,2,2,3,3,...
        //Shuffle method, Fisher-Yates, grab from MainFrame
        //
        int count = 0;
        for(int i = 0; i < tiles.length/2; i++){
            tiles[count] = i;
            tiles[count + 1] = i;
            count += 2;  
        }
        shuffleArray(tiles);
        printTiles();
    } 
    
    
    static void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for(int i = ar.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);   
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    
    
    
    private void printTiles(){
        for(int i = 0; i < tiles.length; i++){
            System.out.println(i + ": " + tiles[i]);
        }
    }
        
//A set of n image
    
    public void processUserChoice (int choice){
        if(currentChoice == -1){
            //This is te first tile they flipped so just remember choice
            currentChoice = choice; //choice is the input from the GUI
        }    
        else{
            //This is the second Tile they've flipped, so see if there is a match
            if(tiles[currentChoice] == tiles[choice]){
                //Match found
                matched[currentChoice] = true; 
                matched[choice] = true;
        }
            else{
                //No match found, no update on match array, just set choice and currentChoice
                currentChoice = -1;
            }
            /*if(matched[currentChoice] =! true){ //If the boolean array of current choice isn't true then
                if(currentChoice > -1 && choice < 0){ //check wheter currentchoice has a value and if a second tile
                    choice = currentChoice;
                    currentChoice = -1;
                Roc
                }
                else if(currentChoice > -1 && choice > -1){
                    if(tiles[currentChoice] == tiles[choice]){
                        //Create a Found state within the tile object    
                        matched[currentChoice] = true;
                        matched[choice] = true;
                        choice = -1;
                        currentChoice = -1;    
                    } //
                    else{
                        //not found
                        choice = -1;
                        currentChoice = -1;
                    }
                }
            }
            else{
                currentChoice = -1;
            }**/
        }
    }
            
    public boolean isGameOver(){
        //allows Front end to detect when game is Over
        for(int i = 0; i < matched.length; i++){
            if(matched[i] == false){
                return false;
            }
        }
        return true;
    }
    //This is hunter x hunter baby, I AM STUCCCCKK
    //TAKAAAAGI sANNN, 
    //I will use Rock, Rock
    
    
    public boolean[] getMatched(){
        return Arrays.copyOf(matched, NUM_TILES); //Allows the frontend to get a copy of boolean array
        //also lets a safety precaustion as if the Front end fucks up, the back end is still safe
        //Allows front end to know which tiles have already been matched and
        //therefore which tiles should be flipped to their front image or not
        //unresponsive to clicks
    }
            //If the user hasn't clicked anything then currentChoice will still be or set to negative 1
            //So when its less than 0, currentChoice will set itself to choice which will hopefully be -1
            //however when user clicks a tile, the game then sets currentChoice to its assigned variable
            //the game would need to store currentchoice as one set choice, for example, until the game recognisez that two
            //cards have been clicked, the game takes note of current choice and waits until another current choice takes place
            //once that has been done the game will wait for anothercurrentchoice to be chosen
            //if done it will compare teh old currentChoice and the ne currentChoice
            //if it matches the boolean for loop will set both values to true
            //if not the game merely sets their flip state to the original value and set currentChoice and old currentChoice
            //to -1, and repeats cycle again
            //to do this I would need to check if a value iss stored or not, this is probably done trhough choice
            //with choice we just would need to check if the value is greater than -1
            //We need more ARMOAR
            //Na yi you
    
    
   
    
    
    /**public void processTileSelection(){

        if(tilelogic.check == 0){    //check which Tile has been clicked
            for(int i = 0; i < tiles.length; i++){  //Creates a list of Gamestates for each Tile on the field
                if(index[i] == 777){
                    index[i] = index[i];
                }
                else{
                index[i] = i;
                }
                if(index[i] == tilelogic.identification && tilechecker == 0){
                    tilestate = index[i];
                    tilelogic.identification = 100;
                    tilechecker = 1;
                }
                if(index[i] == tilelogic.identification && tilechecker == 1){
                    if(tilelogic.identification == tilestate){
                        index[tilelogic.identification] = 777;
                        index[i] = 777;
                    }
                    else{
                        tilelogic.identification = 100;
                        tilechecker = 0;
                    }
                } 
                //Think of tiles as nothing but a long list
                //A array of numbers with another number
                //This is a int array called tiles
                //int[] tiles = next int[16] (16 is just the number integers, goes to 0-15)
                //Put random numbers there, 
                //keep searching each tile until the right one is found
                //after that change the game state of the the tile
                //another if to check if there is another tile stored
                //if yes then check whether they have the same index
                //ProcessTileSelection only gets the ID of said Tiles, to do that the program will store the id numbers
                //unless it is already holding one, then processTileSelection will tell the game to change gamestates
                //There will probably be a method to check the games state and send commands to the Ui to change that accor
                //-dingly.
                //How do I make a tile unselectable?
                //I need to check for something extra
                //meaning for these if statements to activate they need to check 3 gates
                //for example, if index[i] equals something weird, like making index[i] a untold number
                //The way I am writing the code is pretty sloppy right now
                //The code needs to somehow lock two tiles without the if code falling apart
                //The code needs to also make the player decide which difficulty format they would like
            }
        }
    } **/
    //Check is card is selected usign Tile, the Tile needs to set SOMETHING to another value to check 
    //If the a card has selected, check if no card in the array has been selected, if yes proceed to next line
    //Check the ID/index of Tile1 and Tile2, if are matching change SET values to 1, if not tell UI to flip cards again and rinse and repeat

    
    
    /*public int getDoesMatch(){
        return doesmatch;
    }
    
    public void setDoesMatch(){
        this.doesmatch = doesmatch;
    }
    **/
    public int[] getTiles(){
        return tiles;
    }
    
    public void setTiles(){
        this.tiles = tiles;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(){
        this.count = count;
    }
    
    }

//Timer runs on a thread
//The UI doesn't even need to know if the match is found
//ProcessTileSelection process click
//After getting the two and compares them 
//Folder setup with sets of images can score well with algorithmitic thinking
//Somewhere within the UI, a file chooser, allows me to choose and appropiate image sets
//create UI labels, set their image data
//add them to the grid
//add them to a array
//Maybe the mainframe does it? In the code for mouseclick I would probably Doclick(this.id)

