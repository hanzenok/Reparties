package m2geii.reparties.inters;

import java.rmi.Remote;
import java.rmi.RemoteException;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;

public interface ProcessingAppInterface extends Remote {
	
	public Matrix mult(Matrix m, float scal) throws RemoteException, MatrixException;
	public Matrix mult(Matrix m1, Matrix m2) throws RemoteException, MatrixException;
	public Matrix add(Matrix m1, Matrix m2) throws RemoteException, MatrixException;
	public Matrix transpose(Matrix m) throws RemoteException, MatrixException;
	
	public int getBusyness() throws RemoteException;
	
}
