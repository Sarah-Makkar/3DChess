import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;

public class MoveListener implements ActionListener
{
    private final Chess chess;
    private Location start;
    private ChessBoard startBoard;
    private ChessBoard endBoard;
    private Location end;
    Color lightBrown = new Color(240,216,195);
    public MoveListener(Chess chess) {
        this.chess = chess;
    }

    public void actionPerformed(ActionEvent actionEvent) {
    
    JButton button = (JButton) actionEvent.getSource();
    setMove(button);
     
    }

    public void setMove(JButton button){
        ChessBoard3D board = chess.getBoard();
        ChessBoard b = board.getChessBoard(button);
        Location location = b.getLocation(b.getRow(button), b.getCol(button));
        
        if (this.start == null) {
            Piece startPiece = location.getPiece();
            if (startPiece != null && startPiece.getColor() == this.chess.getCurrentPlayer()) {
                startPiece.focusValidMoves(board);
                button.setBackground(lightBrown);
                start = location;
                startBoard = b;
            }
        }
        else {
            end = location;
            endBoard = b;
            Piece endPiece = location.getPiece();
            Piece startPiece =  start.getPiece();
            if (endPiece != null && startPiece.getColor() == endPiece.getColor()) {
                JButton startButton = startBoard.getJbutton(start.getRow(), start.getCol());
                startButton.setBackground(start.getSquareColor());
                start = location;
                button.setBackground(lightBrown);
                startPiece = start.getPiece();
                startBoard = b;
                startPiece.focusValidMoves(board);
                end = null;
                endBoard = null;
            } else if (startPiece.isValidMove(end, board)){
                JButton startButton = startBoard.getJbutton(start.getRow(), start.getCol());
                JButton endButton = endBoard.getJbutton(end.getRow(), end.getCol());
                startButton.setBackground(start.getSquareColor());
                chess.move(start,end);
                Icon startIcon = startButton.getIcon();
                startButton.setIcon(null);
                endButton.setIcon(startIcon);
                start = null;
                startBoard = null;
                chess.switchPlayers();
            }
         }
    }
}
