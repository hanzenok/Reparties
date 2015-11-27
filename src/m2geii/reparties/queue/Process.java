package m2geii.reparties.queue;

import java.util.concurrent.Callable;

public abstract class Process extends Thread implements Callable{

	protected int duration;

	public Process(int duration){
		
		this.duration=duration;
	}

	public int getDuration(){
		
		return duration;
	}
	
	public abstract void runProcess();
}
