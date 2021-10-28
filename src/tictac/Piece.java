package tictac;

public class Piece {
	
	private char pieceSymbol;
	
	public Piece(char _pieceSymbol)
	{
		setPiece(_pieceSymbol);
	}

	public char getPieceSymbol()
	{	
		return pieceSymbol;
	}

	public void setPiece(char _pieceSymbol)
	{
		pieceSymbol = _pieceSymbol;
	}

	
}
