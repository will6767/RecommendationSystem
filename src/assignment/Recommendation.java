package assignment;

import java.util.Random;

public class Recommendation 
{
	/*
	 * Inscrivez votre nom complet (prénom et nom de famille)
	 * ainsi que votre numéro sciper ci-dessous :
	 */
	
	/* Etudiant 1 */
	public static String NAME1 = "William Wood";
	public static int SCIPER1 = 238594;
	
	/* Etudiant 2 - laissez tel quel si vous avez codé le projet tout seul */
	public static String NAME2 = "Julian Barry";
	public static int SCIPER2 = 250154;
	
	//Variables
	static Random random = new Random(); //Random number

	//--------------------------------------------------------------------------------------
	//-------- Page 6 - 4.3 Représentation de la matrice sous la forme d’une String --------
	//--------------------------------------------------------------------------------------
	public static String matrixToString(double[][] A) 
	{
		int compteur=0;							// Integer counter
		String output="{"+"\n";					// Define the string called "output" and adds a { and a return to it
		for(double[] table:A)					// Iterates over the rows of A
		{
			output+=" {";						// Add a { at the start of each new row
			for(int j=0;j<table.length;++j)		// Iterates over the columns of A
			{
				if(j==table.length-1)			// If the row number is equal to the size -1
				{
					output+=table[j];			// Add the element to the output string
				}
				else							// If not equal to
				{
					output+= table[j]+",";		// Add a ,
				}
			}
			++compteur;							// Add 1 to the counter
			if(compteur==A.length)				// If the counter is equal to the rows of A (When it reaches the end of all the rows)
			{
				output+="}"+"\n";				// Add a } and return
			}
			else								// Otherwise when it reaches the end of a row (not the final one)
			{
				output+="},"+"\n";				// Add a }, and return
			}
		}
		output+="};";							// Add a final };
		return output;							// Return the string "output"
	}
	
	//--------------------------------------------------------------------------------------
	//------------------------ Page 7 - 4.4 Controle de la Matrice -------------------------
	//--------------------------------------------------------------------------------------
	
	public static boolean isMatrix( double[][] A ) 
	{
		if(A.length==0)								// If rows of A = 0
		{
			return false;							// Return false
		}
		else										// When A is not empty
		{
			for(double[]table:A)					// For 
			{
				if(table.length==0)					// If columns are empty
				{
					return false;					// Return false
				}
			}
			int firstLineLength=A[0].length;		// Set value of A columns as variable "firstLineLength"
			for(double[]table:A)					
			{
				if(table.length!=firstLineLength)	// If the number of rows is not equal to number of columns
				{
					return false;					// Return false
				}
			}
			return true;							// Else Return True
		}
	}
	
	//--------------------------------------------------------------------------------------
	//---------------------- Page 7 - 4.5 Multiplication de matrices -----------------------
	//--------------------------------------------------------------------------------------
	
	
	public static double[][] multiplyMatrix(double[][] A, double[][] B)
	{
        int aRows = A.length; 							//Rows in Matrix A
        int bRows = B.length; 							//Rows in Matrix B
        int aColumns = A[0].length; 					//Columns in Matrix A
        int bColumns = B[0].length; 					//Columns in Matrix B
        
        double[][] C = new double[aRows][bColumns]; 	//New Matrix C - Will become the output matrix
        	
        if (aColumns != bRows) 							// Check if the two matrix's are compatible to multiply
		{
            return null;
        } 
		else 
		{
            for (int i = 0; i < C.length; i++)  		// Fill the matrix C with 0's
			{
                for (int j = 0; j < C[0].length; j++) 
				{
                    C[i][j] = 0; 
                }
            }
        	for (int i = 0; i < aRows; i++)  			// Multiply the matrices together
        	{
        		for (int j = 0; j < bColumns; j++) 
        		{ 
        			for (int k = 0; k < aColumns; k++) 
        			{
                    C[i][j] += A[i][k] * B[k][j]; 		//C[i][j] will be (Aik)*(Bkj)
        			}
        		}
        	}
        }
        return C; 										// Return the matrix C
	}
	
	
	//--------------------------------------------------------------------------------------
	//----------------------------- Page 8 - 4.6 Create Matrix -----------------------------
	//--------------------------------------------------------------------------------------
	// n lignes et m colonnes et dont chaque element doit etre une valeur generee aleatoirement entre les bornes k et l
	public static double[][] createMatrix( int n, int m, int k, int l)
	{
		if(n==0 || m==0 || k >l ) 								// Checking the matrix is not empty and that the limits are possible.
		{
			return null;										// If it is empty / return null
		}
		else													// If it is within the criteria
		{
			double[][] M = new double[n][m]; 					// Create a new matrix M (size n x m)
	        for (int i = 0; i < n; i++)							// Iterates across rows of M
	        {
	            for (int j = 0; j < m; j++)						// Iterates across columns of M
	            {
	            	if (n != 0)									// If rows is not empty
	            	{
	            		M[i][j] = random.nextDouble()*(l-k)+k; 	//Random double to fill matrix within the limits k up to l
	            	}
	            }
	        }

			return M; 											// Return the new matrix
		}
		
	}
	
	//--------------------------------------------------------------------------------------
	//--------------------- Page 8 - 4.7 RMSE "Root Mean Square Error" ---------------------
	//--------------------------------------------------------------------------------------
	//(Si les matrices sont de dimensions differentes, la ḿethode rmse retournera −1.)
	
	public static double rmse(double[][] M, double[][] P)
	{
		if(!(M[0].length == P[0].length))
		{
			return -1;
		}
		else
		{
			double s = 0; 										// Sum
			double sm = 0; 										// S mean
			double rms = 0; 									// Root Mean Square Error
			
			for (int i = 0; i < M.length; i++)					// Iteration over M rows
			{
				for (int j = 0; j < M[0].length; j++)			// Iteration over M columns
				{
					if (M[i][j] == 0)							// When M[i][j] = 0
					{
						s+= 0;									// Sum + 0
						sm += 0;								// S mean + 0
					}
					else										// When M[i][j] is different to 0
					{
						s += Math.pow((M[i][j] - P[i][j]), 2);	// Sum + 0
						sm+= 1;									// S mean + 1
					}		
				}
			}
			rms = Math.sqrt(s/sm);								// Root Mean Square Error = Square root of (sum / s mean)
	        return rms;											// Return Root Mean Square Error
	    }	
	}
	
	
	//--------------------------------------------------------------------------------------
	//----------------------- Page 8 - 4.8 Mise à jour d'un élément ------------------------
	//--------------------------------------------------------------------------------------
	
	
	public static double updateUElem( double[][] M, double[][] U, double[][] V, int r, int s )
	{
		int colonnesM=M[0].length;				// integer representing the number of columns in the matrix M
		int colonnesU=U[0].length;				// integer representing the number of columns in the matrix U
		double n=0; 							// counter for the sum over j(top line of fraction)
		double z=0;								// counter for second sum in top like over k(second part of top line fraction)
		double y=0;								// counter for lower part of fraction
		double output;							// value of updated element in matrix U
		for(int j=0;j<colonnesM;++j)			// iteration over j to calculate upper part of fraction
		{
			if(M[r][j]==0.0)					//removing case where M[r][j] is null
			{
				continue;
			}
			else
			{
				for(int k=0;k<colonnesU;++k)	// iteration over k
				{
					if(k!=s)					// excludes case where k=s
					{
					z+=U[r][k]*V[k][j];			// updates z according to formula as k changes
					}
				}
				n+=V[s][j]*(M[r][j]-z);			// updates n according to formula as j changes
				z=0;							// resets z for each iteration
			}
		}
		
		for(int j=0;j<colonnesM;++j)			// iteration over j, this time to calculate the bottom part of fraction
		{
			if(M[r][j]==0.0)					// removing case where M[r][j] is null
			{
				continue;
			}
			else
			{
				y+=V[s][j]*V[s][j];				//updates y as j changes according to formula
			}
		}
		
		output =n/y;							//divides the value of the top part of the fraction by the bottom part
		
		return output;
	}
	
	public static double updateVElem( double[][] M, double[][] U, double[][] V, int r, int s )
	{
		int rowsM=M.length;						//integer representing the number of rows in the matrix M
		int colonnesU=U[0].length;				//integer representing the number of columns in the matrix U
		double n=0; 							//counter for the sum over i(top line of fraction)
		double z=0;								// counter for second sum in top like over k(second part of top line fraction)
		double y=0;								//counter for lower part of fraction
		double output;							//value of updated element in matrix V
		for(int i=0;i<rowsM;++i)				//iteration over i to calculate upper part of fraction
		{
			if(M[i][s]==0.0)					//removing case where M[i][s] is null
			{
				continue;
			}
			else
			{
				for(int k=0;k<colonnesU;++k)	// iteration over k
				{
					if(k!=r)					// excludes case where k=r
					{
						z+=U[i][k]*V[k][s];		//updates z according to formula as k changes
					}
				}
				n+=U[i][r]*(M[i][s]-z);			//updates n according to formula as i changes
				z=0;							//resets z for each iteration
			}
		}
		
		for(int i=0;i<rowsM;++i)				//iteration over i, this time to calculate the bottom part of fraction
		{
			if(M[i][s]==0.0)					//removing case where M[i][s] is null
			{
				continue;
			}
			else
			{	
				y+=U[i][r]*U[i][r];				//updates y as i changes according to formula
			}
		}
		
		output =n/y;							//divides the value of the top part of the fraction by the bottom part
		
		return output;
	}
	
	
	//--------------------------------------------------------------------------------------
	//----------------------- Page 9 - 4.9 Optimisation de la matrice ----------------------
	//--------------------------------------------------------------------------------------
	// minimisant le RMSE entre M et P
	
	public static double [][] optimizeU(double[][] M, double[][] U, double[][] V)
	{	
		
		int uLignes=U.length;					//number of lines in the matrix U
		int uColonnes=U[0].length;				//number of columns in the matrix U
		
		for(int i=0;i<uLignes;++i)				//iterates through the lines of matrix U
		{
			for(int j=0;j<uColonnes;++j)		//for each line it iterates through the columns of matrix U
			{
				U[i][j]=updateUElem(M,U,V,i,j);	//updates the element at row i column j of the matrix U and stores this value in the place of the old one
			}
		}
		return U;								//returns updated Matrix
	}
	
	public static double [][]optimizeV(double[][] M, double[][] U, double[][] V)
	{
		int vLignes=V.length;					//number of lines in the matrix V
		int vColonnes=V[0].length;				//number of columns in the matrix V
		
		for(int i=0;i<vLignes;++i)				//iterates through the lines of matrix V
		{
			for(int j=0;j<vColonnes;++j)		//for each line it iterates through the columns of matrix V
			{
				V[i][j]=updateVElem(M,U,V,i,j);	//updates the element at row i column j of the matrix U and stores this value in the place of the old one
			}
		}
		return V;								//returns updated Matrix
	}
	
	//--------------------------------------------------------------------------------------
	//--------------------------- Page 10 - 4.10 Recommendation ----------------------------
	//--------------------------------------------------------------------------------------
	//(Prendra le parametre M et elle retournera un tableau d’entiers indiquant à la position i, la meilleure recommandation de l’utilisateur i.)

	public static int[] recommend(double[][] M, int d)
	{
		//----------------------------------------------------------------------------------
		//--------------------------- Defining All the Variables ---------------------------
		//----------------------------------------------------------------------------------
		
		int rowsM=M.length;							//integer representing the number of rows in the matrix M
		int colonnesM=M[0].length;					//integer representing the number of columns in the matrix M
		double U [][] = new double [rowsM][d];		//defines matrix U
		double V [][] = new double [d][colonnesM];	//defines matrix V
		int rowsU=U.length; 						//integer representing the number of rows in the matrix U
		int colonnesU=U[0].length; 					//integer representing the number of columns in the matrix U
		int rowsV=V.length; 						//integer representing the number of rows in the matrix V
		int colonnesV=V[0].length; 					//integer representing the number of columns in the matrix V

		
		//----------------------------------------------------------------------------------
		//-------------------------- Calculating the initial value -------------------------
		//----------------------------------------------------------------------------------
		
		int numOfNonNegM = 0; 					// Number of non-negative elements in M 
		double sumOfM = 0;						// Double value "sumOfM"
		double moyenneDeM = 0;	 				// Sum of non negative M / Number of 
		double initialValue; 					// Double value "initialValue" for which the matrix P will be based on
		
		for(int i=0;i<rowsM;++i)				// Iterates across rows of M
		{
			for(int j=0;j<colonnesM;++j)		// Iterates across columns of M
			{
				if(M[i][j]!=0.0)				// Removing case where M[i][j] is null
				{
					sumOfM += M[i][j];			// Add the value in position M[i][j] to the sum of M
					numOfNonNegM += 1;			// Add one to the number of non negative values in M
				}
			}
		}
		
		moyenneDeM = sumOfM/numOfNonNegM;		// Average of M = Sum of M / Number of non negative values in M
		initialValue=Math.sqrt(moyenneDeM/d); 	// Initial value = Square root of the Average of M over the predetermined value d
		
		//----------------------------------------------------------------------------------
		//--------------------- Find best RMSE of 10 values for U & V ----------------------
		//----------------------------------------------------------------------------------
		
		double rmseFinal = 1000; 										//smallest RMSE value for all loops, given a large value to ensure it is overwritten
		double[][] pFinal = new double[colonnesU][rowsV];			// Defines the final P matrix
		double[][] P = new double [colonnesU][rowsV];				// Defines P matrix 
		
		for(int x=0;x<1;x++) 										// Starts a loop that will repeat 10 times
		{	
			//------- Creates matrix U -------
			for(int i=0;i<rowsU;++i) 								// Creates the matrix U
			{
				for(int j=0;j<colonnesU;++j) 
				{
					U[i][j] = initialValue + (2*random.nextDouble()-1); 	// Creates a matrix U, filled with initialValue + or - max 1
				}
			}
			//------- Creates matrix V -------
			for(int i=0;i<rowsV;++i)								// Creates the matrix V
			{
				for(int j=0;j<colonnesV;++j)
				{
					V[i][j] = initialValue + (2*random.nextDouble()-1); 	// Creates a matrix V, filled with initialValue + or - max 1
				}
			}
			//---- Determines RMSE and updates U and V until rmseDifference falls below threshold ----
			double rmseFinalTemp; 								// Defines final RMSE value of internal loop
			double rmseInitialTemp;
			double rmseDifference;										
			do
			{
				P = multiplyMatrix(U,V); 							// Creates matrix P
				rmseInitialTemp = rmse(M,P);
				optimizeU(M,U,V); 									// Optimize matrix U
				optimizeV(M,U,V); 									// Optimize matrix V
				P=multiplyMatrix(U,V);								// Updates matrix P
				rmseFinalTemp = rmse(M,P); 							// Calculating RMSE of P after being updated												
				rmseDifference = rmseInitialTemp - rmseFinalTemp;
				if(rmseFinalTemp<rmseFinal) 						// Checks if the rmseFinal temp value is smaller than the stocked one
				{
					rmseFinal = rmseFinalTemp; 						// If it is, replaces the rmseFinal value with the temp one
					pFinal = P; 									// Stocks the P matrix as pFinal
				}
			} while (rmseDifference > 0.00005); 					// Loops until RMSE difference is smaller than value
		}
		
		//----------------------------------------------------------------------------------
		// ----- Creating new table "output" to stock the index of best recommendation -----
		//----------------------------------------------------------------------------------
		
		double maxValue=0;							// Double "maxValue" the biggest value in the row of P
    	int maxValueIndex=0;						// Integer "maxValueIndex" which is the index in the row of maxValue
    
    	int pFinalColumns=pFinal[0].length;				// Integer representing the number of columns in the matrix pFinal
    	int pFinalRows=pFinal.length;					// Integer representing the number of rows in the matrix pFinal
    	int [] output=new int[pFinalRows];			// Defines the table "output"
    	int k=0;									// Integer k that counts the amount of 0s in a row of M(if all zeros the user hasn't rated anything!)
    	int m=0;									// Integer m that counts the amount of non 0s in a row of M(if all non-zero the user has rated everything!)
    	
    	for(int r=0;r<pFinalRows;++r)				// Iterates across lines of pFinal
    	{
    		for(int c=0;c<pFinalColumns;++c)		// Iterates across columns of pFinal
    		{
    			if(M[r][c]==0)						// Checks if corresponding element in M is null
    			{
    				k++; 							// If the user hasn't rated an item k is incremented
    				if(pFinal[r][c]>maxValue)		// Checks if value in pFinal is superior to maxValue
    				{
    					maxValue=pFinal[r][c];		// Rewrites maxValue
    					maxValueIndex=c;			// Stores index
    					output[r]=maxValueIndex;	// Sends index to output table
    				}
    			}
    			else
    			{
    				++m;							// If the user has rated an item, m is incremented
    			}
    		}
    		maxValue=0;								// Resets variable maxValue for next line
    		maxValueIndex=0;						// Resets variable maxValueIndex for next line
    		if(k==pFinalColumns) 					// If the row is filled with only 0s
    		{
    			output[r] = -1; 					// The user has not rated any items and no recommendation can be determined so return -1
    		}
    		k=0;									//Resets k for next user(line of matrix)
    		if(m==pFinalColumns)
    		{
    			output[r]=-1;						//The user has rated every item and no recommendation can be determined
    		}
    		m=0;									// Resets m for next user(line of matrix)
    	}
    	
    	return output; 								// Returns the table "output" with the index values of best recommendation
	}

}


