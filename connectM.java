import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class connectM{
   static int boardHeight=0;
   static int boardWidth=0;
   static int[][] board;
   static int winNumber;

   // creates the board on game start
   public connectM(){  
      Scanner reader = new Scanner(System.in);    
      System.out.println("Please Select a Board Size");
      int size = reader.nextInt();
      boardHeight=size;
      boardWidth=size;
      board= new int [boardHeight][boardWidth];
      System.out.println("Please Select a Winning Number");
      winNumber = reader.nextInt();
   }
   
   
   public static void main(String args[]){
      int player1 = 1;
      int player2 = 2;
      Scanner reader = new Scanner(System.in);
      connectM cM=new connectM();
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("");
        outer:

      cM.printBoard();
      
      for(int i=0;i<100;i++){
         placeToken(player1, cM);
         cM.printBoard();
         placeToken(player2, cM);
         cM.printBoard();
         

      }
      /*
         cM.board[4][3] = 1;
         cM.board[4][4] = 2;
         cM.board[3][4] = 1;
         cM.printBoard();
         findWinnerDiagnal(cM);*/
   }
   
   //This function prints the board for the game
    public static void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0){
                    System.out.print(" _ ");
                    }
                if(board[i][j] == 1){
                    System.out.print(" X ");
                    }
                if(board[i][j] == 2){
                    System.out.print(" O ");
                    }
            }
            System.out.println();
        }
        
        for(int i=0;i<boardWidth;i++)
            System.out.print("|" + (i) + "|");
        System.out.println();
    }
  
  //This function is for placing a token for the selected token.
  public static void placeToken(int id, connectM cM){
      
      Scanner reader = new Scanner(System.in); 
      int selection = 0;
      System.out.println("Player " + id + " Please Select a Tile to Drop a Token in.");
      selection = reader.nextInt();
      
      for(int i=board.length-1;i>-1;i--){
         if(cM.board[i][selection] == 1 || cM.board[i][selection] == 2){
            
         }
         else{
            cM.board[i][selection] = id;
            findWinnerColumn(cM);
            findWinnerRow(cM);
            findWinnerDiagnal(cM);
            break;
         }
         if(cM.board[0][selection] == 1 || cM.board[0][selection] == 2){
            System.out.println("Please select another place to drop.");
            placeToken(id, cM);
            break;
         }
         
      } 
  }
  
  //This function will check for the victory condition for columns at the end of a placement
  // i will represent the row & j will represent the column
  public static void findWinnerColumn(connectM cM){
  
  int winCounter1 = 0;
  int winCounter2 = 0;
  
   for(int j = 0;j<cM.board.length; j++){
      for(int i = cM.board.length-1; i >-1 ;i--){
         if(cM.board[i][j]==0){
            break;
         }
         if (cM.board[i][j]==1){
            if(i == cM.board.length-1){
               winCounter1 = 0;
               winCounter1++;
               winCounter2=0;
            }
            if((i != cM.board.length-1) && ((cM.board[i+1][j] == 1)||(cM.board[i-1][j] == 1))){
               winCounter1++;
               winCounter2=0;
            } 
         }

         if(cM.board[i][j]==2){
            if(i == cM.board.length-1){
               winCounter2 = 0;
               winCounter2++;
               winCounter1=0;
            }
            if((i != cM.board.length-1) && ((cM.board[i+1][j] == 2)||(cM.board[i-1][j] == 2))){
               winCounter2++;
               winCounter1=0;
            } 
         }
         
         if(winCounter1 == connectM.winNumber){
            System.out.println("Congradulations Player 1! You WIN!");
            cM.printBoard();
            System.exit(0);
         }
         
         if(winCounter2 == connectM.winNumber){
            System.out.println("Congradulations Player 2! You WIN!");
            cM.printBoard();
            System.exit(0);
         }
         else{
            
         }
      }   
   }
  }

  //This function will check for the victory condition for rows at the end of a placement
  // i will represent the row & j will represent the column
  public static void findWinnerRow(connectM cM){
  
  int winCounter1 = 0;
  int winCounter2 = 0;
  
   for(int i = cM.board.length-1; i >-1 ;i--){
      for(int j = 0;j<cM.board.length; j++){
         if(cM.board[i][j]==0){
            break;
         }
         if (cM.board[i][j]==1){
            winCounter2=0;
            if(j == 0){
               winCounter1 = 0;
               winCounter1++;
            }
            if((j != 0) && ((cM.board[i][j+1] == 1)||(cM.board[i][j-1] == 1))){
               winCounter1++;
            } 
         }

         if(cM.board[i][j]==2){
            winCounter1=0;
            if(j == 0){
               winCounter2 = 0;
               winCounter2++;
            }
            if((j != 0) && ((cM.board[i][j+1] == 2)||(cM.board[i][j-1] == 2))){
               winCounter2++;
            } 
         }
         
         if(winCounter1 == connectM.winNumber){
            System.out.println("Congradulations Player 1! You WIN!!");
            cM.printBoard();
            System.exit(0);
         }
         
         if(winCounter2 == connectM.winNumber){
            System.out.println("Congradulations Player 2! You WIN!!");
            cM.printBoard();
            System.exit(0);
         }
      }   
   }
  }
  
  //This function will check for the victory condition for diagnals at the end of a placement
  // i will represent the row & j will represent the column
  public static void findWinnerDiagnal(connectM cM){
  
  int winCounter1 = 0;
  int winCounter2 = 0;
  
   for(int j = 0;j<cM.board.length; j++){
      for(int i = cM.board.length-1; i >-1 ;i--){
         if(cM.board[i][j]==0){
            break;
         }
         if (cM.board[i][j]==1){
            if(i == cM.board.length-1){
               winCounter1 = 0;
               winCounter1++;
               winCounter2=0;
               
               for(int k= 1; k<cM.board.length;k++){
                  if(cM.board[i-k][j+k]==1){
                     winCounter1++;
                     winCounter2=0;
                  }
                  if(winCounter1 == connectM.winNumber){
                     System.out.println("Congradulations Player 1! You WIN!!!");
                     cM.printBoard();
                     System.exit(0);
                  }
               }              
            }
            
            if(i != cM.board.length-1){
               winCounter1++;
               winCounter2=0;
               
               for(int k= 1; k<cM.board.length-1;k++){
                  if((i-k>0) || (j+k<board.length-1)){
                     break;
                  }
                  if(cM.board[i-k][j+k]==1){
                     winCounter1++;
                  }
                  else if(i != cM.board.length-1){
                     for(int l = 1; l<cM.board.length-1;l++){
                        if((cM.board[i+l][j-l]==1) && (i+l < board.length-1)){
                           winCounter1++;
                        }
                        else{
                           break;
                        }
                     }
                  }
                  if(winCounter1 == connectM.winNumber){
                     System.out.println("Congradulations Player 1! You WIN!!!");
                     cM.printBoard();
                     System.exit(0);
                  }
               }
            } 
         }
         
                
         
         if(winCounter2 == connectM.winNumber){
            System.out.println("Congradulations Player 2! You WIN!!!");
            cM.printBoard();
            System.exit(0);
         }
      }   
   }
  }
  
}