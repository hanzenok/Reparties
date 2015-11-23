package m2geii.reparties.papp.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import m2geii.reparties.papp.inter.ProcessingAppInterface;

public class ProcessingAppServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		if(System.getSecurityManager() == null) {
			
			System.setSecurityManager(new SecurityManager());
		}
		
		System.out.println("Creation of object");
		ProcessingAppInterface pa = new ProcessingApp();
		
	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind("123", pa);
	    System.out.println("Server launched");

	}
}