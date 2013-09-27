

public class CandySimulator {

	private int [][] candyBoard;
	private BoardCreator creator = new BoardCreator();
	private boolean comboPresent;
	private int currentCandy, numComboBoards=0;
	
	
	public CandySimulator() {
	}
	
	
	public int simulate(int size, int numSims) {
		
		
		//Run numSims times
		for(int i=0; i<numSims; i++) {
			
			//Create a new board for this run of simulation
			candyBoard = creator.createBoard(size);
			comboPresent = false;
			
			
			/*
			for(int m=0; m<size; m++) {
				for(int n=0; n<size; n++) {
					System.out.print(candyBoard[m][n]+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			System.out.println();
			*/
			
			
			//Search board for any 5 in a row possibilities
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					
					currentCandy = candyBoard[j][k];
					
					//Look for horizontal orientation --_-- first
					if(j<(size-1) && k<=size-5) {
						if(currentCandy==candyBoard[j][k+1] && currentCandy==candyBoard[j+1][k+2] && currentCandy==candyBoard[j][k+3] && currentCandy==candyBoard[j][k+4]) {
							comboPresent = true; 		
							break;
						}
					}
										
					//Look for horizontal orientation __-__ second
					if(j>0 && k<=size-5) {
						if(currentCandy==candyBoard[j][k+1] && currentCandy==candyBoard[j-1][k+2] && currentCandy==candyBoard[j][k+3] && currentCandy==candyBoard[j][k+4]) {
							comboPresent = true;
							break;
						}
					}
					
					//Look for vertical orientation |- third
					if(j<=size-5 && k<size-1) {
						if(currentCandy==candyBoard[j+1][k] && currentCandy==candyBoard[j+2][k+1] && currentCandy==candyBoard[j+3][k] && currentCandy==candyBoard[j+4][k]) {
							comboPresent = true;
							break;
						}
					}
					
					//Look for vertical orientation -| fourth
					if(j<=size-5 && k>0) {
						if(currentCandy==candyBoard[j+1][k] && currentCandy==candyBoard[j+2][k-1] && currentCandy==candyBoard[j+3][k] && currentCandy==candyBoard[j+4][k]) {
							comboPresent = true;
							break;
						}
					}
					
					
				}
			}
			
			if (comboPresent ==true){
				numComboBoards++;
				//System.out.println("5 Combo present!!!");
			}
			
		}
		
		
		
		
		return numComboBoards;
	}
	
	
	
	
	
	
}
