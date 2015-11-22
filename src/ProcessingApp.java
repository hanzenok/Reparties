import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProcessingApp extends UnicastRemoteObject implements ProcessingAppInterface {
	
	private int ps;
	public int nb_clients;
	
	protected ProcessingApp(int ps) throws RemoteException{
		
		super();
		
		this.ps = ps;
		nb_clients = 0;
	}
	
	protected ProcessingApp() throws RemoteException {
		
		super();
		
		ps = 1;
		nb_clients = 0;
	}

	@Override
	public Matrix mult(Matrix M, float scal) throws RemoteException, MatrixException {
		
		int i,j;
		int n = M.rows();
		int m = M.cols();
		
		Matrix M2 = M;
		
		for(i=0;i<n;i++){
			
			for(j=0;j<m;j++){
				
				M2.setValue(i, j, M.getValue(i, j)*scal);
			}
		}
		
		System.out.println("Nb clients: " + ++nb_clients);
		
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

}
