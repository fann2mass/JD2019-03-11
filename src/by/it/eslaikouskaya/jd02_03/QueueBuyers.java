package by.it.eslaikouskaya.jd02_03;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

	private QueueBuyers() {
	}

	private static final BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>();

	static synchronized void add(Buyer buyer) {
		BUYERS.addLast(buyer);
	}

	static synchronized Buyer extract() {
		return BUYERS.pollFirst();
	}

	static synchronized int buyersInQueue (){
		return BUYERS.size();
	}

}
