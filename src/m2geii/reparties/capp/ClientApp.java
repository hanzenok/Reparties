package m2geii.reparties.capp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ClientAppInterface;
import m2geii.reparties.inters.ManagerAppInterface;

public class ClientApp implements ClientAppInterface {
	
	static ManagerAppInterface ma;
	
	public static void main(String[] args) throws MatrixException, MalformedURLException, RemoteException, NotBoundException {
		
		int i,j;
		int n=3, m=2;
		
		float[][] tab = new float[n][m];
		
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				tab[i][j] = i+j;
			
		Matrix M = new Matrix(n, m, tab);
		
		
		ma = (ManagerAppInterface)Naming.lookup("122");
		register();
		
		System.out.println("Before: \n" + M);
		Matrix M2 = ma.mult(M, 2);
		System.out.println("After: \n" + M2);
		
		while(true){}
	}

	public void doSomething() throws RemoteException {
		
		Thread t1 = new Thread(new Runnable() {
		     public void run() {
		    	 
		    	 System.out.println("Server invoked doSomething()");
		     }
		});  
		t1.start();
		
	}
	
	public void register() throws RemoteException {
		
		ma.registerClient(this);
	}

}
