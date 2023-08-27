import javax.swing.ImageIcon;
import java.awt.Color;

public class Queen extends Piece
{
   ImageIcon icon;
    public Queen(final Location location,final Color color) {
        super(location,color);
        if(color == Color.BLACK) {
           icon = new ImageIcon(getClass().getClassLoader().getResource("blackQueen.png"));
        } else {
            icon = new ImageIcon(getClass().getClassLoader().getResource("brownQueen.png"));
        }
        super.setIcon(icon);
        
    }

    Color RED = new Color(146, 39, 36);

    public void focusValidMoves(ChessBoard3D board){
        int row = location.getRow();
        int col = location.getCol();
        int boardNumber = location.getBoardNumber();
        removeFocus(board);

        if(boardNumber == 0){
            focusStepOnce(board.getChessBoard(1), row, col);
            focusStepTwice(board.getChessBoard(2), row,col);
        } else if(boardNumber == 1){
            focusStepOnce(board.getChessBoard(0), row, col);
            focusStepOnce(board.getChessBoard(2), row, col);
        } else {
            focusStepOnce(board.getChessBoard(1), row, col);
            focusStepTwice(board.getChessBoard(0), row,col);
        }

        focusVerticalMoves(board.getChessBoard(boardNumber), row, col);
        focusHorizontalMoves(board.getChessBoard(boardNumber), row, col);
        focusDiagonal1(board.getChessBoard(boardNumber), row, col);
        focusDiagonal2(board.getChessBoard(boardNumber), row, col);
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
        for(int i = row + 1; i <= 7 && j >= 0; i++){
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

    public void focusStepOnce(ChessBoard board, int row, int col){
        int X[] = { 0, 0,1,1,1,-1,-1,-1};
        int Y[] = { 1,-1,0,1,-1, 0,-1, 1};

        for (int i = 0; i < 8; i++) {
            int x = row + X[i];
            int y = col + Y[i];

            if (x <= 7 && y < 8 && x >= 0 && y >= 0) {
               Location location = board.getLocation(x, y);
                if(location.getPiece() == null){
                    board.getJbutton(location).setBackground(RED);
                    location.setFocused(true);
                }
            }
        }
    }

     public void focusStepTwice(ChessBoard board, int row, int col){

        int X[] = { 0, 0,2,2,2,-2,-2,-2};
        int Y[] = { 2,-2,0,2,-2, 0,-2, 2};

        int StepOnceX[] = { 0, 0,1,1,1,-1,-1,-1};
        int StepOnceY[] = { 1,-1,0,1,-1, 0,-1, 1};


        for (int i = 0; i < 8; i++) {
            int x = row + X[i];
            int y = col + Y[i];

            int stepOnceX = row + StepOnceX[i];
            int stepOnceY = col + StepOnceY[i];

            if (x <= 7 && y < 8 && x >= 0 && y >= 0 && stepOnceX <= 7 && stepOnceY < 8 && stepOnceX >= 0 && stepOnceY >= 0) {
                if(board.getLocation(stepOnceX,stepOnceY).getPiece() == null){
                    Location location = board.getLocation(x, y);
                    if(location.getPiece() == null){
                        board.getJbutton(location).setBackground(RED);
                        location.setFocused(true);
                    }
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
