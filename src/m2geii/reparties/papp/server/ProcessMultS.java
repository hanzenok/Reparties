package m2geii.reparties.papp.server;

import m2geii.reparties.matrix.Matrix;
import m2geii.reparties.matrix.MatrixException;
import m2geii.reparties.queue.Process;;

public class ProcessMultS extends Process{
	
	Matrix M;
	float scal;
	Matrix res;
	
	ProcessMultS(Matrix M, float scal, int duration) {
		
		super(duration);
		
		this.M = M;
		this.scal = scal;
	}

	@Override
	public void runProcess() {
		
		//simulation d'attente
		try {Thread.sleep(duration*1000);} 
		catch(InterruptedException e) {Thread.currentThread().interrupt();}
		
		//calcule
		int i,j;
		int n = M.rows();
		int m = M.cols();
		
		for(i=0;i<n;i++){
			
			for(j=0;j<m;j++){
				
				try {M.setValue(i, j, M.getValue(i, j)*scal);} 
				catch (MatrixException e) {e.printStackTrace();}
			}
		}
	}
	
	


}
