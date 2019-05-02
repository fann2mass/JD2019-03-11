package by.it.eslaikouskaya.jd02_02.SelfCheck;

class ParkingSlot extends Thread{

	private int number;

	ParkingSlot(int number){
		this.number=number;
	}

	@Override
	public void run() {

	}

	@Override
	public String toString() {
		return "Parking slot № "+number;
	}
}
