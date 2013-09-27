import java.util.*;



public class BoardCreator {

	
	private int [][] board;
	Random generator = new Random();
	
	
	//Default constructor
	public BoardCreator() {
		
	}
	
	
	//Creates a square board of size*size dimensions filled with ints 0-5
	public int[][] createBoard(int size) {
		//Create new board and fill it with random candies
		int candyToAdd;
		board = new int[size][size];	
		
		
		for(int j=0; j<size; j++) {
			for(int k=0; k<size; k++) {
				
				candyToAdd = generator.nextInt(6);
				
				//Check left 2 and up 2 if won't go out of bounds
				if(k>1 && j>1) {
					//While the previous 2 in UP or LEFT direction are same, generate new candy
					while((candyToAdd==board[j-1][k] && candyToAdd==board[j-2][k])|| (candyToAdd==board[j][k-1] && candyToAdd==board[j][k-2])) {
						candyToAdd = generator.nextInt(6);
					}
				}
				//Check up 2
				else if(j>1) {
					while(candyToAdd==board[j-1][k] && candyToAdd==board[j-2][k]) {
						candyToAdd = generator.nextInt(6);
					}
				}
				//Check left 2					
				else if(k>1) {
					while(candyToAdd==board[j][k-1] && candyToAdd==board[j][k-2]) {
						candyToAdd = generator.nextInt(6);
					}
				}
				//Else it's in top left corner, so no need for checking
				
				board[j][k] = candyToAdd;
			}
		}
		return board;
	}
	
	
	
	
}
