package ch07_JavaMoreSkill.JMS_Thread;

public class ThreadEX extends Thread{
	int seq;

	public ThreadEX(){}
	public ThreadEX(int seq){
		this.seq = seq;
	}

	public void run(){
		System.out.println(this.seq + " thread start.");
		try{
			Thread.sleep(1000L * seq / 2);
		} catch ( Exception e ) {
			System.err.println("Thread Error");
		}
		System.out.println(this.seq + " thread end.");
	}

	public static void main(String[] args) {
		Thread t = new ThreadEX();
		for ( int i = 0 ; i < 10 ; i ++ ){
			t = new ThreadEX(i);
			t.start();
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			System.err.println("Thread JOIN Error");
		}

		System.out.println("Main Method End");
	}
}
