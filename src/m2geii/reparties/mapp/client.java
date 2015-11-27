package m2geii.reparties.mapp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.papp.inter.ProcessingAppInterface;

public class client {

	public static void main(String[] args) throws MatrixException, MalformedURLException, RemoteException, NotBoundException {
		
	
		int i,j;
		int n=3, m=2;
		
		float[][] tab = new float[n][m];
		
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				tab[i][j] = i+j;
			
		Matrix M = new Matrix(n, m, tab);
		ProcessingAppInterface pa = (ProcessingAppInterface)Naming.lookup("123");
		
		System.out.println("Before: \n" + M);
		Matrix M2 = pa.mult(M, 2);
		System.out.println("After: \n" + M2);
	}

}
