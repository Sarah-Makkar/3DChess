
import java.awt.Color;
import javax.swing.ImageIcon;

public class King extends Piece
{
   ImageIcon icon;
   public King(final Location location,final Color color) {
        super(location,color);
        if(color == Color.BLACK) {
            icon =  new ImageIcon(getClass().getClassLoader().getResource("blackKing.png"));
        } else {
            icon =  new ImageIcon(getClass().getClassLoader().getResource("brownKing.png"));
        }
        super.setIcon(icon);
        
    }

     @Override
    public void focusValidMoves(ChessBoard3D board){
        int row = location.getRow();
        int col = location.getCol();
        removeFocus(board);
        int X[] = { 0, 0,1,1,1,-1,-1,-1};
        int Y[] = { 1,-1,0,1,-1, 0,-1, 1};

         Color RED = new Color(146, 39, 36);

        for (int i = 0; i < 8; i++) {
            int x = row + X[i];
            int y = col + Y[i];

            if (x <= 7 && y < 8 && x >= 0 && y >= 0) {
               Location location = board.getChessBoard(0).getLocation(x, y);
                if(location.getPiece() == null){
                    board.getChessBoard(0).getJbutton(location).setBackground(RED);
                    location.setFocused(true);
                }
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
