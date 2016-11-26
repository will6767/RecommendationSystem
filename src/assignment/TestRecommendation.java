package assignment;

public class TestRecommendation extends Recommendation
{
	//---------------------------------------
	//    -----------  VALUES -----------
	//---------------------------------------
	static double[][] M = 
			{
			{ 11, 0, 9, 8, 7 },
			{ 18, 0, 18, 18, 18 },
			{ 29, 28, 27, 0, 25 },
			{ 6, 6, 0, 6, 6 },
			{ 17, 16, 15, 14, 0 }
			};
	static double[][] M1 = {
			{ 0, 8, 9, 8, 7 },
			{ 18, 0, 18, 18, 18 },
			{ 29, 28, 27, 0, 25 },
			{ 6, 6, 0, 6, 6 },
			{ 17, 16, 15, 14, 0 }
			};
	static double[][] U1 = { {2,2}, {2,2}, {2,2}, {2,2}, {2,2} };
	static double[][] V = { {1,1,1,1,1}, {1,1,1,1,1} };
	
	static double [][] U = {{ 1, 0, 2},{ 0, 1}};
	
	static double [][] N = {{ 1, 0, 0},{ 0, 1, 1}};
	static double [][] P = {{ 1, 0, 2},{ 0, 1, 1}};
	
	static double [][] Q = {{ 1, 0, 1},{ 0, 1, 1}};
	static double [][] R = {{ 1, 0, 2},{ 3, 1, 1}};
	
	static double [][] S = {{ 1, 0, 1},{ 0, 1, 1}};
	static double [][] T = {{ 1, 0},{ 3, 1}};
	
	static double [][] A = 	{{ 1, 0, 2},
							{ 0, 1, 1}};
	static double [][] B = 	{{ 1, 2},
							{ 0, 1},
							{ 1, 0}};
	
	// For testing optimizeU
	
	static double [][] M3={ { 3.0, 7.0, 6.0, 7.0, 6.0, 4.0},
							{ 3.0, 13.0, 10.0, 13.0, 12.0, 6.0},
							{ 5.0, 0.0, 0.0, 0.0, 0.0, 5.0},
							{ 6.0, 12.0, 7.0, 0.0, 0.0, 8.0},
							{ 4.0, 9.0, 0.0, 0.0, 6.0, 5.0}};

	static double [][]	U3={ { 1.0, 2.0, 3.0},
							 { 2.0, 2.0, 1.0},
							 { 3.0, 2.0, 1.0},
							 { 2.0, 3.0, 2.0},
							 { 2.0, 2.0, 2.0}};

	static double [][] 	V3={ { 2.0, 0.0, 3.0, 3.0, 2.0, 2.0},
							 { 3.0, 3.0, 2.0, 2.0, 2.0, 3.0},
							 { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0}};
	
	//Initial Error: 5.1478150704935

	// Error after updating every element in U once: 2.8915025059090134

	// The value of U after updating every element in U once with udpateUElem

			
			
	//---------------------------------------
	// PRINT ARRAY TO STRING METHODS
	
	public static void affiche(double[][] C)
	{
        String chaine = "";

        chaine += "{";

        for (int i = 0; i < C.length; i++) 
        {
            chaine += "{ ";
            for (int j = 0; j < C[0].length; j++) 
            {
                chaine += (C[i][j]);
                if (j != (C[0].length-1)) 
                {
                    chaine += ", ";
                }
            }
          chaine += " }";
          if (i != (C.length-1)) 
          {
                chaine += ",";
          }
        }
        chaine += "}";
        System.out.print(chaine);
    }
	
	public static void affiche1(int[] C)
	{
        String chaine = "";

        chaine += "{";

        for (int i = 0; i < C.length; i++) 
        {
            chaine += "{ ";
            chaine += (C[i]);
            chaine += " }";
            if (i != (C.length-1)) 
            {
                chaine += ",";
            }
        }
        chaine += "}";
        System.out.print(chaine);
    }
	
	//---------------------------------------
	
	public static void main(String[] args)
	{
		
		// TEST matrixToString
		System.out.println(" ---- Test Matrix to String ---- ");
		System.out.println(matrixToString(M));
		System.out.println(" ");
		System.out.println("Should display the following:");
		System.out.println("{");
		System.out.println("{11.0,0.0,9.0,8.0,7.0},");	
		System.out.println("{18.0,0.0,18.0,18.0,18.0},");	
		System.out.println("{29.0,28.0,27.0,0.0,25.0},");	
		System.out.println("{6.0,6.0,0.0,6.0,6.0},");	
		System.out.println("{17.0,16.0,15.0,14.0,0.0}");	
		System.out.println("};");	
		System.out.println(" ");
		
		//---------------------------------------
		
		// TEST isMatrix
		System.out.println(" ---- Test Is Matrix ---- ");
		System.out.print(isMatrix(M)); // should return true
		System.out.println(" --- Value should be true");
		System.out.print(isMatrix(U)); // should return false
		System.out.println(" --- Value should be false");
		System.out.println(" ");
		
		//---------------------------------------
		
		// TEST multiplyMatrix
		System.out.println(" ---- Test Multiply Matrix ---- ");
		double [][] C = multiplyMatrix(A,B); // should return C={{ 3, 2},{ 1, 1}}
		System.out.print("C = "); affiche(C);
		System.out.println();
		System.out.println("Should return C={{ 3, 2},{ 1, 1}}");
		System.out.println(" ");
		
		//---------------------------------------
		
		// TEST createMatrix
		System.out.println(" ---- Test Create Matrix ------ ");
		double [][] E = createMatrix(2,4,3,5);
		System.out.println(matrixToString(E));
		System.out.println();
		System.out.println("Le resultat n'est evidemment pas unique puisque les valeurs auront ete generees aleatoirement.");
		System.out.println("Les valeurs devraient etre entre 3 et 5");
		System.out.println(" ");
		
		//---------------------------------------
		
		//TEST RMSE
		System.out.println(" ------ Test RMSE ------ ");
		System.out.print(rmse(N,P)); // should return 0.0
		System.out.println(" --- Value should be 0.0");
		System.out.print(rmse(Q,R)); // should return 0.5
		System.out.println(" --- Value should be 0.5");
		System.out.print(rmse(S,T)); // should return -1
		System.out.println(" --- Value should be -1");
		System.out.println(" ");
		
		//---------------------------------------
		
		//TEST Update element
		System.out.println("  ---- Test Mise à jour d'un element ---- ");
		System.out.print(updateUElem(M, U1, V, 0, 0)); // should return between 6.749 and 6.751
		System.out.println(" --- Value should be between 6.749 and 6.751");
		System.out.print(updateVElem(M, U1, V, 0, 0)); // should return between 7:099 and 7:101
		System.out.println(" --- Value should be between 7:099 and 7:101");
		System.out.print(updateUElem(M1, U1, V, 0, 0));  // should return between 5:999 and 6:001
		System.out.println(" --- Value should be between 5:999 and 6:001");
		System.out.print(updateVElem(M1, U1, V, 0, 0));  // should return between 7:749 and 7:751
		System.out.println(" --- Value should be between 7:749 and 7:751");
		System.out.println(" ");
	
		//---------------------------------------
		
		//TEST OptimizeU
		System.out.println("  ---- Test OptimizeU ---- ");	
		System.out.print("RMSE of the inital Matrix: ");
		double[][] P2=multiplyMatrix(U3,V3);//initial matrix P calculated of initial matrices U1,V
		System.out.println(rmse(M,P2));//RMSE for this initial matrix P
		optimizeU(M3,U3,V3);//updates the matrix U to reduce RMSE
		P2=multiplyMatrix(U3,V3);//recalculates the product of our updated matrices
		System.out.print("RMSE of the matrix after updating U: ");
		System.out.println(rmse(M3,P2));//should be lower than before
		optimizeV(M3,U3,V3);//updates the matrix V this time
		P2=multiplyMatrix(U3,V3);//recalculates product again
		System.out.print("RMSE of the matrix after updating V: ");
		System.out.println(rmse(M,P2));//even lower value
		System.out.println("");
		System.out.println("Final RMSE of U should be: 2.8915025059090134"); 
		System.out.println("");
		System.out.print("U="); System.out.println(matrixToString(U3));
		System.out.println("");
		System.out.println("Should display the following:"); 
		System.out.println("U={ { -0.4, 1.5692307692307692, 2.526923076923077},");
		System.out.println("    { 1.6, 2.0820512820512818, 2.244871794871796},");
		System.out.println("    { -0.75, 2.0, 0.5},"); 
		System.out.println("    { -0.5294117647058824, 2.8880455407969636, 0.8652751423149905},"); 
		System.out.println("    { -0.8333333333333334, 2.043010752688172, 1.9964157706093193}}");
		System.out.println(" ");

		//---------------------------------------
		
		
		// TEST Recommend
		System.out.println("  ---- Test Recommend ---- ");
		System.out.println(" ");
		System.out.println("Multiplying M and M1 we get P");
		double [][] P = multiplyMatrix(M,M1);
		System.out.println(matrixToString(P));
		System.out.println(" ");
		System.out.println("We then take out some numbers and replace them with 0s");
		System.out.println("We then get P1 :");
		// WE GET P:
		double[][] P1 = {
			{ 428, 500.0, 0, 234.0, 350.0 },
			{ 936.0, 0, 918.0, 0, 684.0 },
			{ 0, 1388.0, 0, 1086.0, 0 },
			{ 246.0, 0, 252.0, 0, 186.0 },
			{ 0, 0, 0, 0, 0 },
			};
		System.out.println(matrixToString(P1));
		System.out.println("We then test to see what the recommended values are:");
		int d = 50;
		int [] F = recommend(P1,d);
		affiche1(F);
		
		System.out.println(" ");
		System.out.println("Test with Netflix data:");
		//TEST Recommend
		double[][] M = Netflix.readData("src/utility_user100_movies200.m");
		int d1 = 20;
		int [] G = recommend(M,d1);
		affiche1(G);
		
    }
}

