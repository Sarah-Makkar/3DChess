import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChessBoard extends JPanel{

 JButton grid[][] = new JButton[8][8];
 Location tiles[][] = new Location[8][8];

	public ChessBoard(MoveListener l, int board) {
		Color darkBrownColor = new Color(112,77,43,255);
		Color lightBrownColor = new Color(191,156,115,255);
		JButton chessButton = null;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if((i+j) % 2 == 0){
                    chessButton = new JButton();
                    chessButton.setModel(new FixedStateButtonModel());
                    grid[i][j] = chessButton;
                    chessButton.setBackground(darkBrownColor);
                    chessButton.setOpaque(true);
                    chessButton.setBorderPainted(false);
                    add(chessButton);
                    tiles[i][j] = new Location(i,j,darkBrownColor,board);
                } else {
                    chessButton = new JButton();
                    chessButton.setModel(new FixedStateButtonModel());
                    grid[i][j] = chessButton;
                    
                    chessButton.setBackground(lightBrownColor);
                    chessButton.setOpaque(true);
                    chessButton.setBorderPainted(false);
                    add(chessButton);
                    tiles[i][j] = new Location(i,j,lightBrownColor,board);
                }
            
                grid[i][j].addActionListener(l);
                grid[i][j].setFocusPainted(false);
                
            }
        }
        
		this.setLayout(new GridLayout(8, 8)); 

	}
    

    public JButton getJbutton(int row, int col) {
        return grid[row][col];
    }

    public JButton getJbutton(Location location) {
        int row = location.getRow();
        int col = location.getCol();
        return grid[row][col];
    }

     public Location getLocation(int row, int col) {
        return tiles[row][col];
    }

    public int getRow(JButton button){
        for (int i = 0; i < 8; i++){
             for (int j = 0; j < 8; j++){
                 if(grid[i][j] == button){
                     return i;
                 }
             }
        }
        return -1;
    }

     public int getCol(JButton button){
        for (int i = 0; i < 8; i++){
             for (int j = 0; j < 8; j++){
                 if(grid[i][j] == button){
                     return j;
                 }
             }
        }
         return -1;
    }
}

class FixedStateButtonModel extends DefaultButtonModel    {
        @Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public boolean isRollover() {
            return false;
        }
}