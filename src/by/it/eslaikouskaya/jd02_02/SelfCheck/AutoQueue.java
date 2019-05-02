package by.it.eslaikouskaya.jd02_02.SelfCheck;

import java.util.ArrayDeque;
import java.util.Deque;

class AutoQueue {

	private AutoQueue() {
	}

	private static final Deque<Auto> autoDeque = new ArrayDeque<>();

	static synchronized void add(Auto auto) {
		autoDeque.addLast(auto);
	}

	static synchronized Auto extract() {
		return autoDeque.pollFirst();
	}

}
