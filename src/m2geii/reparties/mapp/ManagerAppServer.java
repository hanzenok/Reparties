package m2geii.reparties.mapp;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import m2geii.reparties.inters.ManagerAppInterface;

public class ManagerAppServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		if(System.getSecurityManager() == null) {
			
			System.setSecurityManager(new SecurityManager());
		}
		
		System.out.println("Creation of object");
		ManagerAppInterface ma = new ManagerApp();
		
	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind("122", ma);
	    System.out.println("Server launched");
	    
	    ma.doSomethingOnClient();

	}
}
