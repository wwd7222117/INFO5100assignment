package Assignment7;

public class ReverseHello implements Runnable{
	public static int times = 50;
	private int time;
	
	public ReverseHello(int time) {
		this.time = time;
	}

	public void run() {
		if(time < times) {
			Thread recursive = new Thread(new ReverseHello(++time));
			recursive.start();
			try {
				recursive.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello from Thread "+this.time);	
		}
	}
	
    public static void main(String[] args) {
        Thread sta = new Thread(new ReverseHello(0));
        sta.start();
    }
}