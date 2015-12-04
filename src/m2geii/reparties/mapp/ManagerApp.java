package m2geii.reparties.mapp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ClientAppInterface;
import m2geii.reparties.inters.ManagerAppInterface;
import m2geii.reparties.inters.ProcessingAppInterface;

public class ManagerApp extends UnicastRemoteObject implements ManagerAppInterface {
	
	private static final long serialVersionUID = 1L;
	private ClientAppInterface client;
	
	protected ManagerApp(int ps) throws RemoteException{
		
		super();
	}
	
	protected ManagerApp() throws RemoteException {
		
		super();
	}

	@Override
	public void mult(final Matrix M, final float scal) throws RemoteException, MatrixException {
		
		ProcessingAppInterface pa;
		Matrix M2 = new Matrix();
		
		try {
			System.out.println("ManagerApp calculates smth...");
			pa = (ProcessingAppInterface)Naming.lookup("123");
			
			M2 = pa.mult(M, scal);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.setResult(M2);
		client.showResult();
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
	public void registerClient(ClientAppInterface ca) throws RemoteException {
		
		this.client = ca;
		
	}

	@Override
	public void send() throws RemoteException {
		
		client.showResult();
		
	}

}
