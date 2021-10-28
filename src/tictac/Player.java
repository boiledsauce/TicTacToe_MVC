package tictac;

public class Player {
	private int playerID;
	private RuleEngine ruleEngine;
	private int moveX;
	private int moveY;
	
	
	public Player(RuleEngine _ruleEngine, int _playerID)
	{
		ruleEngine = _ruleEngine;
		playerID = _playerID;
	}
	
	public int getPlayerMoveX()
	{
		return moveX;
	}
	
	public int getPlayerMoveY()
	{
		return moveY;
	}

	public int getPlayerID()
	{
		return playerID;
	}
	
	public void setMovePos(int x, int y)
	{
		moveX = x;
		moveY = y;
	}
	
	public String getPlayerToken()
	{
		int playerID = getPlayerID();
		
		if (playerID == 0)
			return String.valueOf('X');
		
		if (playerID == 1)
			return String.valueOf('O');
		
		return  String.valueOf(((char) (65 + getPlayerID()))); 
	}
	
	public String getPlayerName()
	{
		return "Player"+getPlayerToken();
	}
}
