package m2geii.reparties.capp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ClientAppInterface;
import m2geii.reparties.inters.ManagerAppInterface;

public class ClientApp extends UnicastRemoteObject implements ClientAppInterface{
	
	private ManagerAppInterface ma;
	
	protected ClientApp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected ClientApp(ManagerAppInterface ma) throws RemoteException{
		
		this.ma = ma;
		ma.registerClient(this);
	}

	@Override
	public void blink() throws RemoteException {
		
		System.out.println("Blink!!");
	}

	@Override
	public Matrix mult(Matrix m, float scal) throws RemoteException, MatrixException {
		
		return ma.mult(m, scal);
	}

	@Override
	public Matrix mult(Matrix m1, Matrix m2) throws RemoteException,
			MatrixException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix add(Matrix m1, Matrix m2) throws RemoteException,
			MatrixException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix transpose(Matrix m) throws RemoteException, MatrixException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
