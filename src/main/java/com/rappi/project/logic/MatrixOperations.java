package com.rappi.project.logic;

/**
 * Class that has the operations over the matrix
 * @author <a href="mailto:jhonedison237@gmail.com">Jhon Londono</a>
 * @version 0.0.1
 */
public class MatrixOperations {

	/** The matrix on which the operations are carried out */
	private int[][][] matrix;
	
	/**
	 * Class constructor.
	 * 
	 * @param dimension To initialize the matrix dimension.
	 */
	public MatrixOperations(int dimension) {
		initMatrix(dimension);
	}
	
	/**
	 * Initializes the matrix with values equal to zero.
	 * 
	 * @param dimension To initialize the matrix dimension.
	 */
	private void initMatrix(int dimension) {
		
		matrix = new int[dimension][dimension][dimension];
		
		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < dimension; j++)
				for (int k = 0; k < dimension; k++)
					matrix[i][j][k] = 0;
	}
	
	/**
	 * Updates the matrix with the new value.
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @param newValue the new value to update in the given coordinates 
	 */
	public void updateMatrix(int x, int y, int z, int newValue) {
		matrix[x-1][y-1][z-1] = newValue;
	}
	
	/**
	 * Calculates the sum of the value of blocks whose x coordinate is between
	 * x1 and x2 (inclusive), y coordinate between y1 and y2 (inclusive) and z
	 * coordinate between z1 and z2 (inclusive).
	 * 
	 * @param x1 the x1 coordinate
	 * @param y1 the y1 coordinate
	 * @param z1 the z1 coordinate
	 * @param x2 the x2 coordinate
	 * @param y2 the y2 coordinate
	 * @param z2 the z2 coordinate
	 * @return the result of the query
	 */
	public int queryMatrix(int x1, int y1, int z1, int x2, int y2, int z2) {
		
		int sum = 0;
		
		for (int i = x1-1; i <= x2-1; i++)
			for (int j = y1-1; j <= y2-1; j++)
				for (int k = z1-1; k <= z2-1; k++)
					sum += matrix[i][j][k];
		
		return sum;
	}
	
}
