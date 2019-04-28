package by.it.eslaikouskaya.jd02_02.SelfCheck;

public class Auto extends Thread {
	@Override
	public void run() {
		enterToTheParking();
		parking();
		goOut();
	}


	Object getMonitor(){
		return this;
	}

	Auto(int number){
		super("Auto "+number);
	}


	private void enterToTheParking() {
		System.out.println(this+" entered to parking");
	}


	private void parking() {
		System.out.println(this+" start parking");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
		System.out.println(this+" finish parking");
	}


	private void goOut() {
		System.out.println(this+" go out from the parking");
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
