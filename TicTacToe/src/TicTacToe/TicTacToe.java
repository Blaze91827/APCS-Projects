import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
    printBoard(board);
    
    boolean gameEnd = false;
    while (!gameEnd) {
     boolean invalidmovex = false;
     while (!invalidmovex) {
      System.out.println("Player 1: Enter the x-coordinate and then the y-coordinate: ");
      int p1x = sc.nextInt();
      int p1y = sc.nextInt();
      if (board[p1x][p1y].equals("_")) {
       board = updateBoard(board, p1x, p1y, "x");
       invalidmovex = true;
      }
      else {
       System.out.println("Invalid move. Try again: ");
       printBoard(board);
      }
     }
     printBoard(board);
     gameEnd = checkWinner(board, "x");
     if (gameEnd) {
      System.out.println("Player 1 wins!");
      break;
     }
     gameEnd = checkDraw(board);
     if (gameEnd) {
      System.out.println("Draw");
      break;
     }
     boolean invalidmovey = false;
     while (!invalidmovey) {
      System.out.println("Player 2: Enter the x-coordinate and then the y-coordinate: ");
      int p2x = sc.nextInt();
      int p2y = sc.nextInt();
      if (board[p2x][p2y].equals("_")) {
       board = updateBoard(board, p2x, p2y, "o");
       invalidmovey = true;
      }
      else {
       System.out.println("Invalid move. Try again: ");
       printBoard(board);
      }
     }
     printBoard(board);
     gameEnd = checkWinner(board, "o");
     if (gameEnd) {
      System.out.println("Player 2 wins!");
     }
    }
    sc.close();
  }
  public static String[][] updateBoard(String[][] board, int x, int y, String letter) {
   board[x][y] = letter;
   return board;
  }
  public static void printBoard(String[][] board) {
   for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
     System.out.print("|");
     System.out.print("" + board[i][j]);
    }
    System.out.print("|");
    System.out.println("");
   }
   
  }
  public static boolean checkWinner(String[][] board, String letter) {
   if (board[0][0].equals(letter) && board[0][1].equals(letter) && board[0][2].equals(letter)) {
    return true;
   }
   else if (board[1][0].equals(letter) && board[1][1].equals(letter) && board[1][2].equals(letter)) {
    return true;
   }
   else if (board[2][0].equals(letter) && board[2][1].equals(letter) && board[2][2].equals(letter)) {
    return true;
   }
   else if (board[0][0].equals(letter) && board[1][0].equals(letter) && board[2][0].equals(letter)) {
    return true;
   }
   else if (board[0][1].equals(letter) && board[1][1].equals(letter) && board[2][1].equals(letter)) {
    return true;
   }
   else if (board[0][2].equals(letter) && board[1][2].equals(letter) && board[2][2].equals(letter)) {
    return true;
   }
   else if (board[0][0].equals(letter) && board[1][1].equals(letter) && board[2][2].equals(letter)) {
    return true;
   }
   else if (board[0][2].equals(letter) && board[1][1].equals(letter) && board[2][0].equals(letter)) {
   return true; 
   }
   else {
    return false;
   }
  }
  public static boolean checkDraw(String[][] board) {
   boolean empty = false;
   for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
     if (board[i][j].equals("_")) {
      empty = true;
     }
    }
   }
   if (empty) {
    return false;
   }
   else {
    return true;
   }
  }
}