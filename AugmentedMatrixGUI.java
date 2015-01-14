/*
 * Author: Sebastian Amara
 * Date: January 8, 2015
 * Description: representation of an augmented matriz
 * */
public class AugmentedMatrixGUI
{
  /** The underlying matrix that will hold the data */
  private ConnectFourBoard theBoard;
  
  /** The status message at the top of the window */
  private JLabel status;
  
  
  
  
  
  
  /** An inner class that represents one graphical cell in the matrix.
    * Each cell keeps track of what row and column it is in.
    * These are the objects that will listen for mouse clicks.
    * Because they are an inner class, they have access to all of
    * the methods in the AugmentedMatrixGUI outer class.  
    * */
  class BoardCell extends JPanel
  {
    /** The row in which this BoardCell appears in the board. *
      * */
    private int row;
    
    /** The column in which this BoardCell appears in the board. 
      * */
    private int column;
    
    /** Create a new BoardCell object at row r and column c. 
      * The constructor is the right place to add the PlayListener too. */
    BoardCell( int r, int c )
    {
      row = r;
      column = c;
      addMouseListener(new PlayListener());
    }
  
    /** Return the preferred size for this BoardCell */
    public Dimension getPreferredSize()
    {
      // Just a suggestion. Feel free to change it if you want.  
      return new Dimension( 50, 50 );
    }
  
    // Paint the BoardCell.  that this method should paint empty cells 
    // in one color, cells filled with and 'X' with another color, and cells 
    // filled with an 'O' in a third color.  
    protected void paintComponent( Graphics g )
    { 
      super.paintComponent( g );
      //creates yellow frame
      g.setColor(Color.YELLOW);
      g.fillRect(0,0,50,50);
      //determines color of circles
      if (theBoard.getContents(row,column) == ' ')
        g.setColor(new Color(160,160,160));
      if (theBoard.getContents(row,column) == 'X')
        g.setColor(Color.RED);
      if (theBoard.getContents(row,column) == 'O')
        g.setColor(Color.BLUE);
      g.fillOval(3,3,44,44);
      //draws a border to circles 
      g.setColor(Color.BLACK);
      g.drawOval(3,3,44,44);
    }
    
    /** This is the listener that will handle clicks on the board cell.
      * You will not need to change this code at all, but you should understand 
      * what is going on.
      * */
    class PlayListener implements MouseListener
    {
      /** Inform the ConnectFour object that the corresponding column has been
        * clicked */
      public void mouseClicked( MouseEvent e ) 
      {
        makeMove( column );
      }
      
      public void mousePressed( MouseEvent e ) {}
      public void mouseReleased( MouseEvent e ) {}
      public void mouseEntered( MouseEvent e ) {}
      public void mouseExited( MouseEvent e ) {}
    }
  }
}