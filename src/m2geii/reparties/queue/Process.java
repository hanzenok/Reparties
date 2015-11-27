package m2geii.reparties.queue;


public abstract class Process extends Thread {

	protected int duration;

	public Process(int duration){
		
		this.duration=duration;
	}

	public int getDuration(){
		
		return duration;
	}
	
	public abstract void runProcess();
}
