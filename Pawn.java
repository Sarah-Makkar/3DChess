import javax.swing.ImageIcon;
import java.awt.Color;

public class Pawn extends Piece
{
   ImageIcon icon;
   boolean isFirstMove;
    public Pawn(final Location location,final Color color) {
        super(location,color);
        if(color == Color.BLACK) {
            icon = new ImageIcon(getClass().getClassLoader().getResource("blackPawn.png"));
        } else {
            icon = new ImageIcon(getClass().getClassLoader().getResource("brownPawn.png"));
        }
        isFirstMove = true;
        super.setIcon(icon);
        
    }
     @Override
    public void focusValidMoves(ChessBoard3D board) {
        removeFocus(board);
        Color RED = new Color(146, 39, 36);
        int row = location.getRow();
        int col = location.getCol();
        Location location1, location2, location3, location4;
        if (isFirstMove == true) {
            if (color == Color.BLACK) {
                location1 = board.getChessBoard(0).getLocation(row + 1, col);
                location2 = board.getChessBoard(0).getLocation(row + 2, col);
                location3 = board.getChessBoard(1).getLocation(row + 1, col);
                location4 = board.getChessBoard(2).getLocation(row + 2, col);
            } else {
                location1 = board.getChessBoard(0).getLocation(row - 1, col);
                location2 = board.getChessBoard(0).getLocation(row - 2, col);
                location3 = board.getChessBoard(1).getLocation(row - 1, col);
                location4 = board.getChessBoard(2).getLocation(row - 2, col);
            }

            if (location1.getPiece() == null) {
                board.getChessBoard(0).getJbutton(location1).setBackground(RED);
                location1.setFocused(true);
                if (location2.getPiece() == null) {
                    board.getChessBoard(0).getJbutton(location2).setBackground(RED);
                    location2.setFocused(true);
                }
            } 
            if(location3.getPiece() == null) {
                board.getChessBoard(1).getJbutton(location3).setBackground(RED);
                location3.setFocused(true);
            }
            if(location4.getPiece() == null) {
                board.getChessBoard(2).getJbutton(location4).setBackground(RED);
                location4.setFocused(true);
            }
            

        } else {
            int boardNumber = location.getBoardNumber();
            if (color == Color.BLACK) {
                if (boardNumber == 0) {
                    location1 = board.getChessBoard(0).getLocation(row + 1, col);
                    location2 = board.getChessBoard(1).getLocation(row + 1, col);
                    location3 = null;
                    location4 = null;
                } else if (boardNumber == 1) {
                    location1 = board.getChessBoard(0).getLocation(row + 1, col);
                    location2 = board.getChessBoard(1).getLocation(row + 1, col);
                    location3 = board.getChessBoard(2).getLocation(row + 1, col);
                } else {
                    location1 = null;
                    location2 = board.getChessBoard(1).getLocation(row + 1, col);
                    location3 = board.getChessBoard(2).getLocation(row + 1, col);
                }
            } else {
                 if (boardNumber == 0) {
                    location1 = board.getChessBoard(0).getLocation(row - 1, col);
                    location2 = board.getChessBoard(1).getLocation(row - 1, col);
                    location3 = null;
                } else if (boardNumber == 1) {
                    location1 = board.getChessBoard(0).getLocation(row - 1, col);
                    location2 = board.getChessBoard(1).getLocation(row - 1, col);
                    location3 = board.getChessBoard(2).getLocation(row - 1, col);
                }else {
                    location1 = null;
                    location2 = board.getChessBoard(1).getLocation(row - 1, col);
                    location3 = board.getChessBoard(2).getLocation(row - 1, col);
                }
            }

            if(location1 != null && location1.getPiece() == null) {
                board.getChessBoard(0).getJbutton(location1).setBackground(RED);
                location1.setFocused(true);
            }
            if(location2 != null && location2.getPiece() == null) {
                board.getChessBoard(1).getJbutton(location2).setBackground(RED);
                location2.setFocused(true);
            }
            if(location3 != null && location3.getPiece() == null) {
                board.getChessBoard(2).getJbutton(location3).setBackground(RED);
                location3.setFocused(true);
            }
        }
    }
    
    @Override
    public boolean isValidMove(Location location, ChessBoard3D board) {
       if (location.getIsFocused() == true) {
            removeFocus(board);
            this.location = location;
            isFirstMove = false;
            return true;
        } else {
            return false;
        }
    }
}
