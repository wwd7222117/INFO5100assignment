package Assignment8;
import java.util.*;

/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {


    @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);
        Set<Integer> unusedset = new HashSet<Integer>();
        for(int i = 1; i < 10; i++) {
        	unusedset.add(i);
        }

        while (true) {
            @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            @SuppressWarnings("unused")
			int playerPos = scan.nextInt();
            placePiece(gameBoard, playerPos,"player");
            printGameBoard(gameBoard);
            unusedset.remove(playerPos);
            String result = checkWinner(gameBoard);
            if(result != " " ) {
            	System.out.println(result);
            	break;
            }
            System.out.println("It turns to Cpu");
            @SuppressWarnings("unchecked")
			ArrayList<Integer> unusedlist = new ArrayList(unusedset);
            int randomIndex = new Random().nextInt(unusedlist.size());
            Integer randomItem = unusedlist.get(randomIndex);
            placePiece(gameBoard, randomItem,"cpu");
            unusedset.remove(randomItem);
            result = checkWinner(gameBoard);
            printGameBoard(gameBoard);
            if(result != " " ) {
            	System.out.println(result);
            	break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        // write your code here
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			System.out.print(gameBoard[i][j]);
    		}
    		System.out.print("\n");
    	}
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos,gameBoard,symbol);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos,gameBoard,symbol);
        }
    }

    public static String checkWinner(char[][] gameBoard) {
        // write your code here
    	for(int row = 0; row <5; row+=2) {
    		if(gameBoard[row][0] != ' '&& gameBoard[row][0] == gameBoard[row][2] && gameBoard[row][2] == gameBoard[row][4]) {
    			if(gameBoard[row][0] == 'X')
    				return "Player";
    			else
    				return "Cpu";
    		}
    	}
		for(int col = 0; col <5; col+=2) {
    		if(gameBoard[0][col] != ' '&& gameBoard[0][col] == gameBoard[2][col] && gameBoard[2][col] == gameBoard[4][col]) {
    			if(gameBoard[0][col] == 'X')
    				return "Player";
    			else
    				return "Cpu";
    		}
		}
		if(gameBoard[0][0]!= ' ' && gameBoard[0][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][4]) {
			if(gameBoard[0][0] == 'X')
				return "Player";
			else
				return "Cpu";
		}
		if(gameBoard[0][4]!= ' ' && gameBoard[0][4] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][0]) {
			if(gameBoard[0][4] == 'X')
				return "Player";
			else
				return "Cpu";
		}
		return " ";
    }
    
    static class Positions{
    	public static void add(int pos, char[][] gameBoard,char symbol) {
    		while(true) {
	    		try {
	    			if(pos >0 && pos <10) {
	    				int row = (pos-1)/3*2;
	    				int col = (pos-1)%3*2;
	    				if (gameBoard[row][col] == ' ') {
	    					gameBoard[row][col] = symbol;
	    					break;
	    				}
	    				else {
	    					System.out.println("Invalid Position!!!!");
	    				}
	    			}
	    			else {
	    				System.out.println("Invalid Position!!!!");
	    			}
	    		}catch(Exception e) {
	    			System.out.println("You should input a INTEGER (1~9)!!!!");
	    		}
    		}
    	}
    }
    static class playerPositions extends Positions{}
    static class cpuPositions extends Positions{}
    /*
    static class cpuPositions{
    	public static void add(int pos, char[][] gameBoard) {
    		try {
    			if(pos >0 && pos <10) {
    				int row = (pos-1)/3*2;
    				int col = (pos-1)%3*2;
    				if (gameBoard[row][col] == ' ') {
    					gameBoard[row][col] = 'O';
    				}
    				else {
    					System.out.println("Invalid Position!!!!");
    				}
    			}
    			else {
    				System.out.println("Invalid Position!!!!");
    			}
    		}catch(Exception e) {
    			System.out.println("You should input a INTEGER (1~9)!!!!");
    		}
    	}
    }
    */
}


