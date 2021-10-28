package tictac;
import java.util.ArrayList;

public class RuleEngine {
	private Controller controller;
	private Board gameBoard;
	private ArrayList<winRule> winScenarios;
	private ArrayList<moveRule> legalMoves;
	private int playerAmount;
	private boolean isGameOver;
	
	private ArrayList<Player> players;
	private int playerTurn;
	
	
	public RuleEngine(Controller _controller)
	{
		controller = _controller;

		gameBoard = new Board(5);
		playerAmount = 3;
		
		playerTurn = 0;
		isGameOver = false;
		winScenarios = new ArrayList();
		legalMoves = new ArrayList();
		players = new ArrayList();
		
		
		for (int playerID = 0; playerID < playerAmount; playerID++)
			players.add(new Player(this, playerID));
		
		winScenarios.add(new diagonalWin(this));
		winScenarios.add(new verticalWin(this));
		winScenarios.add(new horizontalWin(this));	
		
		legalMoves.add(new moveOnEmptyTileRule(this));
	}
	
	public void setPlayerMove(int x, int y)
	{
		getPlayer().setMovePos(x,y);
	}
	
	public void performMove()
	{
		Player currentPlayer = getPlayer();
		int movePosX = currentPlayer.getPlayerMoveX();
		int movePosY = currentPlayer.getPlayerMoveY();
		
		if (isLegalMove(movePosX, movePosY))
		{
			placePieceOnBoard(movePosX, movePosY, currentPlayer.getPlayerToken().charAt(0));
			increasePlayerTurn();
		}
	}
		
	public void placePieceOnBoard(int x, int y, char token)
	{
		Board gameBoard = getBoard();
		gameBoard.placePieceOnPos(x, y, token);
	}
	
	public void setGameOver()
	{
		isGameOver = true;
	}
	
	public int getPlayerAmount()
	{
		return playerAmount;
	}
	
	public Player getPlayer()
	{
		return players.get(getPlayerTurn());
	}
	
	private int getPlayerTurn()
	{
		return playerTurn;
	}
	
	private void increasePlayerTurn()
	{
		playerTurn = (playerTurn+1) % players.size();
	}
	
	public boolean isGameOver()
	{
		for (winRule winScenario : winScenarios)
		{
			if (winScenario.isRuleFulfilled())
			{
				System.out.println("AA");
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegalMove(int x, int y)
	{
		for (moveRule legalMove : legalMoves)
		{
			if (legalMove.isMoveRuleFulfilled(x, y))
			{
				return true;
			}
		}
		return false;
	}
		
	public Board getBoard()
	{
		return gameBoard;
	}
	
	
	public Piece getPiece(int x, int y)
	{
		Board theBoard = getBoard();
		if (theBoard != null)
		{
			Square theSquare = theBoard.getSquare(x, y);
			return theSquare.getPiece();
		}
		
		return null;
	}
	
}
