
import java.awt.Color;
import javax.swing.ImageIcon;

public class Bishop extends Piece
{
   ImageIcon icon;
    public Bishop(final Location location,final Color color) {
        super(location,color);
        if(color == Color.BLACK) {
            icon = new ImageIcon(getClass().getClassLoader().getResource("blackBishop.png"));
        } else {
            icon =  new ImageIcon(getClass().getClassLoader().getResource("brownBishop.png"));
        }
        super.setIcon(icon);
        
    }

   Color RED = new Color(146, 39, 36);

    @Override
    public void focusValidMoves(ChessBoard3D board){
        int row = location.getRow();
        int col = location.getCol();
        removeFocus(board);
        focusDiagonal1(board.getChessBoard(0), row, col);
        focusDiagonal2(board.getChessBoard(0), row, col);
    }

    public void focusDiagonal1(ChessBoard board, int row, int col){
        int j = col + 1;
        for(int i = row + 1; i < 8 && j < 8; i++){
            Location location = board.getLocation(i, j);
            if(location.getPiece() != null) {
                break;
            } else {
                board.getJbutton(location).setBackground(RED);
                location.setFocused(true);
            }
            j++;
        }

        j = col - 1;
        for(int i = row - 1; i >= 0 && j >= 0; i--){
            Location location = board.getLocation(i, j);
            if(location.getPiece() != null) {
                break;
            } else {
                board.getJbutton(location).setBackground(RED);
                location.setFocused(true);
            }
            j--;
        }
    }    


    public void focusDiagonal2(ChessBoard board, int row, int col){
        int j = col + 1;
        for(int i = row - 1; i >= 0 && j < 8; i--){
            Location location = board.getLocation(i, j);
            if(location.getPiece() != null) {
                break;
            } else {
                board.getJbutton(location).setBackground(RED);
                location.setFocused(true);
            }
            j++;
        }

        j = col - 1;
        for(int i = row + 1; i < 8 && j >= 0; i++){
             Location location = board.getLocation(i, j);
            if(location.getPiece() != null) {
                break;
            } else {
                board.getJbutton(location).setBackground(RED);
                location.setFocused(true);
            }
            j--;
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
