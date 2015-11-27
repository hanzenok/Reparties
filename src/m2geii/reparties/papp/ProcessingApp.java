package m2geii.reparties.papp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ProcessingAppInterface;
import m2geii.reparties.queue.Queue;

public class ProcessingApp extends UnicastRemoteObject implements ProcessingAppInterface {
	
	private static final long serialVersionUID = 1L;
	
	private int ps;
	private int nb_clients;
	
	private Queue q;
	
	protected ProcessingApp(int ps) throws RemoteException{
		
		super();
		
		this.ps = ps;
		nb_clients = 0;
		
		q = new Queue();
		q.start();
		
	}
	
	protected ProcessingApp() throws RemoteException {
		
		super();
		
		ps = 1;
		nb_clients = 0;
		
		q = new Queue();
		q.start();
	}

	@Override
	public Matrix mult(Matrix M, float scal) throws RemoteException, MatrixException {
		
//		q.addProcess(new ProcessMultS(M, scal, 5));
//		
//		try {Thread.sleep(8*1000);} 
//		catch(InterruptedException e) {Thread.currentThread().interrupt();}
		
		System.out.println("ProcessingApp calculates smth...");
		
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

}