package m2geii.reparties.papp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ProcessingAppInterface;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessingApp extends UnicastRemoteObject implements ProcessingAppInterface {
	
	private static final long serialVersionUID = 1L;
	
	private int ps; //capacite de serveur
	private int current_ps; //capacite actuelles. si  = 0 cad serveur est chargee
	private final Lock mutex = new ReentrantLock(true); //mutex pour threads
//	private int nb_clients;
	
	protected ProcessingApp(int ps) throws RemoteException{
		
		super();
		
		this.ps = ps;
		current_ps = ps;
//		nb_clients = 0;
	}
	
	protected ProcessingApp() throws RemoteException {
		
		super();
		
		ps = 1;
		current_ps = ps;
//		nb_clients = 0;
	}

	@Override
	public Matrix mult(Matrix M, float scal) throws RemoteException, MatrixException {
		
//		mutex.lock();
//		current_ps--;//dercremente la capacite actuelle
		System.out.println("ProcessingApp calculates scalar multiplication. Busyness is " + current_ps);
//		mutex.unlock();
		
		try {Thread.sleep(ps*3*1000*3);} 
		catch(InterruptedException e) {Thread.currentThread().interrupt();}
		
		int i,j;
		int n = M.rows();
		int m = M.cols();
		
		for(i=0;i<n;i++){
			
			for(j=0;j<m;j++){
				
				try {M.setValue(i, j, M.getValue(i, j)*scal);} 
				catch (MatrixException e) {e.printStackTrace();}
			}
		}
		
		return M;
	}

	@Override
	public Matrix mult(Matrix m1, Matrix m2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix add(Matrix m1, Matrix m2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix transpose(Matrix m) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBusyness() throws RemoteException {
		
		int tmp = ps; //sinon cela ne marche pas
		
		return tmp;
	}
	

}
