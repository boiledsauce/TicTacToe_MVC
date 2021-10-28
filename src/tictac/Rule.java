package tictac;
/*
public interface Rule {
	public boolean isRuleFulfilled();
}
*/

abstract class Rule
{
	private RuleEngine ruleEngine;
	
	public Rule(RuleEngine _ruleEngine)
	{
		ruleEngine = _ruleEngine;
	}
	
	public Board getBoardFromEngine() { return ruleEngine.getBoard(); }
	public Piece getPieceFromEngine(int x, int y) { return ruleEngine.getPiece(x, y); }
	public int getBoardSizeFromEngine() { return getBoardFromEngine().getSideLength(); }
		
}

abstract class winRule extends Rule
{
	public winRule(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}

	public abstract boolean isRuleFulfilled();
}

class diagonalWin extends winRule
{
	public diagonalWin(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRuleFulfilled()
	{
		int boardLength = getBoardSizeFromEngine();
	
		/* {1, 0, 0, 0} */
		/* {0, 0, 0, 0} */
		/* {0, 0, 1, 0} */
		/* {0, 0, 0, 1} */	
		
		for (int diagonalNW = 1; diagonalNW < boardLength; diagonalNW++)
		{
			Piece piece = getPieceFromEngine(diagonalNW,diagonalNW);
			Piece pieceNext = getPieceFromEngine(diagonalNW-1, diagonalNW-1);
			
			if (piece == null || pieceNext == null)
				break;
			
			if (piece.getPieceSymbol() != pieceNext.getPieceSymbol())
			{
				break;
			}
			
			if (diagonalNW == boardLength-1)
				return true;
		}
		
		/* {0, 0, 0, 1} */
		/* {0, 0, 1, 0} */
		/* {0, 1, 0, 0} */
		/* {1, 0, 0, 0} */
		
		for (int diagonalNE = boardLength-1; diagonalNE > 0; diagonalNE--)
		{
			Piece piece = getPieceFromEngine(diagonalNE, boardLength-diagonalNE-1);			
			Piece pieceNext = getPieceFromEngine(diagonalNE-1, boardLength-diagonalNE);
			
			if (piece == null || pieceNext == null)
				return false;
			
			if (piece.getPieceSymbol() != pieceNext.getPieceSymbol())
			{
				return false;
			}
		}
	
		return true;
	}

	
}

class verticalWin extends winRule
{
	public verticalWin(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRuleFulfilled()
	{
		/* {1, 0, 0, 0} */
		/* {1, 0, 0, 0} */
		/* {1, 0, 0, 0} */
		/* {1, 0, 0, 0} */
		
		int boardLength = getBoardSizeFromEngine();
		
		for (int x = 0; x < boardLength; x++)
		{
			
			for (int y = 1; y < boardLength; y++)
			{
				Piece piece = getPieceFromEngine(x, y-1);			
				Piece pieceNext = getPieceFromEngine(x, y);
				
				if (piece == null || pieceNext == null)
					break;
				
				if (piece.getPieceSymbol() != pieceNext.getPieceSymbol())
				{
					break;
				}
				
				if (y == boardLength-1)
					return true;
			}
		}
		
		return false;
	}
}

class horizontalWin extends winRule
{
	public horizontalWin(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRuleFulfilled()
	{
		int boardLength = getBoardSizeFromEngine();
		
		for (int y = 0; y < boardLength; y++)
		{
			for (int x = 1; x < boardLength; x++)
			{
				Piece piece = getPieceFromEngine(x-1, y);			
				Piece pieceNext = getPieceFromEngine(x, y);
				
				if (piece == null || pieceNext == null)
					break;
				
				if (piece.getPieceSymbol() != pieceNext.getPieceSymbol())
				{
					break;
				}
				
				if (x == boardLength-1)
					return true;
			}
		}
		
		return false;
	}		
}

abstract class moveRule extends Rule
{
	public moveRule(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}

	public abstract boolean isMoveRuleFulfilled(int x, int y);
}

class moveOnEmptyTileRule extends moveRule
{

	public moveOnEmptyTileRule(RuleEngine _ruleEngine) {
		super(_ruleEngine);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isMoveRuleFulfilled(int x, int y)
	{
		Piece thePiece = getPieceFromEngine(x,y);
			
		if (thePiece == null)
			return true;
		
		
		return false;
	}
	
	
	
}



