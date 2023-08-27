import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Chess extends JFrame
{
    private final ChessBoard3D chessBoard3D;
    private final Color whitePlayer;
    private final Color blackPlayer;
    private Color currentPlayer;
    
    public Chess() {
        super("Chess");
        this.chessBoard3D = new ChessBoard3D(new MoveListener(this));
        this.whitePlayer = Color.WHITE;
        this.blackPlayer = Color.BLACK;
    }
    
    private void setGame() {
        this.setChessPieces();
        this.currentPlayer = this.whitePlayer;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(this.chessBoard3D);
    }
    
   private void setChessPieces() {
        this.setPiece(0, 0, new Rook(chessBoard3D.getChessBoard().getLocation(0,0),Color.BLACK));
        this.setPiece(0, 1, new Bishop(chessBoard3D.getChessBoard().getLocation(0,1),Color.BLACK));
        this.setPiece(0, 2, new Knight(chessBoard3D.getChessBoard().getLocation(0,2),Color.BLACK));
          this.setPiece(0, 3, new Queen(chessBoard3D.getChessBoard().getLocation(0,3),Color.BLACK));
        this.setPiece(0, 4, new King(chessBoard3D.getChessBoard().getLocation(0,4),Color.BLACK));
        this.setPiece(0, 5, new Knight(chessBoard3D.getChessBoard().getLocation(0,5),Color.BLACK));
        this.setPiece(0, 6, new Bishop(chessBoard3D.getChessBoard().getLocation(0,6),Color.BLACK));
        this.setPiece(0, 7, new Rook(chessBoard3D.getChessBoard().getLocation(0,7),Color.BLACK));
        for (int i = 0; i < 8; i++) {
            this.setPiece(1, i, new Pawn( chessBoard3D.getChessBoard().getLocation(1,i),Color.BLACK));
        }
        for (int j = 0; j < 8; j++) {
            this.setPiece(6, j, new Pawn(chessBoard3D.getChessBoard().getLocation(6,j),Color.WHITE));
        }
        this.setPiece(7, 0, new Rook(chessBoard3D.getChessBoard().getLocation(7,0),Color.WHITE));
        this.setPiece(7, 1, new Bishop(chessBoard3D.getChessBoard().getLocation(7,1),Color.WHITE));
        this.setPiece(7, 2, new Knight(chessBoard3D.getChessBoard().getLocation(7,2),Color.WHITE));
        this.setPiece(7, 3, new Queen(chessBoard3D.getChessBoard().getLocation(7,3),Color.WHITE));
        this.setPiece(7, 4, new King(chessBoard3D.getChessBoard().getLocation(7,4),Color.WHITE));
        this.setPiece(7, 5, new Knight(chessBoard3D.getChessBoard().getLocation(7,5),Color.WHITE));
        this.setPiece(7, 6, new Bishop(chessBoard3D.getChessBoard().getLocation(7,6),Color.WHITE));
        this.setPiece(7, 7, new Rook(chessBoard3D.getChessBoard().getLocation(7,7),Color.WHITE));
    }
    
    private void setPiece(final int i, final int j, final Piece piece) {
        JButton button = chessBoard3D.getChessBoard().getJbutton(i, j);
        button.setIcon(piece.getIcon());
        chessBoard3D.getChessBoard().getLocation(i,j).setPiece(piece);
    }
    
    public void move(final Location start, final Location end) {
        final Piece piece = start.getPiece();
        start.setPiece(null);
        end.setPiece(piece);
    }
    
    public ChessBoard3D getBoard() {
        return this.chessBoard3D;
    }
    
    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    public void switchPlayers() {
        if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
        }
        else {
            this.currentPlayer = this.blackPlayer;
        }
    }
    
    public static void main(final String[] array) {
        final Chess chess = new Chess();
        chess.setGame();
        chess.setSize(650, 650);
        chess.setVisible(true);
    }
}
