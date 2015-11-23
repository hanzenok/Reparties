package ur.geii.util.queue;

/**
 * 
 * Class which simulates a process
 * 
 * @author pierre
 *
 */
public class Process extends Thread {

	private int duration;
	private String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param duration
	 */
	Process(String name, int duration) {
		this.name=name;
		this.duration=duration;
	}
	
	/**
	 * @return the process name
	 */
	public String getProcessName() {
		return name;
	}

	/**
	 * 
	 * @return the remaining duration for this process
	 */
	int getDuration() {
		return duration;
	}
	
	/**
	 * simulates the process execution. The running time is simulated by waiting duration  
	 */
	void runProcess() {
		System.out.println(name+" started");
		while(duration!=0) {
			try {
				duration--;
				Thread.sleep(1000);
				System.out.print('.');
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("\n"+name+" terminated");
	}
}
