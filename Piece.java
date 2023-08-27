import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JButton;

public abstract class Piece{
    private Icon icon;
    protected final Color color;
    protected Location location;
    
    protected Piece(final Location location,final Color color) {
        this.location = location;
        this.color = color;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public Icon getIcon() {
        return this.icon;
    }
    
    public Color getColor() {
        return this.color;
    }


    public void removeFocus(ChessBoard3D board) {
        for(int i = 0 ; i < 8; i++){
                  for(int j = 0 ; j < 8; j++){
                      for(int k = 0 ; k < 3; k++){
                          Location location = board.getChessBoard(k).getLocation(i,j);
                          JButton button = board.getChessBoard(k).getJbutton(i,j);
                          if(location.getIsFocused() == true) {
                              button.setBackground(location.getSquareColor());
                              location.setFocused(false);
                          }
                      }
                  }
             }
    }

    public abstract void focusValidMoves(ChessBoard3D board);
    public abstract boolean isValidMove(Location l, ChessBoard3D board);
   
}