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
import m2geii.reparties.papp.ProcessingApp;
import m2geii.reparties.inters.ClientAppInterface;
import m2geii.reparties.inters.ManagerAppInterface;
import m2geii.reparties.inters.ProcessingAppInterface;

public class ManagerApp extends UnicastRemoteObject implements ManagerAppInterface {
	
	private static final long serialVersionUID = 1L;
	private ClientAppInterface client;
	
	private String host;
	
	private ProcessingAppInterface[] servers;
	private Registry registry;
	
	protected ManagerApp(String[] args) throws RemoteException, NotBoundException{
		
		super();
		
		if(System.getSecurityManager() == null) {
		    System.setSecurityManager(new SecurityManager());
		}
		
		//hostname
		host = args[0];
		
		//initialisation des serverus
		int n = args.length - 1;//nombre des serveurs
		servers = new ProcessingAppInterface[n];
		
		registry = LocateRegistry.getRegistry(host);
		
		for(int i=1; i<args.length; i++){
			
			servers[i-1] = (ProcessingAppInterface)registry.lookup(args[i]);
		}
	}
	
	protected ManagerApp() throws RemoteException {
		
		super();
	}

	@Override
	public void mult(final Matrix M, final float scal) throws RemoteException {
		
		Thread t1 = new Thread(new Runnable() {
			public void run(){
		    	
		    	try{
		    		Matrix M2 = new Matrix();
					
					M2 = getLessBusyest().mult(M, scal);
				
					client.setResult(M2);
					client.showResult();
					
				}
		    	catch (RemoteException e) { e.printStackTrace();}
		    	catch (MatrixException e) { e.printStackTrace();}
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
	
	public ProcessingAppInterface getLessBusyest() throws RemoteException{
		
		int i,n = servers.length;
		
		int i_min = 0; //indice d'un valeur minimale
		int min = servers[0].getBusyness();
		
		if(n!=0){
			
			for(i=0; i<n; i++){
			
				if(min > servers[i].getBusyness()){
					
					i_min = i;
					min = servers[i].getBusyness();
				}
			}
			
			return servers[i_min];
		}
		else 
			return null;
	}

}
