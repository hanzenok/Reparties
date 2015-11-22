package m2geii.reparties.papp.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import m2geii.reparties.papp.inter.ProcessingAppInterface;

public class ProcessingAppServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		if(System.getSecurityManager() == null) {
			
			System.setSecurityManager(new SecurityManager());
		}
		
		System.out.println("Creation of object");
		ProcessingAppInterface pa = new ProcessingApp();
		ProcessingAppInterface stub = (ProcessingAppInterface) UnicastRemoteObject.exportObject(pa, 0):
		
	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind("123", stub);
	    System.out.println("Server launched");

	}
}