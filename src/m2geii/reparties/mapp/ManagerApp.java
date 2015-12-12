package m2geii.reparties.mapp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.inters.ClientAppInterface;
import m2geii.reparties.inters.ManagerAppInterface;
import m2geii.reparties.inters.ProcessingAppInterface;

public class ManagerApp extends UnicastRemoteObject implements ManagerAppInterface {
	
	private static final long serialVersionUID = 1L;
	private ClientAppInterface client;
	
	private String host;
	private int ps;
	
	protected ManagerApp(int ps, String host) throws RemoteException{
		
		super();
		
		if(System.getSecurityManager() == null) {
		    System.setSecurityManager(new SecurityManager());
		}
		
		this.host = host;
		this.ps = ps;
	}
	
	protected ManagerApp() throws RemoteException {
		
		super();
	}

	@Override
	public void mult(final Matrix M, final float scal) throws RemoteException {
		
		Thread t1 = new Thread(new Runnable() {
			public void run(){
		    	
		    	try{
		    		ProcessingAppInterface pa;
		    		Matrix M2 = new Matrix();
				
					System.out.println("ManagerApp calculates smth...");
					Registry registry = LocateRegistry.getRegistry(host);
					
					pa = (ProcessingAppInterface)registry.lookup("123");
					
					M2 = pa.mult(M, scal);
				
					client.setResult(M2);
					client.showResult();
					
				}
		    	catch (RemoteException e) { e.printStackTrace();}
		    	catch (MatrixException e) { e.printStackTrace();}
		    	catch (NotBoundException e) { e.printStackTrace();}
			}
		});  
		t1.start();

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
