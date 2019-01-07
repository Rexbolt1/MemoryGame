/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

/**
 *
 * @author rexbolt1
 */
public class MemoryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        GameLogic logic = new GameLogic();

        //MainFrame frame = new MainFrame();        
        
        logic.processUserChoice(7); //test code
        logic.processUserChoice(1);
        logic.processUserChoice(2);
        logic.processUserChoice(9);
        boolean[]matched = logic.getMatched();
        //getmatched
        for(boolean b : matched){
            System.out.print(b ? 1 : 0);
        }
           
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainFrame().setVisible(true);
        }
        });
    }
    
}
