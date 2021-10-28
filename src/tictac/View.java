package tictac;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;

public class View {
	  private JFrame frame = new JFrame("Non-TerribleTicTacToe");
	  private JPanel myButtonPanel = new JPanel();
	  private JButton[][] buttons;
	  
      private JPanel myTextPanel = new JPanel();
      private Controller controller;
      
      public static int viewAmount;
      public int viewID;
      
      
      private JLabel playerTurnLabel = new JLabel("First move", SwingConstants.CENTER);
      private JPanel myMainPanel = new JPanel();
  
      public View(Controller _controller)
      {
    	  controller = _controller;
    	  viewID=viewAmount;
    	  viewAmount++;
    	  init();
      }
  
      public int getViewID()
      {
    	  return viewID;
      }
      
      public JButton getButton(int x, int y)
      {
    	  return buttons[x][y];
      }
  
      public void setLabel(String text)
      {
    	  playerTurnLabel.setText(text);
      }
      
      
      public void init()
      {
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  int sideLength = controller.getBoardSideLengthFromEngine();
          buttons = new JButton[sideLength][sideLength];

    	  setupButtons(sideLength);
          myButtonPanel.setLayout(new GridLayout(sideLength,sideLength));
          myTextPanel.setLayout(new GridLayout(1,1));
          
          myTextPanel.setPreferredSize(new Dimension(150,50));
          myTextPanel.add(playerTurnLabel);
          myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
          myMainPanel.add(myButtonPanel);
          myMainPanel.add(myTextPanel);
	      frame.getContentPane().add(myMainPanel);

	      //addListeners();
          
          frame.pack();
	      frame.setVisible(true);   
      }

      public void setupButtons(int sideLength) 
      {
    	     for(int r=0; r < sideLength; r++) 
    	     {
    	          for(int c = 0; c < sideLength; c++) 
    	          {
    	              final int _r = r;
    	              final int _c = c;
    	              JButton button = buttons[_r][_c] = new JButton(" ");
    	              button.setPreferredSize(new Dimension(50,50));
    	              button.addActionListener(new ActionListener(){
    	                  @Override
    	                  public void actionPerformed(ActionEvent e) 
    	                  {
    	                      controller.buttonClicked(_r,_c, getViewID());
    	                  }
    	              });
    	              myButtonPanel.add(button);
    	          }
    	      }
    	}
      
      /*
       * public void addListeners()
      
      {
    	
    	  for (int i = 0; i < 3; i++)
    	  {
    		for (int j = 0; j < 3; j++)
    		{	  
    		buttons[i][j].addActionListener(new ActionListener(){
          	@Override
          	public void actionPerformed(ActionEvent e) 
          	{
          		JButton clickedButton = ((JButton)e.getSource());
          		clickedButton.setOpaque(true);
          		clickedButton.setBackground(Color.red);
          		
          	}
    		});
       
    	  }
    	  }
      } */
}

