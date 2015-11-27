package ur.geii.util.queue;

import java.util.LinkedList;

/**
 * 
 * @author Pierre HÃ©roux
 * 
 * Main class for the ProcessQueue
 *
 */
public class Queue {

	LinkedList<Process> queue=new LinkedList<Process>();
	Process runningProcess;
	QueueThread th;
	
	/**
	 * 
	 * Adds a process to the queue
	 * 
	 * @param p Process to add to the queue.
	 */
	public void addProcess(Process p) {
		queue.add(p);
		
		System.out.println(p.getProcessName()+" added");
	}
	
	/**
	 * Removes the next process in the queue
	 * 
	 * @return Returns the next process in the queue. It is removed from the queue. Returns null if the queue is empty. 
	 */
	public Process removeProcess() {
		Process p = null;
		if(!queue.isEmpty())
			p = queue.pop();
		return p;
	}
	
	/**
	 * 
	 * @return Returns the duration of the whole queue. The duration includes the remaining duration of the running process. 
	 */
	public int getDuration() {
		int duration=0;
		for(Process p : queue) {
			if(p!=null)
				duration+=p.getDuration();
		}
		
		if(runningProcess!=null)
			duration+=runningProcess.getDuration();
		return duration;
	}
	
	/**
	 * Launch the queue process
	 */
	void start() {
		th = new QueueThread(this);
		th.start();
	}
	
	/**
	 * Interrupt the queue. The execution is not interrupted while the queue is not empty.
	 */
	void stop() {
		while (getDuration()!=0);
		th.stopThread();
	}
	
	public static void main(String [] args) {
		// CrÃ©ation de la file
		Queue q = new Queue();
		
		// On ajoute 5 processus
		q.addProcess(new Process("p1", 3));

		// On affiche la durÃ©e de la file, soit 19
		System.out.println(q.getDuration());
		
		// On lance l'exÃ©cution
		q.start();
		
		q.addProcess(new Process("p2", 2));
		q.addProcess(new Process("p3", 6));
		q.addProcess(new Process("p4", 5));
		q.addProcess(new Process("p5", 3));
		
		// Le thread courrant attend 8 secondes mais les threads de la liste s'exÃ©cute 
		try {
			Thread.sleep(8000);
			System.out.print('.');
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		// AprÃ¨s les 8 secondes, on demande l'affichage du temps restant
		// On devrait avoir l'affichage d'Ã  peu prÃ¨s le temps initial moins les 8 secondes, soit 11 secondes
		System.out.println(q.getDuration());
		
		// On rajoute un processus en cours d'exÃ©cution
		q.addProcess(new Process("p6", 2));
		// La durÃ©e est augmentÃ©e
		System.out.println(q.getDuration());
		
		// On attend suffisamment pour Ã©puiser la file. Il n'y a plus de traitement.
		try {
			Thread.sleep(16000);
			System.out.print('.');
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		// On ajoute deux processus.
		q.addProcess(new Process("p7", 5));
		q.addProcess(new Process("p8", 5));
		// Le premier dÃ©marre immÃ©diatement
		
		// On arrÃªte l'exÃ©cution de la file
		q.stop();
	}
}

