import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ProcessingAppServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		System.out.println("Creation of object");
		ProcessingApp pa = new ProcessingApp();
		
		System.out.println("En attente");
		Naming.rebind("123", pa);

	}
}