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
import m2geii.reparties.queue.Queue;

public class ManagerApp extends UnicastRemoteObject implements ManagerAppInterface {
	
	private static final long serialVersionUID = 1L;
	
	private volatile ClientAppInterface client;
	
	protected ManagerApp(int ps) throws RemoteException{
		
		super();
	}
	
	protected ManagerApp() throws RemoteException {
		
		super();
	}

	@Override
	public Matrix mult(Matrix M, float scal) throws RemoteException, MatrixException {
		
		ProcessingAppInterface pa;
		Matrix M2 = new Matrix();
		
		try {
			System.out.println("ManagerApp calculates smth...");
			pa = (ProcessingAppInterface)Naming.lookup("123");
			
			M2 = pa.mult(M, scal);
			
			return M2;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return M2;
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

//	@Override
//	public void registerClient(ClientAppInterface client) throws RemoteException {
//		
//		this.client = client;	
//	}

//    public void doSomethingOnClient() throws RemoteException {
//        
//    	client.doSomething();
//    }
}
