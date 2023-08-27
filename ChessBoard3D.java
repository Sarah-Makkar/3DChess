import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JButton;

public class ChessBoard3D extends JPanel
{
    ChessBoard[] board;
    ChessBoard chessBoard;
    private int row;
    private int col;
   
    public ChessBoard3D(MoveListener l) {
        this.row = 8;
        this.col = 8;
        createBoard(l);
    }
    
    public void createBoard(MoveListener l) {
        Color pastelBrown = new Color(131,105,83);
        Color coconut = new Color(150,90,62);
        this.board = new ChessBoard[3];
        (this.board[0] = new ChessBoard(l,0)).setBorder(BorderFactory.createMatteBorder(5,5,5,5, pastelBrown));
        (this.board[1] = new ChessBoard(l,1)).setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.black));
        (this.board[2] = new ChessBoard(l,2)).setBorder(BorderFactory.createMatteBorder(5,5,5,5, coconut));
        this.chessBoard = board[0];
        this.setLayout(new GridLayout(1,3));
        this.add(this.board[0]);
        this.add(this.board[1]);
        this.add(this.board[2]);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

     public ChessBoard getChessBoard(int n) {
        return this.board[n];
    }


    public ChessBoard getChessBoard(JButton button){
        if(this.board[0].getRow(button) != -1 && this.board[0].getCol(button) != -1){
            return board[0];
        } else if (this.board[1].getRow(button) != -1 && this.board[1].getCol(button) != -1){
            return board[1];
        } else if (this.board[2].getRow(button) != -1 && this.board[2].getCol(button) != -1){
            return board[2];
        }
        return null;
    }
}