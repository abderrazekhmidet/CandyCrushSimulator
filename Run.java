import java.util.Scanner;


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int size, numSimulations, numCombos;
		double comboRatio;
		
		do {
		System.out.println("What is the size of your board? (>4)");
		size = scan.nextInt();
		if(size<5)
			System.out.println("Error. Size too small. Try again.");
		}
		while (size<5);
		
		System.out.println("How many simulations do you wish to run?");
		numSimulations = scan.nextInt();
			
		CandySimulator simulator = new CandySimulator();
		numCombos = simulator.simulate(size, numSimulations);
		
		comboRatio = (double) numCombos/numSimulations;
		System.out.println("Number of combos: "+numCombos+"\nRatio: "+comboRatio);
		
	}
}
