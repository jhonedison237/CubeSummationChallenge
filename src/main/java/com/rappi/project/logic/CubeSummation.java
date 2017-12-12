package com.rappi.project.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class that has the operations over the matrix
 * @author <a href="mailto:jhonedison237@gmail.com">Jhon Londono</a>
 * @version 0.0.1
 */
public class CubeSummation {
	
	/** BufferedReader object to read from the keyboard */
	private BufferedReader br;
	
	/**
	 * The class constructor.
	 */
	public CubeSummation() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Method that launch the program flow.
	 * 
	 * @throws IOException Exception produced by failed or interrupted I/O operations.
	 */
	public void init() throws IOException {
		StringBuffer result = new StringBuffer();

		System.out.print("Please enter the number of test cases: ");
		int testCasesNumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCasesNumber; i++) {
			result.append(performTestCase(i+1));
		}
		
		System.out.println("The result is:");
		System.out.println(result.toString());
	}
	
	/**
	 * Method that performs the test case.
	 * 
	 * @param numberTestCase The number of test cases defined by the user.
	 * @return The outcome of the operations made over the matrix.
	 * @throws IOException Exception produced by failed or interrupted I/O operations. 
	 */
	private String performTestCase(int numberTestCase) throws IOException {
		
		StringBuffer result = new StringBuffer();
		
		System.out.print("\nTEST CASE " + numberTestCase + ". Define the matrix dimension "
				+ "followed by a space and the number of operation you are going to perform: ");
		
		String line = br.readLine();
		String[] splitLine = line.split(" ");
		int matrixDimension = Integer.parseInt(splitLine[0]);
		int numberOfOperations = Integer.parseInt(splitLine[1]);
		
		MatrixOperations matrix = new MatrixOperations(matrixDimension);
		
		for (int i = 0; i < numberOfOperations; i++) {
			System.out.println("Enter the operation number " + (i+1));
			String operation = br.readLine();
			splitLine = operation.split(" ");
			
			if (operation.startsWith("UPDATE")) {
				
				int x = Integer.parseInt(splitLine[1]);
				int y = Integer.parseInt(splitLine[2]);
				int z = Integer.parseInt(splitLine[3]);
				int newValue  = Integer.parseInt(splitLine[4]);
				matrix.updateMatrix(x, y, z, newValue);
				
			} else if (operation.startsWith("QUERY")) {
				
				int x1 = Integer.parseInt(splitLine[1]);
				int y1 = Integer.parseInt(splitLine[2]);
				int z1 = Integer.parseInt(splitLine[3]);
				int x2 = Integer.parseInt(splitLine[4]);
				int y2 = Integer.parseInt(splitLine[5]);
				int z2 = Integer.parseInt(splitLine[6]);
				int sum = matrix.queryMatrix(x1, y1, z1, x2, y2, z2);
				result.append(sum + "\n"); 
				
			}
			
		}
		
		return result.toString();
	}

	/**
	 * Main method that start the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CubeSummation cubeSummation = new CubeSummation();
		try {
			cubeSummation.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
