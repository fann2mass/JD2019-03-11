package by.it.eslaikouskaya.jd02_02.SelfCheck;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	public static void main(String[] args) {

		List<Thread> threads = new ArrayList<>();
		System.out.println("====parking is open");
		for (int i = 1; i <= 80; i++) {
			ParkingSlot parkingSlot = new ParkingSlot(i);
			Thread threadSlots = new Thread(parkingSlot);
			parkingSlot.start();
			threads.add(parkingSlot);
		}

		int numberAuto = 0;
		int count = (int) (Math.random()*2);
		for (int i = 0; i < 200; i++) {
			for (int n = 0; n <= count; n++) {
				Auto auto = new Auto(++numberAuto);
				auto.start();
				threads.add(auto);
			}
		}

		for (Thread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				System.out.println("wow");
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("====parking is close");
	}
}
