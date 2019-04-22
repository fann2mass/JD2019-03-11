package by.it.eslaikouskaya.jd02_03;


class Cashier implements Runnable{

	private int number;

	Cashier(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		while (Dispatcher.marketOpened()){
			Buyer buyer = QueueBuyers.extract();
			if (buyer!=null){
				System.out.println(this+" started service "+buyer);
				int timeout = Util.random(2000, 4000);
				Util.sleep(timeout);
				System.out.println(this+" finished service "+buyer);
				synchronized (buyer.getMonitor()){
						StringBuilder finalCheck = new StringBuilder("======");
						finalCheck.append(buyer).append(" check======\n").append(buyer.check()).
								append("\nPeople in queue: ").append(QueueBuyers.buyersInQueue()).
								append("\nMarket proceed: ").append(Buyer.getAmount()).append("\n");
						System.out.println(finalCheck);
						buyer.setWait(false);
						buyer.getMonitor().notify();
				}
			}
		}
		System.out.println(this+" closed");
	}

	@Override
	public String toString() {
		return "-- Cashier №" + number;
	}
}
