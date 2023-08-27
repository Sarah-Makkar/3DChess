import java.awt.Color;

public class Location 
{
    private final int row;
    private final int col;
    private int board;
    private final Color squareColor;
    private Piece piece;
    private boolean isFocused;

    public Location(final int row, final int col, final Color squareColor, int board) {
        this.row = row;
        this.col = col;
        this.squareColor = squareColor;
        this.board = board;
    }

    public void setFocused(boolean isFocused){
        this.isFocused = isFocused;
    }
    
    public int getRow() {
        return this.row;
    }

     public int getBoardNumber() {
        return this.board;
    }

    public Color getSquareColor() {
        return this.squareColor;
    }
    
    public int getCol() {
        return this.col;
    }

    public boolean getIsFocused(){
        return isFocused;
    }

    public void setPiece(final Piece piece) {
        if (this.piece != null) {
            this.piece = null;
        }
        this.piece = piece;
        if (this.piece != null) {
            this.piece = piece;
        }
    }
    
    public Piece getPiece() {
        return this.piece;
    }
}
