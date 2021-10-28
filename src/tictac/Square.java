package tictac;

public class Square {
	private Piece squarePiece;
	
	public Square()
	{}
	
	public Square(Piece thisPiece)
	{
		squarePiece = thisPiece;
	}
	
	public Piece getPiece()
	{
		return squarePiece;
	}
	
	public boolean hasPiece()
	{
		return getPiece() != null;
	}
	
	public void placePiece(char symbol)
	{
		assert( ! hasPiece() );
		
		Piece newPiece = new Piece(symbol);
		squarePiece = newPiece;
	}
}
