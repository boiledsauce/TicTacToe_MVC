package tictac;

public class Board {
	private int sideLength;
	private Square[][] squareBoard;
	private int piecesPlaced;
	
	public Board(int _sideLength)
	{
		sideLength = _sideLength;
		squareBoard = new Square[_sideLength][_sideLength];
		piecesPlaced = 0;
		initBoard();
	}
	
	public Square getSquare(int x, int y)
	{
		// Do not return out of its scope
		assert(x >= 0 && y >= 0 && x < sideLength && y < sideLength);
		
		return squareBoard[x][y];
	}
	
	public int getSideLength()
	{
		return sideLength;
	}
	
	public boolean hasPieceOnPos(int x, int y)
	{
		Square squareAtPos = getSquare(x,y);
		Piece pieceAtPos = squareAtPos.getPiece();
		
			if (pieceAtPos == null)
				return false;
			
		return true;
	}
	
	public void placePieceOnPos(int x, int y, char token)
	{
		Square squareAtPos = getSquare(x,y);
		squareAtPos.placePiece(token);	
	}
	
	public Piece getPieceFromPos(int x, int y)
	{
		Square squareAtPos = getSquare(x,y);
		return squareAtPos.getPiece();
	}
	
	private void initBoard()
	{
		int sideLength = getSideLength();
		
		for (int x = 0; x < sideLength; x++)
		{
			for (int y = 0; y < sideLength; y++)
			{
				//  add no pieces to each square
				createSquareOnPos(x,y);
			}
		}
	}
	
	private void createSquareOnPos(int x, int y)
	{
		squareBoard[x][y] = new Square(null);
	}
	
	
}
