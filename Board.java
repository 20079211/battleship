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
      for(String column: row) { // add the contents through the columns of the current row
        results += column + " ";
      }
      results += "\n"; // after each row, move to the next line
    }
    return results;
  }

  public boolean addShip(int row, int col, int len, boolean horizontal){
    if(horizontal) { // horizontal ship placement
      if((col + len) <= squares[0].length) { // if the ship's length and placement would be on the board
        for(int column = col; column<col+len; column++) {// iterate through the cells that would be occupied by the placed ship
          if(squares[row][column] == "b") {
            return false; // if theres a ship there, short-circuit and return false
          }
        }
        for(int column = col; column<col+len; column++) {
          squares[row][column] = "b"; // if not, make the ship on the board
        }
        return true; // s-s if horizontal and possible
      }
      else {
        return false;
      }
    }
      
    else if(!(horizontal)) { // vertical ship placement
      if((row + len) <= squares.length) { // if the ship's length and placement would be on the board
        for(int rows = row; rows<row+len; rows++) { // iterate through the cells that would be occupied by the placed ship
          if(squares[rows][col] == "b") {
            return false; // if there's a ship there, short-circuit and return false
          }
        }
        for(int rows = row; rows<row+len; rows++) {
          squares[rows][col] = "b"; // when it's a valid placement, create the ship
        }
        return true; // s-s if vertical and possible
      }
      else {
        return false;
      }
    }
    return false;
  }

  public boolean foundShip(int len){
    int comparator = 0; // counting the length of a found ship
    for(String[] row: squares) { // horizontal ship finder
      for(String column: row) {
        if(column.equals("b")) {
          comparator++; 
        }
        if(!(column.equals("b"))) { // stop counting when the ship ends
          if(comparator == len) { // if the ship is length 'len' - return true
            return true;
          }
          else {
            comparator = 0; // resetting the counter variable
          }
        }
      }
    }
    for(int column = 0; column<squares[0].length; column++) // vertical ship finder
      for(int row = 0; row<squares.length; row++) {
        if(squares[row][column].equals("b")) {
          comparator++;
        }
        if(!(squares[row][column].equals("b"))) {
          if(comparator == len) {
            return true;
          }
          else {
            comparator = 0;
          }
        }
      }
    return false;
  }

  public int shoot(int row, int col){
    if(row < squares.length && col < squares[0].length)  // boundary condition for the board size  {
      if(squares[row][col].equals("b")) {
        squares[row][col] = "x";
        return 1;
      }
      else if(squares[row][col].equals("m") || squares[row][col].equals("x")) {
        return 2;
        }
      else if(squares[row][col].equals("-")) {
        squares[row][col] = "m";
        return 0;
      }
    }
    return -1;
  }

  public boolean gameOver(){
    for(String[] row: squares) {
      for(String column: row) { // iterate through the whole board array, and if a ship is found - don't end the game
        if(column.equals("b")) {
          return false;
        }
      }
    }
    return true;
  }

}
