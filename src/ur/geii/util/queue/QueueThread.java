package ur.geii.util.queue;

/**
 * 
 * @author Pierre HÃ©roux
 * 
 * Thread class for the queue processing
 *
 */
class QueueThread extends Thread {
	Queue q;
	private boolean stopThread = false;
	
	/**
	 * 
	 * 
	 * @param q the Queue to handle
	 */
	QueueThread(Queue q) {
		this.q=q;
	}
	
	/**
	 * Method which runs when the queue is processed. Do not call this method directly. Call start instead.
	 */
	public void run() {
		boolean end=false;
		
		while(!end) {
			try {
				Process p = q.removeProcess();
				q.runningProcess=p;
				if(p!=null)
					p.runProcess();
				synchronized(this) {
					Thread.yield();
					end=this.stopThread;
				}
			} catch(Exception e) {
				
			}
		}
	}
	
	/**
	 * Called to interrupt the thread
	 */
	public synchronized void stopThread() {
		this.stopThread = true;
	}
}
