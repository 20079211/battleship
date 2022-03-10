public class Board {

  private String[][] squares;

  public Board(){
    squares = new String[10][10];
    for(int row = 0; row<squares.length; row++) {
      for(int column = 0; column<squares[0].length; column++)
        squares[row][column] = "-";
    }
  }

  public String toString(){
    String results = "";
    for(String[] row: squares) {
      for(String column: row) {
        results += column + " ";
      }
      results += "\n";
    }
    return results;
  }

  public boolean addShip(int row, int col, int len, boolean horizontal){
    return false;
  }

  public boolean foundShip(int len){
    return false;
  }

  public int shoot(int row, int col){
    return 0;
  }

  public boolean gameOver(){
    return false;
  }

}
