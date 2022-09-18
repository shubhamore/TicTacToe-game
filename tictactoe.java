import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String player1="shubham";
        String player2="devang";
        int turns=0;
        char board[][]={
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}
        };
        printboard(board);
        while (turns!=9) {
            if (turns%2==0) 
                System.out.println(player1+",enter the value of placement(1-9)");
            else
                System.out.println(player2+",enter the value of placement(1-9)");
            int choice=sc.nextInt();
            markOnBoard(board,turns,choice);
            printboard(board);
            turns++;
            if (isGameCompleted(board)) {
                turns--;
                break;
            }
        }
        if (turns==9) 
            System.out.println("It is a tie between "+player1+" and "+player2);
        else if (turns%2==0) 
            System.out.println(player1+" won the game!");
        else
            System.out.println(player2+" won the game!");
    }

    public static void printboard(char board[][]){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void markOnBoard(char board[][],int turns,int choice){
        char symbol;
        int x=-1;
        int y=-1;
        if (turns%2==0)
            symbol='X';
        else
            symbol='O';
        switch (choice) {
            case 1:
            {
                x=0;
                y=0;
                break;
            }
            case 2:
            {
                x=0;
                y=2;
                break;
            }
            case 3:
            {
                x=0;
                y=4;
                break;
            }
            case 4:
            {
                x=2;
                y=0;
                break;
            }
            case 5:
            {
                x=2;
                y=2;
                break;
            }
            case 6:
            {
                x=2;
                y=4;
                break;
            }
            case 7:
            {
                x=4;
                y=0;
                break;
            }
            case 8:
            {
                x=4;
                y=2;
                break;
            }
            case 9:
            {
                x=4;
                y=4;
                break;
            }        
            default:
            {
                System.out.println("Value of placement is only allowed from 1-9 \nEnter a different value for placement ");
                Scanner sc=new Scanner(System.in);
                choice=sc.nextInt();
                markOnBoard(board,turns,choice);
            }
        }
        if (isNotFilled(x,y,board)) {
            board[x][y]=symbol;
        }
        else{
            System.out.println(board[x][y]+" already exist at placement "+choice+"\nEnter a different value for placement ");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            markOnBoard(board,turns,choice);
        }
    }

    public static boolean isNotFilled(int x,int y,char board[][]){
        if (board[x][y]==' ') {
            return true;
        }
        return false;
    }

    public static boolean isGameCompleted(char board[][]){
        if (
            board[0][0]==board[0][2]&&board[0][0]==board[0][4]&&board[0][0]!=' '||
            board[2][0]==board[2][2]&&board[2][0]==board[2][4]&&board[2][0]!=' '||
            board[4][0]==board[4][2]&&board[4][0]==board[4][4]&&board[4][0]!=' '||
            board[0][0]==board[2][0]&&board[0][0]==board[4][0]&&board[0][0]!=' '||
            board[0][2]==board[2][2]&&board[0][2]==board[4][2]&&board[0][2]!=' '||
            board[0][4]==board[2][4]&&board[0][4]==board[4][4]&&board[0][4]!=' '||
            board[0][0]==board[2][2]&&board[0][0]==board[4][4]&&board[0][0]!=' '||
            board[0][4]==board[2][2]&&board[0][4]==board[4][0]&&board[0][4]!=' '
        ) {
            return true;
        }
        return false;
    }
}
