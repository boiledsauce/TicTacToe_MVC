package tictac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.util.ArrayList;

import tictac.View;

public class Controller {
	 private ArrayList<View> views;
	 private RuleEngine ruleEngine;
	 
	 public Controller()
	 {
		 ruleEngine = new RuleEngine(this);	
		 views = new ArrayList();
		 for (int i = 0; i < ruleEngine.getPlayerAmount(); i++)
		 {
			 views.add(new View(this));
		 }
	 }
	 
	 public int getPlayerAmountFromEngine()
	 {
		 return ruleEngine.getPlayerAmount();
	 }
	 
	 public int getBoardSideLengthFromEngine()
	 {
		 return ruleEngine.getBoard().getSideLength();
	 }
	 
	 
	 public void buttonClicked(int row, int col, int viewID){
		 
		 
		    if (ruleEngine.getPiece(row, col) != null || ruleEngine.isGameOver())
		    	return;
		    	
		    if (! ruleEngine.isLegalMove(row, col))
		    	return;

		    Player curPlayer = ruleEngine.getPlayer();
		    
		    
		    if (viewID != curPlayer.getPlayerID())
		    	return;
		    
		    ruleEngine.setPlayerMove(row, col);		    
		    ruleEngine.performMove();
		    
		    for (View view : views)
		    {
		    	view.getButton(row, col).setText(curPlayer.getPlayerToken());
		    	view.setLabel(ruleEngine.getPlayer().getPlayerToken() + "'s turn");
		    	
		    	views.get(curPlayer.getPlayerID()).setLabel("player " + ruleEngine.getPlayer().getPlayerToken() + "'s turn");
		    	//views.get(curPlayer.getPlayerID()).setLabel("player " + ruleEngine.getPlayer().getPlayerToken() + "'s turn");
		    }
		   
		    views.get(curPlayer.getPlayerID()).setLabel("player " + ruleEngine.getPlayer().getPlayerToken() + "'s turn");
		    curPlayer.getPlayerID();

		    if (ruleEngine.isGameOver())
		    {
		    	views.get(curPlayer.getPlayerID()).setLabel(curPlayer.getPlayerName() + " has Won the game");
		    	ruleEngine.setGameOver();
		    	
		    	return;
		    }

	}
}
