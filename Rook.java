import java.awt.Color;
import javax.swing.ImageIcon;

public class Rook extends Piece
{
   ImageIcon icon;
    public Rook(final Location location,final Color color) {
        super(location,color);
        if(color == Color.BLACK) {
             icon = new ImageIcon(getClass().getClassLoader().getResource("blackRook.png"));
        } else {
            icon = new ImageIcon(getClass().getClassLoader().getResource("brownRook.png"));
        }
        super.setIcon(icon);
        
    }
    Color RED = new Color(146, 39, 36);
    
    @Override
    public void focusValidMoves(ChessBoard3D board){
        int row = location.getRow();
        int col = location.getCol();
        removeFocus(board);
        focusVerticalMoves(board.getChessBoard(0), row, col);
        focusHorizontalMoves(board.getChessBoard(0), row, col);
    }

    public void focusVerticalMoves(ChessBoard board,int row, int col){
            for(int i = row- 1; i >= 0; i--){
                 Location location = board.getLocation(i,col);
                 if(location.getPiece() != null) {
                     break;
                 } else {
                     board.getJbutton(location).setBackground(RED);
                     location.setFocused(true);
                 }
            }

            for(int i = row + 1; i < 8; i++){
                 Location location = board.getLocation(i,col);
                 if(location.getPiece() != null) {
                     break;
                 } else {
                     board.getJbutton(location).setBackground(RED);
                     location.setFocused(true);
                 }
            }
    }

    public void focusHorizontalMoves(ChessBoard board,int row, int col){
            for(int i = col + 1; i < 8; i++){
                 Location location = board.getLocation(row, i);
                 if(location.getPiece() != null) {
                     break;
                 } else {
                     board.getJbutton(location).setBackground(RED);
                     location.setFocused(true);
                 }
            }

            for(int i = col - 1; i >= 0; i--){
                 Location location = board.getLocation(row, i);
                 if(location.getPiece() != null) {
                     break;
                 } else {
                     board.getJbutton(location).setBackground(RED);
                     location.setFocused(true);
                 }
            }
    }

    @Override
    public boolean isValidMove(Location location, ChessBoard3D board) {
       if (location.getIsFocused() == true) {
            removeFocus(board);
            this.location = location;
            return true;
        } else {
            return false;
        }
    }
}
