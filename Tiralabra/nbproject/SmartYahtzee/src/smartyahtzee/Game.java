/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartyahtzee;

import java.util.ArrayList;

/**
 *
 * @author essalmen
 */
public class Game {
    
    private ArrayList<Player> players;
    
    public Game(int humans, int bots) {
        
        players = new ArrayList<Player>();
        
        for (int i = 0; i<humans; i++) {
            Human humanPlayer = new Human();
            players.add(humanPlayer);
        }
        
        for (int i = 0; i<bots; i++)
        {
            Bot botPlayer = new Bot();
            players.add(botPlayer);
        }
        
    }
    
    public void runGame()
    {
        for (int i = 0; i<16; i++)
        {
            for (Player player : players)
            {
                //drawScoreboard();
                player.playTurn();
            }
        }
    }

   
    
    
    
}